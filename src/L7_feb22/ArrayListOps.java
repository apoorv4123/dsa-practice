package L7_feb22;

import java.util.ArrayList;

public class ArrayListOps {

	public static void main(String[] args) {
		int[] one = { 10, 19, 20, 30, 40, 40, 40, 50 };
		int[] two = { 15, 16, 17, 18, 20, 25, 30, 30, 40 };
		System.out.println(intersection(one, two));
		System.out.println(sumof2arrays(one, two));

	}

	public static ArrayList<Integer> intersection(int[] one, int[] two) {
		ArrayList<Integer> list = new ArrayList<>();
		int i = 0, j = 0;
		while (i < one.length && j < two.length) {
			if (one[i] < two[j]) {
				i++;
			} else if (one[i] > two[j]) {
				j++;
			} else {
				list.add(one[i]);
				i++;
				j++;
			}
		}

		System.out.println(list);
		return null;
	}

	public static ArrayList<Integer> sumof2arrays(int[] one, int[] two) {
		ArrayList<Integer> sum = new ArrayList<>();
		int i = one.length - 1;
		int j = two.length - 1;
		int carry = 0;
		while (i >= 0 || j >= 0) {
			int psum = 0;
			if (i < 0) {
				psum = carry + two[j];
				if (psum % 10 == psum) {
					sum.add(0, psum);
				} else if (psum % 10 != psum) {
					sum.add(0, psum % 10);
					carry = psum / 10;
					j--;
				}
			} else if (j < 0) {
				psum = carry + one[i];
				if (psum % 10 == psum) {
					sum.add(0, psum);
				} else if (psum % 10 != psum) {
					sum.add(0, psum % 10);
					carry = psum / 10;
					i--;
				}
			} else {
				psum = carry + one[i] + two[j];
				if (psum % 10 == psum) {
					sum.add(0, psum);
				} else if (psum % 10 != psum) {
					sum.add(0, psum % 10);
					carry = psum / 10;
				}
				i--;
				j--;
			}
		}
		if (carry > 0) {
			sum.add(0, carry);
		}
		return sum;
	}

}
