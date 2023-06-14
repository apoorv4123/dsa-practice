package L24_Heap;

import java.util.ArrayList;

public class HeapQuestions {

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

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

		mergeKSortedLists(lists);
//		kLargestElements(new int[] { 5, 3, 10, 2, 20, 30, 15, 60, 7 }, 3);

	}

	public static class Pair implements Comparable<Pair> {

		int data;
		int listNo;
		int idxNo;

		@Override
		public int compareTo(Pair o) {
			return o.data - this.data;
			// for min-heap, smaller value has greater priority{other-this}
		}
	}

	public static void mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {

//		HeapQuestions obj=new HeapQuestions(); object formation of outer class
		HeapGeneric<Pair> heap = new HeapGeneric<>();

		// enter the first elements of all the lists in heap
		for (int i = 0; i < lists.size(); i++) {

//			Pair np=obj.new Pair(); if Pair class is non-static
			Pair np = new Pair();
			np.data = lists.get(i).get(0);
			np.listNo = i;
			np.idxNo = 0;

			heap.add(np);
		}

		// do work until list is not empty
		while (!heap.isEmpty()) {

			Pair rp = heap.remove();

			System.out.println(rp.data);

			rp.idxNo++;

			// to make sure that list from which next element is to be added in heap is not
			// empty
			if (rp.idxNo < lists.get(rp.listNo).size()) {
				rp.data = lists.get(rp.listNo).get(rp.idxNo);
				heap.add(rp);
			}
		}

	}

	public static void kLargestElements(int[] arr, int k) {

		Heap heap = new Heap();

		// add first k elements in heap
		for (int i = 0; i < k; i++) {
			heap.add(arr[i]);
		}

		// remaining work
		for (int i = k; i < arr.length; i++) {

			int weaker = heap.get(); // obtain the weakest element of min-heap

			if (arr[i] > weaker) {
				heap.remove();
				heap.add(arr[i]);
			}
		}

		while (!heap.isEmpty()) {
			System.out.println(heap.remove());
		}
	}

}