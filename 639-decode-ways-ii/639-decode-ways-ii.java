class Solution {
    private final static int INF = 1000000000 + 7;
    
    public int numDecodings(String s) {
        int len = s.length();
        long[] dp = new long[len];
        char[] num = s.toCharArray();
        dp[0] = (num[0] == '*' ? 9 : (num[0] == '0' ? 0 : 1));
        
        for(int i = 1; i < len; i++){
            if(num[i] == '*'){
                dp[i] = (dp[i] + dp[i-1]*9)%INF;
                if(num[i-1] == '1' || num[i-1] == '*'){
                    dp[i] = (dp[i] + (i-2 >= 0 ? dp[i-2]*9 : 9))%INF;
                }
                if(num[i-1] == '2' || num[i-1] == '*'){
                    dp[i] = (dp[i] + (i-2 >= 0 ? dp[i-2]*6 : 6))%INF;
                }
            }else{
                if(num[i] != '0'){
                    dp[i] = (dp[i] + dp[i-1])%INF;
                }
                if(num[i-1] == '1' || num[i-1] == '*'){
                    dp[i] = (dp[i] + (i-2 >= 0 ? dp[i-2] : 1))%INF;
                }
                if((num[i-1] == '2' || num[i-1] == '*') && num[i] >= '0' && num[i] <= '6'){
                    dp[i] = (dp[i] + (i-2 >= 0 ? dp[i-2] : 1))%INF;
                }
            }
        }
        return (int)dp[len-1]%INF;
    }
}