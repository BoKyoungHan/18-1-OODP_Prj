package OODP_3RD_Prj;

public class Mediator {

	private boolean slotFull = false;

	public synchronized void myTurn(Sensor s) {

		while (slotFull == true) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		if (s.getID() == AutonomousCar.ID) {

			if (AutonomousCar.loopCount % 6 == 0) {
				AutonomousCar.NOI = AutonomousCar.NOI + 1;
				if (AutonomousCar.NOI == 5) {
					System.exit(0);
				}

				try {
					Thread.sleep(2500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("\nLoop <" + AutonomousCar.NOI + ">");
			}

			AutonomousCar.loopCount = AutonomousCar.loopCount + 1;
			slotFull = true; // 중요!
			s.init();
			s.indicator();
			s.setNext();
		}
		notifyAll();

	}

	public synchronized void yourTurn(Sensor s) {

		while (slotFull == false) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		if (s.getID() == AutonomousCar.ID) {

			if (AutonomousCar.loopCount % 6 == 0) {
				AutonomousCar.NOI = AutonomousCar.NOI + 1;
				if (AutonomousCar.NOI == 5) {
					System.exit(0);
				}
				try {
					Thread.sleep(2500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Loop" + AutonomousCar.NOI);
			}

			AutonomousCar.loopCount = AutonomousCar.loopCount + 1;
			slotFull = false;
			s.init();
			s.indicator();
			s.setNext();
		}
		notifyAll();
	}
}
