package Category_4;

public class LongestPalindromicSubsequence {
	public int LPS(char[] str) {

		int[][] dp = new int[str.length][str.length];
		for (int iter = 0; iter < str.length; iter++) {
			dp[iter][iter] = 1;
		}

		// sliding window protocol.
		for (int k = 2; k <= dp.length; k++) {
			for (int iter = 0; iter <= str.length - k; iter++) {
				int jter = iter + k - 1;

				if (str[iter] == str[jter]) {
					dp[iter][jter] = dp[iter + 1][jter - 1] + 2;
				} else {
					dp[iter][jter] = Math.max(dp[iter][jter - 1], dp[iter + 1][jter]);
				}
			}
		}

		// the subsequence which is palindrom is.
		String ans = "";
		int x = 0;
		int y = str.length - 1;
		while (true) {
			if (x == y) {
				ans = ans + str[x] + new StringBuilder(ans).reverse().toString();
				break;
			}
			if ((dp[x][y] == 2 + dp[x + 1][y - 1]) && (str[x] == str[y])) {
				ans = ans + str[y];
				x = x + 1;
				y = y - 1;
			} else if (dp[x][y] == dp[x][y - 1]) {
				y = y - 1;
			} else if (dp[x][y] == dp[x + 1][y]) {
				x = x + 1;
			}
		}
		System.out.println(ans);
		return dp[0][str.length - 1];
	}
}
