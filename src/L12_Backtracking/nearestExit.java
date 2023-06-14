package L12_Backtracking;

public class nearestExit {

	public static void main(String[] args) {
		char[][] maze = { { '+', '+', '+' }, { '.', '.', '.' }, { '+', '+', '+' } };
//		char[][] maze = { { '+', '+', '.', '+' }, { '.', '.', '.', '+' }, { '+', '+', '+', '.' } };
		int[] ent = { 1, 0 }; // 1,2
		System.out.println(nearestexit(maze, ent));
		System.out.println(r);

	}

	public static int nearestexit(char[][] maze, int[] entrance) {
		int ans = getMP(maze, entrance, entrance[0], entrance[1], new boolean[maze.length][maze[0].length]);
		if (ans == 0) {
			return -1;
		}
		return ans;
	}

	static int r = 0;
	
	public static int getMP(char[][] maze, int[] ent, int cr, int cc, boolean[][] visited) {

		if (cr == maze.length || cr < 0 || cc == maze[0].length || cc < 0) {
//			System.out.println(cr + " " + cc);
			return 0;
		}

		if (visited[cr][cc] || maze[cr][cc] == '+') {
//			System.out.println(cr + " " + cc);
			return 0;
		}

		if (cr == maze.length - 1 || cr == 0 || cc == maze[0].length - 1 || cc == 0) {
			if (cr != ent[0] && cc != ent[1] && maze[cr][cc] == '+') {
				System.out.println(cr + " " + cc);
				r = Math.abs(ent[0] - cr) + Math.abs(ent[1] - cc);
				return r;
			}
		}

//		System.out.println(cr + " " + cc);
		visited[cr][cc] = true;
		// T
		int ct = getMP(maze, ent, cr - 1, cc, visited);
		// D
		int cd = getMP(maze, ent, cr + 1, cc, visited);
		// L
		int cl = getMP(maze, ent, cr, cc - 1, visited);
		// R
		int cro = getMP(maze, ent, cr, cc + 1, visited);

		visited[cr][cc] = false;

//		System.out.println(ct + " " + cd + " " + cl + " " + cro);
		return Math.min(Math.min(ct, cd), Math.min(cl, cro));
	}

}
