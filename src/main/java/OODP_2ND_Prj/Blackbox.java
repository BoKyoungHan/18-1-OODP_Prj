package OODP_2ND_Prj;

//BlackBox class is used to implement singleton pattern
public class Blackbox {
	private final int MAX_SIZE = 100;
	private NewVehicle[] blackbox = new NewVehicle[MAX_SIZE];

	private static Blackbox singleton = new Blackbox();

	private Blackbox() {

	}

	public static Blackbox getInstance() {
		return singleton;
	}

	public synchronized void addVehicle(NewVehicle v) {
		if (size() == MAX_SIZE) {
			System.out.println("BlackBox memory is full !!!");
		} else {
			blackbox[size()] = v;
		}
	}

	public synchronized NewVehicle[] getBlackbox() {
		return blackbox;
	}

	public int size() {
		int i = 0;
		while (blackbox[i] != null) {
			i++;
		}
		return i;
	}
}
