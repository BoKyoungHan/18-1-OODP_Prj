package OODP_3RD_Prj;

public class AutonomousCar {
	public static int loopCount = 0;
	public static int ID = 1;
	public static int NOI = 0;

	public static void main(String[] args) throws InterruptedException {
		Mediator md = new Mediator();

		new FrontCarVelocitySensor(md).start();
		new SideCarSensor(md).start();
		new LaneSensor(md).start();
		new TrafficSignalSensor(md).start();
		new PedestrianSensor(md).start();
		new ObjectSensor(md).start();

	}

}
