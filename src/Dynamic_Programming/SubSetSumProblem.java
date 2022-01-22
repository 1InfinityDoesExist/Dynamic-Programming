package Dynamic_Programming;

import java.util.ArrayList;
import java.util.List;

public class SubSetSumProblem {

	public boolean sub_set_sum_problem(int[] number, int sum) {

		boolean[][] dp = new boolean[number.length + 1][sum + 1];
		for (int iter = 1; iter < dp.length; iter++) {
			for (int jter = 0; jter < dp[iter].length; jter++) {
				if (jter == 0) {
					dp[iter][jter] = true;
					continue;
				}
				if (number[iter - 1] > jter) {
					dp[iter][jter] = dp[iter - 1][jter];
				} else {
					dp[iter][jter] = dp[iter - 1][jter] || dp[iter - 1][jter - number[iter - 1]];
				}
			}
		}
		// subset whose sum add up to sum
		int x = number.length;
		int y = sum;
		List<Integer> ans = new ArrayList<>();
		while (true) {
			if (y == 0) {
				break;
			}
			if (dp[x][y] == dp[x - 1][y]) {
				x--;
			} else {
				ans.add(number[x - 1]);
				y = y - number[x - 1];
				x--;

			}
		}
		for (int iter = 0; iter < ans.size(); iter++) {
			System.out.println(ans.get(iter));
		}
		return dp[number.length][sum];
	}

}
