package Dynamic_Programming;

public class MainClass {
	public static void main(String[] args) {

		int val[] = { 1, 4, 5, 7 };
		int wt[] = { 1, 3, 4, 5 };

		KnapsackProblem kp = new KnapsackProblem();
		System.out.println(kp.knapsack(val, wt, 7));
	}

}
