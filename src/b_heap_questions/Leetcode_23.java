package b_heap_questions;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Leetcode_23 {

	public static void main(String[] args) {

		List<List<Integer>> lists = new ArrayList<>();

		lists.add(new ArrayList<Integer>());
		lists.add(new ArrayList<Integer>());
		lists.add(new ArrayList<Integer>());
		lists.add(new ArrayList<Integer>());

		lists.get(0).add(10);
		lists.get(0).add(20);
		lists.get(0).add(30);

		lists.get(1).add(5);
		lists.get(1).add(7);
		lists.get(1).add(15);
		lists.get(1).add(17);

		lists.get(2).add(3);
		lists.get(2).add(8);

		lists.get(3).add(16);
		lists.get(3).add(32);

		System.out.println(bruteforce(lists));
	}

	public static List<Integer> bruteforce(List<List<Integer>> lists) {

		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

		for (int i = 0; i < lists.size(); i++) {
			for (int j = 0; j < lists.get(i).size(); j++) {
				heap.offer(lists.get(i).get(j));
			}
		}

		List<Integer> result = new ArrayList<Integer>();
		while (!heap.isEmpty()) {
			result.add(heap.poll());
		}

		return result;

	}

	public List<Integer> mergeKLists(List<List<Integer>> lists) {

		int i = 0, j = 0, k = 0;
		int size = 0;
		while (i < lists.size()) {
			size += lists.get(i).size();
			i++;
		}
		i = 0;
		List<Integer> result = new ArrayList<Integer>();

		while (size < 0) {

		}
		return null;
	}

}
