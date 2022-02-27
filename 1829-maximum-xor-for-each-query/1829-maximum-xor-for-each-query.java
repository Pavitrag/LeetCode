class Solution {
    
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int len = nums.length;
        int[] ret = new int[len];
        int k = (1 << maximumBit) - 1;
        
        ret[len-1] = k^nums[0];
        for(int i = len-2; i >= 0; i--){
            ret[i] = nums[len-1 - i]^ret[i+1];
        }
        return ret;
    }
}