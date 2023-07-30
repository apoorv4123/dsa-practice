package striver_dp;

import java.util.Arrays;

public class ClimbingStairs {

	public static void main(String[] args) {
		int n = 4;
		System.out.println(recursion(n, 0));
		System.out.println(recursion2(n));
		
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		System.out.println(memoizaion(n, 0, dp));
		
		System.out.println(tabulation(n));
		
		System.out.println(spaceOptimization(n));
	}
	
	public static int recursion(int n, int curr) {
		if(curr > n) {
			return 0;
		}
		if(curr == n) {
			return 1;
		}
//		BP: 0 -> n number of ways
//		SP: 1 -> n number of ways and 2 -> n number of ways 
//		SW: 0 -> n number of ways = 1 -> n number of ways + 2 -> n number of ways 
		int numOfWays = recursion(n, curr + 1) + recursion(n, curr + 2);
		return numOfWays;
	}
	
	public static int recursion2(int n) {
		if(n == 0) {
			return 1;
		}
		if(n < 0) {
			return 0;
		}
//		BP: n -> 0 number of ways
//		SP: n - 1 -> 0 number of ways and n-2 -> 0 number of ways 
//		SW: n -> 0 number of ways = n-1 -> 0 number of ways + n-2 -> 0 number of ways 
		int numOfWays = recursion2(n - 1) + recursion2(n - 2);
		return numOfWays;
	}
	
	public static int memoizaion(int n, int curr, int[] dp) {
		if(curr > n) {
			return 0;
		}
		if(curr == n) {
			return 1;
		}
		if(dp[curr] != -1) {
			return dp[curr];
		}
		int numOfWays = recursion(n, curr + 1) + recursion(n, curr + 2);
		dp[curr] = numOfWays;
		return numOfWays;
	}
	
	public static int tabulation(int n) {
		int[] dp = new int[n + 2];
		dp[n] = 1;
		for(int i = n - 1; i >= 0; i--) {
			dp[i] = dp[i + 1] + dp[i + 2];
		}
		return dp[0];
	}

	public static int spaceOptimization(int n) {
		int np1 = 1;
		int np2 = 0;
		for(int i = 1; i <= n; i++) {
			int curr = np1 + np2;
			np2 = np1;
			np1 = curr;
		}
		return np1;
	}
}
