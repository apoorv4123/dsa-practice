package hackerBlocks;

import java.util.Scanner;

public class RatChasesItsCheese {

	public static void main(String[] args) {
//		char[][] maze = { { 'O', 'X', 'O', 'O' }, { 'O', 'O', 'O', 'X' }, { 'X', 'O', 'X', 'O' },
//				{ 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'O' } };
//		ques(maze, 0, 0, new int[5][4], new boolean[5][4]);

		
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int m=s.nextInt();
		char[][] maze=new char[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				maze[i][j]=s.next().charAt(0);
			}
		}
		
		
	}

	public static void ques(char[][] maze, int row, int col, int[][] ans, boolean[][] vstd) {

		if (row == maze.length - 1 && col == maze[0].length - 1) {
			for (int r = 0; r < maze.length; r++) {
				for (int c = 0; c < maze[0].length; c++) {
//					if (vstd[r][c]) {
//						System.out.print("1" + " ");
//					} else {
//						System.out.print("0" + " ");
//					}
					System.out.print(ans[r][c]+" ");
				}
				System.out.println();
			}
			return;
		}
		if (row == -1 || col == -1 || row == maze.length || col == maze[0].length) {
			return;
		}

		if (isItPossible(maze, row, col, vstd)) {

			vstd[row][col] = true;
			ans[row][col] = 1;
			// T
			ques(maze, row - 1, col, ans, vstd);
			// d
			ques(maze, row + 1, col, ans, vstd);
			// L
			ques(maze, row, col - 1, ans, vstd);
			// R
			ques(maze, row, col + 1, ans, vstd);
			ans[row][col] = 0;
			vstd[row][col] = false;
		}
	}

	private static boolean isItPossible(char[][] grid, int row, int col, boolean[][] vstd) {
		if (grid[row][col] == 'O' && vstd[row][col] == false) {
			return true;
		}
		return false;
	}

}
