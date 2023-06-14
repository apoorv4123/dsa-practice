package L16_Adapters;

import L16_StackQueue.DynamicStack;

public class QUSEnqEfficient {

	DynamicStack ps = new DynamicStack(); // primary stack

	// O(1)
	public void enqueue(int item) throws Exception {
		try {
			ps.push(item);
		} catch (Exception e) {
			// although, this exception will never come as we're using dynamic stack
			throw new Exception("Queue is Full");
		}
	}

	// O(n)
	public int dequeue() throws Exception {

		try {
			DynamicStack hs = new DynamicStack();

			while (ps.size() != 1) {
				hs.push(ps.pop());
			}

			int temp = ps.pop();

			while (!hs.isEmpty()) {
				ps.push(hs.pop());
			}

			return temp;
		} catch (Exception e) {
			throw new Exception("Queue is Empty");
		}
	}

	public int getFront() throws Exception {

		try {
			DynamicStack hs = new DynamicStack();

			while (ps.size() != 1) {
				hs.push(ps.pop());
			}

			int temp = ps.peek();
			// int temp=ps.pop();
			// hs.push(temp);

			while (!hs.isEmpty()) {
				ps.push(hs.pop());
			}

			return temp;
		} catch (Exception e) {
			throw new Exception("Queue is empty");
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
	public void display() throws Exception {

		System.out.println("---------------");
		displayH();
		System.out.println("---------------");

	}

	public void displayH() throws Exception {

		try {
			if (ps.isEmpty()) {
				return;
			}

			int temp = ps.pop();

			displayH();

			System.out.println(temp);

			ps.push(temp);
		} catch (Exception e) {
			throw new Exception("Error in display");
		}
	}

}