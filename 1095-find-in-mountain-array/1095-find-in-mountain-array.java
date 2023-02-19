/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
     int peakIndex = findPeak(mountainArr);
        if(target > mountainArr.get(peakIndex)){
            return -1;
        }
        int tindex = binarySearch(target, mountainArr, 0, peakIndex, false);
        if(tindex == -1){
            tindex = binarySearch(target, mountainArr, peakIndex+1, mountainArr.length()-1, true);
        }
        return tindex;
    }

    private int binarySearch(int target, MountainArray arr, int lo, int hi, boolean reverseSorted) {
        while (lo <= hi) {
            int mid = ((lo + hi) >>> 1);
            if (arr.get(mid) == target) {
                return mid;
            } else {
                if (reverseSorted){
                    if(arr.get(mid) > target){
                        lo = mid+1;
                    }else {
                        hi = mid - 1;
                    }
                }else{
                    if(arr.get(mid) < target){
                        lo = mid+1;
                    }else {
                        hi = mid - 1;
                    }
                }
            }
        }
        return -1;
    }

    private int findPeak(MountainArray mountainArr){
        int L_LIMIT = -1;
        int hi = mountainArr.length()-1;
        int lo = 0;

        while(lo <= hi){
            int mid = ((lo + hi) >>> 1);
            int middle = mountainArr.get(mid);
            int prev = mid-1 >= 0 ? mountainArr.get(mid-1) : L_LIMIT;
            int next = mid + 1 < mountainArr.length() ? mountainArr.get(mid+1) : L_LIMIT;

            if(prev < middle && middle > next){ //peak
                return mid;
            }else if(prev < middle && middle < next){
                lo = mid+1;
            }else{
                hi = mid -1;
            }
        }
        return -1;
    }
}