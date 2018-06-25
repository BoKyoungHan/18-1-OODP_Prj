package OODP_3RD_Prj;

public class FrontCarVelocitySensor extends Thread implements Sensor {

	private int frontCarVelocity; // velocity of front car
	private int velocity; // velocity of our car
	private String direction;
	private Mediator med;
	private final int id = 1;

	public FrontCarVelocitySensor(Mediator m) {
		med = m;
	}

	public void run() {
		for (;;) {
			med.myTurn(this);
		}

	}

	public int getID() {
		return this.id;
	}

	public void setNext() {
		AutonomousCar.ID = 2;
	}

	public void init() {
		frontCarVelocity = velocityGenerator();
		velocity = velocityGenerator();

		if (frontCarVelocity == 100) {
			direction = "Stay current velocity... " + velocity + " km/h";
		} else if (frontCarVelocity == velocity) {
			direction = "Stay current velocity...";
		} else if (frontCarVelocity > velocity) {
			direction = "Increase velocity..." + velocity;
			while (true) {
				velocity += 10;
				direction += "->" + velocity;
				if (frontCarVelocity == velocity) {
					break;
				}
			}
		} else {
			direction = "Decrease velocity..." + velocity;
			while (true) {
				velocity -= 10;
				direction += "->" + velocity;
				if (frontCarVelocity == velocity) {
					break;
				}
			}
		}

	}

	public void indicator() {
		System.out.println("frontCarVelocity:" + frontCarVelocity);
		System.out.println("Direction:" + direction);
	}

	public int velocityGenerator() {
		return (int) (Math.random() * 11) * 10;
	}

}
