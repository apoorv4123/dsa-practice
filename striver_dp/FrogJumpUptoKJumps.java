package striver_dp;

import java.util.Arrays;

public class FrogJumpUptoKJumps {

	public static void main(String[] args) {
		int n = 8; // 3,4
		int[] height = {20, 30, 10, 60, 10, 60, 50, 20 }; // {10,50,10},{10,20,30,10}

		System.out.println(recursion(n - 1, 3, height));

		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		System.out.println(memoization(n - 1, 3, height, dp));
		
		System.out.println(tabulation(n, 3, height));
	}

	public static int recursion(int n, int k, int[] ht) {
		if (n == 0) {
			return 0;
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 1; i <= k; i++) {
			if (n >= i)
				ans = Integer.min(ans, recursion(n - i, k, ht) + Math.abs(ht[n] - ht[n - i]));
		}
		return ans;
	}

	public static int memoization(int n, int k, int[] ht, int[] dp) {
		if (n == 0) {
			return 0;
		}
		if (dp[n] != -1) {
			return dp[n];
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 1; i <= k; i++) {
			if (n >= i)
				ans = Integer.min(ans, memoization(n - i, k, ht, dp) + Math.abs(ht[n] - ht[n - i]));
		}
		dp[n] = ans;
		return ans;
	}

	public static int tabulation(int n, int k, int[] ht) {
		int[] dp = new int[n];
		dp[0] = 0;

		for (int j = 1; j < n; j++) {
			int ans = Integer.MAX_VALUE;
			for (int i = 1; i <= k; i++) {
				if (j >= i)
					ans = Integer.min(ans, dp[j - i] + Math.abs(ht[j] - ht[j - i]));
			}
			dp[j] = ans;
		}
		return dp[n - 1];
	}

}
