package Dynamic_Programming;

import java.util.ArrayList;
import java.util.List;

public class KnapsackProblem {

	public int knapsack(int[] value, int[] weight, int W) {

		int[][] dp = new int[weight.length + 1][W + 1];
		for (int iter = 0; iter <= weight.length; iter++) {
			for (int jter = 0; jter <= W; jter++) {
				if (iter == 0 || jter == 0) {
					dp[iter][jter] = 0;
					continue;
				}
				if (weight[iter - 1] > jter) {// if weight is greater then j
					dp[iter][jter] = dp[iter - 1][jter]; // take the value from top.
				} else { // if weight is less than or equal to j (where j is weight from 0 to W)
					dp[iter][jter] = Math.max(value[iter - 1] + dp[iter - 1][jter - weight[iter - 1]],
							dp[iter - 1][jter]); // take max of Value of current weight + value of remaining weight and
													// value by skipping that weight basically take the value from top
				}
			}
		}

		// weight added in the sack.
		int x = weight.length;
		int y = W;
		List<Integer> ans = new ArrayList<>();
		while (true) {
			if (dp[x][y] == 0) {
				break;
			}
			if (dp[x][y] == dp[x - 1][y]) {
				x--;
			} else {
				ans.add(weight[x - 1]);
				y = y - weight[x - 1];
				x--;

			}
		}

		return dp[weight.length][W];
	}

}
