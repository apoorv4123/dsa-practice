package L23_Interfaces;

public class PairClient {

	public static void main(String[] args) {

		Pair<String> pair = new Pair<>();
		pair.one = "abc";
		pair.two = "pqr";

		Pair<Integer> pair1 = new Pair<>();
		pair1.one = 10;
		pair1.two = 20;

		PairTwo<Integer, String> pair2 = new PairTwo<>();
		pair2.one = 30;
		pair2.two = "xyz";

		LinkedListGeneric<Car> list = new LinkedListGeneric<>();
		Car[] cars = new Car[5];
		cars[0] = new Car(100, 5000, "Red");
		cars[1] = new Car(200, 6000, "White");
		cars[2] = new Car(300, 5500, "Black");
		cars[3] = new Car(400, 2500, "Yellow");
		cars[4] = new Car(250, 7000, "Grey");

		list.addlast(cars[0]);
		list.addlast(cars[1]);
		list.addlast(cars[2]);
		list.addlast(cars[3]);
		list.addlast(cars[4]);

		list.display();

	}

}
