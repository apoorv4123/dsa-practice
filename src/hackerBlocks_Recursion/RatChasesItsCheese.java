package hackerBlocks_Recursion;

import java.util.Scanner;

public class RatChasesItsCheese {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int m = scn.nextInt();

		char[][] maze = new char[n][m];

		for (int i = 0; i < n; i++) {
			String temp = scn.next();
			for (int j = 0; j < m; j++) {
				maze[i][j] = temp.charAt(j);
			}
		}

		int[][] ans = new int[n][m];
		ques(maze, 0, 0, ans, new boolean[n][m]);

		if (ans[0][0] != 1) {
			System.out.println("NO PATH FOUND");
		} else {

			for (int i = 0; i < ans.length; i++) {
				for (int j = 0; j < ans[0].length; j++) {
					System.out.print(ans[i][j] + " ");
				}
				System.out.println();
			}

		}
		scn.close();
	}

	public static void ques(char[][] maze, int row, int col, int[][] ans, boolean[][] dummy) {

		if (row == maze.length - 1 && col == maze[0].length) {
			answer(ans, dummy);
			return;
		}

		if (row < 0 || row == maze.length || col < 0 || col == maze[0].length) {
			return;
		}

		if (maze[row][col] == 'O' && dummy[row][col] == false) {
			dummy[row][col] = true;

			// T
			ques(maze, row - 1, col, ans, dummy);
			// D
			ques(maze, row + 1, col, ans, dummy);
			// R
			ques(maze, row, col + 1, ans, dummy);
			// L
			ques(maze, row, col - 1, ans, dummy);

			dummy[row][col] = false;
		}

	}

	private static void answer(int[][] ans, boolean[][] dummy) {

		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[0].length; j++) {
				if (dummy[i][j] == true) {
					ans[i][j] = 1;
				} else {
					ans[i][j] = 0;
				}
			}
		}
	}

}