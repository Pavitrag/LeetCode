class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        int left = 0, right = 0; 
        int maxl = 1;
        int[] lastPos = new int[256];
        
        lastPos[(int)s.charAt(0) - 0] = 1;
        for(int i = 1; i < s.length(); i++){
            right = i;
            left = Math.max(left, lastPos[s.charAt(i)] == 0 ? left : lastPos[s.charAt(i)]);
            lastPos[s.charAt(i)] = i+1; //holding index + 1 so that index 0 means invalid/unseen
            maxl = Math.max(maxl, right - left + 1);
        }
        return maxl;
        
    }
}