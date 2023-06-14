package L16_Adapters;

public class QUSClient {

	public static void main(String[] args) throws Exception {
		
//		QUSEnqEfficient queue=new QUSEnqEfficient();
		QUSDeqEfficient queue =new QUSDeqEfficient();
		
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		
		queue.display();
		System.out.println();
		
		System.out.println(queue.dequeue());
		System.out.println(queue.getFront());
		
		System.out.println();
		queue.display();

		
	}

}
