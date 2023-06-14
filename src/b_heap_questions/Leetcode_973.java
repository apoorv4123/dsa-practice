package b_heap_questions;

import java.util.Collections;
import java.util.PriorityQueue;

public class Leetcode_973 {

	public static void main(String[] args) {

		int[][] points = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
		kClosest(points, 2);
	}

	class Pair implements Comparable<Pair> {
		int distance;
		int x;
		int y;

		public Pair(int x, int y) {
			this.distance = (int) Math.pow(x, 2) + (int) Math.pow(y, 2);
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pair o) {
			return this.distance > o.distance ? +1 : -1;
		}

	}

	public static int[][] kClosest(int[][] points, int K) {

		Leetcode_973 l = new Leetcode_973();

		PriorityQueue<Pair> heap = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < points.length; i++) {
			heap.add(l.new Pair(points[i][0], points[i][1]));

			if (heap.size() > K) {
				heap.poll();
			}

		}

		int[][] result = new int[K][2];

		int row = 0;
		while (!heap.isEmpty()) {
			Pair p = heap.poll();
			result[row][0] = p.x;
			result[row++][1] = p.y;
		}
		return result;
	}

}
