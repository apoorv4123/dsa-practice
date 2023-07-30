package striver_dp;

import java.util.Arrays;

public class FrogJump {

	public static void main(String[] args) {

		int N = 6; // 3,4
		int[] height = { 30, 10, 60, 10, 60, 50 }; // {10,50,10},{10,20,30,10}
		System.out.println(recursion(0, N, height));

		System.out.println(recursion2(N - 1, height));
		
		int[] dp = new int[N];
		Arrays.fill(dp, -1);
		System.out.println(memoization(N - 1, height, dp));
		
		System.out.println(tabulation(N, height));
		
		System.out.println(spaceOptimization(N, height));
	}

	public static int recursion(int curr, int n, int[] height) {
		if (curr == n - 1) {
			return 0;
		}
		if (curr >= n) {
			return Integer.MAX_VALUE;
		}
		int left = recursion(curr + 1, n, height);
		if (left != Integer.MAX_VALUE) {
			left += Math.abs(height[curr] - height[curr + 1]);
		}
		int right = recursion(curr + 2, n, height);
		if (right != Integer.MAX_VALUE) {
			right += Math.abs(height[curr + 2] - height[curr]);
		}
		return Math.min(left, right);
	}

	public static int recursion2(int n, int[] height) {
		if (n == 0) {
			return 0; // cannot jump anywhere else from 0
		}

		// left = 1 jump
		int left = 0;
		// right = 2 jump
		int right = Integer.MAX_VALUE;
		left = recursion2(n - 1, height) + Math.abs(height[n] - height[n - 1]);
		if (n > 1) {
			right = recursion2(n - 2, height) + Math.abs(height[n] - height[n - 2]);
		}
		return Math.min(left, right);
	}
	
	public static int memoization(int n, int[] height, int[] dp) {
		if (n == 0) {
			return 0; // cannot jump anywhere else from 0
		}

		if(dp[n] != -1){
			return dp[n];
		}
		// left = 1 jump
		int left = 0;
		// right = 2 jump
		int right = Integer.MAX_VALUE;
		left = recursion2(n - 1, height) + Math.abs(height[n] - height[n - 1]);
		if (n > 1) {
			right = recursion2(n - 2, height) + Math.abs(height[n] - height[n - 2]);
		}
		int result = Math.min(left, right);
		dp[n] = result;
		return result;
	}
	
	public static int tabulation(int n, int[] height) {
		int[] dp = new int[n];
		dp[0] = 0;
		dp[1] = Math.abs(height[0] - height[1]);
		
		for(int i = 2; i < n ; i++) {
			int left = dp[i - 1] + Math.abs(height[i] - height[i - 1]);
			int right = dp[i - 2] + Math.abs(height[i] - height[i - 2]);
			dp[i] = Math.min(left,  right);
		}
		
		return dp[n - 1];
	}
	
	public static int spaceOptimization(int n, int[] height) {
		int prev2 = 0;
		int prev1 = Math.abs(height[0] - height[1]);
		
		for(int i = 2; i < n ; i++) {
			int curr = Math.min(
					prev1 + Math.abs(height[i] - height[i - 1]),
					prev2 + Math.abs(height[i] - height[i - 2]));
			prev2 = prev1;
			prev1 = curr;
		}
		
		return prev1;
	}
}
