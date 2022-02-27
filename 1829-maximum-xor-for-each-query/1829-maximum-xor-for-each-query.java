class Solution {
    private int power(int maxbit){
        int res = 1;
        int base = 2;    
        while(maxbit > 0){
            if(maxbit % 2 == 1){
                res *= base;
            }
            base *= base;
            maxbit /=2;
        }
        return res - 1;
    }
    
//     public int[] getMaximumXor(int[] nums, int maximumBit) {
//         int len = nums.length;
//         int[] ret = new int[len];
//         int xor = 0;
//         int k = power(maximumBit);
//         for(int e: nums){
//             xor ^= e;
//         }
        
//         for(int i = len-1; i >= 0; i--){
//             ret[len-1 - i] = k^xor;
//             xor ^= nums[i];
//         }
//         return ret;
//     }
    
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