class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int r = 0, c = n-1;
        while(r < m && c >= 0){
            int val = matrix[r][c];
            if(val == target){
                return true;
            }
            if(val > target){
                c--;
            }else{
                r++;
            }
        }
        return false;
    }
}