package binarySearch;

public class SquareRoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(squareRoot(2, 2));
	}

	public static float squareRoot(int number, int precision) {

		int start = 0, end = number, mid = 0;
		float ans = 0;

		// integer part
		while (start <= end) {
			mid = (start + end) / 2;
			if (mid * mid < number) {
				ans = mid;
				start = mid + 1;
			} else if (mid * mid > number) {
				end = mid - 1;
			} else {
				ans = mid;
				break;
			}
		}

//		 precision part
		float inc = 0.1f;
		for (int i = 1; i <= precision; i++) {

			while (ans * ans <= number) {
				ans += inc;
			}
			ans -= inc;
//			System.out.println(i + ". " + ans);
			inc /= 10;

		}

//		float a = ans, temp = 0;
//		int dec = 10;
//		for (int i = 1; i <= precision; i++) {
//			int start1 = 1, end1 = 9, mid1 = 0;
//			while (start1 <= end1) {
//				mid1 = (start1 + end1) / 2;
//				float pre = (float) mid1 / dec;
//				if ((a + pre) * (a + pre) < number) {
//					temp = a + pre;
//					start1 = mid1 + 1;
//				} else if ((a + pre) * (a + pre) > number) {
//					end1 = mid1 - 1;
//				} else {
//					return a + pre;
//				}
//			}
//			a = temp;
//			dec *= 10;
//		}
		return ans;
	}

}
