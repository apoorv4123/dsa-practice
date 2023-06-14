package b_heap_questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Leetcode_692 {

	public static void main(String[] args) {

		String[] words = { "i", "love", "leetcode", "i", "love", "coding" };
		System.out.println(topKFrequent(words, 2));
	}

	class Pair implements Comparable<Pair> {
		int frequency;
		String val;

		public Pair(int frequency, String val) {
			this.frequency = frequency;
			this.val = val;
		}

		@Override
		public int compareTo(Pair o) {
			return this.frequency - o.frequency;
		}
	}

	public static List<String> topKFrequent(String[] words, int k) {

		Leetcode_692 l = new Leetcode_692();

		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (String str : words) {
			map.put(str, map.getOrDefault(str, 0) + 1);
		}

		PriorityQueue<Pair> heap = new PriorityQueue<>();

		for (String str : map.keySet()) {
			heap.offer(l.new Pair(map.get(str), str));

			if (heap.size() > k) {
				heap.remove();
			}
		}

		List<String> resultList = new ArrayList<String>();

		if (heap.size() == map.size()) {
			while (!heap.isEmpty()) {
				resultList.add(heap.poll().val);
			}
			Collections.reverse(resultList);
			return resultList;
		}

		while (!heap.isEmpty()) {
			resultList.add(heap.poll().val);
		}
		return resultList;
	}

}
