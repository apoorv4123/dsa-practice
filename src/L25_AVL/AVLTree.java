package L25_AVL;

public class AVLTree {

	private class Node {
		int data;
		Node left;
		Node right;
		int height;

		public Node(int data) {
			this.data = data;
			this.height = 0;
		}
	}

	private Node root;

	public void insert(int item) {
		root = insert(this.root, item);
	}

	public Node insert(Node node, int item) {

		if (node == null) {
			Node nn = new Node(item);
			return nn;
		}

		if (item < node.data) {
			node.left = insert(node.left, item);
		} else {
			node.right = insert(node.right, item);
		}

		int bf = bf(node);

		// detecting problems
		if (bf > 1 && item < node.left.data) { // LL
			return rightRotation(node);
		}
		if (bf < -1 && item > node.right.data) { // RR
			return leftRotation(node);
		}
		if (bf > 1 && item > node.left.data) { // LR
			Node a = leftRotation(node.left);
			node.left = a;
			return rightRotation(node);
		}
		if (bf < -1 && item < node.right.data) { // RL
			node.right = rightRotation(node.right);
			return leftRotation(node);
		}

		return node;
	}

	private int height(Node node) {
		if (node == null) {
			return -1;
		}
		return Math.max(height(node.left), height(node.right)) + 1;
	}

	private int bf(Node node) {
		if (node == null) {
			return 0;
		}
		return height(node.left) - height(node.right);
	}

	// Solution of LL problem
	private Node rightRotation(Node c) {

		Node b = c.left;
		Node T3 = b.right;

		// rotation
		b.right = c;
		c.left = T3;

		// updating height of b & c
		c.height = height(c);
		b.height = height(b);

		return b;
	}

	// Solution of RR problem
	private Node leftRotation(Node c) {

		Node b = c.right;
		Node T2 = b.left;

		// rotate
		b.left = c;
		c.right = T2;

		c.height = height(c);
		b.height = height(b);

		return b;
	}

	public void display() {
		display(this.root);
	}

	private void display(Node node) {

		if (node == null) {
			return;
		}

		String str = "";
		if (node.left == null) {
			str += ".";
		} else {
			str += node.left.data;
		}

		str += "->" + node.data + "<-";

		if (node.right == null) {
			str += ".";
		} else {
			str += node.right.data;
		}

		System.out.println(str);

		display(node.left);
		display(node.right);

	}

}