package L16_StackQueue;

public class Stackpractice {

	
	private int[] data;
	private int tos;

	public Stackpractice() {// constructor
		data = new int[5];
		tos = -1;
	}

	public Stackpractice(int capacity) {// parameterised constructor
		data = new int[capacity];
		tos = -1;
	}

	public void push(int item) throws Exception {

		if (isFull()) {
			throw new Exception("Stack is Full");
		}
		tos++;
		data[tos] = item;
	}

	public int pop() throws Exception {
		
		if (isEmpty()) {
			throw new Exception("Stack is Empty");
		}
		int temp = data[tos];
		data[tos] = 0;
		tos--;
		return temp;
	}

	public int peek() {
		return data[tos];
	}

	public int size() {
		return tos + 1;
	}

	public boolean isEmpty() {
//		return tos==-1;
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
