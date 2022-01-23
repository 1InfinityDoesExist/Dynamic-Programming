package Category_1;

import java.util.ArrayList;
import java.util.List;

public class CoinChaningProblem {

	public int coinChaningProblem(int[] coins, int total) {
		int[][] dp = new int[coins.length + 1][total + 1];
		for (int iter = 0; iter < dp.length; iter++) {
			for (int jter = 0; jter <= total; jter++) {
				if (iter == 0 || jter == 0) { // 0th column will be 0
					if (iter == 0 && jter == 0) { // 0th row will contains maximum value.
						dp[iter][jter] = 0;
					} else if (jter == 0) {
						dp[iter][jter] = 0;
					} else {
						dp[iter][jter] = Integer.MAX_VALUE;
					}
					continue;
				}
				if (coins[iter - 1] > jter) {
					dp[iter][jter] = dp[iter - 1][jter];
				} else {
					dp[iter][jter] = Math.min(dp[iter - 1][jter], 1 + dp[iter][jter - coins[iter - 1]]);
				}
			}
		}

		// weight added in the sack.
		int x = coins.length;
		int y = total;
		List<Integer> ans = new ArrayList<>();
		while (true) {
			if (dp[x][y] == 0) {
				break;
			}
			if (dp[x][y] == dp[x - 1][y]) {
				x--;
			} else {
				ans.add(coins[x - 1]);
				y = y - coins[x - 1];
			}
		}
		for (int iter = 0; iter < ans.size(); iter++) {
			System.out.println(ans.get(iter));
		}

		return dp[coins.length][total];
	}

}
