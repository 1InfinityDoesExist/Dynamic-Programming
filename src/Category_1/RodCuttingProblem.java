package Category_1;

import java.util.ArrayList;
import java.util.List;

public class RodCuttingProblem {

	public int rodCuttingProblem(int[] rodLength, int[] value, int rod) {

		int[][] dp = new int[rodLength.length + 1][rod + 1];
		for (int iter = 0; iter < dp.length; iter++) {
			for (int jter = 0; jter < dp[iter].length; jter++) {
				if (iter == 0 || jter == 0) {
					dp[iter][jter] = 0;
					continue;
				}
				if (rodLength[iter - 1] > jter) {
					dp[iter][jter] = dp[iter - 1][jter];
				} else {
					dp[iter][jter] = Math.max(value[iter - 1] + dp[iter][jter - rodLength[iter - 1]],
							dp[iter - 1][jter]);
				}

			}
		}

		// Required length of rod.
		int x = rodLength.length;
		int y = rod;
		List<Integer> rodLen = new ArrayList<Integer>();
		while (true) {
			if (y == 0) {
				break;
			}
			if (dp[x][y] == dp[x - 1][y]) {
				x = x - 1;
			} else {
				rodLen.add(rodLength[x - 1]);
				y = y - rodLength[x - 1];
			}
		}

		for (int iter = 0; iter < rodLen.size(); iter++) {
			System.out.println(rodLen.get(iter));
		}
		return dp[rodLength.length][rod];
	}

}
