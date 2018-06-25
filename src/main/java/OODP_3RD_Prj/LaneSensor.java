package OODP_3RD_Prj;

public class LaneSensor extends Thread implements Sensor {
	private String position;
	private String direction;

	private final int FIRST_SITU = 0;
	private final int SECOND_SITU = 1;
	private final int THIRD_SITU = 2;
	private final int FOURTH_SITU = 3;
	private final int NUMBER_OF_SITUATION = 4;

	private Mediator med;
	private final int id = 3;

	public LaneSensor(Mediator m) {
		med = m;
	}

	public int getID() {
		return this.id;
	}

	public void setNext() {
		AutonomousCar.ID = 4;
	}

	public void run() {
		for (;;) {
			med.myTurn(this);
		}

	}

	public void indicator() {
		System.out.println("PositionBetweenLanes:" + position);
		System.out.println("Direction:" + direction);
	}

	public void init() {
		int situation = situationGenerator();
		if (situation == FIRST_SITU) {
			position = "Left wheel on left lane";
			direction = "Adjust wheel to run inside two lanes...";
		} else if (situation == SECOND_SITU) {
			position = "Right wheel on right lane";
			direction = "Adjust wheel to run inside two lanes...";
		} else if (situation == THIRD_SITU) {
			position = "In Lanes...";
			direction = "Keep current status...";
		} else if (situation == FOURTH_SITU) {
			position = "No Lanes";
			direction = "Use GPS...";
		}

	}

	public int situationGenerator() {
		return (int) (Math.random() * NUMBER_OF_SITUATION);
	}

}
