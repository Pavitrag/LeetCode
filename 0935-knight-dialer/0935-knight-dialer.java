class Solution {
    public int knightDialer(int n) {
        final int MOD = 1_000_000_007;

        long[] curr = new long[10];
        long[] next = new long[10];
        Arrays.fill(curr, 1);
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= 9; j++){
                switch(j){
                    case 0 -> next[0] = (curr[4] + curr[6]) % MOD;
                    case 1 -> next[1] = (curr[6] + curr[8]) % MOD;
                    case 2 -> next[2] = (curr[7] + curr[9]) % MOD;
                    case 3 -> next[3] = (curr[4] + curr[8]) % MOD;
                    case 4 -> next[4] = (curr[0] + (curr[3] + curr[9]) % MOD) % MOD;
                    case 5 -> next[5] = 0;
                    case 6 -> next[6] = (curr[0] + (curr[1] + curr[7]) % MOD) % MOD;
                    case 7 -> next[7] = (curr[2] + curr[6]) % MOD;
                    case 8 -> next[8] = (curr[1] + curr[3]) % MOD;
                    case 9 -> next[9] = (curr[2] + curr[4]) % MOD;
                }
            }
            long[] temp = curr;
            curr = next;
            next = temp;
        }
        long count = 0;
        for(int i = 0; i <= 9; i++){
            count =  (count + curr[i]) % MOD;
        }
        return (int)count;
    }
}