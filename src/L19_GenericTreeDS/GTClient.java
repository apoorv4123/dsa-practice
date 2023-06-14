package L19_GenericTreeDS;

public class GTClient {

	public static void main(String[] args) {
		// 10 3 20 2 50 0 60 1 80 0 30 0 40 1 70 0
//		 10 3 20 2 50 0 60 0 30 0 40 1 70 0
		GenericTree gt = new GenericTree();

		gt.display();

//		System.out.println(gt.size());

//		System.out.println(gt.max());

//		System.out.println(gt.height());

//		System.out.println(gt.find(60));

//		gt.mirror();
//		gt.display();

//		gt.printAtLevel(2);

//		gt.linearize();
//		gt.display();

//		gt.display2();

//		gt.preorder();
//		System.out.println();
//		gt.postorder();
//		System.out.println();
//		gt.levelorder();
//		gt.levelOrderLinewiseApp1();
//		gt.levelOrderLinewiseApp2();

		// HACKERBLOCKS
//		gt.depthvalue();
//		gt.display();
//		System.out.println(gt.countLeafNodes());
//		System.out.println(gt.sumOfNodes());
		
		gt.zigZag();
	}

}
