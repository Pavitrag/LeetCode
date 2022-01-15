class Solution {
    public int findMin(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    
    private int helper(int[] nums, int b, int e){
        if(b >= e) return nums[b];
        int mid = b + (e-b)/2;
        if(nums[mid]< nums[e]){
            return helper(nums, b, mid);
        }else{
            return helper(nums, mid+1, e);
        }
    }
}