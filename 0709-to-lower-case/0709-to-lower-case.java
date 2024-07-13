class Solution {
    public String toLowerCase(String s) {
        char[] out = new char[s.length()];
        int i = 0;
        for(char c: s.toCharArray()){
            if(c >= 'A' && c <= 'Z'){
                out[i++] = (char)(c - 'A' + 'a');
            }else{
                out[i++] = c;
            }
        }
        return new String(out);
    }
}