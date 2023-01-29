class Solution {
    public int[][] merge(int[][] intervals) {
        //O(n.log(n))
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1]));
        record Interval(int s, int e){};
        Stack<Interval> stack = new Stack<>();

        stack.push(new Interval(intervals[0][0], intervals[0][1]));
        for(int i = 1; i < intervals.length; i++){
            Interval curr = new Interval(intervals[i][0], intervals[i][1]);
            while(!stack.isEmpty() && (curr.s() <= stack.peek().s())){ //current covers completely the interval on top of stack
                stack.pop();
            }
            if(stack.isEmpty()){
                stack.push(curr);
            }else{ //stack has some elements which either are disjoint or overlap with current interval
                if(curr.s() <= stack.peek().e()){ //overlap
                    Interval top = stack.pop();
                    stack.push(new Interval(Math.min(top.s(), curr.s()), Math.max(top.e(), curr.e())));
                }else{ //disjoint
                    stack.push(curr);
                }
            }
        }

        int[][] out = new int[stack.size()][2];

        int size = stack.size();
        for(int i = size-1; i >= 0; i--){
            Interval top = stack.pop();
            out[i] = new int[]{top.s(), top.e()};
        }
        return out;
    }
}