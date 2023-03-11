class Solution {
    public int networkDelayTime(int[][] g, int n, int k) {
        final int NO_PATH = -1;
        int[][] times = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i != j) {
                    times[i][j] = NO_PATH;
                }else{
                    times[i][j] = 0;
                }

            }
        }
        for(int i = 0; i < g.length; i++){
            times[g[i][0]-1][g[i][1]-1] = g[i][2];
        }

        for (int v = 0; v < n; v++) {
            for(int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (times[i][v] != NO_PATH && times[v][j] != NO_PATH) {
                        int through_v = times[i][v] + times[v][j];
                        times[i][j] = Math.min((times[i][j] == NO_PATH ? Integer.MAX_VALUE : times[i][j]), through_v);
                    }
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int t : times[k-1]) {
            if(t == NO_PATH){
                return NO_PATH;
            }
            max = Math.max(max, t);
        }
        return max;
    }
}