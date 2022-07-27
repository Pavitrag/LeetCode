class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int len = s.length();
        int[] left = new int[len];
        int[] right = new int[len];
        int[] cumul = new int[len];
        int[] result = new int[queries.length];
        
        int nearestLeftCandleIndex = -1;
        for(int i=0; i < len; i++){
            if(s.charAt(i) == '|'){
                nearestLeftCandleIndex = i;
            }
            left[i] = nearestLeftCandleIndex;
            cumul[i] = (i > 0 ? (cumul[i-1] + (s.charAt(i) == '*' ? 1 : 0))  : 1);
        }
        
        int nearestRightCandleIndex = -1;
        for(int i= len -1; i >= 0 ; i--){
            if(s.charAt(i) == '|'){
                nearestRightCandleIndex = i;
            }
            right[i] = nearestRightCandleIndex;
        }
        
        for(int i = 0; i  < queries.length; i++){
            int l = queries[i][0], r = queries[i][1];
            if(left[r] < 0 || right[l] < 0){
                result[i] = 0;
            }else{
                int plates = cumul[left[r]] - cumul[right[l]];
                result[i] = plates < 0 ? 0 : plates;
            }
        }
        return result;
    }
}