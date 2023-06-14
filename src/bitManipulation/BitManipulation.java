package bitManipulation;

public class BitManipulation {

	public static void main(String[] args) {

		System.out.println(extractIthBit(22, 5));
		System.out.println(setIthBit(20, 4));
		System.out.println(resetIthBit(21, 3));
		System.out.println(rightmostSetBit(4));
		System.out.println(addOne(5));
		System.out.println(magicNo(3));
		System.out.println(pascalTriangleSumTillnthrow(6));

		System.out.println(powerOf2(8));
		System.out.println(powerOf2(40));
		System.out.println(powerOf2(0));
		System.out.println(powerOf2(1));

	}

	public static int extractIthBit(int n, int i) {

		int mask = 1;

//		for (j = 1; j <= i - 1; j++) {
//			j = j << 1;
//		}
//		 OR simply

		mask = 1 << (i - 1);

		n = n & mask;

		return (n == 0 ? 0 : 1);
	}

	public static int setIthBit(int n, int i) {

		int mask = 1;

		mask = 1 << (i - 1);

		n = n | mask;

		return n;

	}

	public static int resetIthBit(int n, int i) {

		int mask = 1;

		mask = ~(1 << (i - 1));

		n = n & mask;

		return n;

	}

	public static int rightmostSetBit(int n) {

		int pos = 1;
		int mask = 1;
		while ((n & mask) == 0) {
			pos++;
			mask = mask << 1;
		}
		return pos;

	}

	public static int addOne(int n) {

		int mask = 1;

		while ((n & mask) != 0) {

			n = n ^ mask;

			mask = mask << 1;
		}

		n = n ^ mask;

		return n;
	}

	public static int magicNo(int i) {

		int pow = 1;
		int ans = 0;

		while (i != 0) {

			pow = pow * 5;

			if ((i & 1) != 0) {
				ans += pow;
			}

			i = i >> 1;
		}

		return ans;
	}

	public static int pascalTriangleSumTillnthrow(int n) {

		return (1 << n) - 1;

	}

	public static boolean powerOf2(int n) {

		if (n != 0) {

			if ((n & (n - 1)) == 0) {
				return true;
			}
		}
		return false;
	}
}
