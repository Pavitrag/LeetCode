class Solution {
    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    int partition(int[] nums, int begin, int end){
        int e = nums[end];
        for(int i = begin; i < end; i++){
            if(nums[i] > e){
                swap(nums, i, begin++);
            }
        }
        swap(nums, begin, end);
        return begin;
    }
    
    int kSelect(int[] nums, int begin, int end, int k){
        if(begin > end){
            return -1;
        }
        int pivot = partition(nums, begin, end);
        if(pivot+1 < k){
            return kSelect(nums, pivot + 1, end, k);
        }
        if(pivot + 1> k){
            return kSelect(nums, begin, pivot - 1, k);
        }
        return pivot;
    }
    
    public int findKthLargest(int[] nums, int k) {
        return nums[kSelect(nums, 0, nums.length-1, k)];
    }
}