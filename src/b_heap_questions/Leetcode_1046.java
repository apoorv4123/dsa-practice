package b_heap_questions;

import java.util.Collections;
import java.util.PriorityQueue;

public class Leetcode_1046 {

	public static void main(String[] args) {

		int[] stones = { 2, 2};
		System.out.println(lastStoneWeight(stones));

	}

	public static int lastStoneWeight(int[] stones) {

		PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(Collections.reverseOrder());

		for (int wt : stones) {
			maxheap.add(wt);
		}
		int y = 0;
		while (!maxheap.isEmpty()) {
			y = maxheap.poll();
			
			if (maxheap.isEmpty()) {
				maxheap.add(y);
				break;
			}
			int x = maxheap.poll();

			if (x != y) {
				maxheap.add(y - x);
			}

		}

		return (maxheap.isEmpty()) ? 0 : maxheap.poll();
	}

}
