package Category_2;

public class EditDistanceProblem {

	public int editDistance(char[] from, char[] to) {

		int[][] dp = new int[to.length + 1][from.length + 1];
		for (int iter = 0; iter < dp.length; iter++) {
			for (int jter = 0; jter < dp[iter].length; jter++) {
				if (iter == 0 || jter == 0) {
					if (iter == 0 && jter == 0) {
						dp[iter][jter] = 0;
					} else if (jter == 0) {
						dp[iter][jter] = iter;
					} else {
						dp[iter][jter] = jter;
					}
					continue;
				}
				if (to[iter - 1] == from[jter - 1]) {
					dp[iter][jter] = dp[iter - 1][jter - 1];
				} else {
					dp[iter][jter] = 1
							+ Math.min(Math.min(dp[iter - 1][jter], dp[iter][jter - 1]), dp[iter - 1][jter - 1]);
				}
			}
		}

		int x = dp.length - 1;
		int y = dp[x].length - 1;
		while (true) {
			if (dp[x][y] == 0) {
				break;
			}
			if (to[x - 1] == from[y - 1]) {
				x = x - 1;
				y = y - 1;
			} else if (dp[x][y] == dp[x - 1][y - 1] + 1) {
				System.out.println("Char " + from[y - 1] + " is changed to " + to[x - 1]);
				x = x - 1;
				y = y - 1;

			} else if (dp[x][y] == dp[x - 1][y] + 1) {
				System.out.println("Char " + to[x - 1] + " is deleted");
				x = x - 1;

			} else if (dp[x][y] == dp[x][y - 1] + 1) {
				System.out.println("Char " + from[y - 1] + " is deleted");

				y = y - 1;

			} else {
				System.out.println("Something went wrong");
				break;
			}

		}

		return dp[to.length][from.length];
	}

}
