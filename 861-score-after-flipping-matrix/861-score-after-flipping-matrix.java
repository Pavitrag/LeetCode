class Solution {
    
    private void flip(int[] row) {
            int len = row.length;
            for (int i = 0; i < len; i++) {
                row[i] = row[i] == 0 ? 1 : 0;
            }
        }

        private void flip(int[][] grid, int col) {
            int len = grid.length;
            for (int i = 0; i < len; i++) {
                grid[i][col] = grid[i][col] == 0 ? 1 : 0;
            }
        }

        private int number(int[] row) {
            int result = 0;
            int base = 1;
            int len = row.length;
            for (int i = len - 1; i >= 0; i--) {
                if (row[i] == 1) {
                    result += base;
                }
                base *= 2;
            }
            return result;
        }

        public int matrixScore(int[][] grid) {
            int r = grid.length;
            int c = grid[0].length;
            
            for (int[] row : grid) {
                if (row[0] == 0) {
                    flip(row);
                }
            }

            for (int i = 1; i < c; i++) {
                int zeros = 0;
                for (int[] row : grid) {
                    if (row[i] == 0) {
                        zeros++;
                    }
                }
                if (zeros > r - zeros) {
                    flip(grid, i);
                }
            }

            int sum = 0;
            for (int[] row : grid) {
                sum += number(row);
            }
            return sum;
        }
}