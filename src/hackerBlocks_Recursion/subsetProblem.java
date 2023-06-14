package hackerBlocks_Recursion;

import java.util.Scanner;

public class subsetProblem {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int n = s.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = s.nextInt();
		}

		int target = s.nextInt();

		int ans = subset(arr, 0, 0, "", target);
		System.out.println();
		System.out.println(ans);
		
		s.close();
	}

	public static int subset(int[] arr, int vidx, int sum, String ans, int target) {

		if (vidx == arr.length) {

			if (sum == target) {
				System.out.print(ans + " ");
				return 1;
			}
			return 0; 
		}

		// include
		int include = subset(arr, vidx + 1, sum + arr[vidx], ans + arr[vidx] + " ", target);
		// exclude
		int exclude = subset(arr, vidx + 1, sum, ans, target);

		return include + exclude;
	}

}
