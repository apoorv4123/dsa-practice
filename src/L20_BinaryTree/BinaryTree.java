package L20_BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BinaryTree {

	Scanner scn = new Scanner(System.in);

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public BinaryTree() {
		root = takeInput(null, false); // true can also be passed
	}

	private Node takeInput(Node parent, boolean ilc) {

		// prompt
		if (parent == null) {
			System.out.println("Enter the data for root node ?");

		} else {

			if (ilc) {
				System.out.println("Enter the data for left child of " + parent.data);
			} else {
				System.out.println("Enter the data for right child of " + parent.data);
			}
		}

		// take input for data
		int item = scn.nextInt();

		// create new node
		Node nn = new Node();

		// update the data of node
		nn.data = item;

		// ask user if node has left child
		System.out.println("If " + nn.data + " has left child ?");

		// take input either true or false
		boolean hlc = scn.nextBoolean();

		// if left child exists then create it
		if (hlc) {
			nn.left = takeInput(nn, true);
		}

		// ask user if node has right child
		System.out.println("If " + nn.data + " has right child ?");

		// take input either true or false
		boolean hrc = scn.nextBoolean();

		// if right child exists then create it
		if (hrc) {
			nn.right = takeInput(nn, false);
		}

		// node is ready, so return it
		return nn;
	}

	public BinaryTree(int[] pre, int[] in) {
		root = construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	private Node construct(int[] pre, int plo, int phi, int[] in, int inlo, int inhi) {

		if (plo > phi || inlo > inhi) {
			return null;
		}

		// create a new node with pre[plo]
		Node nn = new Node();
		nn.data = pre[plo];

		// search for pre[plo] in in-order
		int si = -1;
//		int nel = 0;
		for (int i = inlo; i <= inhi; i++) {
//			nel++; no
			if (in[i] == pre[plo]) {
				si = i;
				break;
			}
//			nel++;
		}
		int nel = 0;
		for (int i = inlo; i < si; i++) {
			nel++;
		}

		// left and right child call
		nn.left = construct(pre, plo + 1, plo + nel, in, inlo, si - 1);
		nn.right = construct(pre, plo + nel + 1, phi, in, si + 1, inhi);

		return nn;
	}

	public void display() {
		System.out.println("---------------");
		display(root);
		System.out.println("---------------");
	}

	private void display(Node node) {
//		if (node.left != null) {
//			System.out.print(node.left.data);
//		} else {
//			System.out.print(".");
//		}
//
//		System.out.print(" -> " + node.data + " <- ");
//
//		if (node.right != null) {
//			System.out.println(node.right.data);
//		} else {
//			System.out.println(" .");
//		}
//
//		if (node.left != null)
//			display(node.left);
//		if (node.right != null)
//			display(node.right);

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

	public int size() {
		return size(root);
	}

	private int size(Node node) {

//		if (node == null) {
//			return 0;
//		}
//
//		int tc = 0;
//
//		tc += size(node.left) + size(node.right);
//
//		return tc + 1;

		if (node == null) {
			return 0;
		}

		int ls = size(node.left);
		int rs = size(node.right);

		return ls + rs + 1;

	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {

		if (node == null) {
			return Integer.MIN_VALUE;
		}

		int lmax = max(node.left);
		int rmax = max(node.right);

		return Math.max(node.data, Math.max(lmax, rmax));

	}

	public boolean find(int item) {
		return find(root, item);
	}

	private boolean find(Node node, int item) {

//		if (node == null) {
//			return false;
//		}
//
//		if (node.data == item) {
//			return true;
//		}
//
//		if (find(node.left, item) || find(node.right, item)) {
//			return true;
//		}
//
//		return false;

		if (node == null) {
			return false;
		}

		if (node.data == item) {
			return true;
		}

		boolean lf = find(node.left, item);
		boolean rf = find(node.right, item);

		return lf || rf;
	}

	public int height() {
		return height(root);
	}

	private int height(Node node) {

		if (node == null) {
			return -1;
		}

		int lht = height(node.left);
		int rht = height(node.right);

		return Math.max(lht, rht) + 1;
	}

	int diameterAns = Integer.MIN_VALUE;

	public int diameter() {

		// Approach 1
//		diameterapp1(root);
//		return diameterAns;

		// Approach 2
//		return diameterapp2(root);

		// Approach 3
		return diameterapp3(root).dia;
	}

	private void diameterapp1(Node node) {

		if (node == null) {
			return;
		}

		// assuming present node to be root node of diameter
		int presentNodeRoot = height(node.left) + height(node.right) + 2;

		if (presentNodeRoot > diameterAns) {
			diameterAns = presentNodeRoot;
		}

		diameterapp1(node.left);
		diameterapp1(node.right);

	}

	private int diameterapp2(Node node) {

		if (node == null) {
			return 0;
		}

		// max distance b/w two subtrees may lie in left sub-tree : left ka diameter
		int ld = diameterapp2(node.left);

		// max distance b/w two subtrees may lie in right sub-tree : right ka diameter
		int rd = diameterapp2(node.right);

		// self node might be root node of diameter
		int sd = height(node.left) + height(node.right) + 2;

		return Math.max(sd, Math.max(ld, rd));

	}

	private class DiaPair {
		int dia = 0;// diameter
		int ht = -1;// height
	}

	private DiaPair diameterapp3(Node node) {

		if (node == null) {
			return new DiaPair();
		}

		DiaPair ldp = diameterapp3(node.left);
		DiaPair rdp = diameterapp3(node.right);

		DiaPair sdp = new DiaPair();

		int ld = ldp.dia;
		int rd = rdp.dia;
		int sd = ldp.ht + rdp.ht + 2;

		sdp.dia = Math.max(sd, Math.max(ld, rd));
		sdp.ht = Math.max(ldp.ht, rdp.ht) + 1;

		return sdp;

	}

	public boolean isBalanced() {

		// Approach 1
//		return isBalancedApp1(root);

		// Approach 2
		return isBalancedApp2(root).isBal;
	}

	private boolean isBalancedApp1(Node node) {

		if (node == null) {
			return true;
		}
		boolean lbal = isBalancedApp1(node.left);
		boolean rbal = isBalancedApp1(node.right);

		int bf = height(node.left) - height(node.right);

		if (lbal && rbal && bf >= -1 && bf <= 1) {
			return true;
		}
		return false;

	}

	private class BalPair {
		boolean isBal = true;
		int ht = -1;
	}

	private BalPair isBalancedApp2(Node node) {

		if (node == null) {
			return new BalPair();
		}

		BalPair lbp = isBalancedApp2(node.left);
		BalPair rbp = isBalancedApp2(node.right);

		BalPair sbp = new BalPair();

		boolean lbool = lbp.isBal;
		boolean rbool = rbp.isBal;

		int sbf = lbp.ht - rbp.ht;

		if (lbool && rbool && (sbf == 1 || sbf == 0 || sbf == -1)) {
			sbp.isBal = true;
		} else {
			sbp.isBal = false;
		}
		sbp.ht = Math.max(lbp.ht, rbp.ht) + 1;

		return sbp;

	}

	public boolean areFlipEquivalent(BinaryTree other) {
		return areFlipEquivalent(root, other.root);
	}

	private boolean areFlipEquivalent(Node node1, Node node2) {

		if (node1 == null && node2 == null) {
			return true;
		}

		if (node1 == null || node2 == null) {
			return false;
		}

		if (node1.data != node2.data) {
			return false;
		}

		boolean ll = areFlipEquivalent(node1.left, node2.left);
		boolean rr = areFlipEquivalent(node1.right, node2.right);
		boolean lr = areFlipEquivalent(node1.left, node2.right);
		boolean rl = areFlipEquivalent(node1.right, node2.left);

		return (ll && rr) || (lr && rl);
	}

	public void preorder() { // NLR
		preorder(root);
		System.out.println();
	}

	private void preorder(Node node) {

		if (node == null) {
			return;
		}

		// N
		System.out.print(node.data + " ");

		// L
		preorder(node.left);

		// R
		preorder(node.right);
	}

	public void postorder() { // LRN
		postorder(root);
		System.out.println();
	}

	private void postorder(Node node) {

		if (node == null) {
			return;
		}

		postorder(node.left);
		postorder(node.right);
		System.out.print(node.data + " ");

	}

	public void inorder() { // LNR
		inorder(root);
		System.out.println();
	}

	private void inorder(Node node) {

		if (node == null) {
			return;
		}

		inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);

	}

	private class Pair {
		Node node;
		boolean selfdone;
		boolean leftdone;
		boolean rightdone;
	}

	public void preorderIterative() {

		// create a stack
		Stack<Pair> stack = new Stack<>();

		// create starting pair
		Pair sp = new Pair();
		sp.node = root; // and by default, boolean values are initialise to false

		// push sp in stack
		stack.push(sp);

		// work till your stack is not empty
		while (!stack.isEmpty()) {

			// get topmost pair
			Pair tp = stack.peek();

			if (tp.node == null) {
				stack.pop();
				continue;
			}

			if (tp.selfdone == false) {
				System.out.print(tp.node.data + " ");
				tp.selfdone = true;
			} else if (tp.leftdone == false) {

				// make a new pair
				Pair np = new Pair();
				np.node = tp.node.left;

				// push the new pair into stack
				// if (np.node != null)
				stack.push(np);

				// put true in leftdone of tp
				tp.leftdone = true;

			} else if (tp.rightdone == false) {

				Pair np = new Pair();
				np.node = tp.node.right;

				// if (np.node!= null)
				stack.push(np);

				tp.rightdone = true;

			} else { // all are true

				stack.pop();

			}

		}
	}

	public int sumTree() {
		return sumTree(root);
	}

	private int sumTree(Node node) {

		if (node == null) {
			return 0;
		}
		return sumTree(node.left) + sumTree(node.right) + node.data;
	}

	public int maxSubtreeSum() {

		// Approach 1 : Using global variables
//		maxSubtreeSum1(root);
//		return maxsubtreesum;

		// Approach 2 : recursion is returning something (something -> maximum subtree
		// sum)
//		return maxSubtreeSum2(root);

		// Approach 3 : recursion will return a pair(multiple values) so that time
		// complexity is O(n)
		return maxSubtreeSum3(root).msts;
	}

	int maxsubtreesum = Integer.MIN_VALUE;

	private int maxSubtreeSum1(Node node) {

		if (node == null) {
			return 0;
		}

		// using void return type
//		int presentsubtreesum = sumTree(node.left) + sumTree(node.right) + node.data;
//		if (presentsubtreesum > maxsubtreesum) {
//			maxsubtreesum = presentsubtreesum;
//		}
//
//		maxSubtreeSum1(node.left);
//		maxSubtreeSum1(node.right);

		int ls = maxSubtreeSum1(node.left);
		int rs = maxSubtreeSum1(node.right);

		int nodeans = ls + rs + node.data;
		if (nodeans > maxsubtreesum) {
			maxsubtreesum = nodeans;
		}

		return nodeans;

	}

	private int maxSubtreeSum2(Node node) {

		if (node == null) {
			return Integer.MIN_VALUE;
		}

		int lmsts = maxSubtreeSum2(node.left); // left maximum subtree sum
		int rmsts = maxSubtreeSum2(node.right); // right maximum subtree sum

		int selfsum = sumTree(node.left) + sumTree(node.right) + node.data; // or simply selfsum=sumTree(node)

		return Math.max(selfsum, Math.max(lmsts, rmsts));
	}

	private class MaxSubtreeSumPair {

		int msts = Integer.MIN_VALUE; // Maximum subtree sum
		int sum = 0; // entire sum

	}

	private MaxSubtreeSumPair maxSubtreeSum3(Node node) {

		if (node == null) {
			return new MaxSubtreeSumPair();
		}

		MaxSubtreeSumPair lp = maxSubtreeSum3(node.left); // left pair
		MaxSubtreeSumPair rp = maxSubtreeSum3(node.right); // right pair

		MaxSubtreeSumPair sp = new MaxSubtreeSumPair(); // self pair

		int lmsts = lp.msts; // left maximum subtree sum
		int rmsts = rp.msts; // right maximum subtree sum

		sp.sum = lp.sum + rp.sum + node.data; // self node sum

		sp.msts = Math.max(sp.sum, Math.max(lmsts, rmsts));

		return sp;

	}

	private class BSTPair {
		boolean isBST = true;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
//		public int largestBSTSize;
//		public Object largestBSTRootNode;
	}

	public boolean isTreeBST() {
		return isTreeBST(root).isBST;
	}

	private BSTPair isTreeBST(Node node) {

		if (node == null) {
			return new BSTPair();
		}

		BSTPair lpair = isTreeBST(node.left);
		BSTPair rpair = isTreeBST(node.right);

		BSTPair spair = new BSTPair();

		spair.max = Math.max(node.data, Math.max(lpair.max, rpair.max));
		spair.min = Math.min(node.data, Math.min(lpair.min, rpair.min));

		if (node.data > lpair.max && node.data < rpair.min && lpair.isBST && rpair.isBST) {
			spair.isBST = true;
		} else {
			spair.isBST = false;
		}

		return spair;

	}

	private class BSTPair2 {
		boolean isBST = true;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		int largestBSTRootNode;
		int largestBSTSize;
	}

	public void largestBST() {
		BSTPair2 ans = largestBST(root);
		System.out.println(ans.largestBSTRootNode + " " + ans.largestBSTSize);
	}

	private BSTPair2 largestBST(Node node) {

		if (node == null) {
			return new BSTPair2();
		}

		BSTPair2 lpair = largestBST(node.left);
		BSTPair2 rpair = largestBST(node.right);

		BSTPair2 spair = new BSTPair2();

		spair.max = Math.max(node.data, Math.max(lpair.max, rpair.max));
		spair.min = Math.min(node.data, Math.min(lpair.min, rpair.min));

		if (node.data > lpair.max && node.data < rpair.min && lpair.isBST && rpair.isBST) {
			spair.isBST = true;

			spair.largestBSTRootNode = node.data;
			spair.largestBSTSize = lpair.largestBSTSize + rpair.largestBSTSize + 1;
		} else {
			spair.isBST = false;

			if (lpair.largestBSTSize > rpair.largestBSTSize) {
				spair.largestBSTSize = lpair.largestBSTSize;
				spair.largestBSTRootNode = lpair.largestBSTRootNode;
			} else {
				spair.largestBSTSize = rpair.largestBSTSize;
				spair.largestBSTRootNode = rpair.largestBSTRootNode;
			}
		}
		return spair;
	}

	private class VOPair {
		Node node;
		int vlevel;// vertical level

		public VOPair(Node node, int vlevel) {
			this.node = node;
			this.vlevel = vlevel;
		}
	}

	public void verticalOrderDisplay() {

		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

		Queue<VOPair> queue = new LinkedList<>();

		VOPair sp = new VOPair(root, 0);
		queue.add(sp);

		while (!queue.isEmpty()) {

			VOPair rp = queue.remove();

			if (!map.containsKey(rp.vlevel)) {
				map.put(rp.vlevel, new ArrayList<Integer>());
			}

			// add node.data to the already existing arrayList
			map.get(rp.vlevel).add(rp.node.data);

			// System.out.println(rp.node.data + " " + rp.vlevel);

			if (rp.node.left != null) {
				queue.add(new VOPair(rp.node.left, rp.vlevel - 1));
			}
			if (rp.node.right != null) {
				queue.add(new VOPair(rp.node.right, rp.vlevel + 1));
			}
		}

		ArrayList<Integer> al = new ArrayList<>(map.keySet());

		Collections.sort(al);

		for (int key : al) {
			System.out.println(key + "->" + map.get(key));
		}
	}

	public void sibling() {
		this.sibling(this.root);
	}

	private void sibling(Node node) {

		if (node == null) {
			return;
		}

		if (node.left != null && node.right == null) {
			System.out.print(node.left.data + " ");
		} else if (node.left == null && node.right != null) {
			System.out.print(node.right.data + " ");
		}
		sibling(node.left);
		sibling(node.right);

	}

	public int sumOAllNodes() {
		return sumOfAllNodes(root);
	}

	private int sumOfAllNodes(Node node) {

		if (node == null) {
			return 0;
		}
		int lsum = sumOfAllNodes(node.left);
		int rsum = sumOfAllNodes(node.right);
		return lsum + rsum + node.data;
	}

	public void levelOrderNewLine() {

		// write your code here
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(root);
		queue.addLast(null);

		while (!queue.isEmpty()) {

			Node rn = queue.removeFirst();

			if (rn == null) {
				System.out.println();

				if (queue.size() == 0) {
					break;
				}

				queue.addLast(null);

			}
			if (rn != null) {
				System.out.print(rn.data + " ");

				if (rn.left != null)
					queue.addLast(rn.left);
				if (rn.right != null)
					queue.addLast(rn.right);
			}
		}
	}

}