package com.day19;

import java.util.Arrays;
public class TravellingSalesManProblem {
    private static final int INF = Integer.MAX_VALUE;
    public static int FindMinCost(int[][] graph) {
        int n = graph.length;
        int[][] memo = new int[n][(1 << n)];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return tsp(0, 1, graph, memo);
    }
    private static int tsp(int pos, int mask, int[][] graph, int[][] memo) {
        int n = graph.length;
             if (mask == (1 << n) - 1) {
            return graph[pos][0];
        }
             if (memo[pos][mask] != -1) {
            return memo[pos][mask];
        }
        int ans = INF;
             for (int city = 0; city < n; city++) {
            if ((mask & (1 << city)) == 0) {
                int newAns = graph[pos][city] + tsp(city, mask | (1 << city), graph, memo);
                ans = Math.min(ans, newAns);
            }        }
             memo[pos][mask] = ans;
        return ans;
    }
        public static void main(String[] args) {
        int[][] graph = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}};
        int result = FindMinCost(graph);
        System.out.println("The minimum cost to visit all cities and return to the starting city is: " + result);
    }
}
