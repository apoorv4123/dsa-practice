package L22_Hashmap;

import java.util.HashMap;
import java.util.Scanner;

public class Questions {

	public static void main(String[] args) {

//		Scanner s = new Scanner(System.in);
//		String str = s.next();
//		maxFrequenchChar(str);

//		int[] one = { 10, 200, 30, 10, 30, 40, 50, 40 };
//		int[] two = { 40, 10, 50, 50, 30, 30, 10, 10, 50, 10 };
//		int[] one2 = { 5, 1, 3, 4, 7 };
//		int[] two2 = { 2, 4, 3, 5, 7, 10, 15 };
//		intersection(one, two);
//		System.out.println();
//		intersection2(one2, two2);

		int[] arr = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 };
		largestPossibleSeqOfConseqNos(arr);
	}

	public static void maxFrequenchChar(String str) {

		HashMap<Character, Integer> map = new HashMap<>();

		int i = 0;

		while (i < str.length()) {

			char ch = str.charAt(i);
//			if (map.containsKey(ch)) {
//				int of = map.get(ch);
//				map.put(ch, of + 1);
//			} else {
//				map.put(ch, 1);
//			}
			int of = map.getOrDefault(ch, 0);
			map.put(ch, of + 1);

			i++;
		}

		// traverse over map an find the highest frequency character
		int maxFreq = Integer.MIN_VALUE;
		char maxFreqChar = '\0';

		for (char key : map.keySet()) { // entry set can also be used

			if (map.get(key) > maxFreq) {
				maxFreq = map.get(key);
				maxFreqChar = key;
			}
		}

		// work can be done in one loop itself

		System.out.println(maxFreqChar);

	}

	public static void intersection(int[] one, int[] two) {

		// make hashmap of array two
		HashMap<Integer, Integer> map2 = new HashMap<>();

		// frequency map for array two
		for (int key : two) {
			int of = map2.getOrDefault(key, 0);
			map2.put(key, of + 1);
		}

		// traverse over array one
		for (int key : one) {

			if (map2.containsKey(key) && map2.get(key) > 0) {

				System.out.println(key);
				map2.put(key, map2.get(key) - 1);
			}
		}
	}

	// this method will be used if neither of the array contains duplicate values
	public static void intersection2(int[] one, int[] two) {

		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();

		for (int key : one) {
			map.put(key, false);
		}

		for (int key : two) {

			if (map.containsKey(key) && map.get(key) == false) {
				System.out.println(key);
				map.put(key, true);
			}

		}
	}

	public static void largestPossibleSeqOfConseqNos(int[] arr) {

		HashMap<Integer, Boolean> map = new HashMap<>();

		for (int key : arr) {

			// insert the key
			if (map.containsKey(key - 1)) {
				map.put(key, false);
			} else {
				map.put(key, true);
			}

			// key after being place will impact key+1
			if (map.containsKey(key + 1)) {
				map.put(key + 1, false);
			}

		}

		int maxLength = 0;
		int seqStart = 0;
		// filter out the nos which are starting points of a sequences
		for (int key : map.keySet()) {
			if (map.get(key)/* ==true */) {

				int count = 0;
				while (map.containsKey(key + count)) {
					count++;
				}

				if (count > maxLength) {
					maxLength = count;
					seqStart = key;
				}

			}
		}

		for (int i = 0; i < maxLength; i++) {
			System.out.print(seqStart + i + " ");
		}

	}

}