class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int maxHGap = 0;
        int maxVGap = 0;
        int prev = 0;
        for(int c: horizontalCuts){
            maxHGap = Math.max(maxHGap, c - prev);
            prev = c;
        }
        maxHGap = Math.max(maxHGap, h - prev); 
        
        prev = 0;
        for(int c: verticalCuts){
            maxVGap = Math.max(maxVGap, c - prev);
            prev = c;
        }
        maxVGap = Math.max(maxVGap, w - prev);
        
        return (int)((long)maxHGap*maxVGap % (1000000007));
    }
}