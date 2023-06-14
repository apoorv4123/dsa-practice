package L28_Graph;

import java.util.ArrayList;
// MIN-HEAP
import java.util.HashMap;

public class HeapGeneric<T extends Comparable<T>> {

	ArrayList<T> data = new ArrayList<>();

	HashMap<T, Integer> map = new HashMap<>();

	public void add(T item) {
		data.add(item);
		map.put(item, data.size() - 1);
		upheapify(data.size() - 1); // the last index at which element is entered is passed
	}

	private void upheapify(int ci) {

		int pi = (ci - 1) / 2;

		// when priority of child > priority of parent , swap them
		if (isLarger(data.get(ci), data.get(pi)) > 0) {
			swap(pi, ci);
			upheapify(pi);
		}
	}

	private void swap(int i, int j) {

		T ith = data.get(i);
		T jth = data.get(j);

		data.set(i, jth);
		data.set(j, ith);

		map.put(ith, j);
		map.put(jth, i);
	}

	public void display() {
		System.out.println(data);
	}

	public int size() {
		return this.data.size();
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public T remove() {

		// swap 0th and last element
		swap(0, this.data.size() - 1);

		// remove last element
		T rv = this.data.remove(this.data.size() - 1);

		map.remove(rv);

		downheapify(0);

		return rv;

	}

	private void downheapify(int pi) {

		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		int mini = pi;

		// if left child has higher priority, upate mini
		if (lci < this.data.size() && isLarger(data.get(lci), data.get(mini)) > 0) {
			mini = lci;
		}

		// if right chil has
		if (rci < this.data.size() && isLarger(data.get(rci), data.get(mini)) > 0) {
			mini = rci;
		}

		if (mini != pi) {
			swap(pi, mini);
			downheapify(mini);
		}
	}

	public T get() {
		return this.data.get(0);
	}

	// if t has higher priority, returns +ve value else -ve
	public int isLarger(T t, T o) {
		return t.compareTo(o);
	}

	public void updatePriority(T pair) {

		int index = map.get(pair);

		upheapify(index);// NOT downheapify

	}
}