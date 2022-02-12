class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] left = new int[len];
        int[] right = new int[len];
        
        for(int i = 1; i < len; i++){
            left[i] = Math.max(left[i-1], height[i-1]);
        }
        
        for(int i = len-2; i>=0; i--){
            right[i] = Math.max(right[i + 1], height[i+1]);
        }
        
        int w = 0;
        for(int i = 0; i< len; i++){
            int c = Math.min(left[i], right[i]) - height[i];
            if(c > 0){
                w +=  c;
            }
        }
        return w;
    }
}