package binarySearch;

public class divide2Nos {

	public static void main(String[] args) {
		System.out.println(divide(Integer.MAX_VALUE, Integer.MAX_VALUE));

	}

	public static int divide(int dividend, int divisor) {
		return binarySearch(dividend, divisor);
	}

	public static int binarySearch(int divi, int dis) {

		if (dis == 1) {
			if (divi == Integer.MIN_VALUE) {
				return Integer.MIN_VALUE;
			} else if (divi == Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			} else {
				return divi;
			}
		} else if (dis == -1) {
			if (divi == Integer.MIN_VALUE) {
				return Integer.MAX_VALUE;
			} else if (divi == Integer.MAX_VALUE) {
				return Integer.MIN_VALUE;
			} else {
				return -divi;
			}

		}

		int st = 0;
		int end = divi < 0 ? divi * -1 : divi;
		int di = dis < 0 ? dis * -1 : dis;
		int ans = 0;
		while (st <= end) {
			int mid = (st + end) / 2;
//			System.out.println(st + "-" + mid + "-" + end);
			if (di * mid == (divi < 0 ? divi * -1 : divi)) {
				ans = mid;
				return ans;
			} else if (di * mid > (divi < 0 ? divi * -1 : divi)) {
				end = mid - 1;
			} else {
				ans = mid;
				st = mid + 1;
			}
		}
		if ((divi < 0 && dis > 0) || (divi > 0 && dis < 0)) {
			return -ans;
		} else {
			return ans;
		}
	}

}
