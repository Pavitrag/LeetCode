class Solution {
    public int firstMissingPositive(int[] arr) {
        assert arr != null;
        int n = arr.length;
        // check if 1 is not there. Then its the minimum
        boolean foundOne = false;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                foundOne = true;
                break;
            }
        }
        if (!foundOne) {
            return 1;
        }

        //1 is there
        for(int i = 0; i < n; i++) {
            if (arr[i] <= 0 || arr[i] > n) {
                arr[i] = 1;
            }
        }
        for(int i = 0; i < n; i++){
            if(arr[Math.abs(arr[i]) - 1] > 0){
                arr[Math.abs(arr[i])-1] *= -1; 
            }
        }
        
        for (int i = 0; i < n; i++) {
            if(arr[i] > 0){
                return i+1;
            }
        }
        return n+1;
        
    }
}