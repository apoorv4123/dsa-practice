package L12_Backtracking;

public class Practice {
	static int count = 0;

	public static void main(String[] args) {
//		System.out.println(QueenPermutations(new boolean[4], 2, 0, ""));
//		QueenCombQueenRes(new boolean[4], 2, 0, "", 0);
//		QueenCombBoxRes(new boolean[4], 2, 0, 0, "");
//		QueenCombBoxRes2D(new boolean[3][4], 3, 0, 0, 0, "");
//		NKnights(new boolean[3][3], 3, 0, 0, 0, "");

		int[][] maze = { { 0, 1, 0, 0 }, { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 } };
		blockedMazePath(maze, 0, 0, "", new boolean[maze.length][maze[0].length]);
//		boolean[][] board = new boolean[4][4];
//		System.out.println(countNQueens(board, 0));
//		printNQueens(board, 0, "");
//		int[] coins = { 2, 3, 5, 6 };
//		System.out.println(coinChange(coins, 0, 10, 0, ""));
	}

	public static int QueenPermutations(boolean[] board, int tq, int qpsf, String ans) {
		if (tq == qpsf) {
			System.out.println(ans);
			return 1;
		}
		int count = 0;
		for (int col = 0; col < board.length; col++) {
			if (board[col] == false) {
				board[col] = true;
				count += QueenPermutations(board, tq, qpsf + 1, ans + "q" + qpsf + "b" + col + " ");
				board[col] = false;
			}
		}
		return count;
	}

	public static void QueenCombQueenRes(boolean[] board, int tq, int qpsf, String ans, int lastboxvisited) {
		if (tq == qpsf) {
			System.out.println(ans);
			return;
		}

		for (int col = lastboxvisited; col < board.length; col++) {
			if (!board[col]) {
				board[col] = true;
				QueenCombQueenRes(board, tq, qpsf + 1, ans + "q" + qpsf + "b" + col + " ", col);
				board[col] = false;
			}
		}
	}

	public static void QueenCombBoxRes(boolean[] board, int tq, int qpsf, int col, String ans) {
		if (tq == qpsf) {
			System.out.println(ans);
			return;
		}
		if (col == board.length) {
			return;
		}
		board[col] = true;
		QueenCombBoxRes(board, tq, qpsf + 1, col + 1, ans + "b" + col + " ");
		board[col] = false;
		QueenCombBoxRes(board, tq, qpsf, col + 1, ans);
	}

	public static void QueenCombBoxRes2D(boolean[][] board, int tq, int qpsf, int row, int col, String ans) {
		if (tq == qpsf) {
			System.out.println(ans);
			return;
		}
		if (col == board[0].length) {
			row++;
			col = 0;
		}
		if (row == board.length) {
			return;
		}
		if (isItPossible(board, row, col)) {
			board[row][col] = true;
			QueenCombBoxRes2D(board, tq, qpsf + 1, row, col + 1, ans + "(" + row + "," + col + ") ");
			board[row][col] = false;
		}
		QueenCombBoxRes2D(board, tq, qpsf, row, col + 1, ans);
	}

	public static boolean isItPossible(boolean[][] board, int row, int col) {
		for (int r = row, c = col; r >= 0; r--) {
			if (board[r][c]) {
				return false;
			}
		}
		for (int r = row, c = col; r >= 0 && c >= 0; r--, c--) {
			if (board[r][c]) {
				return false;
			}
		}
		for (int r = row, c = col; r >= 0 && c < board[0].length; r--, c++) {
			if (board[r][c]) {
				return false;
			}
		}
		for (int r = row, c = col; c >= 0; c--) {
			if (board[r][c]) {
				return false;
			}
		}
		return true;

	}

	public static void NKnights(boolean[][] board, int tk, int kpsf, int row, int col, String ans) {
		if (tk == kpsf) {
			count++;
			System.out.println(count + ". " + ans);
			return;
		}
		if (col == board[0].length) {
			row++;
			col = 0;
		}
		if (row == board.length) {
			return;
		}
		// knight ko place karane se pehle check karenge ki kya knight ko place krna
		// safe hai
		// aur agar knight ko place krna safe hua tabhi aage ki call denge else nhi
		// denge
		if (isItSafeToPlaceKnight(board, row, col)) {
			board[row][col] = true;// place knight
			NKnights(board, tk, kpsf + 1, row, col + 1, ans + "(" + row + "," + col + ") ");
			board[row][col] = false;// displace knight
		}
		NKnights(board, tk, kpsf, row, col + 1, ans);
	}

	public static boolean isItSafeToPlaceKnight(boolean[][] board, int row, int col) {
		int[] rowArr = { -1, -2, -2, -1 };
		int[] colArr = { 2, 1, -1, -2 };
		for (int i = 0; i < 4; i++) {
			int r = row + rowArr[i];
			int c = col + colArr[i];
			if (r >= 0 && r < board.length && c >= 0 && c < board[0].length) {
				if (board[r][c]) {
					return false;
				}
			}
		}
		return true;
	}

	public static int countNQueens(boolean[][] board, int row) {
		if (row == board.length) {
			return 1;
		}
		int count = 0;
		for (int col = 0; col < board[row].length; col++) {
			if (isItPossible1(board, row, col)) {
				board[row][col] = true;
				count += countNQueens(board, row + 1);
				board[row][col] = false;
			}
		}
		return count;
	}

	public static boolean isItPossible1(boolean[][] board, int row, int col) {
		for (int i = 0; i < row; i++) {
			if (board[i][col]) {
				return false;
			}
		}
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j]) {
				return false;
			}
		}
		for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
			if (board[i][j]) {
				return false;
			}
		}
		return true;
	}

	public static int coinChange(int[] coin, int curr, int target, int lastcoinvisited, String ans) {
		if (curr == target) {
			System.out.println(ans);
			return 1;
		}
		if (curr > target) {
			return 0;
		}
		int count = 0;
		for (int c = lastcoinvisited; c < coin.length; c++) {
			count += coinChange(coin, curr + coin[c], target, c, ans + coin[c]);
		}
		return count;
	}

	public static void blockedMazePath(int[][] maze, int row, int col, String ans, boolean[][] visited) {
		if (row == maze.length - 1 && col == maze[0].length - 1) {
			System.out.println(ans);
			return;
		}
		if (row == -1 || col == -1 || row == maze.length || col == maze[0].length || maze[row][col] == 1
				|| visited[row][col] == true) {
			return;
		}

		// put a mark
		visited[row][col] = true;

		// T
		blockedMazePath(maze, row - 1, col, ans + "T", visited);
		// D
		blockedMazePath(maze, row + 1, col, ans + "D", visited);
		// L
		blockedMazePath(maze, row, col - 1, ans + "L", visited);
		// R
		blockedMazePath(maze, row, col + 1, ans + "R", visited);

		// undo
		visited[row][col] = false;
	}
}