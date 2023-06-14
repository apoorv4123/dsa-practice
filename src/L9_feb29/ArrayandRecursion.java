package L9_feb29;

public class ArrayandRecursion {

	public static void main(String[] args) {
		
		int[] arr = { 10, 22, 70, 30, 90, 30, 30, 40 };
		
		System.out.println(maxArr(arr, 0));
		System.out.println();
		
		System.out.println(firstIndex(arr, 0, 30));
		System.out.println();
		
		System.out.println(lastIndex(arr, 0, 30));
		System.out.println();
		
		for (int val : allIndices(arr, 0, 20, 0)) {
			System.out.println(val);
		}
	}

	public static int maxArr(int[] arr, int idx) {
//		if (idx == arr.length - 1) {
//			return arr[idx];
//		}
		if (idx == arr.length) {
			return Integer.MIN_VALUE;
		}
		int max1 = maxArr(arr, idx + 1);
//		if (max1 > arr[idx]) {
//			return max1;
//		} else {
//			return arr[idx];
//		}
		return Math.max(arr[idx], max1);
	}

	public static int firstIndex(int[] arr, int idx, int item) {
		if (idx == arr.length) {
			return -1;
		}
		if (arr[idx] == item) {
			return idx;
		}
		int id = firstIndex(arr, idx + 1, item);
		return id;
	}

	public static int lastIndex(int[] arr, int idx, int item) {
		if (idx == arr.length) {
			return -1;
		}
		int rr = lastIndex(arr, idx + 1, item);
		if (arr[idx] == item && rr == -1) {
			return idx;
		}
		return rr;
	}

	public static int[] allIndices(int[] arr, int idx, int item, int count) {
		if (idx == arr.length) {
			int[] ans = new int[count];
			return ans;
		}
		if (arr[idx] == item) {
			int[] rr = allIndices(arr, idx + 1, item, count + 1);
			rr[count] = idx;
			return rr;
		} else {
			int[] rr = allIndices(arr, idx + 1, item, count);
			return rr;
		}
	}
}
