package hackerBlocks;

public class KadanesAlgorithm {

	public static void main(String[] args) {

		int[] arr = {-2,1,-3,4,-1,2,1,-5,4 };
//		int[] arr = { -10, 2, -1, 3, -2 };
		System.out.println(kadanesAlgo(arr));
	}

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
