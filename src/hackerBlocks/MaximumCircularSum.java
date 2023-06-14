package hackerBlocks;

public class MaximumCircularSum {

	public static void main(String[] args) {

		int[] arr = { 10, -12, -5, 3, 11 };
		System.out.println(BruteForceApproach(arr));
		System.out.println(BestApproach(arr));
	}

	public static int BruteForceApproach(int[] arr) {
		int maxsum = Integer.MIN_VALUE;
		for (int si = 0; si < arr.length; si++) {
			for (int ei = si; ei < si + arr.length; ei++) {
				int sum = 0;
				for (int k = si; k <= ei; k++) {
					sum += arr[k % arr.length];
				}
				if (sum > maxsum) {
					maxsum = sum;
				}
			}
		}
		return maxsum;
	}

	public static int BestApproach(int[] arr) {

		// case 1
		int nonWrappingMaxSum = kadanesAlgo(arr);

		// case 2: cont. elements are wrapping
		int totSum = 0;

		for (int i = 0; i < arr.length; i++) {
			totSum += arr[i];
			arr[i] = -arr[i];
		}

		int nonContributingElementsSum = kadanesAlgo(arr);

		int WrappingMaxSum = totSum + nonContributingElementsSum;

		return Math.max(nonWrappingMaxSum, WrappingMaxSum);

	}

//	public static int kadanesAlgo(int[] arr) {
//		int sum = 0;
//		int max = 0;
//		for (int i = 0; i < arr.length; i++) {
//
//			sum += arr[i];
//			max = Math.max(sum, arr[i]);
//
//			if (max > sum) {
//				sum = max;
//			}
//		}
//		return max;
//	}
	public static int kadanesAlgo(int[] arr) {

		int sum = arr[0];
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {

			sum = Math.max(sum + arr[i], arr[i]);

			if (sum > max) {
				max = sum;
			}
		}
		return max;

	}
}