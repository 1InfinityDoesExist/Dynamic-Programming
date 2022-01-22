package Dynamic_Programming;

public class KnapsackProblem {

	public int knapsack(int[] value, int[] weight, int W) {

		int[][] dp = new int[weight.length + 1][W + 1];
		for (int iter = 0; iter <= weight.length; iter++) {
			for (int jter = 0; jter <= W; jter++) {
				if (iter == 0 || jter == 0) {
					dp[iter][jter] = 0;
					continue;
				}
				if (weight[iter - 1] > jter) {
					dp[iter][jter] = dp[iter - 1][jter];
				} else {
					dp[iter][jter] = Math.max(value[iter - 1] + dp[iter - 1][jter - weight[iter - 1]],
							dp[iter - 1][jter]);
				}
			}
		}

		for (int iter = 0; iter < weight.length + 1; iter++) {
			for (int jter = 0; jter < W + 1; jter++) {
				System.out.print(dp[iter][jter] + " ");
			}
			System.out.println();
		}
		return dp[weight.length][W];
	}

}
