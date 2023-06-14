package L14_apr15;

public class MergeSort {

	public static void main(String[] args) {

		int[] arr = { 90, 50, 30, 80, 60, 20, 45, 10, 70, 25 };
		int[] ans = mergeSort(arr, 0, arr.length - 1);

//		int[] one = { 10, 20, 30, 40, 50 };
//		int[] two = { 2, 3, 10, 11, 15, 16, 90, 100 };
//		int[] ans = mergeTwoSorteArrays(one, two);

		for (int val : ans) {
			System.out.print(val + " ");
		}

	}

	public static int[] mergeTwoSorteArrays(int[] one, int[] two) {

		int[] merged = new int[one.length + two.length];
		int i = 0; // one
		int j = 0; // two

		int k = 0; // merge array

		while (i < one.length && j < two.length) {

			if (one[i] < two[j]) {
				merged[k] = one[i];
				k++;
				i++;
			} else {
				merged[k] = two[j];
				k++;
				j++;
			}
		}

		if (i == one.length) {

			while (j < two.length) {
				merged[k] = two[j];
				k++;
				j++;
			}
		}

		if (j == two.length) {

			while (i < one.length) {
				merged[k] = one[i];
				k++;
				i++;
			}
		}
		return merged;
	}

	// array is always broken virtually by taking two variables, low an high
	public static int[] mergeSort(int[] arr, int lo, int hi) {

		if (lo == hi) {
			int[] br = new int[1];
			br[0] = arr[lo];
			return br;
		}

		int mid = (lo + hi) / 2;

		int[] fpres = mergeSort(arr, lo, mid); // first half result, first half sorted
		int[] spres = mergeSort(arr, mid + 1, hi); // second half result, second half sorted

		int[] result = mergeTwoSorteArrays(fpres, spres);

		return result;
	}
}