package L6_feb16;

public class Question {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };
		int[] narr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			int pro = 1;
			for (int j = 0; j < arr.length; j++) {
				if (j == i) {
					continue;
				} else {
					pro *= arr[j];
				}
			}
			narr[i] = pro;
		}
		for (int val : narr) {
			System.out.print(val + " ");
		}

	}

}
