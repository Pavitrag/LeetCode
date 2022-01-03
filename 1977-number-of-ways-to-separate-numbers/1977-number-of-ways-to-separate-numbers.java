class Solution {
    private static final int INF = 1000000000+7;
    public int numberOfCombinations(String num) {
        if(num.length() <= 0) return 0;
        return solve(num);
    }
    
    /**
     * Dynamic Programming solution with 2 optimizations:
     * 1. constant time method to find the first uncommon character of two strings.
     * 2. dp[index][length] = no. of ways to separate the string into valid numbers wher the string ending at 'index' with length from 1 to length.
     * */
    private int solve(String numsString) {
        int numslen = numsString.length();
        char[] nums = numsString.toCharArray();
        if (nums[0] == '0') {
            return 0;
        }

        int[][] dp = new int[numslen][numslen + 1];
        dp[0][1] = 1;
        int[][] lcp = new int[numslen + 1][numslen + 1];
        for (int prev = numslen - 2; prev >= 0; prev--) {
            for (int curr = prev + 1; curr < numslen; curr++) {
                if (nums[prev] == nums[curr]) {
                    lcp[prev][curr] = 1 + lcp[prev + 1][curr + 1];
                }
            }
        }

        for (int end = 1; end < numslen; end++) {
            dp[end][end + 1] = 1;
            // length of the current number in number of chars (digits) in it.
            for (int len = 1; len <= end; len++) {
                int val = 0;
                int j = end - len + 1; // index of first character of the current number.
                if (nums[j] == '0') { //if current number begins with '0'
                    val = 0;
                }else if(j < len){ //if not enough digits to make previous number's # of digits equal to that of current number's # of digits
                    val = dp[j - 1][j];
                }/*else if(nums[j-len] == '0'){//if previous number begins with '0'
                    val = dp[j-1][len-1];
                }*/else  {
                    int common = lcp[j - len][j];
                    if ((common >= len)
                            || (nums[j - len + common] <= nums[j + common])) {
                        val = dp[j-1][len];
                    }else{//if previous number is bigger than current number then consider previous number with one less digit which will definitely be smaller than current number (because current number's digits is one more than previous number's digits)
                        val = dp[j-1][len-1];
                    }
                }
                dp[end][len] =  (int) (dp[end][len-1] + (long)val) % INF;
            }
            dp[end][end + 1] = (int) (dp[end][end + 1] + (long) dp[end][end]) % INF;
        }
        return dp[numslen - 1][numslen];
    }
}