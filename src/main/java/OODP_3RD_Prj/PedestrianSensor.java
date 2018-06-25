package OODP_3RD_Prj;

public class PedestrianSensor extends Thread implements Sensor {
	private String pedestrian;
	private String direction;
	private int distanceToPedestrian;

	private final int MIN_DISTANCE = 1; // 10
	private final int MAX_DISTANCE = 6; // 60
	private final int FIRST_SITU = 0;
	private final int SECOND_SITU = 1;
	private final int NUMBER_OF_SITUATION = 2;

	private Mediator med;
	private final int id = 5;

	public PedestrianSensor(Mediator m) {
		med = m;
	}

	public int getID() {
		return this.id;
	}

	public void setNext() {
		AutonomousCar.ID = 6;
	}

	public void run() {
		for (;;) {
			med.myTurn(this);
		}
	}

	public void indicator() {
		System.out.println("Pedestrian:" + pedestrian);
		if (!pedestrian.equals("None")) {
			System.out.println("DistanceToPedestrian:" + distanceToPedestrian + "m");
		}
		System.out.println("Direction:" + direction);
	}

	public void init() {
		if (isExist() == false) {
			pedestrian = "None";
			direction = "Keep current status...";
			return;
		}

		int situation = situationGenerator();
		if (situation == FIRST_SITU) {
			pedestrian = "Walk acrossing...";
			distanceToPedestrian = distanceGenerator();
			Controller();
		} else if (situation == SECOND_SITU) {
			pedestrian = "Standing on the street";
			distanceToPedestrian = distanceGenerator();
			Controller();
		}

	}

	public void Controller() {
		if (distanceToPedestrian <= 10) {
			direction = "Slow down fast and make a full stop...";
		} else if (distanceToPedestrian <= 30) {
			direction = "Slow down the speed and run slowly...";
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
