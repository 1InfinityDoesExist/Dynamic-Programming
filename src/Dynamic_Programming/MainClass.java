package Dynamic_Programming;

import Category_2.EditDistanceProblem;

public class MainClass {
	public static void main(String[] args) {

//		int val[] = { 1, 4, 5, 7 };
//		int wt[] = { 1, 3, 4, 5 };
//
//		KnapsackProblem kp = new KnapsackProblem();
//		System.out.println(kp.knapsack(val, wt, 7));

//		String str1 = "ABCDGHLQR";
//		String str2 = "AEDPHR";
//
//		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
//		System.out.println(lcs.lcs(str1.toCharArray(), str2.toCharArray()));

//		SubSetSumProblem sb = new SubSetSumProblem();
//		System.out.println(sb.sub_set_sum_problem(new int[] { 2, 3, 7, 8 }, 11));

//		int total = 11;
//		int coins[] = { 1, 5, 6, 8 };
//		CoinChaningProblem cc = new CoinChaningProblem();
//		System.out.println(cc.coinChaningProblem(coins, total));

		String str1 = "azced";
		String str2 = "abcdef";
		EditDistanceProblem editDistance = new EditDistanceProblem();
		int result = editDistance.editDistance(str2.toCharArray(), str1.toCharArray());
		System.out.println(result);
	}

}
