class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int max = 0;
        int size = boxTypes.length;
        int[] units = new int[1001];
        for(int[] box: boxTypes){
            units[box[1]] += box[0]; 
        }

        for(int u = 1000; u > 0; u--){
            if(units[u] > 0){
                int min = Math.min(units[u], truckSize);
                truckSize -= min;
                max += (u * min);
                if(truckSize <= 0){
                    break;
                }
            }
        }
        return max;
    }
}