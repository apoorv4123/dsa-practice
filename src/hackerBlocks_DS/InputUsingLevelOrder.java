package hackerBlocks_DS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class InputUsingLevelOrder {

	Scanner scn = new Scanner(System.in);

	public class Node {
		Node left;
		int data;
		Node right;

		public Node(int data) {
			this.data = data;
		}
	}

	private Node root;

	public InputUsingLevelOrder() {

		Queue<Node> q = new LinkedList<>();

		int rootdata = scn.nextInt();

		if (rootdata == -1) {
			return;
		}

		root = new Node(rootdata);
		q.add(root);

		while (!q.isEmpty()) {

			Node pn = q.remove();

			int ld = scn.nextInt();

			if (ld != -1) {
				Node ln = new Node(ld);
				pn.left = ln;
				q.add(ln);
			}

			int rd = scn.nextInt();

			if (rd != -1) {
				Node rn = new Node(rd);
				pn.right = rn;
				q.add(rn);
			}

		}

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

		// Self work
		String str = "";

		if (node.left == null)
			str += ".";
		else
			str += node.left.data;

		str += "->" + node.data + "<-";

		if (node.right == null)
			str += ".";
		else
			str += node.right.data;

		System.out.println(str);

		// Smaller problems
		display(node.left);
		display(node.right);

	}

	public static void main(String[] args) {

		InputUsingLevelOrder tree = new InputUsingLevelOrder();

		tree.display();

	}

}
