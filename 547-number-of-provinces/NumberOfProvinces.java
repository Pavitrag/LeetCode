package org.challenges.algorithm;

import java.util.Stack;

public class NumberOfProvinces {
    int pos = 0;
    int nextUnVisited(boolean[] visited){
        for(int i = pos; i < visited.length; i++){
            if(!visited[i]){
                pos = i + 1;
                return i;
            }
        }
        return -1;
    }
    public int findCircleNum(int[][] isConnected) {
        int connectedComponents = 0;
        int len = isConnected.length;
        boolean[] visited = new boolean[len];
        int curr = -1;
        while((curr = nextUnVisited(visited)) != -1){
            connectedComponents++;
            Stack<Integer> stack = new Stack<>();
            stack.push(curr);
            visited[curr] = true;
            while(!stack.empty()){
                int top = stack.pop();
                for(int i = top+1; i < len; i++){
                    if((isConnected[top][i] == 1) && !visited[i]){
                        visited[i] = true;
                        stack.push(i);
                    }
                }
            }
        }
        return connectedComponents;
    }

    public int findCircleNumRecursive(int[][] isConnected) {
        int connectedComponents = 0;
        int len = isConnected.length;
        boolean[] visited = new boolean[len];
        for(int i = 0; i < len; i++){
            if(!visited[i]) {
                connectedComponents++;
                dfs(isConnected, i, visited);
            }
        }
        return connectedComponents;
    }

    private void dfs(int[][] isConnected, int curr, boolean[] visited) {
        visited[curr] = true;
        for(int i = 0; i < isConnected.length; i++){
            if((isConnected[curr][i] == 1) && !visited[i]){
                dfs(isConnected, i, visited);
            }
        }
    }

    public static void main(String[] args) {
        NumberOfProvinces p = new NumberOfProvinces();
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(p.findCircleNumRecursive(isConnected));
        isConnected = new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        System.out.println(p.findCircleNumRecursive(isConnected));
    }
}
