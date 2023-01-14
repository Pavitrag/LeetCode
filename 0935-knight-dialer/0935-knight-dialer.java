class Solution {
    public int knightDialer(int n) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i <= 9; i++){
            switch(i){
                case 0 -> map.put(0, List.of(4, 6));
                case 1 -> map.put(1, List.of(6, 8));
                case 2 -> map.put(2, List.of(7, 9));
                case 3 -> map.put(3, List.of(4, 8));
                case 4 -> map.put(4, List.of(0, 3, 9));
                case 5 -> map.put(5, List.of());
                case 6 -> map.put(6, List.of(0, 1, 7));
                case 7 -> map.put(7, List.of(2, 6));
                case 8 -> map.put(8, List.of(1, 3));
                case 9 -> map.put(9, List.of(2, 4));
            }
        }

        final int MOD = 1_000_000_007;
        long count = 0;
        long[][] dp = new long[n+1][10];
        IntStream.range(0, 10).forEach(r -> dp[0][r]++);

        for(int i = 1; i <n; i++){
            for(int p = 0; p <= 9; p++){
                for(int k: map.get(p)) {
                    dp[i][p] = (dp[i][p] + dp[i - 1][k]) % MOD;
                }
            }
        }
        for(int i = 0; i <= 9; i++){
            count =  (count + dp[n-1][i]) % MOD;
        }
        return (int)count;
    }
}