package OODP_2ND_Prj;

public class Submarine extends BaseVehicle {

	private int depth;
	private int depth_min;
	private int depth_max;

	private final int MIN_INCREASING = 15;
	private final int MAX_INCREASING = 20;

	public Submarine() {
		s_min = 0;
		s_max = 60;

		e_min = 10;
		e_max = 100;

		depth_min = 10;
		depth_max = 100;

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
		setIncreasing(MIN_INCREASING, MAX_INCREASING);
	}

	public void vehicleDepth() {
		depth = randomNumberGenerator(depth_min, depth_max);
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
		return "Current Function: Submarine\n" + vehicleSpeed() + "\n" + "Energy: " + energy + "%\n" + charging() // should
																													// be
																													// called
																													// after
																													// setIncreasing().
				+ "Depth : " + depth + " m\n" + "Temperature: " + temperature + " degree\n" + "Humidity: " + humidity
				+ "%\n";
	}

}
