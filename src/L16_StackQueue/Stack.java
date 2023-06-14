package L16_StackQueue;

public class Stack {

	// Must be private because if not made private then the client can access
	protected int[] data;
	protected int tos;

	public Stack() {// constructor
//			int[] data=new int[5];//wrong
		data = new int[5];
		tos = -1;
	}

	public Stack(int cap) {
		data = new int[cap];
		tos = -1;
	}

	public int pop() throws Exception {

		if (isEmpty()) {
			throw new Exception("Stack is Empty");
		}
		int temp = data[tos];
		data[tos] = 0; // won't be a problem if not done
		tos--;
		return temp;
	}

	public void push(int item) throws Exception {

		if (isFull()) {
			throw new Exception("Stack is Full");
		}

		tos++;
		data[tos] = item;
	}

	public int peek() throws Exception {
		if (isEmpty()) {
			throw new Exception("Stack is Empty");
		}
		return data[tos];
	}

	public int size() {
		return tos + 1;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public boolean isFull() {
		return size() == data.length;
	}

	public void display() {
		System.out.println("-----------------");
		for (int i = tos; i >= 0; i--) {
			System.out.print(data[i] + " ");
		}
		System.out.println(".");
		System.out.println("-----------------");
	}

}
