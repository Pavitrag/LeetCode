class Solution {
    
    public int maxProfit(int[] prices) {
        int len = prices.length;
        
        int min = prices[0];
        int max = 0;
        
        for(int i = 1; i < len; i++){
            min = Math.min(min, prices[i-1]);
            max = Math.max(max, prices[i] - min);
        }
        
        return max;
    }
}