package OODP_2ND_Prj;

public class PlaneAdapter extends Plane implements NewVehicle {

	public PlaneAdapter() {
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

	public void altitude() {
		vehicleAltitude();
	}

	public void airDensity() {
		vehicleAirDensity();
	}

}
