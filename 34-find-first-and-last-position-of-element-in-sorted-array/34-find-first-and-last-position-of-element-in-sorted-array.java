class Solution {
    
    private int[] binarySearch(int[] nums, int lo, int hi, int t) {
      int[] ret = { -1, -1 };
      if(lo > hi){
        return ret;
      }
      if (lo == hi) {
        if (nums[lo] != t) {
          return ret;
        } else {
          ret[0] = lo;
          ret[1] = hi;
          return ret;
        }
      }
      int mid = (lo + hi) >>> 1;
      int[] left = { -1, -1 }, right = { -1, -1 };
      if (nums[mid] >= t) {
        left = binarySearch(nums, lo, mid - 1, t);
        if(nums[mid] > t){
          return left;
        }
      }
      if (nums[mid] <= t) {
        right = binarySearch(nums, mid + 1, hi, t);
        if(nums[mid] < t){
          return right;
        }
      }
      if (nums[mid] == t) {
        ret[0] = ret[1] = mid;
        if(left[0] != -1){
          ret[0] = left[0];
        }
        if(right[1] != -1){
          ret[1] = right[1];
        }
      }
      return ret;
    }
    
    public int[] searchRange(int[] nums, int target) {
        int[] ret = {-1, -1};
        if(nums == null || nums.length == 0){
            return ret;
        }
        return binarySearch(nums, 0, nums.length - 1, target);
    }
}