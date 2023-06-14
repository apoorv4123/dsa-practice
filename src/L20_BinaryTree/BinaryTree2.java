package L20_BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BinaryTree2 {

	Scanner s = new Scanner(System.in);

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public BinaryTree2() {
		this.root = takeInput(null, false);
	}

	private Node takeInput(Node parent, boolean ilc) {

		if (parent == null) {
			System.out.println("Enter the data for root node : ");
		} else {
			if (ilc) {
				System.out.println("Enter the data for left child of " + parent.data + " :");
			} else {
				System.out.println("Enter the data for right child of " + parent.data + " :");
			}
		}

		int item = s.nextInt();

		Node nn = new Node();

		nn.data = item;

		System.out.println("If " + nn.data + " has left child?");
		boolean hlc = s.nextBoolean();
		if (hlc) {
			nn.left = takeInput(nn, true);
		}

		System.out.println("If " + nn.data + " has right child?");
		boolean hrc = s.nextBoolean();
		if (hrc) {
			nn.right = takeInput(nn, false);
		}

		return nn;

	}

	public void display() {
		display(this.root);
	}

	private void display(Node node) {

		if (node == null) {
			return;
		}

		String str = "";
		if (node.left != null) {
			str += node.left.data;
		} else {
			str += ";";
		}
		str += " -> " + node.data + " <- ";
		if (node.right != null) {
			str += node.right.data;
		} else {
			str += ";";
		}
		System.out.println(str);
		display(node.left);
		display(node.right);

	}

	public int size() {
		return size(this.root);
	}

	private int size(Node node) {
		if (node == null) {
			return 0;
		}
		return size(node.left) + size(node.right) + 1;
	}

	public int max() {
		return max(this.root);
	}

	private int max(Node node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}
		return Math.max(node.data, Math.max(max(node.left), max(node.right)));
	}

	public boolean find(int val) {
		return find(this.root, val);
	}

	private boolean find(Node node, int val) {

		if (node == null) {
			return false;
		}

		return node.data == val || find(node.left, val) || find(node.right, val);
	}

	public int height() {
		return height(this.root);
	}

	private int height(Node node) {
		if (node == null) {
			return -1;
		}
		return Math.max(height(node.left), height(node.right)) + 1;
	}

	public boolean isBalanced() {
//		return isBalanced(this.root);
		return isBalanced2(this.root).isBal;
	}

	private boolean isBalanced(Node node) {

		if (node == null) {
			return true;
		}

		int hlst = height(node.left);
		int hrst = height(node.right);

		int bf = hlst - hrst;

		return (bf == 1 || bf == -1 || bf == 0) && isBalanced(node.left) && isBalanced(node.right);

	}

	private class BPair {
		int ht = -1;
		boolean isBal = true;
	}

	private BPair isBalanced2(Node node) {

		if (node == null) {
			return new BPair();
		}

		BPair lp = isBalanced2(node.left);
		BPair rp = isBalanced2(node.right);

		int cbf = lp.ht - rp.ht;

		BPair cbp = new BPair();
		cbp.isBal = lp.isBal && rp.isBal && (cbf == 0 || cbf == 1 || cbf == -1);
		cbp.ht = Math.max(lp.ht, rp.ht) + 1;

		return cbp;
	}

	public void preOrder() {
		preOrder(this.root);
	}

	private void preOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	public void postOrder() {
		postOrder(this.root);
	}

	private void postOrder(Node node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data + " ");
	}

	public void inOrder() {
		inOrder(this.root);
	}

	private void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.data + " ");
		inOrder(node.right);
	}

	public List<Integer> preorderIterative() {
		return preorderIterative(this.root);
	}

	private List<Integer> preorderIterative(Node root) {

		if (root == null) {
			return new ArrayList<>();
		}

		Stack<Node> stack = new Stack<>();
		List<Integer> list = new ArrayList<Integer>();
		stack.push(this.root);

		while (!stack.isEmpty()) {

			Node rn = stack.pop();
			list.add(rn.data);
			if (rn.right != null) {
				stack.push(rn.right);
			}
			if (rn.left != null) {
				stack.push(rn.left);
			}
		}
		return list;
	}

	private class Pair {
		Node node;
		boolean selfdone;
		boolean leftdone;
		boolean rightdone;
	}

	public List<Integer> postorderIterative() {
		return postorderIterative(this.root);
	}

	private List<Integer> postorderIterative(Node root) {

		Stack<Pair> stack = new Stack<>();
		List<Integer> list = new ArrayList<Integer>();

		Pair np = new Pair();
		np.node = this.root;
		stack.push(np);

		while (!stack.isEmpty()) {

			Pair tp = stack.peek();
			if (tp.leftdone == false) {
				Pair lp = new Pair();
				lp.node = tp.node.left;
				tp.leftdone = true;
				stack.push(lp);
			} else if (tp.rightdone == false) {
				Pair rp = new Pair();
				rp.node = tp.node.right;
				tp.rightdone = true;
				stack.push(rp);
			} else if (tp.selfdone == false) {
				list.add(tp.node.data);
				tp.selfdone = true;
			} else {
				stack.pop();
			}
		}
		return list;
	}

	public List<Integer> inorderIterative() {
		return inorderIterative(this.root);
	}

	private List<Integer> inorderIterative(Node root) {

		if (root == null) {
			return new ArrayList<>();
		}

		Stack<Pair> stack = new Stack<>();

		List<Integer> list = new ArrayList<Integer>();

		Pair np = new Pair();
		np.node = this.root;
		stack.push(np);

		while (!stack.isEmpty()) {

			Pair tp = stack.peek();

			if (tp.node == null) {
				stack.pop();
				continue;
			}

			if (tp.leftdone == false) {
				Pair lp = new Pair();
				lp.node = tp.node.left;
				stack.push(lp);
				tp.leftdone = true;
			} else if (tp.selfdone == false) {
				list.add(tp.node.data);
				tp.selfdone = true;
			} else if (tp.rightdone == false) {
				Pair rp = new Pair();
				rp.node = tp.node.right;
				stack.push(rp);
				tp.rightdone = true;
			} else {
				stack.pop();
			}

		}
		return list;
	}

	public List<List<Integer>> zigzaglevelorder() {
		List<List<Integer>> sol = new ArrayList<List<Integer>>();
		zigZagLevelOrder(root, sol);
		return sol;
	}

	public void zigZagLevelOrder(Node root, List<List<Integer>> list) {

		LinkedList<Node> pq = new LinkedList<>();
		LinkedList<Node> hq = new LinkedList<>();

		List<Integer> l = new ArrayList<Integer>();

		int count = 0;

		pq.addLast(root);

		while (!pq.isEmpty()) {

			if (count % 2 == 0) {
				while (!pq.isEmpty()) {
					Node rn = pq.removeFirst();
					l.add(rn.data);
					if (rn.left != null)
						hq.addLast(rn.left);
					if (rn.right != null)
						hq.addLast(rn.right);
				}
			} else {
				while (!pq.isEmpty()) {
					Node rn = pq.removeLast();
					l.add(rn.data);
					if (rn.right != null)
						hq.addFirst(rn.right);
					if (rn.left != null)
						hq.addFirst(rn.left);
				}
			}
			if (pq.isEmpty()) {
				pq = hq;
				hq = new LinkedList<>();
				list.add(l);
				l = new ArrayList<>();
				count++;
			}

		}
	}

}
