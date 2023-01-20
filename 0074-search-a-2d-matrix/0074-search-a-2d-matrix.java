class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int lo = 0, hi = m*n-1;
        while(lo <= hi){
            int mid = (lo + hi) >>> 1;
            int val = matrix[mid/n][mid%n];
            if(val == target){
                return true;
            }
            if(val > target){
                hi--;
            }else{
                lo++;
            }
        }
        return false;
    }
}