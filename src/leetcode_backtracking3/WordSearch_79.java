package leetcode_backtracking3;

public class WordSearch_79 {

	public static void main(String[] args) {

//		String[][] board = { { "F", "Y", "C", "E", "N", "R", "D" }, { "K", "L", "N", "F", "I", "N", "U" },
//				{ "A", "A", "A", "R", "A", "H", "R" }, { "N", "D", "K", "L", "P", "N", "E" },
//				{ "A", "L", "A", "N", "S", "A", "P" }, { "O", "O", "G", "O", "T", "P", "N" },
//				{ "H", "P", "O", "L", "A", "N", "O" } };

		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };

		String word = "SEE";

		System.out.println(exist(board, word));

	}

	static boolean res;

	public static boolean exist(char[][] board, String word) {

		res = false;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				exist(i, j, board, new boolean[board.length][board[0].length], "", word);
			}
		}
		return res;
	}

	public static void exist(int row, int col, char[][] board, boolean[][] visited, String ans, String word) {

		if (ans.equals(word)) {
			res = res || true;
		}

		if (row < 0 || col < 0 || row == board.length || col == board[0].length || visited[row][col]) {
			return;
		}

		visited[row][col] = true;

		exist(row + 1, col, board, visited, ans + board[row][col], word);
		exist(row - 1, col, board, visited, ans + board[row][col], word);
		exist(row, col + 1, board, visited, ans + board[row][col], word);
		exist(row, col - 1, board, visited, ans + board[row][col], word);

		visited[row][col] = false;
	}

}