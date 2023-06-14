package binarySearch;

public class MinimumSizeSubarraySum {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		System.out.println(kadanesAlgo(arr, 11));

	}

	public static int kadanesAlgo(int[] arr, int s) {

		int sum = arr[0];
		int count = 1, ans = 0;
		for (int i = 1; i < arr.length; i++) {

			sum = Math.max(sum + arr[i], arr[i]);

			if (sum >= s) {
				ans = ++count;
				count = 0;
				sum = 0;
				continue;
			}
			count++;
		}
		return ans;

	}

}
