package L16_Adapters;

import java.util.ArrayList;

import L16_StackQueue.DynamicQueue;

public class SUQPushEfficient {

	DynamicQueue pq = new DynamicQueue(); // primary queue

	// O(1)
	public void push(int item) throws Exception {

		try {
			pq.enqueue(item);
		} catch (Exception e) {
			throw new Exception("Stack is Full");
		}
	}

	// O(n)
	public int pop() throws Exception {

		try {
			DynamicQueue hq = new DynamicQueue();

			while (pq.size() != 1) {
				hq.enqueue(pq.dequeue());
			}

			int temp = pq.dequeue();

			pq = hq;

			return temp;
		} catch (Exception e) {

			throw new Exception("Stack is Empty");

		}
	}

	// O(n)
	public int peek() throws Exception {
		try {
			DynamicQueue hq = new DynamicQueue();

			while (pq.size() != 1) {
				hq.enqueue(pq.dequeue());
			}

			int temp = pq.dequeue();

			hq.enqueue(temp);

			pq = hq;

			return temp;
		} catch (Exception e) {
			throw new Exception("Stack is Empty");
		}
	}

	// O(1)
	public int size() {
		return pq.size();
	}

	// O(1)
	public boolean isEmpty() {
		return pq.isEmpty();
	}

	// O(1)
	public boolean isFull() {
		return pq.isFull();
	}

	public void display() throws Exception {
		System.out.println("-------------------");
		display(0);
		System.out.println("-------------------");
	}

	private void display(int count) throws Exception {
		try {

			if (count == pq.size()) {
				return;
			}

			int temp = pq.dequeue();
			pq.enqueue(temp); // to maintain the queue order

			display(count + 1);

			System.out.println(temp + " ");

		} catch (Exception e) {
			throw new Exception("Error in dispaly");
		}

	}

}
