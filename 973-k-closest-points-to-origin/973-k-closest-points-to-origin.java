import java.util.*;

class Solution {
    private int[][] get(int[][] points, int k){

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((e1, e2) -> {
          int x1 = e1.getKey(), y1 = e1.getValue();
          int x2 = e2.getKey(), y2 = e2.getValue();
          return (x1 * x1 + y1 * y1) - (x2 * x2 + y2 * y2);
        });

        for (int[] point : points) {
          pq.add(new AbstractMap.SimpleEntry<Integer, Integer>(point[0], point[1]));
        }

        int[][] closestk = new int[k][2];
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> point = pq.poll();
            closestk[i][0] = point.getKey();
            closestk[i][1] = point.getValue();
        }
        return closestk;
    }
    public int[][] kClosest(int[][] points, int k) {
        return get(points, k);
        
    }
}