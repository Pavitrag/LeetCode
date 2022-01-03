class Solution {
    private static final int INF = 1000000000+7;
    public int numberOfCombinations(String num) {
        if(num.length() <= 0) return 0;
        return solve(num);
    }
    
    private int solve(String nums) {
        int numslen = nums.length();

        if (nums.startsWith("0")) {
            return 0;
        }

        int[][] dp = new int[numslen][numslen + 1];
        dp[0][1] = 1;
        int[][] lcp = new int[numslen + 1][numslen + 1];
        for (int prev = numslen - 2; prev >= 0; prev--) {
            for (int curr = prev + 1; curr < numslen; curr++) {
                if (nums.charAt(prev) == nums.charAt(curr)) {
                    lcp[prev][curr] = 1 + lcp[prev + 1][curr + 1];
                }
            }
        }
        
        // for(int end = 0; end < numslen; end++){
        //     for(int len = 1; len <= end+1; len++){
        //         int j = end - len + 1;
        //         int cur = 0;
        //         if(nums.charAt(j) == '0'){
        //             cur = 0;
        //         }else if(j == 0){
        //             cur = 1;
        //         }else{
        //             int maxl2 = 0;
        //             if(j < len){
        //                 maxl2 = j;
        //             }else{
        //                 int cl = lcp[j-len][j];
        //                 if(cl >= len || nums.charAt(j-len+cl) <= nums.charAt(j+cl)){
        //                     maxl2 = len;
        //                 }else{
        //                     maxl2 = len-1;
        //                 }
        //             }
        //             cur = dp[j-1][maxl2];
        //         }
        //         dp[end][len] = dp[end][len-1] + cur;
        //     }
        //     //return dp[numslen-1][numslen]%INF;
        // }

        for (int end = 1; end < numslen; end++) {
            dp[end][end + 1] = 1;
            // length of the current number in number of chars (digits) in it.
            for (int len = 1; len <= end; len++) {
                int val = 0;
                int j = end - len + 1; // index of first character of the current number.
                String curr = nums.substring(j, end + 1);
                int prevBeginIdx = j - len; //first character of previous number
                if (prevBeginIdx < 0)
                    prevBeginIdx = 0;
                /*if(nums.charAt(prevBeginIdx) == '0'){//previous number begins with '0'
                    val = 0;
                }else */if(curr.length() > 1 && curr.startsWith("0")){//current number of length more than 1 has first character '0'
                    val = 0;
                }else {
                    if (j < len) {
                        val = dp[j - 1][j];
                    } else {
                        int common = lcp[j - len][j];
                        if ((common >= len) || (nums.charAt(j - len + common) <= nums.charAt(j + common))) {
                            val = dp[end - len][len];
                        }else{
                            val = dp[end - len][len-1];
                        }
                    }
                }
                dp[end][len] = (int)(dp[end][len-1] + (long)val)%INF;
            }
            dp[end][end + 1] = (dp[end][end + 1] + dp[end][end]) % INF;
        }
         return dp[numslen - 1][numslen];
    }
}