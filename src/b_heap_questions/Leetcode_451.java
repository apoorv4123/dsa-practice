package b_heap_questions;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode_451 {

	public static void main(String[] args) {
		
		System.out.println(frequencySort("Aabb"));

	}

	class Pair implements Comparable<Pair> {
		char ch;
		int freq;

		public Pair(char ch, int freq) {
			this.ch = ch;
			this.freq = freq;
		}

		@Override
		public int compareTo(Pair o) {
			return this.freq - o.freq;
		}
	}

	public static String frequencySort(String s) {

		Leetcode_451 l = new Leetcode_451();

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}

		PriorityQueue<Pair> heap = new PriorityQueue<>(Collections.reverseOrder());

		for (char ch : map.keySet()) {
			heap.offer(l.new Pair(ch, map.get(ch)));
		}

		StringBuilder sb = new StringBuilder();
		while (!heap.isEmpty()) {
			Pair rp = heap.poll();
			for (int i = 1; i <= rp.freq; i++) {
				sb.append(rp.ch);
			}
		}
		return sb.toString();
	}

}
