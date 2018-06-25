package OODP_3RD_Prj;

public class SideCarSensor extends Thread implements Sensor {
	private String leftCar;
	private String rightCar;;
	private String leftDirection;
	private String rightDirection;

	private final int FIRST_SITU = 0;
	private final int SECOND_SITU = 1;
	private final int THIRD_SITU = 2;
	private final int NUMBER_OF_SITUATION = 3;

	private Mediator med;
	private final int id = 2;

	public SideCarSensor(Mediator m) {
		med = m;
	}

	public int getID() {
		return this.id;
	}

	public void setNext() {
		AutonomousCar.ID = 3;
	}

	public void run() {
		for (;;) {
			med.yourTurn(this);
		}
	}

	public void init() {
		rightCarSensor();
		leftCarSensor();
	}

	public void rightCarSensor() {
		int situation = situationGenerator();
		if (situation == FIRST_SITU) {
			rightCar = "None";
			rightDirection = "Keep current status...";
		} else if (situation == SECOND_SITU) {
			rightCar = "Approaching";
			rightDirection = "Do not step on right lane...";
		} else if (situation == THIRD_SITU) {
			rightCar = "Too close";
			rightDirection = "Keep distance from right car...";
		}
	}

	public void leftCarSensor() {
		int situation = situationGenerator();
		if (situation == FIRST_SITU) {
			leftCar = "None";
			leftDirection = "Keep current status...";
		} else if (situation == SECOND_SITU) {
			leftCar = "Approaching";
			leftDirection = "Do not step on left lane...";
		} else if (situation == THIRD_SITU) {
			leftCar = "Too close";
			leftDirection = "Keep distance from left car...";
		}
	}

	public int situationGenerator() {
		return (int) (Math.random() * NUMBER_OF_SITUATION);
	}

	public void indicator() {
		System.out.println("LeftSideCar:" + leftCar);
		System.out.println("Direction:" + leftDirection);
		System.out.println("RightSideCar:" + rightCar);
		if (leftDirection.equals("Too close...") && rightDirection.equals("Too close...")) {
			System.out.println("low down the speed and run slowly...");
			return;
		} else {
			System.out.println("Direction:" + rightDirection);
		}

	}

}
