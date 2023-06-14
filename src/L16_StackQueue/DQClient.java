package L16_StackQueue;

public class DQClient {
	
	public static void main(String[] args) throws Exception {
		
		DynamicQueue queue=new DynamicQueue();
		
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		
		queue.display();
		
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		
		
		queue.enqueue(60);
		queue.enqueue(70);
		queue.enqueue(80);
		queue.enqueue(90);
		
		queue.display();
		
		
		
	}

}
