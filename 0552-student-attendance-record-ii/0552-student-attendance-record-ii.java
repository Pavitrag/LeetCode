class Solution {
    final int MODULO = 1000000007;
    
    public int checkRecord(int n) {

            int A = 0, L = 1, P = 2;
            long[][] dp = new long[n][3];

            dp[0][L] = 1;
            dp[0][P] = 1;

            for(int i = 1; i < n; i++){
                dp[i][L] = ((i - 2 < 0 ? 1 : dp[i-2][P]) + dp[i-1][P])%MODULO;
                dp[i][P] = (dp[i-1][L] + dp[i-1][P])%MODULO;
            }
            long count = 0;
            for(int i = 0; i < n; i++){ // A is on [0, n)
                count =  (count + ((i-1 < 0 ? 1 : dp[i-1][L] + dp[i-1][P])%MODULO * (n-i-2 < 0 ? 1 : dp[n-i-2][L] + dp[n-i-2][P])%MODULO)%MODULO)%MODULO;
            }

            return (int)(((count + dp[n-1][P])%MODULO + dp[n-1][L])%MODULO);
        }
}