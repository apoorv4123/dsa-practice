package L26_SegmentTree;

public class SegmentTree {

	private class Node {

		int data;
		int startInterval;
		int endInterval;
		Node left; // type object, so by default null
		Node right;

	}

	private Node root;

	public SegmentTree(int[] arr) {
		// SUM
		this.root = constructTree(arr, 0, arr.length - 1);
	}

	private Node constructTree(int[] arr, int si, int ei) {

		if (si == ei) {
			Node leafNode = new Node();
			leafNode.data = arr[si]; // or ei
			leafNode.startInterval = si; // or ei
			leafNode.endInterval = si; // or ei
			return leafNode;
		}

		Node nn = new Node();
		nn.startInterval = si;
		nn.endInterval = ei;

		int mid = (si + ei) / 2;

		nn.left = constructTree(arr, si, mid);
		nn.right = constructTree(arr, mid + 1, ei);

		nn.data = nn.left.data + nn.right.data;

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

		if (node.left == null) {
			str += "NoLeftChild";
		} else {
			str += "Interval=[" + node.left.startInterval + "," + node.left.endInterval + "] , data=" + node.left.data;
		}

		str += "-> Interval=[" + node.startInterval + "," + node.endInterval + "] , data=" + node.data + " <-";

		if (node.right == null) {
			str += "NoRightChild";
		} else {
			str += "Interval=[" + node.right.startInterval + "," + node.right.endInterval + "] , data="
					+ node.right.data;
		}

		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	public int sumBetweenIndices(int qsi, int qei) {
		return sumBetweenIndices(this.root, qsi, qei);
	}

	private int sumBetweenIndices(Node node, int qsi, int qei) {
		if (node.startInterval >= qsi && node.endInterval <= qei) { // node completely inside query case
			return node.data;
		} else if (node.startInterval > qei || node.endInterval < qsi) { // completely outside
			return 0; // return default value
		} else { // overlapping case
			return sumBetweenIndices(node.left, qsi, qei) + sumBetweenIndices(node.right, qsi, qei);
		}
	}

	public void update(int idx, int newvalue) {
		update(this.root, idx, newvalue);
	}

	private int update(Node node, int idx, int newvalue) {

		if (idx >= node.startInterval && idx <= node.endInterval) {
			if (idx == node.startInterval && idx == node.endInterval) {
				node.data = newvalue;
			} else {
				node.data = update(node.left, idx, newvalue) + update(node.right, idx, newvalue);
			}
		}
		return node.data;
	}

}