class Solution {
    int minTaps(int n, int[] ranges){
        int[] dp= new int[n+1];
        Arrays.fill(dp, n+2);

        dp[0] = 0;
        for(int i =0; i < ranges.length; i++){
            int left = Math.max(0, i - ranges[i]);
            int right = Math.min(n, i + ranges[i]);

            for(int x = left; x <= right; x++){
                dp[x] = Math.min(dp[left] + 1, dp[x]);
            }
        }

        for(int e: dp){
            if(e == n+2) {
                return -1;
            }
        }
        return dp[n];
    }
}