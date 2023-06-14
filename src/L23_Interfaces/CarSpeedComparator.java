package L23_Interfaces;

import java.util.Comparator;

public class CarSpeedComparator implements Comparator<Car> {

	@Override
	public int compare(Car tcar, Car ocar) {
		
		// comparison done on basis of speed: badi cheez badi
		return tcar.speed-ocar.speed;
	}

}
