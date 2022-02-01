import java.util.*;

class Solution {
    
    void swap(int[][] points, int i, int j){
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
    
    private int distance(int[] p){
        return p[0]*p[0] + p[1]*p[1];    
    }
    
    private int partition(int[][] points, int begin, int end){  
        if(begin > end){
            return -1;
        }
        int[] pivot = points[end];
        int dist = distance(pivot);
        for(int i = begin; i < end; i++){
            if(distance(points[i]) < dist){
                swap(points, i, begin++);
            }
        }
        swap(points, end, begin);
        return begin;
    }
    
    private void partialSort(int[][] points, int begin, int end, int k) {
        int pivot = end + 1;
        while (pivot != k) {
          pivot = partition(points, begin, end);
          if (pivot + 1 < k) {
            begin = pivot + 1;
          } else if (pivot + 1 > k) {
            end = pivot - 1;
          }
        }
      }

    public int[][] kClosest(int[][] points, int k) {
        partialSort(points, 0, points.length - 1, k);
        var kclose = Arrays.copyOf(points, k);
        return kclose;
    }
}