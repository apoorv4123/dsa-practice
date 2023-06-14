package b_heap_questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Leetcode_373 {

	public static void main(String[] args) {

		int[] nums1 = { 1, 2 }, nums2 = { 3 };
		System.out.println(kSmallestPairs(nums1, nums2, 3));

	}

	class Pair implements Comparable<Pair> {
		int sum;
		int num1;
		int num2;

		public Pair(int num1, int num2) {
			this.sum = num1 + num2;
			this.num1 = num1;
			this.num2 = num2;
		}

		@Override
		public int compareTo(Pair o) {
			return this.sum < o.sum ? -1 : +1;
		}

	}

	public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

		Leetcode_373 l = new Leetcode_373();

		List<List<Integer>> resultList = new ArrayList<List<Integer>>();

		PriorityQueue<Pair> heap = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				heap.offer(l.new Pair(nums1[i], nums2[j]));

				if (heap.size() > k) {
					heap.poll();
				}

			}
		}

		List<Integer> list;
		while (!heap.isEmpty()) {
			list = new ArrayList<Integer>();
			Pair rp = heap.poll();
			list.add(rp.num1);
			list.add(rp.num2);
			resultList.add(list);
		}

		return resultList;
	}

	public List<int[]> kSmallestPairs1(int[] nums1, int[] nums2, int k) {
		PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
		List<int[]> res = new ArrayList<>();
		if (nums1.length == 0 || nums2.length == 0 || k == 0)
			return res;
		for (int i = 0; i < nums1.length && i < k; i++)
			que.offer(new int[] { nums1[i], nums2[0], 0 });
		while (k-- > 0 && !que.isEmpty()) {
			int[] cur = que.poll();
			res.add(new int[] { cur[0], cur[1] });
			if (cur[2] == nums2.length - 1)
				continue;
			que.offer(new int[] { cur[0], nums2[cur[2] + 1], cur[2] + 1 });
		}
		return res;
	}

}
