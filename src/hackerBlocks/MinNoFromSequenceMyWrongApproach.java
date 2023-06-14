package hackerBlocks;

import java.util.ArrayList;
import java.util.Scanner;

public class MinNoFromSequenceMyWrongApproach {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		ArrayList<String> al = new ArrayList<>();
		int sz = n;
		while (sz > 0) {
			al.add(s.next());
			sz--;
		}
		while (sz < n) {
			String str = al.get(sz);
			int[] arr = new int[str.length() + 1];
			arr[0] = 1;
			int i = 0, idx = 1;
			while (i < str.length()) {
				if (str.charAt(i) == 'D') {
					incByOne(arr, 0, idx);
					arr[idx] = minArr(arr, 0, idx) - 1;
				} else {
					arr[idx] = maxArr(arr, 0, idx) + 1;
				}
				idx++;
				i++;
			}
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[j]);
			}
			System.out.println();
			sz++;
		}
	}

	public static int maxArr(int[] arr, int lo, int hi) {
		int max = Integer.MIN_VALUE;
		for (int i = lo; i < hi; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

	public static int minArr(int[] arr, int lo, int hi) {
		int min = Integer.MAX_VALUE;
		for (int i = lo; i < hi; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		return min;
	}

	public static void incByOne(int[] arr, int lo, int hi) {
		for (int i = lo; i < hi; i++) {
			arr[i] = arr[i] + 1;
		}
	}
}