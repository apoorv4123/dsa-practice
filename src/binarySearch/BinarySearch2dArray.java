package binarySearch;

public class BinarySearch2dArray {

	public static void main(String[] args) {

		int[][] arr = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
				{ 18, 21, 23, 26, 30 } };
		for (int a : firstPart(arr, 5)) {
			System.out.print(a + " ");
		}
		System.out.println(secondPart(firstPart(arr, 5), 5));

	}

	public static int[] firstPart(int[][] arr, int key) {
		int lo = 0, hi = arr.length - 1;
		int[] res = null;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (arr[mid][0] == key) {
				return arr[mid];
			}
			if (arr[mid][0] < key) {
				res = arr[mid];
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return res;
	}

	public static boolean secondPart(int[] arr, int key) {
		int lo = 0, hi = arr.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (arr[mid] == key) {
				return true;
			}
			if (arr[mid] < key) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return false;
	}

}
