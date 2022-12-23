package org.challenges.algorithm;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @LeetCode Problem: 1872 · Minimum Cost to Connect Sticks
 * @url: https://www.lintcode.com/problem/1872/
 * @LeetCode url: https://leetcode.com/problems/minimum-cost-to-connect-sticks/ [Premium]
 * @other url:https://leetcode.ca/all/1167.html
 */
public class MinimumCostToConnectSticks {
    public int minimumCost(List<Integer> sticks) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for(int e: sticks){
            minHeap.add(e);
        }
        int cost = 0;
        while(minHeap.size() > 1){
            int sum = (minHeap.poll() + minHeap.poll());
            cost += sum;
            minHeap.add(sum);
        }
        return cost;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumCostToConnectSticks().minimumCost(List.of(16, 62, 43)));
        System.out.println(new MinimumCostToConnectSticks().minimumCost(List.of(25,62,51,92,93,40,23,16,36,32)));
    }

}
