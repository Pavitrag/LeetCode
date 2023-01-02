class Solution {
   
    int sum(int[] bit, int index){
        int sum = 0;
        while(index > 0){
            sum += bit[index];
            index -= (index & -index);
        }
        return sum;
    }
    
    void add(int[] bit, int index){
        while(index < bit.length){
            bit[index] += 1;
            index += (index & - index);
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        final int MAX = 2*10000 + 2; //some higher constant which should be sufficiently large enough to hold values
        final int OFFSET = 10000 + 1;
        // values from -10^4 to 10^4
        Integer[] count = new Integer[nums.length];
        int[] bit = new int[MAX];
        
        for(int i = nums.length - 1; i >= 0; i--){
            int n = nums[i] + OFFSET;
            int c = sum(bit, n-1); // check if any number less than n is there in bit[]
            count[i] = c;
            add(bit, n); // add the number to binary indexed tree 'bit[]' to all the indices <= n (obviously as per Fenwick tree logic) 
        }
        return Arrays.asList(count);
    }
}