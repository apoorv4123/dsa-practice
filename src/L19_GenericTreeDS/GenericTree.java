package L19_GenericTreeDS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

//import L16_StackQueue.DynamicQueue;

public class GenericTree {

	Scanner scn = new Scanner(System.in);

	private class Node {

		int data;
		ArrayList<Node> children = new ArrayList<>();

	}

	private Node root;

	public GenericTree() {
		root = construct(null, -1);
	}

	private Node construct(Node parent, int ith) {

		// prompt
		if (parent == null) {
			// to avoid null pointer exception
			System.out.println("Enter the data for parent node ?");
		} else {
			System.out.println("Enter the data for " + ith + " child of " + parent.data + " ?");
		}
		// take input of data
		int item = scn.nextInt();

		// create a new node
		Node nn = new Node();

		// update the data
		nn.data = item;

		// prompt
		System.out.println("Enter the number of chilfren for " + nn.data + " ?");

		// take input for children
		int noc = scn.nextInt();

		// loop for creating children
		for (int i = 0; i < noc; i++) {
			Node child = construct(nn, i);
			nn.children.add(child);
		}

		return nn;

	}

	public void display() {
		System.out.println("--------------------");
		display(root);
		System.out.println("--------------------");
	}

	private void display(Node node) {

//		System.out.print(node.data + "->");
//		for (int i = 0; i < node.children.size(); i++) {
//			System.out.print(node.children.get(i).data + " ");
//		}
//		System.out.println(".");
//		for (int i = 0; i < node.children.size(); i++) {
//			display(node.children.get(i));
//		}

		// SW
		String str = node.data + "->";

		for (Node child : node.children) {
			str += child.data + " ";
		}

		str += ".";
		System.out.println(str);

		// SP
		for (Node child : node.children) {
			display(child);
		}
	}

	public int size() {
		return size(root);
	}

	private int size(Node node) {

		int ts = 0;

		for (Node child : node.children) {
			int cs = size(child);
			ts += cs;
		}

		return ts + 1;
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {

		int tm = node.data;

		for (Node child : node.children) {
			int cm = max(child);
			tm = Math.max(tm, cm);
		}

		return tm;
	}

	public int height() {
		return height(root);
	}

	private int height(Node node) {

		int th = -1;

		for (Node child : node.children) {
			int ch = height(child);
			th = Math.max(ch, th);
		}

		return th + 1;

	}

	public boolean find(int item) {
		return find(root, item);
	}

	private boolean find(Node node, int item) {

		if (node.data == item) {
			return true;
		}

//		boolean tf = false;
		for (Node child : node.children) {
//			boolean cf = find(child, item);
//			tf = tf || cf;

			if (find(child, item)) {
				return true;
			}
		}

		return false;
	}

	public void mirror() {
		mirror(root);
	}

	private void mirror(Node node) {

//		ArrayList<Node> nchildren=new ArrayList<>();
//		
//		for(Node child:node.children) {
//			mirror(child);
//			nchildren.add(0, child);
////			mirror(child);
//		}
//		
//		node.children=nchildren;

		// .......OR.......

		for (Node child : node.children) {
			mirror(child);
		}

		// self work: ArrayList reverse
//		int i = 0;
//		int j = node.children.size() - 1;
//
//		while (i < j) {
//
//			Node in = node.children.get(i);
//			Node jn = node.children.get(j);
//
//			node.children.set(i, jn);
//			node.children.set(j, in);
//
//			i++;
//			j--;
//
//		}

		Collections.reverse(node.children);

	}

	public void printAtLevel(int level) {

		printAtLevel(root, level, 0);
		System.out.println();

	}

	private void printAtLevel(Node node, int level, int clevel) {

		if (clevel == level) {
			System.out.print(node.data + " ");
			return;// if fount target level,will return an won't go to its chilren
		}

		for (Node child : node.children) {

			printAtLevel(child, level, clevel + 1);

		}

	}

	public void linearize() {
		linearize(root);
	}

	private void linearize(Node node) {

		for (Node child : node.children) {
			linearize(child);
		}

		// Self work

		while (node.children.size() > 1) {

			Node temp = node.children.remove(1); // remove subtree at ith index an store it in temp
			Node tail = leafNode(node.children.get(0)); // obtain leaf node of subtree at 0th index
			tail.children.add(temp);

		}

	}

	private Node leafNode(Node node) {

		if (node.children.size() == 0) {
			return node;
		}
		return leafNode(node.children.get(0));

	}

	public void display2() {
		display2(root);
	}

	private void display2(Node node) {

		System.out.println("Hi " + node.data);

		for (Node child : node.children) {
			System.out.println("Going towards " + child.data);
			display2(child);
			System.out.println("Coming from " + child.data);
		}

		System.out.println("Bye " + node.data);

	}

	public void preorder() {
		preorder(root);
	}

	private void preorder(Node node) {

		System.out.println(node.data);

		for (Node child : node.children) {
			preorder(child);
		}

	}

	public void postorder() {
		postorder(root);
	}

	private void postorder(Node node) {

		for (Node child : node.children) {
			postorder(child);
		}

		System.out.println(node.data);

	}

	public void levelorder() {

		LinkedList<Node> queue = new LinkedList<>();

		// add root node and start the work
		queue.addLast(root);

		// work
		while (!queue.isEmpty()) {

			// remove first node
			Node rn = queue.removeFirst();

			// print
			System.out.print(rn.data + " ");

			// children
			for (Node child : rn.children) {
				queue.addLast(child);
			}
		}

		System.out.println();

	}

	public void levelOrderLinewiseApp1() {

		LinkedList<Node> queue = new LinkedList<>();

		// add root node and an null to start the work
		queue.addLast(root);
		queue.addLast(null);

		// work till queue is not empty
		while (!queue.isEmpty()) {

			// remove first node
			Node rn = queue.removeFirst();

			if (rn == null) {
				System.out.println();

				if (queue.isEmpty()) { // for last null
					break;
				}

				queue.addLast(null);
				continue; // if encounter a null, perform the needful ops and
							// continue to avoid null pointer exception
			}

			// print
			System.out.print(rn.data + " ");

			// children
			for (Node child : rn.children) {
				queue.addLast(child);
			}
		}

		System.out.println();

	}

	public void levelOrderLinewiseApp2() {

		LinkedList<Node> pq = new LinkedList<>();// primary queue
		LinkedList<Node> hq = new LinkedList<>();// helper queue

		pq.addLast(root);

		while (!pq.isEmpty()) {

			// remove first node
			Node rn = pq.removeFirst();

			// print
			System.out.print(rn.data + " ");

			// children
			for (Node child : rn.children) {
				hq.addLast(child);
			}

			// if pq gets empty
			if (pq.isEmpty()) {

				System.out.println();
				pq = hq;
				hq = new LinkedList<>();
				// or you may even swap hq & pq

			}
		}

		System.out.println();

	}

	public void zigZag() {

		LinkedList<Node> p = new LinkedList<>();
		LinkedList<Node> h = new LinkedList<>();

		int count = 0;

		p.addFirst(this.root);

		while (!p.isEmpty()) {

			Node rn = p.removeFirst();

			System.out.print(rn.data + " ");

			if (count % 2 == 0) {

				for (Node child : rn.children) {
					h.addFirst(child);
				}

			} else {

				for (int i = rn.children.size() - 1; i >= 0; i--) {
					h.addFirst(rn.children.get(i));
				}

			}

			if (p.isEmpty()) {
				System.out.println();
				count++;
				p = h;
				h = new LinkedList<>();
			}

		}

	}

	// HACKERBLOCKS
	public void depthvalue() {
		depthvalue(root, 0);
	}

	public void depthvalue(Node node, int depth) {

		if (node.children.size() == 0) {
			node.data = depth;
			return;
		}

		for (Node child : node.children) {
			node.data = depth;
			depthvalue(child, depth + 1);
		}

	}

	public int countLeafNodes() {
		return this.countLeafNodes(this.root);
	}

	private int countLeafNodes(Node node) {

		if (node.children.size() == 0) {
			return 1;
		}
//		if (node == null) {
//			return 0;
//		}
		int count = 0;
		for (Node child : node.children) {
			count += countLeafNodes(child);
		}
		return count;
	}

	public int sumOfNodes() {
		return this.sumOfNodes(this.root);
	}

	private int sumOfNodes(Node node) {

		int sum = 0;
		for (Node child : node.children) {
			sum += sumOfNodes(child);
		}
		sum += node.data;
		return sum;
	}

}