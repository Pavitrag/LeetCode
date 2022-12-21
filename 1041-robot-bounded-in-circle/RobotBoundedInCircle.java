package org.challenges.algorithm;

/**
 * @source: https://leetcode.com/problems/robot-bounded-in-circle/description/
 *
 * Solution: After executing all the instructions and executing the instructions multiple times
 * the robot will be bounded by the circle only if either:
 * 1. it comes back to the position from where it started, or
 * 2. it is not facing North direction (robot's initial direction when it started off)
 *
 * If robot is facing any other direction other than North then eventually it will come back to its starting position
 * and from there on continue to be bounded in the circle.
 */
public class RobotBoundedInCircle {

    private static class Coordinate{
        int x;
        int y;

        Coordinate(int xx, int yy){
            x = xx;
            y = yy;
        }

        public void move(Coordinate m){
            x += m.x;
            y += m.y;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", x, y);
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == null){
                return false;
            }
            if(obj == this){
                return true;
            }
            if(obj instanceof Coordinate){
                Coordinate other = (Coordinate) obj;
                return other.x == x && other.y == y;
            }
            return false;
        }
    }

    final static int L = 0; //LEFT
    final static int R = 1; //RIGHT

    final static int N = 0; //NORTH
    final static int S = 1; //SOUTH
    final static int E = 2; //EAST
    final static int W = 3; //WEST
    static final Coordinate[] NEXT_MOVE = new Coordinate[4];
    static final int DIRECTION[][] = new int[4][2];
    private static void init(){
        NEXT_MOVE[N] = new Coordinate(0, 1);
        NEXT_MOVE[S] = new Coordinate(0, -1);
        NEXT_MOVE[E] = new Coordinate(1, 0);
        NEXT_MOVE[W] = new Coordinate(-1, 0);

        DIRECTION[N][L] = W;
        DIRECTION[S][L] = E;
        DIRECTION[E][L] = N;
        DIRECTION[W][L] = S;

        DIRECTION[N][R] = E;
        DIRECTION[S][R] = W;
        DIRECTION[E][R] = S;
        DIRECTION[W][R] = N;

    }

    public boolean isRobotBounded(String instructions) {
        init();
        int currentDirection = N;
        Coordinate curr = new Coordinate(0,0);
        for(char c: instructions.toCharArray()){
            if(c != 'G'){
                int turn = (c == 'L' ? L : R);
                currentDirection = DIRECTION[currentDirection][turn];
            }else{
                curr.move(NEXT_MOVE[currentDirection]);
            }
        }
        if(curr.equals(new Coordinate(0, 0)) || currentDirection != N){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        RobotBoundedInCircle rbic = new RobotBoundedInCircle();
        System.out.println(rbic.isRobotBounded("GLGLGLGGL"));
        System.out.println(rbic.isRobotBounded("GL"));
        System.out.println(rbic.isRobotBounded("GG"));
    }
}
