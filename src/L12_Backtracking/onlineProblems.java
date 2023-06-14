package L12_Backtracking;

public class onlineProblems {
	static int countper = 0;
	static int countcomb = 0;
	static int count = 0;
	static int c = 0;

	public static void main(String[] args) {

//		queenPermutations(new boolean[4], 0, 2, "");
//		System.out.println();
//		queensCombinations(new boolean[4], 0, 2, 0, "");

//		QueenCombinationBoxRespect1D(new boolean[4], 0, 0, 2, "");
//		queensCombinationsBoxResp2D(new boolean[2][3], 0, 0, 2, 0, "");
//		queenCombinations2DKill(new boolean[3][4], 0, 0, 0, 3, "");
//		NQueens1A(new boolean[4][4], 0, 0, 4, 0, "");
//		NQueens1B(new boolean[4][4], 0, 0, 4, 0, "");
//		NQueens2(new boolean[4][4], 0, 4, 0, "");
//		KQueens(new boolean[4][4], 0, 3, 0, "");

//		NKnights(new boolean[3][3], 3, 0, 0, 0, "");

//		int[] domination = { 2, 3, 5, 6 };
//		coinchange(new int[] { 2, 3, 5, 6 }, 10, 0, "");
//		coinchange2(new int[] { 2, 3, 5, 6 }, 10, 0, "");
//		coinChangePermutations(new int[] { 2, 3, 5, 6 }, 10, "");
//		coinChangeCoinsRespect(new int[] { 1, 2, 3 }, 0, 4, "");

//		boolean[][] board = new boolean[4][4];
//		System.out.println(nQueens(board, 0));

//		int[] arr = { 1, 2, 3, 3, 4, 5 };
//		int ps = target(arr);
//		int ans=splitArray(arr, 0, 0, "", 0, "", ps);
//		System.out.println();
//		System.out.println(ans);

//		int[][] maze = { { 0, 1, 0, 0 }, { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 } };
//		blockedMazePath(maze, 0, 0, "", new boolean[4][4]);
	}

	// qpsf is queens placed so far
	// tq is total queens
	public static void queenPermutations(boolean[] boxes, int qpsf, int tq, String ans) {
		if (qpsf == tq) {
			countper++;
			System.out.println(countper + "." + ans);
			return;
		}

		for (int i = 0; i < boxes.length; i++) {
			if (boxes[i] == false) {// this condition is to make sure the recursion call does not places both queens
									// in same box
				boxes[i] = true;
				queenPermutations(boxes, qpsf + 1, tq, ans + "q" + qpsf + "b" + i + " ");
				boxes[i] = false;// undo work i.e. backtracking step
			}
		}
	}

	public static void queensCombinations(boolean[] boxes, int qpsf, int tq, int lastboxused, String ans) {

		if (qpsf == tq) {
			countcomb++;
			System.out.println(countcomb + "." + ans);
			return;
		}

		for (int i = lastboxused; i < boxes.length; i++) {
//			if (boxes[i] == false) {//this condition is not necessary in case of combinations
			boxes[i] = true;// this is also not necessary
			queensCombinations(boxes, qpsf + 1, tq, i + 1, ans + "q" + qpsf + "b" + i + " ");
			boxes[i] = false;// neither is this
//			}
		}
	}

	// This is the same question as that of two_queen_combinations done previously,
	// the difference being in the last question we were solving with respect to
	// queens, but in this one, we will solve with respect to the boxes, each box
	// has a possibility that whether a queen can be placed in it or not.
	public static void QueenCombinationBoxRespect1D(boolean[] box, int idx, int qpsf, int tq, String ans) {

		// positive base case ans this will come before negative b.c.
		if (tq == qpsf) {
			System.out.println(ans);
			return;
		}

		// negative base case
		if (idx == box.length) {
			return;
		}

		// call when a queen is place at that index
		box[idx] = true;// preparation
		QueenCombinationBoxRespect1D(box, idx + 1, qpsf + 1, tq, ans + "q" + qpsf + "b" + idx + " ");
		box[idx] = false;// undo

		// call when a queen is not placed at that index
		QueenCombinationBoxRespect1D(box, idx + 1, qpsf, tq, ans);
	}

	// queens combination w.r.t board(2D) using 2 approaches
	// when negative base case is encountered
	public static void queensCombinationsBoxResp2D(boolean[][] board, int row, int col, int tq, int qpsf, String ans) {
		
		if (tq == qpsf) {
			System.out.println(++c + " " + ans);
			return;
		}
		if (col == board[row].length) {
			// 1. Making an extra recursive call
			// queensCombinationsBoxResp2D(box, row + 1, 0, tq, qpsf, ans);
			// OR
			// 2. By Manually changing the variables
			row++;
			col = 0;
		}
		if (row == board.length) {
			return;
		}

		// place
		board[row][col] = true;
		queensCombinationsBoxResp2D(board, row, col + 1, tq, qpsf + 1, ans + "(" + row + "," + col + ") ");
		board[row][col] = false;

		// not place
		queensCombinationsBoxResp2D(board, row, col + 1, tq, qpsf, ans);
	}

	// In this question we have to place a given number of queens on a 2D board such
	// that no two queens can kill each other
	public static void queenCombinations2DKill(boolean[][] board, int row, int col, int qpsf, int tq, String ans) {
		if (qpsf == tq) {// positive bc
			System.out.println(++c + "." + ans);
			return;
		}
		if (col == board[0].length) {// negative bc1
			row++;
			col = 0;
		}
		if (row == board.length) {// negative bc2
			return;
		}

		// Queen Placed
		if (isItSafeToPlaceTheQueen(board, row, col)) {
			board[row][col] = true;// prior preparation
			queenCombinations2DKill(board, row, col + 1, qpsf + 1, tq, ans + "(" + row + "," + col + ") ");
			board[row][col] = false;// undo
		}

		// Queen Not Placed
		queenCombinations2DKill(board, row, col + 1, qpsf, tq, ans);
	}

	// works on the same mechanism as queenCombination2DKill
	public static void NQueens1A(boolean[][] board, int row, int col, int tq, int qpsf, String ans) {
		if (qpsf == tq) {
			System.out.println(++c + "." + ans);
			return;
		}
		if (col == board[0].length) {
			row++;
			col = 0;
		}
		if (row == board.length) {
			return;
		}
		if (isItSafeToPlaceTheQueen(board, row, col)) {
			board[row][col] = true;
			NQueens1A(board, row, col + 1, tq, qpsf + 1, ans + "(" + row + "," + col + ") ");
			board[row][col] = false;
		}
		NQueens1A(board, row, col + 1, tq, qpsf, ans);
	}

	public static void NQueens1B(boolean[][] board, int row, int col, int tq, int qpsf, String ans) {
		// works like 2DQueenKill but the restriction being that in one row only one
		// queen can be placed and once a queen is placed in that queen the call for
		// next row and 0th column is given so, in this case the negative base case can
		// be different but since we are working on a given template, we don't change it
		if (qpsf == tq) {
			System.out.println(++c + "." + ans);
			return;
		}
//		if (col == board[0].length) {
//			row++;
//			col = 0;
//		}
		if (col == board[0].length || row == board.length) {
			return;
		}
		if (isItSafeToPlaceTheQueen(board, row, col)) {
			board[row][col] = true;
			NQueens1B(board, row + 1, 0, tq, qpsf + 1, ans + "(" + row + "," + col + ") ");
			board[row][col] = false;
		}
		NQueens1B(board, row, col + 1, tq, qpsf, ans);
	}

	public static void NQueens2(boolean[][] board, int row, int tq, int qpsf, String ans) {
		// ek row m ek queen ka baithna mandatory
		if (qpsf == tq) {
			System.out.println(++c + "." + ans);
			return;
		}
		if (row == board.length) {
			return;
		}
		for (int col = 0; col < board[0].length; col++) {
			// queen row,col p place krne se pehle check krlo ki kya queen
			// vha place ho skti h
			if (isItSafeToPlaceTheQueen(board, row, col)) {
				board[row][col] = true;
				NQueens2(board, row + 1, tq, qpsf + 1, ans + "(" + row + "," + col + ") ");
				board[row][col] = false;
			}
		}
	}

	public static void KQueens(boolean[][] board, int row, int tq, int qpsf, String ans) {
		// ek row m ek queen ka baithna mandatory nhi h
		if (qpsf == tq) {
			System.out.println(++c + "." + ans);
			return;
		}
		if (row == board.length) {
			return;
		}
		for (int col = 0; col < board[0].length; col++) {
			// queen row,col p place krne se pehle check krlo ki kya queen
			// vha place ho skti h
			if (isItSafeToPlaceTheQueen(board, row, col)) {
				board[row][col] = true;
				KQueens(board, row + 1, tq, qpsf + 1, ans + "(" + row + "," + col + ") ");
				board[row][col] = false;
			}
		}
		KQueens(board, row + 1, tq, qpsf, ans);
	}

	public static boolean isItSafeToPlaceTheQueen(boolean[][] board, int row, int col) {

		// vertical upward row
		for (int r = row, c = col; r >= 0; r--) {
			if (board[r][c]) {
				return false;
			}
		}
		// diagonally left upward
		for (int r = row, c = col; r >= 0 && c >= 0; r--, c--) {
			if (board[r][c]) {
				return false;
			}
		}
		// diagonally right upward
		for (int r = row, c = col; r >= 0 && c < board[0].length; r--, c++) {
			if (board[r][c]) {
				return false;
			}
		}
		// horizontally left row
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

	// Coin change combination
	public static void coinchange(int[] denom, int amount, int lastdenomidx, String ans) {

		if (amount == 0) {
			System.out.println(ans);
			return;
		}

		if (amount < 0) {
			return;
		}

		for (int i = lastdenomidx; i < denom.length; i++) {
			coinchange(denom, amount - denom[i], i, ans + denom[i] + " ");
		}
	}

	public static void coinchange2(int[] denom, int amount, int lastdenomidx, String ans) {

		if (amount == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = lastdenomidx; i < denom.length; i++) {
			if (amount >= denom[i])
				coinchange2(denom, amount - denom[i], i, ans + denom[i] + " ");
		}
	}

	public static void coinChangeCoinsRespect(int[] denom, int vidx, int amount, String ans) {
		// positive bc
		if (amount == 0) {
			System.out.println(ans);
			return;
		}
		// negative bc
		if (amount < 0 || vidx == denom.length) {
			return;
		}
		// vidx is virtual index,array will start from vidx to arr.length
		// yes, coin at idx is included
		coinChangeCoinsRespect(denom, vidx, amount - denom[vidx], ans + denom[vidx]);
		// no, coin at idx is not included
		coinChangeCoinsRespect(denom, vidx + 1, amount, ans);
	}

	// Coin change Permutation
	public static void coinChangePermutations(int[] denom, int amount, String ans) {
		if (amount == 0) {
			System.out.println(c++ + " " + ans);
			return;
		}
		for (int i = 0; i < denom.length; i++) {
			if (amount >= denom[i])
				coinChangePermutations(denom, amount - denom[i], ans + denom[i] + " ");
		}
	}

	// ps is permissible sum
	public static int splitArray(int[] arr, int idx, int sum1, String str1, int sum2, String str2, int ps) {
		if (sum1 == sum2 && sum1 == ps) {
			System.out.println(str1 + "and " + str2);
			return 1;
		}
		if (sum1 > ps || sum2 > ps) {
			return 0;
		}
		return splitArray(arr, idx + 1, sum1 + arr[idx], str1 + arr[idx] + " ", sum2, str2, ps)
				+ splitArray(arr, idx + 1, sum1, str1, sum2 + arr[idx], str2 + arr[idx] + " ", ps);

	}

	// N QUEENS QUESTION
	// backtracking is just a programming paradigm in which you make a choice and
	// check whether your
	// current choice can give you an answer or not and if your current choice does
	// not gives
	// you an answer then then you undo it and try other possibility
	public static int nQueens(boolean[][] board, int row) {
		if (row == board.length) {
			return 1;
		}
		int count = 0;
		for (int col = 0; col < board[row].length; col++) {

			if (isSafe(board, row, col)) {
				board[row][col] = true;
				count += nQueens(board, row + 1);
				board[row][col] = false;
			}
		}
		return count;
	}

	public static boolean isSafe(boolean[][] board, int row, int col) {
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

	public static void blockedMazePath(int[][] maze, int row, int col, String ans, boolean[][] visited) {

		if (row == maze.length - 1 && col == maze[0].length - 1) {
			System.out.println(ans);
			return;
		}
		if (row < 0 || col < 0 || row == maze.length || col == maze[0].length) {
			return;
		}

		if (maze[row][col] == 0 && visited[row][col] == false) {
			visited[row][col] = true;
			// T
			blockedMazePath(maze, row - 1, col, ans + "T", visited);
			// D
			blockedMazePath(maze, row + 1, col, ans + "D", visited);
			// L
			blockedMazePath(maze, row, col - 1, ans + "L", visited);
			// R
			blockedMazePath(maze, row, col + 1, ans + "R", visited);
			visited[row][col] = false;
		}
	}

}