package L18_LinkedList;

public class LinkedList {

	private class Node {

		int data;
		Node next;

		public Node() {

		}

		public Node(int item) {
			this.data = item;
		}

	}

	private Node head;
	private Node tail;
	private int size;

	public void display() {

		System.out.println("----------------------");

		Node temp = head;

		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}

		System.out.println(".");
		System.out.println("----------------------");

	}

	public void addlast(int item) {

		// create a new node
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		// attach
		if (this.size >= 1) {
			this.tail.next = nn;
		}

		// summary object, Update
		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			this.tail = nn;
			this.size++;
		}
	}

	public void addfirst(int item) {

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

	public int getFirst() throws Exception {

		// Throw exception if list is empty
		if (this.size == 0) {
			throw new Exception("LL is empty");
		}

		return this.head.data;
	}

	public int getLast() throws Exception {

		// Throw exception if list is empty
		if (this.size == 0) {
			throw new Exception("LL is empty");
		}

		return this.tail.data;
	}

	public int getAt(int idx) throws Exception {

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

	public void addAt(int item, int idx) throws Exception {

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

	public int removeFirst() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is empty.");
		}

		int rv = this.head.data;

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

	public int removeLast() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is empty.");
		}

		int rv = this.tail.data;

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

	public int removeAt(int idx) throws Exception {

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

			int temp = ln.data;
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

	public int midNode() {

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
			int temp = mover.left.data;
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
			int temp = cl.data;
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

	public int kthFromLast(int k) {

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

	public void createDummyList() {

		Node n1 = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(30);
		Node n4 = new Node(40);
		Node n5 = new Node(50);
		Node n6 = new Node(60);
		Node n7 = new Node(70);
		Node n8 = new Node(80);
		Node n9 = new Node(90);
		Node n10 = new Node(100);
		Node n11 = new Node(110);
		Node n12 = new Node(120);
		Node n13 = new Node(130);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = n10;
		n13.next = n12;
		n12.next = n11;
		n11.next = n7;

		Node h1 = n1;
		Node h2 = n13;

		// logic
		intersection(h1, h2);
	}

	private void intersection(Node h1, Node h2) {

		Node fp = h1;
		Node sp = h2;

		while (fp != sp) {

			if (fp == null) {
				fp = h2;
			} else {
				fp = fp.next;
			}

			if (sp == null) {
				sp = h1;
			} else {
				sp = sp.next;
			}

		}

		System.out.println(fp.data);

	}

	public void createDummyListLoop() {

		Node n1 = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(30);
		Node n4 = new Node(40);
		Node n5 = new Node(50);
		Node n6 = new Node(60);
		Node n7 = new Node(70);
		Node n8 = new Node(80);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n3;

		Node h1 = n1;

		// logic
		System.out.println(detect(h1));
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

	public void kReverse(int k) {
		head = kReverse(head, k);
	}

	private Node kReverse(Node node, int k) {

		if (node == null) {
			return null;
		}

		// to identify argument of smaller problem
		Node temp = node;
		for (int i = 1; i <= k && temp != null; i++) {
			temp = temp.next;
		}

		// smaller problem : s2 and s3 reverse
		Node prev = kReverse(temp, k);

		// self work : reverse s1
		Node curr = node;

		while (curr != temp) {
			Node ahead = curr.next;
			curr.next = prev;

			prev = curr;
			curr = ahead;
		}
		return prev;
	}

	public Node swapPairs() {
		return swapPairs(this.head);
	}

	private Node swapPairs(Node head) {
		Node first = head, second = head.next;

		while (second != null) {
			Node ahead = second.next;
			second.next = first;
			first.next = ahead;

			if (first == head) {
				head = second;
			}

			first = ahead;
			second = ahead.next;
		}
		return head;
	}

	public void ques() {
		ques(head);
	}

	private void ques(Node node) {
		Node dummy = new Node(-1);
		dummy.next = node;
		System.out.println(dummy.data);
		System.out.println(node.data);
	}

	public void mergeInBetweenLL() {

		Node n1 = new Node(0);
		Node n2 = new Node(1);
		Node n3 = new Node(2);
		Node n4 = new Node(3);
		Node n5 = new Node(4);
		Node n6 = new Node(5);
		Node n7 = new Node(6);
		Node n8 = new Node(7);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;

		Node n9 = new Node(20);
		Node n10 = new Node(30);
		Node n11 = new Node(40);

		n9.next = n10;
		n10.next = n11;

		this.head = mergeInBetween(n1, 2, 6, n9);

	}

	public Node mergeInBetween(Node list1, int a, int b, Node list2) {

		Node dummy = new Node(0);
		dummy.next = list1;
		Node temp = list1, former = dummy, latter = dummy;
		for (int i = 0; temp != null; i++) {
			System.out.println(i + "." + temp.data);
			if (i == a - 1) {
				former = temp;
			} else if (i == b + 1) {
				latter = temp;
			}
			temp = temp.next;
		}
		System.out.println(former.data + " - " + latter.data);
		former.next = list2;
		temp = list2;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = latter;

		return dummy.next;
	}

}