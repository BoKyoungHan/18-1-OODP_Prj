package OODP_2ND_Prj;

public class SubmarineAdapter extends Submarine implements NewVehicle {

	public SubmarineAdapter() {
		super();
	}

	@Override
	public void speed() {
		// TODO Auto-generated method stub
		vehicleSpeed();
	}

	@Override
	public void energy() {
		// TODO Auto-generated method stub
		vehicleEnergy();

	}

	@Override
	public void temperature() {
		// TODO Auto-generated method stub
		vehicleTemperature();

	}

	@Override
	public void humidity() {
		// TODO Auto-generated method stub
		vehicleHumidity();
	}

	public void depth() {
		vehicleDepth();
	}

}
