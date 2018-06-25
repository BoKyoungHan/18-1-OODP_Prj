package OODP_2ND_Prj;

public class Car extends BaseVehicle {

	private final int MIN_INCREASING = 5;
	private final int MAX_INCREASING = 10;

	public Car() {
		s_min = 0;
		s_max = 100;

		e_min = 10;
		e_max = 100;

		t_min = 10;
		t_max = 80;

		h_min = 10;
		h_max = 80;
	}

	@Override
	public String vehicleSpeed() {
		// TODO Auto-generated method stub
		String s = "Speed: ";
		speed = randomNumberGenerator(s_min, s_max);
		s += speed + "Km/Hour, ";
		for (int i = 0; i < 4; i++) {
			if (speed != 100) {
				speed = randomNumberGenerator(speed + 1, s_max);
			} else {
				speed = 100;
			}
			s += speed + "Km/Hour, ";
		}
		return s.substring(0, s.length() - 2);
	}

	@Override
	public void vehicleEnergy() {
		// TODO Auto-generated method stub
		energy = randomNumberGenerator(e_min, e_max);
		setIncreasing(MIN_INCREASING, MAX_INCREASING); // do not use magic number.
	}

	@Override
	public void vehicleTemperature() {
		// TODO Auto-generated method stub
		temperature = randomNumberGenerator(t_min, t_max);
	}

	@Override
	public void vehicleHumidity() {
		// TODO Auto-generated method stub
		humidity = randomNumberGenerator(h_min, h_max);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Current Function: Car\n" + vehicleSpeed() + "\n" + "Energy: " + energy + "%\n" + charging()
				+ "Temperature: " + temperature + " degree\n" + "Humidity: " + humidity + "%\n";

	}

}
