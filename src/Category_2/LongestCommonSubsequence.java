package Category_2;

public class LongestCommonSubsequence {

	public int lcs(char[] str1, char[] str2) {

		String ans = "";

		int[][] dp = new int[str1.length + 1][str2.length + 1];
		int max = 0;
		for (int iter = 0; iter < dp.length; iter++) {
			for (int jter = 0; jter < dp[iter].length; jter++) {
				if (iter == 0 || jter == 0) {
					dp[iter][jter] = 0;
					continue;
				}
				if (str1[iter - 1] == str2[jter - 1]) { // if char matches then 1 + remaining match
					dp[iter][jter] = 1 + dp[iter - 1][jter - 1];
					ans = ans + str1[iter - 1];
				} else {
					dp[iter][jter] = Math.max(dp[iter - 1][jter], dp[iter][jter - 1]); // if no match then max of
																						// (remove the jth element,
																						// remove ith element)
				}
				max = dp[iter][jter] > max ? dp[iter][jter] : max;
			}
		}
		System.out.println(ans); // longest common subsequence.
		return max;
	}

}
