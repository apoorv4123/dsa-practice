package L16_Adapters;

import L16_StackQueue.DynamicQueue;

public class SUQPopEfficient {

	DynamicQueue pq = new DynamicQueue();

	// O(n)
	public void push(int item) throws Exception {

		try {
			DynamicQueue hq = new DynamicQueue();

			hq.enqueue(item);

			while (pq.size() != 0) {
				hq.enqueue(pq.dequeue());
			}

			pq = hq;
		} catch (Exception e) {
			// although this exception will never come as we are using dynamic queue and
			// dynamic
			// queue can handle itself.
			throw new Exception("Stack is full");
		}

	}

	// O(1)
	public int pop() throws Exception {

		try {
			return pq.dequeue();
		} catch (Exception e) {
			throw new Exception("Stack is empty");
		}

	}

	// O(1)
	public int peek() throws Exception {

		try {
			return pq.getFront();
		} catch (Exception e) {
			throw new Exception("Stack is empty");
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

	// O(1)
	public void display() {
		pq.display();
	}

}