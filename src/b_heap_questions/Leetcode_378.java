package b_heap_questions;

import java.util.Collections;
import java.util.PriorityQueue;

public class Leetcode_378 {

	public static void main(String[] args) {
		
		int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
		System.out.println(kthSmallest(matrix, 8));
	}

	public static int kthSmallest(int[][] matrix, int k) {
		
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				heap.offer(matrix[i][j]);
				
				if(heap.size() > k) {
					heap.poll();
				}
				
			}
		}
		return heap.remove();
	}

}
