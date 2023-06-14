package L25_AVL;

public class Client {

	public static void main(String[] args) {
		
		AVLTree avltree=new AVLTree();
		
		avltree.insert(20);
		avltree.insert(25);
		avltree.insert(30);
		avltree.insert(10);
		avltree.insert(5);
		avltree.insert(15);
		avltree.insert(27);
		avltree.insert(19);
		avltree.insert(16);
		
		avltree.display();
	}

}
