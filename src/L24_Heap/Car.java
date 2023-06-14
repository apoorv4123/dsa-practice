package L24_Heap;

public class Car implements Comparable<Car> {

	int speed;
	int price;
	String color;

	public Car(int speed, int price, String color) {
		this.speed = speed;
		this.price = price;
		this.color = color;
	}

	@Override
	public String toString() {
		return "S: " + this.speed + " P: " + this.price + " C: " + this.color;
	}

	@Override
	public int compareTo(Car other) {
		// comparison being done on basis of speed : large speed, large priority
		return this.speed - other.speed;

		// comparison being done on basis of price : large price, small priority
//		return other.price - this.price;

		// comparison on basis of color
		// String class already has compareTo() function, so we'll use it
		// lexicographically sorting'll be done
//		return this.color.compareTo(other.color);
	}
}