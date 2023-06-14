package L29_DP;

public class MinCostClimbingStairs_746 {

	public static void main(String[] args) {

//		int[] cost = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
		int[] cost = { 10, 15, 20 };
		System.out.println(Math.min(MCCSRecursion(cost, 0), MCCSRecursion(cost, 1)));
		System.out.println(Math.min(MCCSTD(cost, 0, new int[cost.length]), MCCSTD(cost, 1, new int[cost.length])));
	}

	public static int MCCSRecursion(int[] cost, int vidx) {

		if (vidx >= cost.length) {
			return 0;
		}

		int onestep = MCCSRecursion(cost, vidx + 1) + cost[vidx];
		int twostep = MCCSRecursion(cost, vidx + 2) + cost[vidx];

		int ans = Math.min(onestep, twostep);

		return ans;
	}

	public static int MCCSTD(int[] cost, int vidx, int[] storage) {

		if (vidx >= cost.length) {
			return 0;
		}

		if (storage[vidx] != 0) {
			return storage[vidx];
		}

		int onestep = MCCSTD(cost, vidx + 1, storage) + cost[vidx];
		int twostep = MCCSTD(cost, vidx + 2, storage) + cost[vidx];

		int ans = Math.min(onestep, twostep);

		storage[vidx] = ans;

		return ans;
	}

}
