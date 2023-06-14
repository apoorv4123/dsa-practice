package L24_Heap;

public class HeapGenericClient {

	public static void main(String[] args) {

		Car[] cars = new Car[5];
		cars[0] = new Car(100, 5000, "Red");
		cars[1] = new Car(200, 6000, "White");
		cars[2] = new Car(300, 5500, "Black");
		cars[3] = new Car(400, 2500, "Yellow");
		cars[4] = new Car(250, 7000, "Grey");

		HeapGeneric<Car> heapg = new HeapGeneric<>();
		heapg.add(cars[0]);
		heapg.add(cars[1]);
		heapg.add(cars[2]);
		heapg.add(cars[3]);
		heapg.add(cars[4]);
		
		System.out.println(heapg.remove());

	}

}