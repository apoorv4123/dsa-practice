package hackerBlocks_DS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BTQuestions {

	static Scanner s = new Scanner(System.in);

	private class BinaryTree {

		private class Node {
			int data;
			Node left = null;
			Node right = null;
		}

		private Node root;

		public BinaryTree() {
			root = construct(null, false);
//			root = construct();
//			root = c();
		}

		private Node c() {
			Queue<Node> q = new LinkedList<>();
			int item = s.nextInt();
			Node fn = new Node();
			fn.data = item;
			q.add(fn);
			while (!q.isEmpty()) {
				Node remn = q.remove();
				int lc = s.nextInt();
				int rc = s.nextInt();
				if (lc != -1) {
					Node ln = new Node();
					ln.data = lc;
					remn.left = ln;
					q.add(ln);
				}
				if (rc != -1) {
					Node rn = new Node();
					rn.data = rc;
					remn.right = rn;
					q.add(rn);
				}
			}
			return fn;
		}

		private Node construct() {

			Queue<Node> queue = new LinkedList<>();

			Node fn = new Node();
			int item = s.nextInt();
			fn.data = item;
			queue.add(fn);

			while (queue.size() != 0) {

				Node remn = queue.remove();

				int ld = s.nextInt();
				int rd = s.nextInt();

				if (ld != -1) {
					Node ln = new Node();
					ln.data = ld;
					remn.left = ln;
					queue.add(ln);
				} else {
					remn.left = null;
				}

				if (rd != -1) {
					Node rn = new Node();
					rn.data = rd;
					remn.right = rn;
					queue.add(rn);
				} else {
					remn.right = null;
				}

			}

			return fn;
		}

		private Node construct(Node parent, boolean ilc) {

			int item = s.nextInt();
			Node nn = new Node();
			nn.data = item;
			boolean hlc = s.nextBoolean();
			if (hlc) {
				nn.left = construct(nn, true);
			}
			boolean hrc = s.nextBoolean();
			if (hrc) {
				nn.right = construct(nn, false);
			}

			return nn;

		}

		public void display() {
			display(root);
		}

		private void display(Node node) {

			if (node == null) {
				return;
			}

			String str = "";
			if (node.left != null) {
				str += node.left.data;
			} else {
				str += ".";
			}
			str += "->" + node.data + "<-";
			if (node.right != null) {
				str += node.right.data;
			} else {
				str += ".";
			}
			System.out.println(str);
			display(node.left);
			display(node.right);
		}

		public void leftview() {
			leftview(root, 0);
			System.out.println();
		}

		int lmax = Integer.MIN_VALUE;

		private void leftview(Node node, int level) {

			if (node == null) {
				return;
			}

			if (level > lmax) {
				lmax = level;
				System.out.print(node.data + " ");
			}
			leftview(node.left, level + 1);
			leftview(node.right, level + 1);

		}

		public void rootToLeaf(int target) {
//			System.out.println(target);
			rootToLeaf(root, target, root.data, "" + root.data + " ");

		}

		private boolean rootToLeaf(Node node, int target, int sum, String ans) {

			if (sum == target) {
				System.out.println(ans);
				return false;
			}

			if (node.left == null && node.right == null) {
				return true;
			}

			if (sum > target) {
				return true;
			}

			// if ans has not been found in lst, only then traverse rst
			boolean rc = true;
			rc = rootToLeaf(node.left, target, sum + node.left.data, ans + node.left.data + " ");

			if (rc)
				rootToLeaf(node.right, target, sum + node.right.data, ans + node.right.data + " ");

			return rc;
		}

		// level wise nodes in an arraylist
		public void levelWiseAL() {
			List<List<Integer>> ans = new ArrayList<>();
			levelWiseAL(root, ans);
			System.out.println(ans);
		}

		private void levelWiseAL(Node node, List<List<Integer>> ans) {

			LinkedList<Node> pq = new LinkedList<>();
			LinkedList<Node> hq = new LinkedList<>();
			pq.add(node);
			ArrayList<Integer> al = new ArrayList<>();
			while (!pq.isEmpty()) {

				Node rn = pq.removeFirst();
				al.add(rn.data);

				if (rn.left != null) {
					hq.addLast(rn.left);
				}
				if (rn.right != null) {
					hq.addLast(rn.right);
				}

				if (pq.isEmpty()) {

					ans.add(al);
					al = new ArrayList<Integer>();
					pq = hq;
					hq = new LinkedList<>();
					continue;

				}

			}
		}

		private int noOfElements(Node node) {

			if (node == null) {
				return 0;
			}

			int lst = noOfElements(node.left);
			int rst = noOfElements(node.right);
			return lst + rst + 1;

		}

		public boolean structurallyIdentical(BinaryTree bt2) {
			return structurallyIdentical(this.root, bt2.root);
		}

		private boolean structurallyIdentical(Node node1, Node node2) {

			if (node1 == null && node2 == null) {
				return true;
			}

			if ((node1 == null && node2 != null) || (node1 != null && node2 == null)) {
				return false;
			}

			int nlst1 = noOfElements(node1.left);
			int nrst1 = noOfElements(node1.right);
			int nlst2 = noOfElements(node2.left);
			int nrst2 = noOfElements(node2.right);

			boolean silst = structurallyIdentical(node1.left, node2.left);
			boolean sirst = structurallyIdentical(node1.right, node2.right);

			if (nlst1 == nlst2 && nrst1 == nrst2 && silst && sirst) {
				return true;
			}

			return false;
		}

		private class VOPair {
			Node node;
			int vlevel;

			private VOPair(Node node, int vlevel) {
				this.node = node;
				this.vlevel = vlevel;
			}
		}

		public void verticalOrderdisplay() {

			HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

			Queue<VOPair> q = new LinkedList<>();

			q.add(new VOPair(root, 0));

			while (!q.isEmpty()) {

				VOPair rp = q.remove();

				if (!map.containsKey(rp.vlevel)) {
					map.put(rp.vlevel, new ArrayList<Integer>());
				}

				map.get(rp.vlevel).add(rp.node.data);

				if (rp.node.left != null) {
					q.add(new VOPair(rp.node.left, rp.vlevel - 1));
				}
				if (rp.node.right != null) {
					q.add(new VOPair(rp.node.right, rp.vlevel + 1));
				}
			}
			ArrayList<Integer> al = new ArrayList<>(map.keySet());

			Collections.sort(al);

			for (int key : al) {
				for (int i = 0; i < map.get(key).size(); i++) {
					System.out.print(map.get(key).get(i) + " ");
				}
				System.out.println();
			}

		}

		public void TopView() {
			HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
			Queue<VOPair> q = new LinkedList<>();
			q.add(new VOPair(root, 0));
			while (!q.isEmpty()) {

				VOPair rp = q.remove();

				if (!map.containsKey(rp.vlevel)) {
					map.put(rp.vlevel, new ArrayList<Integer>());
				}

				map.get(rp.vlevel).add(rp.node.data);

				if (rp.node.left != null) {
					q.add(new VOPair(rp.node.left, rp.vlevel - 1));
				}
				if (rp.node.right != null) {
					q.add(new VOPair(rp.node.right, rp.vlevel + 1));
				}

			}

			ArrayList<Integer> al = new ArrayList<>(map.keySet());

			Collections.sort(al);

			for (int key : al) {
				System.out.print(map.get(key).get(0) + " ");
			}
		}

		public void printAllLeafNodes() {

			printAllLeafNodes(root);

		}

		private void printAllLeafNodes(Node node) {

			if (node == null) {
				return;
			}

			if (node.left == null && node.right == null) {
				System.out.print(node.data + " ");
				return;
			}

			printAllLeafNodes(node.left);
			printAllLeafNodes(node.right);
		}

		private class LOPair {
			Node node;
			int level;

			private LOPair(Node node, int level) {
				this.node = node;
				this.level = level;
			}
		}

		public void levelOrderZigZag() {

			HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

			Queue<LOPair> q = new LinkedList<>();

			q.add(new LOPair(root, 0));

			while (!q.isEmpty()) {
				LOPair remp = q.remove();
				if (!map.containsKey(remp.level)) {
					map.put(remp.level, new ArrayList<Integer>());
				}
				map.get(remp.level).add(remp.node.data);
				if (remp.node.left != null) {
					q.add(new LOPair(remp.node.left, remp.level + 1));
				}
				if (remp.node.right != null) {
					q.add(new LOPair(remp.node.right, remp.level + 1));
				}
			}

			ArrayList<Integer> al = new ArrayList<>(map.keySet());

			for (int key : al) {
				if (key % 2 == 0) {
					for (int i = 0; i < map.get(key).size(); i++) {
						System.out.print(map.get(key).get(i) + " ");
					}
				} else {
					for (int i = map.get(key).size() - 1; i >= 0; i--) {
						System.out.print(map.get(key).get(i) + " ");
					}
				}
			}
		}

		public void removeTheLeaves() {
			removeTheLeaves(null, this.root, false);
		}

		private void removeTheLeaves(Node parent, Node child, boolean ilc) {

			if (child == null) {
				return;
			}

			if (ilc) {
				if (child.left == null && child.right == null && parent != null) {
					parent.left = null;
				} else {
					removeTheLeaves(child, child.left, true);
					removeTheLeaves(child, child.right, false);
				}
			}

			else {
				if (child.left == null && child.right == null && parent != null) {
					parent.right = null;
				} else {
					removeTheLeaves(child, child.left, true);
					removeTheLeaves(child, child.right, false);
				}
			}

		}

		public boolean isBalanced() {
			return this.isBalanced(this.root).isBalanced;
		}

		private BalancedPair isBalanced(Node node) {

			if (node == null) {
				BalancedPair bp = new BalancedPair();
				bp.height = 0;
				bp.isBalanced = true;
				return bp;
			}

			BalancedPair sp = new BalancedPair();

			BalancedPair lp = isBalanced(node.left);
			BalancedPair rp = isBalanced(node.right);

			sp.height = Math.max(lp.height, rp.height) + 1;
			int t = lp.height - rp.height;
			sp.isBalanced = lp.isBalanced && rp.isBalanced && (t == -1 || t == 0 || t == 1);

			return sp;
		}

		private class BalancedPair {
			int height;
			boolean isBalanced;
		}

	}

	public static void main(String[] args) {

		BTQuestions obj = new BTQuestions();
		BinaryTree bt = obj.new BinaryTree();
//		int target = s.nextInt();

//		bt.display();
//		bt.leftview();
//		bt.rootToLeaf(target);
//		bt.levelWiseAL();

//		BinaryTree bt1 = obj.new BinaryTree();
//		BinaryTree bt2 = obj.new BinaryTree();
//		System.out.println(bt1.structurallyIdentical(bt2));

//		bt.verticalOrderdisplay();
//		bt.TopView();
//		System.out.println();

//		bt.printAllLeafNodes();
//		System.out.println();

//		bt.levelOrderZigZag();
//		System.out.println();

		bt.removeTheLeaves();
		bt.display();

	}
}