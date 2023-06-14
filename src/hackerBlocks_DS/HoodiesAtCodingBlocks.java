package hackerBlocks_DS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HoodiesAtCodingBlocks {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int ops = scn.nextInt();

		ArrayList<Queue<Integer>> q = new ArrayList<>();

		for (int i = 0; i <= ops; i++) {
			q.add(new LinkedList<Integer>());
		}

		ArrayList<Integer> order = new ArrayList<>();

		while (ops > 0) {

			char ch = scn.next().charAt(0);

			if (ch == 'E') {

				int cno = scn.nextInt();
				int rno = scn.nextInt();

				q.get(cno).add(rno);

				if (!order.contains(cno)) {
					order.add(cno);
				}

			} else {

				int removeCourseNo = order.get(0);
				int removeRollNo = q.get(removeCourseNo).remove();

				System.out.println(removeCourseNo + " " + removeRollNo);

				if (q.get(removeCourseNo).isEmpty()) {
					order.remove(0);
				}

			}
			ops--;
		}
		scn.close();
	}
}