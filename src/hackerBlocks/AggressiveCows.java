package hackerBlocks;

import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {
//MAXIMISE THE MINIMUM VALUES
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int test = s.nextInt();

		while (test > 0) {
			int nos = s.nextInt();// no. of stalls
			int noc = s.nextInt();// no. of cows

			int[] stall = new int[nos];
			for (int i = 0; i < stall.length; i++) {
				stall[i] = s.nextInt();
			}
			Arrays.sort(stall);

			// logic...
			int lo = 0;
			int hi = stall[stall.length - 1] - stall[0];
			int finalAns = 0;

			while (lo <= hi) {// O(nlog n)
				int mid = (lo + hi) / 2;

				if (isItPossibleToPlaceCows(stall, nos, noc, mid)) {
					finalAns = mid;
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}
			}

			System.out.println(finalAns);

			test--;
		}
		
		s.close();
	}

	public static boolean isItPossibleToPlaceCows(int[] stall, int nos, int noc, int mid) {

		// initially, place one cow at first stall
		int cowsplacedsofar = 1;
		int lastPos = stall[0];

		// next cows will start placing from second stall i.e. 1st index of stall
		for (int i = 1; i < stall.length; i++) {// O(n)

			if (stall[i] - lastPos >= mid) {
				cowsplacedsofar++;
				lastPos = stall[i];

				if (cowsplacedsofar == noc) {
					return true;
				}
			}
		}
		// code yha p aa rha hai it means ki saare k saare indexes check ho gye but cows
		// minimum distance mid rakh ke saari cows place
		// nhi ho paayi, so retuen false
		return false;
	}
}
