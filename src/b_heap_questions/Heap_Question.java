package b_heap_questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Map.Entry;

public class Heap_Question {

	public static void main(String[] args) {

//		int[] nums = { 7, 10, 4, 3, 20, 15 };
//		System.out.println(findKthLargest(nums, 3));

//		int[] arr = { 8, 1, 1, 5, 1, 3, 5, 5, 2, 2, 5, 4 };
//		frequencySort(arr);

		int[] nums = { 1, 1, 1, 2, 2, 3 };
		for (int a : topKFrequent(nums, 2)) {
			System.out.print(a + " ");
		}
	}

	public static int findKthLargest(int[] nums, int k) {

		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

		for (int i = 0; i < nums.length; i++) {
			heap.add(nums[i]);
			if (heap.size() > k) {
				heap.remove();
			}
		}

		return heap.poll();

	}

	class Pair implements Comparable<Pair> {
		int frequency;
		int value;

		Pair(int frequency, int value) {
			this.frequency = frequency;
			this.value = value;
		}

		@Override
		public int compareTo(Pair o) {
			return this.frequency < o.frequency ? -1 : +1;
		}
	}

	public static void frequencySort(int[] arr) {

		Heap_Question h = new Heap_Question();

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}

		PriorityQueue<Pair> heap = new PriorityQueue<>(Collections.reverseOrder());

		for (Entry<Integer, Integer> entry : map.entrySet()) {
			heap.add(h.new Pair(entry.getValue(), entry.getKey()));
		}

		while (!heap.isEmpty()) {
			Pair p = heap.poll();
			for (int i = 1; i <= p.frequency; i++) {
				System.out.print((p.value) + " ");
			}
//			System.out.println(p.frequency +" " + p.value);
		}

		System.out.println(map);

	}

	public static int[] topKFrequent(int[] nums, int k) {

		Heap_Question h = new Heap_Question();

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		PriorityQueue<Pair> heap = new PriorityQueue<Heap_Question.Pair>();

		for (Entry<Integer, Integer> entry : map.entrySet()) {
			heap.add(h.new Pair(entry.getValue(), entry.getKey()));

			if (heap.size() > k) {
				heap.poll();
			}
		}

		ArrayList<Integer> al = new ArrayList<>();
		while (!heap.isEmpty()) {
			al.add(heap.poll().value);
		}

		int[] arr = new int[al.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = al.get(i);
		}
		return arr;
	}
}