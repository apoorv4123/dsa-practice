package L23_Interfaces;

import java.util.Comparator;

public class CarPriceComparator implements Comparator<Car> {

	@Override
	public int compare(Car tcar, Car ocar) {

		// choti cheez badi : small price more priority
		return ocar.price - tcar.price;
	}

}
