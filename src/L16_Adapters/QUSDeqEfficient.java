package L16_Adapters;

import L16_StackQueue.DynamicStack;

public class QUSDeqEfficient {

	DynamicStack ps = new DynamicStack(); // primary stack

	// O(n)
	public void enqueue(int item) throws Exception {

		try {
			DynamicStack hs = new DynamicStack();

			while (!ps.isEmpty()) {
				hs.push(ps.pop());
			}

			hs.push(item);

			while (!hs.isEmpty()) {
				ps.push(hs.pop());
			}

		} catch (Exception e) {
			throw new Exception("Queue is Full");
		}

	}

	// O(1)
	public int dequeue() throws Exception {

		try {
			return ps.pop();
		} catch (Exception e) {
			throw new Exception("Queue is Empty");
		}

	}

	// O(1)
	public int getFront() throws Exception {

		try {
			return ps.peek();
		} catch (Exception e) {
			throw new Exception("Queue is Empty");
		}
	}

	// O(1)
	public int size() {
		return ps.size();
	}

	// O(1)
	public boolean isEmpty() {
		return ps.isEmpty();
	}

	// O(1)
	public boolean isFull() {
		// this fxn is not significant as we're using dynamic stack and dynamic stack
		// will never be full
		return ps.isFull();
	}

	// O(n)
	public void display() {
		ps.display();
	}

}