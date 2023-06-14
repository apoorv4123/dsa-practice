package L17_StackQueueQuestions;

import L16_StackQueue.DynamicQueue;

public class QueueQuestions {

	public static void main(String[] args) throws Exception {
		DynamicQueue queue = new DynamicQueue();

		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);

//		queue.display();

//		System.out.println(queue.dequeue());
//		System.out.println(queue.dequeue());
//
//		queue.enqueue(60);
//		queue.enqueue(70);
//		queue.enqueue(80);
//		queue.enqueue(90);

		queue.display();
		displayReverse(queue, 0);
		System.out.println();
		queue.display();

		actualReverse(queue);
		queue.display();

	}

	public static void displayReverse(DynamicQueue q, int count) throws Exception {

		if (count == q.size()) {
			return;
		}
		int temp = q.dequeue();
		q.enqueue(temp);
		displayReverse(q, count + 1);
		System.out.print(temp + " ");

	}

	public static void actualReverse(DynamicQueue q) throws Exception {

		if (q.isEmpty()) {
			return;
		}
		int temp = q.dequeue();
		actualReverse(q);
		System.out.print(temp + " ");
		q.enqueue(temp);

	}
}
