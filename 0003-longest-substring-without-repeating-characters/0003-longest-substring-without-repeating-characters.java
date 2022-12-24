class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int left = 0;
        int maxl = 1;
        int[] lastPos = new int[256];

        for (int i = 0; i < s.length(); i++) {
            left = Math.max(left, lastPos[s.charAt(i)]);
            lastPos[(int) s.charAt(i)] = i + 1; //holding index + 1 means left need to be moved to the next of the repeated char's index
            maxl = Math.max(maxl, i - left + 1);
        }
        return maxl;
    }
}