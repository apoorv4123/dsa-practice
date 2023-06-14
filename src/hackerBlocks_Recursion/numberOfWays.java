package hackerBlocks_Recursion;

// Given a string consisting of digits from 0 to 9. Each 5 is replaced with 33 and each 9 with 77.
// Find the number of ways theorugh with a number can be obtained from the given string
public class numberOfWays {

	public static void main(String[] args) {
		System.out.println(sol("0"));
	}
	
	public static int sol(String S) {
		int n = S.length(), mod = 1_000_000_007;
		
		long[] strg = new long[n + 1];
		strg[n - 1] = 1;
		strg[n] = 1;
		
		for(int i = n - 2; i>=0; i--) {
			int num = (S.charAt(i) - '0') * 10 + (S.charAt(i + 1) - '0');
			strg[i] = strg[i + 1];
			if(num == 33 || num == 77) {
				strg[i] += strg[i + 2];
			}
			strg[i] %= mod;
		}
		return (int)strg[0];
	}

}
