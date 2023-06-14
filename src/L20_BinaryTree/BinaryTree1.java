package L20_BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree1 {

	static Scanner s = new Scanner(System.in);

	private class Node {
		int data;
		Node right = null;
		Node left = null;
	}

	private Node root;

	public BinaryTree1() {
		this.root = construct();
	}

	private Node construct() {

		Queue<Node> q = new LinkedList<>();

		Node fn = new Node();
		int fd = s.nextInt();
		fn.data = fd;
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
			} else {
				remn.left = null;
			}

			if (rc != -1) {
				Node rn = new Node();
				rn.data = rc;
				remn.right = rn;
				q.add(rn);
			} else {
				remn.right = null;
			}
		}
		return fn;
	}

	private class viewPair {
		Node node;
		int vidx;

		public viewPair(Node node, int i) {
			this.node = node;
			this.vidx = i;
		}
	}

	public void bottomview() {

		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

		Queue<viewPair> q = new LinkedList<>();

		q.add(new viewPair(this.root, 0));

		while (!q.isEmpty()) {

			viewPair rp = q.remove();

			if (!map.containsKey(rp.vidx)) {
				map.put(rp.vidx, new ArrayList<Integer>());
			}
			map.get(rp.vidx).add(rp.node.data);

			if (rp.node.left != null) {
				q.add(new viewPair(rp.node.left, rp.vidx - 1));
			}
			if (rp.node.right != null) {
				q.add(new viewPair(rp.node.right, rp.vidx + 1));
			}
		}

		ArrayList<Integer> keys = new ArrayList<>(map.keySet());

		Collections.sort(keys);

		for (int key : keys) {
			System.out.print(map.get(key).get(map.get(key).size() - 1) + " ");
		}
		System.out.println();

	}
	
	public boolean isValidBST() {
        return isvalidBST(this.root).isstbst;
    }
    
    class isbstpair{
        
        boolean isstbst = true;    // is sub tree bst
        int max = Integer.MIN_VALUE;    // maximum value in sub tree
        int min = Integer.MAX_VALUE;    // minimum value in sub tree
        
    }
    
    public isbstpair isvalidBST(Node root) {
        
        if(root == null){
            return new isbstpair();
        }
        
        isbstpair l = isvalidBST(root.left);
        isbstpair r = isvalidBST(root.right);
        
        isbstpair sp = new isbstpair();
        sp.max = Math.max(root.data, Math.max(l.max, r.max));
        sp.min = Math.min(root.data, Math.min(l.min, r.min));
        
        if(root.data > l.max && root.data < r.min && l.isstbst && r.isstbst){
            sp.isstbst = true;
        }else{
            sp.isstbst = false;
        }
        
//         if(root.left != null)
//             sp.isstbst = sp.isstbst && root.val > root.left.val;
        
//         if(root.right != null)
//             sp.isstbst = sp.isstbst && root.val < root.right.val;
        
        return sp;
    }

	public static void main(String[] args) {
		BinaryTree1 bt = new BinaryTree1();
//		bt.bottomview();
		System.out.println(bt.isValidBST());
	}
}