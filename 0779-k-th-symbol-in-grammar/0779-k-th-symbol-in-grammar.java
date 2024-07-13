class Solution {
    
    int log2(int k){
        return (int)Math.floor(Math.log10(k)/Math.log10(2));
    }

    public int kthGrammar(int n, int k) {
        int times = 0;
        k--;
        while(k > 1){
            k = k % (int)Math.pow(2, log2(k));
            times++;
        }
        return times % 2 == 0 ? k : (k == 1 ? 0 : 1);
    }
}//:~