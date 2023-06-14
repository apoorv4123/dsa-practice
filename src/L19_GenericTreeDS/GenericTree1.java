package L19_GenericTreeDS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GenericTree1 {

	Scanner s = new Scanner(System.in);

	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;

	public GenericTree1() {
		root = construct(null, -1);
	}

	private Node construct(Node parent, int ith) {

		if (parent == null) {
			System.out.println("Enter the value of root node:");
		} else {
			System.out.println("Enter the value of " + ith + " child of " + parent.data + " ?");
		}

		int item = s.nextInt();

		Node nn = new Node();

		nn.data = item;

		System.out.println("Enter the number of children of " + item + " ?");

		int noc = s.nextInt();

		for (int i = 0; i < noc; i++) {
			nn.children.add(construct(nn, i));
		}

		return nn;
	}

	public void display() {
		display(this.root);
	}

	private void display(Node node) {

		String str = "";
		str += node.data + " -> ";

		for (Node child : node.children) {
			str += child.data;
		}

		System.out.println(str + " .");

		for (Node child : node.children) {
			display(child);
		}

	}

	public int size() {
		return size(this.root);
	}

	private int size(Node root) {

//		if(root.children.size() == 0) {
//			return 1;
//		}

		int count = 0;

		for (Node child : root.children) {
			count += size(child);
		}

		return count + 1;
	}

	public int max() {
		return max(this.root);
	}

	private int max(Node root) {

		int ans = root.data;

		for (Node child : root.children) {
			ans = Math.max(ans, max(child));
		}

		return ans;
	}

	public int height() {
		return height(this.root);
	}

	private int height(Node root) {

		int height = -1;

		for (Node child : root.children) {
			height = Math.max(height, height(child));
		}

		return height + 1;
	}

	public boolean find(int val) {
		return find(this.root, val);
	}

	private boolean find(Node root, int val) {

		if (root.data == val) {
			return true;
		}

		boolean ans = false;

		for (Node child : root.children) {
			ans = ans || find(child, val);
		}

		return ans;
	}

	public void mirror() {
		mirror(this.root);
	}

	private void mirror(Node root) {

		for (Node child : root.children) {
			mirror(child);
		}

		Collections.reverse(root.children);
	}

	public void printAtLevel(int tlevel) {
		printAtLevel(this.root, 0, tlevel);
	}

	private void printAtLevel(Node root, int clevel, int tlevel) {

		if (clevel == tlevel) {
			System.out.print(root.data + " ");
			return;
		}

		for (Node child : root.children) {
			printAtLevel(child, clevel + 1, tlevel);
		}

	}
	
	public void linearize(int tlevel) {
		linearize(this.root, 0, tlevel);
	}

	private void linearize(Node root, int clevel, int tlevel) {

		if (clevel == tlevel) {
			System.out.print(root.data + " ");
			return;
		}

		for (Node child : root.children) {
			printAtLevel(child, clevel + 1, tlevel);
		}

	}
	
	
	
	

}
