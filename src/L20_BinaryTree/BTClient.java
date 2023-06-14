package L20_BinaryTree;

public class BTClient {

	// 10 true 20 true 40 false false true 50 false false true 30 false true 70 false false

	// 10 true 20 true 40 true 70 true 90 true 110 false false false false false
	// true 50 false true 80 false true 110 false true 120 false false true 30 false
	// true 60 false false

	// 10 true 20 true 80 false false true 60 false true 70 false false true 30
	// false true 50 false false

	public static void main(String[] args) {

		BinaryTree bt = new BinaryTree();

		bt.display();

//		System.out.println(bt.size());
//		System.out.println(bt.max());
//		System.out.println(bt.find(500));
//		System.out.println(bt.height());
//		System.out.println(bt.diameter());
//		System.out.println(bt.isBalanced());

//		"abc".compareTo("def");

//		BinaryTree bt2 = new BinaryTree();
//		bt2.display();

//		System.out.println(bt.areFlipEquivalent(bt2));

//		bt.preorder();
//		bt.postorder();
//		bt.inorder();
//		bt.preorderIterative();
//
//		System.out.println();
//		System.out.println(bt.sumTree());

		// 10 true 20 true 40 true 2 false false true 3 false false true -60 false false
		// true -30 true 50 true 60 true 80 false false false true 70 false false true
		// -100 false false
//		System.out.println(bt.maxSubtreeSum());

//		int[] pre = { 10, 20, 40, 30, 50, 60, 70 };
//		int[] in = { 40, 20, 10, 50, 30, 60, 70 };
//		BinaryTree bt1 = new BinaryTree(pre, in);
//		bt1.display();

//		400 true 200 true 10 false false true 30 true 25 true 22 false false false true 35 false false true 60 true 50 false false true 70 false false
//		System.out.println(bt.isTreeBST());
//		bt.largestBST();
		
//		bt.sibling();
		
//		bt.levelOrderNewLine();
		
		bt.verticalOrderDisplay();

	}

}