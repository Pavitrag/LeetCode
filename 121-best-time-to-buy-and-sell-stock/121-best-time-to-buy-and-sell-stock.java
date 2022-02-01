class Solution {
    //FIRST TRY
//     public int maxProfit(int[] prices) {
//         int len = prices.length;
//         int[] m = new int[len];
        
//         for(int i = len - 2; i >= 0; i--){
//             m[i] = Math.max(prices[i+1], i+1 == len-1 ? Integer.MIN_VALUE : m[i+1]);
//         }
        
//         int maxProfit = 0;
//         for(int i = 0; i < len-1; i++){
//             maxProfit = Math.max(maxProfit, m[i] - prices[i]);
//         }
//         return maxProfit;
//     }
    
    //SECOND TRY
    public int maxProfit(int[] prices) {
        int len = prices.length;
        // int[] m = new int[len];
        
        int min = prices[0];
        int max = 0;
        
        for(int i = 1; i < len; i++){
            min = Math.min(min, prices[i-1]);
            max = Math.max(max, prices[i] - min);
        }
        
        return max;
    }
}