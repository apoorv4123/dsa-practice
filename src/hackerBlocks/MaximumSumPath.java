package hackerBlocks;

import java.util.Scanner;

public class MaximumSumPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int[] one = { 2, 3, 7, 10, 12, 15, 30, 34 };
//		int[] two = { 1, 5, 7, 8, 10, 15, 16, 19 };

		Scanner s = new Scanner(System.in);
		int t = s.nextInt();

		while (t > 0) {

			int s1 = s.nextInt();
			int s2 = s.nextInt();
			int[] one = new int[s1];
			int[] two = new int[s2];

			for (int i = 0; i < one.length; i++) {
				one[i] = s.nextInt();
			}

			for (int i = 0; i < two.length; i++) {
				two[i] = s.nextInt();
			}

			int i = 0;
			int j = 0;

			int sum1 = 0;
			int sum2 = 0;

			int sum = 0;

			while (i < one.length && j < two.length) {
				if (one[i] < two[j]) {
					sum1 += one[i];
					i++;
				} else if (one[i] > two[j]) {
					sum2 += two[j];
					j++;
				} else {
					// you've reached equal element
					sum += Math.max(sum1, sum2) + one[i];
					sum1 = 0;
					sum2 = 0;
					i++;
					j++;

				}
			}

			// if i has reached out of boundary
			if (i == one.length) {
				while (j < two.length) {
					sum2 += two[j];
					j++;
				}
			}

			// if j has reached out of boundary
			if (j == two.length) {
				while (i < one.length) {
					sum1 += one[i];
					i++;
				}
			}

			sum += Math.max(sum1, sum2);
			System.out.println(sum);
			t--;
		}
	}

}