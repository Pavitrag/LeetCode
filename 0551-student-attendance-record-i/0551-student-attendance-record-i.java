class Solution {
    public boolean checkRecord(String s) {
        boolean seenA = false;
        int seenL = 0;
        for(char c: s.toCharArray()){
            switch(c){
              case 'A':
                    if(seenA){
                        return false;
                    }
                    seenA = true;
                    seenL = 0;
                    break;
              case 'L':
                    if(seenL == 2){
                        return false;
                    }
                    seenL++;
                    break;
                default:
                    seenL = 0;
            } 
        }
        return true;
        
    }
}