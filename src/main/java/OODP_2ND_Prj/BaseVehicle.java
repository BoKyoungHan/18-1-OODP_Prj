package OODP_2ND_Prj;

public abstract class BaseVehicle {
	protected int speed;
	protected int energy;
	protected int temperature;
	protected int humidity;
	protected int increasing;

	protected int s_min;
	protected int s_max;

	protected int e_min;
	protected int e_max;

	protected int t_min;
	protected int t_max;

	protected int h_min;
	protected int h_max;

	public abstract String vehicleSpeed();

	public abstract void vehicleEnergy();

	public abstract void vehicleTemperature();

	public abstract void vehicleHumidity();

	// set increasing amount of energy between 5~10.
	public void setIncreasing(int min, int max) {
		increasing = randomNumberGenerator(min, max);
	}

	// if energy level is below 50%, charging actions starts.
	public String charging() {
		String charge = "";
		if (energy < 50) {
			charge += "Now Charging : " + energy + "%";
			while (energy <= 100) {
				energy += increasing;
				if (energy >= 100) {
					energy = 100;
					charge += ", " + energy + "%";
					break;
				}
				charge += ", " + energy + "%";
			}
			charge += "\n";
		}
		return charge;
	}

	public int getEnergy() {
		return energy;
	}

	public int getTemperature() {
		return temperature;
	}

	public int getHumidity() {
		return humidity;
	}

	public int randomNumberGenerator(int min, int max) {
		return (int) (Math.random() * (max - min + 1)) + min;
	}

}
