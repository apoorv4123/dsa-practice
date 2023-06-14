package L23_Interfaces;

import java.util.Comparator;

public class GenericsDemo {

	public static void main(String[] args) {

		Integer[] arri = { 10, 20, 30, 40, 50 };
		display(arri);

		String[] arrs = { "delhi", "mumbai", "kolkata", "chennai" };
		display(arrs);

		Car[] cars = new Car[5];
		cars[0] = new Car(100, 5000, "Red");
		cars[1] = new Car(200, 6000, "White");
		cars[2] = new Car(300, 5500, "Black");
		cars[3] = new Car(400, 2500, "Yellow");
		cars[4] = new Car(250, 7000, "Grey");
		display(cars);

//		bubbleSort(cars);
		
//		bubbleSort(cars, new CarSpeedComparator());
//		display(cars);

//		bubbleSort(cars, new CarPriceComparator());
//		display(cars);

//		bubbleSort(cars, new CarColorComparator());
//		display(cars);

//		display(cars);
//		Object obj = new Object();

//		bubbleSort(new int[] { 55, 44, 33, 22, 11 });
	}

	public static <T> void display(T[] arr) {

		for (T val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();

	}

	// when class car has implements comparable
	public static <T extends Comparable<T>> void bubbleSort(T[] arr) {

		for (int counter = 0; counter < arr.length - 1; counter++) {

			for (int j = 0; j < arr.length - 1 - counter; j++) {

				if (arr[j].compareTo(arr[j + 1]) > 0) {
					T temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	// when fxn car oes not has implements comparable
	public static <T> void bubbleSort(T[] arr, Comparator<T> comparator) {

		for (int counter = 0; counter < arr.length - 1; counter++) {

			for (int j = 0; j < arr.length - 1 - counter; j++) {

				if (comparator.compare(arr[j], arr[j + 1]) > 0) {
					T temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

}