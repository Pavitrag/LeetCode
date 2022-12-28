class Solution {
    private static class Pair implements Comparable<Pair>{
        int index;
        int val;

        Pair(int index, int val){
            this.index = index;
            this.val = val;
        }

        @Override
        public int compareTo(Pair o) {
            if(this == o){
                return 0;
            }
            return this.val - o.val;
        }
    }

    //greater than sorts based Pair.val in descending order
    private void mergeSort(Pair[] a, Pair[] aux, int lo, int hi, int[] count){
        if(lo < hi){
            int mid = (lo + hi) >>> 1;
            mergeSort(aux, a, lo, mid, count);
            mergeSort(aux, a, mid+1, hi, count);
            merge(a, aux, lo, mid, hi, count);
        }
    }

    private void merge(Pair[] src, Pair[] dest, int lo, int mid, int hi, int[] count) {
        int i = lo, j = mid+1;
            for(int k = lo; k <= hi; k++){
                if(i > mid) {
                    dest[k] = src[j++];
                }
                else if(j > hi) {
                    dest[k] = src[i++];
                }
                else if(src[i].compareTo(src[j]) > 0) {
                    count[src[i].index] += hi - j +1;
                    dest[k] = src[i++];
                }
                else {
                    dest[k] = src[j++];
                }
            }
    }

    public List<Integer> countSmaller(int[] nums) {
        int[] count = new int[nums.length];
        Pair[] pairs = new Pair[nums.length];

        for(int i = 0; i < nums.length; i++){
            pairs[i] = new Pair(i, nums[i]);
        }

        mergeSort(pairs.clone(), pairs, 0, pairs.length-1, count);
        List<Integer> lcount = new ArrayList<>();
        Arrays.stream(count).forEach(lcount::add);
        return lcount;
    }
}