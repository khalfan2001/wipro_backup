/*Task 1: Knapsack Problem
Write a function int Knapsack(int W, int[] weights, int[] values) in Java that determines the maximum
value of items that can fit into a knapsack with a capacity W. The function should handle up 
to 100 items. Find the optimal way to fill the knapsack with the given items to achieve the maximum total value. 
You must consider that you cannot break items, but have to include them whole.*/


package day20_Assignment_1;

public class KnapsackProblem {

	public static int Knapsack(int W, int[] weights, int[] values) {
		int n = weights.length;

		int[][] dp = new int[n + 1][W + 1];

		for (int i = 0; i <= n; i++) {
			for (int w = 0; w <= W; w++) {
				if (i == 0 || w == 0) {
					dp[i][w] = 0;
				} else if (weights[i - 1] <= w) {

					dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
				} else {

					dp[i][w] = dp[i - 1][w];
				}
			}
		}

		return dp[n][W];
	}

	public static void main(String[] args) {
		int W = 50;
		int[] weights = { 10, 20, 30 };
		int[] values = { 60, 100, 120 };

		int maxValue = Knapsack(W, weights, values);
		System.out.println("The maximum value of items that can fit into the knapsack is: " + maxValue);
	}

}
