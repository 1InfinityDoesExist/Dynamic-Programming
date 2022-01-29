package Category_3;

import java.util.ArrayList;
import java.util.List;

public class MininumJumpToReachEnd {

	public int minJump(int[] input) {
		int[] noOfJumps = new int[input.length];
		int[] actualJump = new int[input.length];

		actualJump[0] = -1;
		noOfJumps[0] = 0;
		for (int iter = 1; iter < noOfJumps.length; iter++) {
			noOfJumps[iter] = Integer.MAX_VALUE;
		}

		for (int iter = 1; iter < noOfJumps.length; iter++) {
			for (int jter = 0; jter < iter; jter++) {
				if (jter + input[jter] >= iter && 1 + noOfJumps[jter] < noOfJumps[iter]) { // second condition is
																							// important to add here
																							// instead of using Math.min
					noOfJumps[iter] = 1 + noOfJumps[jter];
					actualJump[iter] = jter;
				}
			}
		}

		// actual jumps
		List<Integer> jumps = new ArrayList<>();
		jumps.add(actualJump.length - 1);
		int iter = actualJump.length - 1;
		while (true) {
			if (actualJump[iter] == -1) {
				break;
			}
			jumps.add(actualJump[iter]);
			iter = actualJump[iter];
		}
		for (int i = 0; i < jumps.size(); i++) {
			System.out.println(jumps.get(i));
		}
		return noOfJumps[input.length - 1];
	}
}
