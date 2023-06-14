package L22_Hashmap.Generics;

public class LinkedListGeneric<T> {

	private class Node {

		T data;
		Node next;

		public Node() {

		}

		public Node(T item) {
			this.data = item;
		}

	}

	private Node head;
	private Node tail;
	private int size;

	public void display() {

//		System.out.println("----------------------");

		Node temp = head;

		while (temp != null) {
			System.out.print(temp.data + " => ");
			temp = temp.next;
		}

		System.out.println("END");
		System.out.println("***************************");

	}

	public boolean isEmpty() {
		return size == 0 ? true : false;
	}

	public void addlast(T item) {

		// Create
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		// Attach
		if (this.size != 0) {
			this.tail.next = nn;
		}

		// Update
		if (this.size >= 1) {
			tail = nn;
			this.size++;
		} else {
			this.head = nn;
			this.tail = nn;
			this.size++;
		}
	}

	public void addfirst(T item) {

		// Create a node
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		// Attach to pre-existing linked-list
		if (this.size != 0) {
			nn.next = this.head;
		}

		// Update
		if (this.size >= 1) {
			this.head = nn;
			this.size++;
		} else {
			this.head = nn;
			this.tail = nn;
			this.size++;
		}
	}

	public T getFirst() throws Exception {

		// Throw exception if list is empty
		if (this.size == 0) {
			throw new Exception("LL is empty");
		}

		return this.head.data;
	}

	public T getLast() throws Exception {

		// Throw exception if list is empty
		if (this.size == 0) {
			throw new Exception("LL is empty");
		}

		return this.tail.data;
	}

	public int getIndex(T item) {

		int index = 0;

		for (Node temp = head; temp != null; temp = temp.next) {
			if (temp.data.equals(item)) {
				return index;
			}
			index++;
		}
		return -1;

	}

	public T getAt(int idx) throws Exception {

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid index.");
		}

		if (this.size == 0) {
			throw new Exception("LL is empty.");
		}

		Node temp = this.head;
		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}

		return temp.data;
	}

	private Node getNodeAt(int idx) throws Exception {

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid index.");
		}

		if (this.size == 0) {
			throw new Exception("LL is empty.");
		}

		Node temp = this.head;
		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}

		return temp;

	}

	public void addAt(T item, int idx) throws Exception {

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalis index.");
		}

		if (idx == 0) {
			this.addfirst(item);
		} else if (idx == this.size - 1) {
			this.addlast(item);
		} else {

			// create
			Node nn = new Node();
			nn.data = item;
			nn.next = null;

			// pointers nm1,np1
			Node nm1 = getNodeAt(idx - 1);
			Node np1 = nm1.next;

			// attach
			nm1.next = nn;
			nn.next = np1;

			this.size++;

		}
	}

	public T removeFirst() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is empty.");
		}

		T rv = this.head.data;

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		} else {
			this.head = this.head.next;
			this.size--;
		}

		return rv;
	}

	public T removeLast() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is empty.");
		}

		T rv = this.tail.data;

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		} else {
			Node tm1 = getNodeAt(size - 2);
			this.tail = tm1;
			this.tail.next = null;
			this.size--;
		}

		return rv;
	}

	public T removeAt(int idx) throws Exception {

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid index.");
		}

		if (this.size == 0) {
			throw new Exception("LL is empty.");
		}

		if (idx == 0) {
			return removeFirst();
		} else if (idx == this.size - 1) {
			return removeLast();
		} else {

			Node nm1 = getNodeAt(idx - 1);
			Node rn = getNodeAt(idx);
			Node np1 = rn.next;

			nm1.next = np1;

			this.size--;

			return rn.data;
		}
	}

	public void reverseData() throws Exception {

		int left = 0;
		int right = this.size - 1;

		while (left < right) {

			Node ln = getNodeAt(left);
			Node rn = getNodeAt(right);

			T temp = ln.data;
			ln.data = rn.data;
			rn.data = temp;

			left++;
			right--;
		}
	}

	public void reversePointers() throws Exception {

		Node previous = getNodeAt(0);
		Node current = previous.next;

		while (current != null) {

			Node ahead = current.next;

			current.next = previous;
			previous = current;
			current = ahead;
		}

		// swap head and tail
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;

		this.tail.next = null;
	}

	public T midNode() {

		Node slow = this.head;
		Node fast = this.head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow.data;

	}

	public void reversePointerRecursively() {

		reversePointerRecursively(head, head.next);

		// swap head and tail
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;

		this.tail.next = null;
	}

	private void reversePointerRecursively(Node prev, Node curr) {

		if (curr == null) {
			return;
		}

		reversePointerRecursively(prev.next, curr.next);

		curr.next = prev;

	}

	public class HeapMover {
		Node left;
	}

	public void reverseDataRecursively() {

		HeapMover mover = new HeapMover();
		mover.left = head;

		reverseDataRecursively(mover, head, 0);

//		OR

		reverseDataRecursively(head, head, 0);
	}

	private void reverseDataRecursively(HeapMover mover, Node right, int count) {

		if (right == null) {
			return;
		}

		reverseDataRecursively(mover, right.next, count + 1);

		if (count >= this.size / 2) {
			T temp = mover.left.data;
			mover.left.data = right.data;
			right.data = temp;
		}
		mover.left = mover.left.next;

	}

	private Node reverseDataRecursively(Node left, Node right, int count) {

		if (right == null) {
			return left;
		}

		Node cl = reverseDataRecursively(left, right.next, count + 1);

		if (count >= this.size / 2) {
			T temp = cl.data;
			cl.data = right.data;
			right.data = temp;
		}

		return cl.next;

	}

	public void fold() {

		HeapMover mover = new HeapMover();

		mover.left = head;

		fold(mover, head, 0);

	}

	private void fold(HeapMover mover, Node right, int count) {

		if (right == null) {
			return;
		}

		fold(mover, right.next, count + 1);

		if (count >= this.size / 2) {

			if (count == this.size / 2) {
				right.next = null;
			} else {
				Node temp = mover.left.next;

				mover.left.next = right;
				right.next = temp;
			}
		}
		mover.left = right.next;
	}

	public T kthFromLast(int k) {

		Node fast = head;
		Node slow = head;

		for (int i = 1; i < k; i++) {
			fast = fast.next;
		}

		while (fast.next != null) {

			fast = fast.next;
			slow = slow.next;

		}

		return slow.data;
	}

	public boolean detect_RemoveLoop() {
		return detect(this.head);
	}

	private boolean detect(Node h1) {

		Node slow = h1;
		Node fast = h1;

		while (fast != null && fast.next != null) {

			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
//				removeLoop(slow, h1);
				removeLoop2(slow, h1);
				return true;
			}

		}

		return false;

	}

	private void removeLoop(Node meet, Node h) {

		// no. of nodes in loop
		int count = 1;
		Node temp = meet;
		while (temp.next != meet) {
			count = count + 1;
			temp = temp.next;
		}

		// move a pointer count no. of steps ahead
		Node fast = h;
		for (int i = 1; i <= count; i++) {
			fast = fast.next;
		}

		// move slow and fast with same speed
		Node slow = h;
		while (slow.next != fast.next) {
			slow = slow.next;
			fast = fast.next;
		}

		fast.next = null;

		// print ll
		Node t = h;
		while (t != null) {
			System.out.print(t.data + " ");
			t = t.next;
		}
		System.out.println();

	}

	public void removeLoop2(Node meet, Node h) {

		Node start = h;
		Node loop = meet;

		while (loop.next != start.next) {

			start = start.next;
			loop = loop.next;
		}

		loop.next = null;

		Node t = h;
		while (t != null) {
			System.out.print(t.data + " ");
			t = t.next;
		}
		System.out.println();

	}

}
