class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[] m = new int[len];
        
        for(int i = len - 2; i >= 0; i--){
            m[i] = Math.max(prices[i+1], i+1 == len-1 ? Integer.MIN_VALUE : m[i+1]);
        }
        
        int maxProfit = 0;
        for(int i = 0; i < len-1; i++){
            maxProfit = Math.max(maxProfit, m[i] - prices[i]);
        }
        return maxProfit;
    }
}