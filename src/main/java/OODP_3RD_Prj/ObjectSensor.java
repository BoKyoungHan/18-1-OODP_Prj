package OODP_3RD_Prj;

public class ObjectSensor extends Thread implements Sensor {
	private String object;
	private String direction;
	private int distanceToObject;

	private final int MIN_DISTANCE = 1; // 10
	private final int MAX_DISTANCE = 6; // 60
	private final int FIRST_SITU = 0;
	private final int SECOND_SITU = 1;
	private final int NUMBER_OF_SITUATION = 2;

	private Mediator med;
	private final int id = 6;

	public ObjectSensor(Mediator m) {
		med = m;
	}

	public int getID() {
		return this.id;
	}

	public void setNext() {
		AutonomousCar.ID = 1;
	}

	public void run() {
		for (;;) {
			med.yourTurn(this);
		}
	}

	public void indicator() {
		System.out.println("ObjetAppeared:" + object);
		if (!object.equals("None")) {
			System.out.println("DistanceToObject:" + distanceToObject + "m");
		}
		System.out.println("Direction:" + direction);
	}

	public void init() {
		if (isExist() == false) {
			object = "None";
			direction = "Keep current status...";
			return;
		}

		int situation = situationGenerator();
		if (situation == FIRST_SITU) {
			object = "A large stone appeared..";
			distanceToObject = distanceGenerator();
			Controller();
		} else if (situation == SECOND_SITU) {
			object = "A car stopped";
			distanceToObject = distanceGenerator();
			Controller();
		}

	}

	public void Controller() {
		if (distanceToObject <= 10) {
			direction = " Slow down fast and make a full stop...";
		} else if (distanceToObject <= 20) {
			direction = "Slow down the speed and prepare to stop.";
		} else if (distanceToObject <= 50) {
			direction = "Slow down the speed and pass by...";
		} else {
			direction = "Keep current status...";
		}
	}

	public boolean isExist() {
		return Math.random() < 0.5 ? true : false;

	}

	public int situationGenerator() {
		return (int) (Math.random() * NUMBER_OF_SITUATION);
	}

	public int distanceGenerator() {
		return ((int) (Math.random() * (MAX_DISTANCE - MIN_DISTANCE + 1)) + MIN_DISTANCE) * 10;
	}
}
