package L29_DP;

public class BoardPath {

	public static void main(String[] args) {

		int end = 1000000;
//		System.out.println(BPRecursion(0, n));
//		System.out.println(BPTD(0, n, new int[n]));
		System.out.println(BPBU(end));
		System.out.println(BPBUSE(end));
	}

	public static int BPRecursion(int curr, int end) {

		if (curr == end) {
			return 1;
		}

		if (curr > end) {
			return 0;
		}

		int count = 0;

		for (int dice = 1; dice <= 6; dice++) {
			count += BPRecursion(curr + dice, end);
		}

		return count;

	}

	public static int BPTD(int curr, int end, int[] storage) {

		if (curr == end) {
			return 1;
		}

		if (curr > end) {
			return 0;
		}

		// reuse
		if (storage[curr] != 0) {
			return storage[curr];
		}

		int count = 0;

		for (int dice = 1; dice <= 6; dice++) {
			count += BPTD(curr + dice, end, storage);
		}

		storage[curr] = count; // store

		return count;

	}

	// TC : O(n) , SC : O(n)
	public static int BPBU(int end) {

		int[] storage = new int[end + 6];

		storage[end] = 1;

		for (int i = end - 1; i >= 0; i--) {

			int sumofnext6 = storage[i + 1] + storage[i + 2] + storage[i + 3] + storage[i + 4] + storage[i + 5]
					+ storage[i + 6];

			storage[i] = sumofnext6;
		}

		return storage[0];

	}

	public static int BPBUSE(int end) {

		int[] storage = new int[6];
		storage[0] = 1;

		for (int slide = 1; slide <= end; slide++) {

			int sum = storage[0] + storage[1] + storage[2] + storage[3] + storage[4] + storage[5];

			for (int i = storage.length - 1; i > 0; i--) {
				storage[i] = storage[i - 1];
			}

			storage[0] = sum;

		}

		return storage[0];

	}

}