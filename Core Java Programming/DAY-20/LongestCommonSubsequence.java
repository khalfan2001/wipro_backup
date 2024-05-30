/*Task 2: Longest Common Subsequence
Implement int LCS(string text1, string text2)  to find the length of the longest common subsequence between two strings.*/

package day20_Assignment_2;

public class LongestCommonSubsequence {

	public static int LCS(String text1, String text2) {
		int m = text1.length();
		int k = text2.length();

		int[][] dp = new int[m + 1][k + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= k; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {

					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {

					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[m][k];
	}

	public static void main(String[] args) {
		String text1 = "abcde";
		String text2 = "ace";

		int lcsLength = LCS(text1, text2);
		System.out.println("The length of the longest common subsequence is: " + lcsLength);
	}

}
