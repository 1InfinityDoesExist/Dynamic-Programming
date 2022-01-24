package Category_3;

public class LongestIncreasingSubsequence {
	public int LIS(int[] arr) {
		int max = Integer.MIN_VALUE;

		int[] dp = new int[arr.length];
		for (int iter = 0; iter < dp.length; iter++) {
			dp[iter] = 1; // because we know at every point the lis is at least 1 thats for sure.
		}

		for (int iter = 1; iter < dp.length; iter++) {
			for (int jter = 0; jter < iter; jter++) {

				if (arr[jter] < arr[iter]) {
					dp[iter] = Math.max(dp[jter] + 1, dp[iter]);
				}

				if (dp[iter] > max) {
					max = dp[iter];
				}
			}
		}

		return max;
	}

}
