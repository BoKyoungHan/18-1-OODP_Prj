package OODP_3RD_Prj;

public class TrafficSignalSensor extends Thread implements Sensor {
	private String signal;
	private String direction;

	private final int FIRST_SITU = 0;
	private final int SECOND_SITU = 1;
	private final int THIRD_SITU = 2;
	private final int NUMBER_OF_SITUATION = 3;

	private Mediator med;

	private final int id = 4;

	public TrafficSignalSensor(Mediator m) {
		med = m;
	}

	public int getID() {
		return this.id;
	}

	public void setNext() {
		AutonomousCar.ID = 5;
	}

	public void run() {
		for (;;) {
			med.yourTurn(this);
		}

	}

	public void indicator() {
		System.out.println("TrafficSignalAhead:" + signal);
		System.out.println("Direction:" + direction);
	}

	public void init() {
		int situation = situationGenerator();
		if (situation == FIRST_SITU) {
			signal = "Red Light";
			direction = "Slow down the speed and prepare to stop.";
		} else if (situation == SECOND_SITU) {
			signal = "Blue Light";
			direction = "Keep current status...";
		} else if (situation == THIRD_SITU) {
			signal = "Yellow Light";
			direction = "Slow down the speed and prepare to stop.";
		}

	}

	public int situationGenerator() {
		return (int) (Math.random() * NUMBER_OF_SITUATION);
	}

}
