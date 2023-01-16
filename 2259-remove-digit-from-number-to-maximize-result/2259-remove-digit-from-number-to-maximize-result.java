class Solution {
    public String removeDigit(String number, char digit) {
        int len = number.length(), removeIndex = -1;

        for (int i = 0; i < len; i++) {
            char c = number.charAt(i);
            if (c == digit) {
                removeIndex = i;
                if(i < len-1 && number.charAt(i+1) > c){
                    break;
                }
            }
        }
        return number.substring(0, removeIndex) + (removeIndex == len - 1 ? "" : number.substring(removeIndex + 1));
        
    }
}