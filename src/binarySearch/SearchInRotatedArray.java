package binarySearch;

public class SearchInRotatedArray {

	public static void main(String[] args) {
		int[] arr = { 4, 5, 6, 7, 8, 1, 2, 3 };
		System.out.println(binarySearch(arr, 9));

	}

	public static int binarySearch(int[] arr, int tgt) {

		int st = 0;
		int end = arr.length - 1;
		while (st <= end) {
			int mid = (st + end) / 2;
			if (arr[mid] == tgt) {
				return mid;
			} else if (arr[mid] <= arr[end]) {
				if (tgt > arr[mid] && tgt <= arr[end]) {
					st = mid + 1;
				} else {
					end = mid - 1;
				}
			} else if (arr[mid] >= arr[st]) {
				if (tgt < arr[mid] && tgt >= arr[st]) {
					end = mid - 1;
				} else {
					st = mid + 1;
				}
			}
		}
		return -1;
	}

}
