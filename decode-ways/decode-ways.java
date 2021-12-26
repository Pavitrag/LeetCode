class Solution {
    public int numDecodings(String s) {
        int[] count = new int[s.length()];
        if(s.charAt(0) == '0')  return 0;
        
        count[0] = 1;
        for(int i=1; i< s.length(); i++){
            char _0 = s.charAt(i);
            char _1 = s.charAt(i-1);
            
            count[i] = (_0 > '0' ? count[i-1] : 0);
            if(_1 == '1' || (_1 == '2' && _0 <= '6')){
                count[i] += (i - 2 >= 0 ? count[i-2] : 1);
            }
        }
        return count[s.length()-1];
    }
} 