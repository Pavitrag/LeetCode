class Solution {
    public int findSpecialInteger(int[] arr) {
        int len = arr.length;
        int mlimit = (len % 4 != 0 ? (int)Math.ceil((double)len/4) : len/4 + 1);
        
        int count = 1;
        int melem = arr[0];
        for(int i=1; i < len; i++){
            if(arr[i] == arr[i-1]){
                count++;
                if(count >= mlimit){
                    melem = arr[i];
                    break;
                }
            }else{
                count = 1;
            }
        }
        return melem;
    }
}