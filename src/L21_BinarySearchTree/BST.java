package L21_BinarySearchTree;

import java.util.ArrayList;

public class BST {

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public BST(int[] inorder) {
		this.root = construct(inorder, 0, inorder.length - 1);
	}

	private Node construct(int[] inorder, int lo, int hi) {

		if (lo > hi) {
			return null;
		}

		// mid
		int mid = (lo + hi) / 2;

		// create a new node
		Node nn = new Node();
		nn.data = inorder[mid];

		nn.left = construct(inorder, lo, mid - 1);
		nn.right = construct(inorder, mid + 1, hi);

		return nn;
	}

	public void display() {
		System.out.println("---------------");
		display(root);
		System.out.println("---------------");
	}

	private void display(Node node) {

		if (node == null) {
			return;
		}

		String str = "";

		if (node.left == null)
			str += " .";
		else
			str += node.left.data;

		str += " -> " + node.data + " <- ";

		if (node.right != null)
			str += node.right.data;
		else
			str += ". ";

		System.out.println(str);

		display(node.left);
		display(node.right);

	}

	public boolean find(int item) {
		return find(this.root, item);
	}

	private boolean find(Node node, int item) {

		if (node == null) {
			return false;
		}

		if (item > node.data) {
			return find(node.right, item);
		} else if (item < node.data) {
			return find(node.left, item);
		} else { // equals
			return true;
		}
	}

	public int max() {
		return max(this.root);
	}

	private int max(Node node) {
		if (node.right == null) {
			return node.data;
		}
		return max(node.right);
	}

	public void add(int item) {
		add(this.root, item);
	}

	private void add(Node node, int item) {

		if (item > node.data) {
			if (node.right == null) {
				Node nn = new Node();
				nn.data = item;

				node.right = nn;
			} else {
				add(node.right, item);
			}

		} else {
			if (node.left == null) { // no node jisko kaam saunpa jaai, khud kro
				Node nn = new Node(); // new node banao
				nn.data = item; // node ka data set kro

				node.left = nn; // attack kro
			} else { // dekha jaiga ki kya koi node hai jisko kaam saunpa ja sake
				add(node.left, item);
			}
		}

	}

	public void remove(int item) {
		remove(root, null, false, item);
	}

	private void remove(Node node, Node parent, boolean ilc, int item) {

		if (node == null) {// while searching a value that doesn't exists in bst
			return;
		}

		if (item > node.data) {
			remove(node.right, node, false, item);
		} else if (item < node.data) {
			remove(node.left, node, true, item);
		} else { // reached the node

			if (node.left == null && node.right == null) { // leaf node
				if (ilc) {
					parent.left = null;
				} else {
					parent.right = null;
				}
			} else if (node.left == null && node.right != null) {
				if (ilc) {
					parent.left = node.right;
				} else {
					parent.right = node.right;
					node.right = null;
				}

			} else if (node.left != null && node.right == null) {
				if (ilc) {
					parent.left = node.left;
				} else {
					parent.right = node.left;
				}
				node.left = null;

			} else {
				int max = max(node.left);
				node.data = max;

				remove(node.left, node, true, max);
			}

		}

	}

	public void printDec() {
		printDec(root);
	}

	private void printDec(Node node) {

		if (node == null) {
			return;
		}

		// R
		printDec(node.right);

		// N
		System.out.print(node.data + " ");

		// L
		printDec(node.left);

	}

	public void replaceWithSumLarger() {
		replaceWithSumLarger(root);
	}

	int sum = 0;

	private void replaceWithSumLarger(Node node) {

		if (node == null) {
			return;
		}

		// R
		replaceWithSumLarger(node.right);

		// node update
		int temp = node.data;
		node.data = sum;
		sum += temp;

		// L
		replaceWithSumLarger(node.left);
	}

	public void printInRange(int lo, int hi) {
		printInRange(root, lo, hi);
	}

	private void printInRange(Node node, int lo, int hi) {

		if (node == null) {
			return;
		}

		if (node.data < lo) {
			printInRange(node.right, lo, hi);
		} else if (node.data > hi) {
			printInRange(node.left, lo, hi);
		} else { // node in range
			printInRange(node.left, lo, hi);
			System.out.print(node.data + " ");
			printInRange(node.right, lo, hi);
		}

	}

	public void add2(int item) {
		root = add2(root, item); // storing result in root here is insignificant as changes are being made in
									// heap and tree already exists. But, if tree was empty the storing was
									// significant
	}

	private Node add2(Node node, int item) {

		if (node == null) {
			Node nn = new Node();
			nn.data = item;
			return nn;
		}

		if (item <= node.data) { // item < or = to node.data is added in lst
			node.left = add2(node.left, item);
		} else {
			node.right = add2(node.right, item);
		}

		return node;
	}

	// Leetcode 1382
	public ArrayList<Integer> in() {
		return in(root);
	}

	private ArrayList<Integer> in(Node root) {

		if (root == null) {
			return new ArrayList<>();
		}

		ArrayList<Integer> l = in(root.left);
		l.add(root.data);
		l.addAll(in(root.right));

		return l;

	}

	public void construct(ArrayList<Integer> al) {
		this.root = construct(al, 0, al.size() - 1);
	}

	public Node construct(ArrayList<Integer> al, int lo, int hi) {

		if (lo > hi) {
			return null;
		}

		int mid = (lo + hi) / 2;

		Node nn = new Node();
		nn.data = al.get(mid);

		nn.left = construct(al, lo, mid - 1);
		nn.right = construct(al, mid + 1, hi);

		return nn;
	}

	// Leetcode 1373
	public class maxBSTPair {
		boolean isBST = true;
		int maxSumTillNow = Integer.MIN_VALUE;
		int subtreeSum = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
	}

	public int MaximumSumBSTinBinaryTree() {
		return MaximumSumBSTinBinaryTree(this.root).maxSumTillNow;
	}

	private maxBSTPair MaximumSumBSTinBinaryTree(Node node) {

		if (node == null) {
			return new maxBSTPair();
		}

		maxBSTPair l = MaximumSumBSTinBinaryTree(node.left);
		maxBSTPair r = MaximumSumBSTinBinaryTree(node.right);

		maxBSTPair sp = new maxBSTPair();
		
		sp.max = Math.max(node.data, Math.max(l.max, r.max));
		sp.min = Math.min(node.data, Math.min(l.min, r.min));

//		sp.isBST = l.isBST && r.isBST;
//		if (node.left != null)
//			sp.isBST = sp.isBST && node.data > node.left.data;
//		if (node.right != null)
//			sp.isBST = sp.isBST && node.data < node.right.data;

		if (node.data > l.max && node.data < r.min && l.isBST && r.isBST) {
			sp.isBST = true;
		} else {
			sp.isBST = false;
		}
		
		sp.subtreeSum = l.subtreeSum + r.subtreeSum + node.data;
		sp.maxSumTillNow = Math.max(sp.isBST ? sp.subtreeSum : Integer.MIN_VALUE,
				Math.max(l.maxSumTillNow, r.maxSumTillNow));

		return sp;
	}

}