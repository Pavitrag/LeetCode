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
    
    private int get(int[][] points, int begin, int end, int k){        
        int pivot = partition(points, begin, end);
        if(pivot + 1 < k){
            return get(points, pivot + 1, end, k);
        }
        if(pivot + 1 > k){
            return get(points, begin, pivot-1, k);
        }
        return pivot;
    }
    
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (s, t) -> distance(s) - distance(t));
        int[][] kclose = new int[k][];
        for(int i = 1; i <= k; i++){
            kclose[i-1] = points[i-1];
        }
        return kclose;
    }
    
    
    
//     private int[][] get(int[][] points, int k){

//         PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((e1, e2) -> {
//           int x1 = e1.getKey(), y1 = e1.getValue();
//           int x2 = e2.getKey(), y2 = e2.getValue();
//           return (x1 * x1 + y1 * y1) - (x2 * x2 + y2 * y2);
//         });

//         for (int[] point : points) {
//           pq.add(new AbstractMap.SimpleEntry<Integer, Integer>(point[0], point[1]));
//         }

//         int[][] closestk = new int[k][2];
//         for (int i = 0; i < k; i++) {
//             Map.Entry<Integer, Integer> point = pq.poll();
//             closestk[i][0] = point.getKey();
//             closestk[i][1] = point.getValue();
//         }
//         return closestk;
//     }
}