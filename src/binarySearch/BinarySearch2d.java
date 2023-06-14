package binarySearch;

public class BinarySearch2d {

	public static void main(String[] args) {
		int[][] arr = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
		System.out.println(bs2d(arr, 80));

	}

	public static boolean bs2d(int[][] arr, int target) {

		int startRow = 0;
		int endRow = arr.length - 1, targetRow = 0;
		while (startRow <= endRow) {
			int mid = (startRow + endRow) / 2;
			if (arr[mid][0] == target) {
				return true;
			} else if (arr[mid][0] < target) {
				targetRow = mid;
				startRow = mid + 1;
			} else {
				endRow = mid - 1;
			}
		}

		int startColumn = 0;
		int endColumn = arr[0].length - 1;
		while (startColumn <= endColumn) {
			while (startColumn < endColumn && arr[targetRow][startColumn] == arr[targetRow][startColumn + 1])
				startColumn++;
			while (startColumn < endColumn && arr[targetRow][endColumn] == arr[targetRow][endColumn - 1])
				endColumn--;
			int mid = (startColumn + endColumn) / 2;
			if (arr[targetRow][mid] == target) {
				return true;
			} else if (arr[targetRow][mid] < target) {
				startColumn = mid + 1;
			} else {
				endColumn = mid - 1;
			}
		}
		return false;

	}

}
