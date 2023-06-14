package L21_BinarySearchTree;

public class BSTClient {

	public static void main(String[] args) {

		int[] inorder = { 2, 4, 4, 1, 2, 3, 4, 5, 6 };
		BST bst = new BST(inorder);

		bst.display();
//		System.out.println(bst.in());
//
//		bst.construct(bst.in());
		System.out.println(bst.MaximumSumBSTinBinaryTree());
//		bst.display();

//		System.out.println(bst.find(70));

//		System.out.println(bst.max());

//		bst.add(55);
//		bst.display();

//		bst.remove(55);
//		bst.display();

//		bst.remove(40);
//		bst.display();

//		bst.printDec();
//		System.out.println();

//		bst.replaceWithSumLarger();
//		bst.display();

//		bst.printInRange(25, 55);

//		bst.add2(25);
//		bst.display();

	}

}