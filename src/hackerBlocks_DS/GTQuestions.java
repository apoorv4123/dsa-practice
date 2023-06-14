package hackerBlocks_DS;

import java.util.ArrayList;
import java.util.Scanner;

public class GTQuestions {

	static Scanner scn = new Scanner(System.in);

	private class GenericTree {
		private class Node {
			int data;
			ArrayList<Node> children = new ArrayList<>();
		}

		private Node root;

		public GenericTree() {
			this.root = this.takeInput(scn, null, -1);
		}

		private Node takeInput(Scanner scn, Node parent, int i) {

			int childData = scn.nextInt();

			int numGC = scn.nextInt();

			Node child = new Node();
			child.data = childData;

			for (int j = 0; j < numGC; j++) {
				Node gc = this.takeInput(scn, child, j);
				child.children.add(gc);
			}

			return child;
		}

		public void display() {
			System.out.println("--------------------");
			display(root);
			System.out.println("--------------------");
		}

		private void display(Node node) {

//			System.out.print(node.data + "->");
//			for (int i = 0; i < node.children.size(); i++) {
//				System.out.print(node.children.get(i).data + " ");
//			}
//			System.out.println(".");
//			for (int i = 0; i < node.children.size(); i++) {
//				display(node.children.get(i));
//			}

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

		public boolean structurallyIdentical(GenericTree other) {
			return this.structurallyIdentical(this.root, other.root);
		}

		private boolean structurallyIdentical(Node node1, Node node2) {

			int noc1 = node1.children.size();
			int noc2 = node2.children.size();

			if (noc1 != noc2) {
				return false;
			}

			boolean ans = true;
			for (int i = 0; i < noc1; i++) {
				ans = ans && structurallyIdentical(node1.children.get(i), node2.children.get(i));
			}

			return ans;

		}

		public int sumAtK(int k) {
			return sumAtK(root, k, 0);
		}

		private int sumAtK(Node node, int k, int clevel) {

			if (clevel == k) {
				return node.data;
			} else {
				int sum = 0;
				for (Node child : node.children) {
					int s = sumAtK(child, k, clevel + 1);
					sum += s;
				}
				return sum;
			}
		}
	}

	public static void main(String[] args) {

		GTQuestions m = new GTQuestions();

		GenericTree gt1 = m.new GenericTree();
//		GenericTree gt2 = m.new GenericTree();
//		System.out.println(gt1.structurallyIdentical(gt2));

//		gt1.display();
		int k = scn.nextInt();
		System.out.println(gt1.sumAtK(k));

	}

}