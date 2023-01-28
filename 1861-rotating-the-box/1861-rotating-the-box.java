class Solution {
    public char[][] rotateTheBox(char[][] box) {
        char stone = '#';
        char obst = '*';
        char empty = '.';

        for (char[] row : box) {
            int obstaclePos = row.length;
            int c = row.length;
            while (--c >= 0) {
                if (row[c] == stone) {
                    row[c] = empty;
                    row[obstaclePos - 1] = stone;
                    obstaclePos--;
                } else if (row[c] == obst) {
                    obstaclePos = c;
                }
            }
        }

        char[][] rb = new char[box[0].length][box.length];
        int col = rb[0].length;
        for (char[] row : box) {
            col--;
            for (int i = 0; i < row.length; i++) {
                rb[i][col] = row[i];
            }
        }
        return rb;
    }
}