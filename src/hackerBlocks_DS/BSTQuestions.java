package hackerBlocks_DS;

import java.util.*;

public class BSTQuestions {

	private class Node {
		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	private Node root;
	private int size;

	public BSTQuestions() {
		this.root = null;
		this.size = 0;
	}

	public void add(int data) {
		if (this.isEmpty()) {
			this.root = new Node(data, null, null);
			this.size++;
		} else {
			this.add(this.root, data);
		}
	}

	private void add(Node node, int data) {

		if (data > node.data) {
			if (node.right != null) {
				this.add(node.right, data);
			} else {
				this.size++;
				node.right = new Node(data, null, null);
			}
		} else if (data < node.data) {
			if (node.left != null) {
				this.add(node.left, data);
			} else {
				this.size++;
				node.left = new Node(data, null, null);
			}
		}// else {
			// nothing to do
//		}
	}

	public void remove(int data) {
		this.root = this.remove(this.root, data);
	}

	private Node remove(Node node, int data) {
		if (node == null) {
			return null;
		}

		if (data > node.data) {
			node.right = this.remove(node.right, data);
			return node;
		} else if (data < node.data) {
			node.left = this.remove(node.left, data);
			return node;
		} else {
			// found the element
			if (node.left == null && node.right == null) {
				this.size--;
				return null;
			} else if (node.left == null) {
				this.size--;
				return node.right;
			} else if (node.right == null) {
				this.size--;
				return node.left;
			} else {
				// both children
				int lmax = this.max(node.left);
				node.data = lmax;
				node.left = this.remove(node.left, lmax);

				return node;
			}
		}
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void display() {
		System.out.println(this);
	}

	public int max() {
		return this.max(this.root);
	}

	private int max(Node node) {
		int rv = node.data;

		if (node.right != null) {
			rv = this.max(node.right);
		}

		return rv;
	}

	@Override
	public String toString() {
		return this.toString(this.root);
	}

	private String toString(Node node) {
		if (node == null) {
			return "";
		}

		String retVal = "";

		if (node.left != null) {
			retVal += node.left.data + " => ";
		} else {
			retVal += "END" + " => ";
		}

		retVal += node.data;

		if (node.right != null) {
			retVal += " <= " + node.right.data;
		} else {
			retVal += " <= " + "END";
		}

		retVal += "\n";

		retVal += this.toString(node.left);
		retVal += this.toString(node.right);

		return retVal;
	}

	public void replaceWLS() {
		replaceWLS(root);
	}

	private int sum = 0;

	private void replaceWLS(Node node) {

		if (node == null) {
			return;
		}

		// R
		replaceWLS(node.right);

		int temp = node.data;
		node.data = sum;
		sum += temp;

		// L
		replaceWLS(node.left);

	}

	public void leastCommonAncester(int one, int two) {
		int ans = leastCommonAncester(root, one, two);
		if (ans == 0) {
			System.out.println("NULL");
		} else {
			System.out.println(ans);
		}
	}

	private int leastCommonAncester(Node node, int one, int two) {

		if (contains(node, one) && contains(node, two)) {
			return node.data;
		} else {
			return 0;
		}

	}

	private boolean contains(Node node, int item) {

		if (node == null) {
			return false;
		}

		if (node.data == item) {
			return true;
		}

		return contains(node.left, item) || contains(node.right, item);

	}

	public static void main(String[] args) {

		BSTQuestions b1 = new BSTQuestions();
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		while (n != 0) {
			int m = scn.nextInt();
			b1.add(m);
			--n;
		}
//		b1.replaceWLS();
//		System.out.println(b1);
//		b1.leastCommonAncester(50, 60);
		b1.display();
		scn.close();
	}

}