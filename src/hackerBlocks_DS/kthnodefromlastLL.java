package hackerBlocks_DS;

import java.util.Scanner;

public class kthnodefromlastLL {

	class LinkList {

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

		public void addlast(int item) {

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

		public int kthfromlast(int k) {

			Node slow = head;
			Node fast = head;

			for (int i = 1; i < k; i++) {
				fast = fast.next;
			}

			while (fast.next != null) {
				fast = fast.next;
				slow = slow.next;
			}

			return slow.data;

		}

	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		kthnodefromlastLL m = new kthnodefromlastLL();

		LinkList ll = m.new LinkList();

		while (true) {
			int item = s.nextInt();
			if (item == -1) {
				break;
			}
			ll.addlast(item);
		}

		int k = s.nextInt();

		System.out.println(ll.kthfromlast(k));
	}

}