class Solution {
    public String removeDigit(String number, char digit) {
        int len = number.length();
        int count = 0, l = -1, r = -1;
        for(int i = 0; i < number.length(); i++){
            char c = number.charAt(i);
            if(c == digit){
                l = i;
                break;
            }
        }
        for(int j = number.length()-1; j >= 0; j--){
            char c = number.charAt(j);
            if(c == digit){
                r = j;
                break;
            }
        }
        
        if(l == r){
            return number.substring(0, l) + (l == len - 1 ? "" : number.substring(l + 1, len));
        }
        
        String res = null;
        for(int i = 0; i < number.length(); i++){
            char c = number.charAt(i);
            if(c == digit){
                if(i == r){
                   return number.substring(0, i) + (i == number.length()-1 ? "" : number.substring(i+1, number.length()));
                }
                if(i+1 < number.length() && number.charAt(i+1) > c){
                    return number.substring(0, i) + (i == number.length()-1 ? "" : number.substring(i+1, number.length()));
                }
            }
        }
        return res;
        
    }
}