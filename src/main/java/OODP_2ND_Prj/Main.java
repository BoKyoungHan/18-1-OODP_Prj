package OODP_2ND_Prj;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String input = null;

		do {
			System.out.println("Next Vehicle Action : ");
			System.out.println("(C)ar (P)lane (S)ubmarine (B)lackbox (H)alt");
			input = sc.nextLine();
			switch (input) {
			case "c":
			case "C":
				CarAdapter car = new CarAdapter();
				car.speed();
				car.energy();
				car.temperature();
				car.humidity();
				Blackbox.getInstance().addVehicle(car);
				System.out.println(car);
				break;

			case "p":
			case "P":
				PlaneAdapter plane = new PlaneAdapter();
				plane.speed();
				plane.energy();
				plane.altitude();
				plane.temperature();
				plane.humidity();
				plane.airDensity();
				Blackbox.getInstance().addVehicle(plane);
				System.out.println(plane);
				break;

			case "s":
			case "S":
				SubmarineAdapter submarine = new SubmarineAdapter();
				submarine.speed();
				submarine.energy();
				submarine.depth();
				submarine.temperature();
				submarine.humidity();
				Blackbox.getInstance().addVehicle(submarine);
				System.out.println(submarine);
				break;

			case "b":
			case "B":
				blackboxStart(); // blackbox action starts.
				break;

			case "h":
			case "H":
				System.out
						.println("Halting the vehicle...\n" + "Adjusting the vehicle to the safe condition...\n" + "");
				break;

			default:
				System.out.println("Enter the correct input");

			}

		} while (!(input.equals("H") || input.equals("h")));
	}

	public static void blackboxStart() {
		String function = "Function:";
		String energyLevel = "Energy Level: ";
		String tem = "Temperature: ";
		String hum = "Humidity: ";

		for (NewVehicle nv : Blackbox.getInstance().getBlackbox()) {
			if (nv instanceof CarAdapter) {

				function += " car ->";
				energyLevel += ((CarAdapter) nv).getEnergy() + " -> ";
				tem += ((CarAdapter) nv).getTemperature() + " -> ";
				hum += ((CarAdapter) nv).getHumidity() + " -> ";
			} else if (nv instanceof PlaneAdapter) {
				function += " plane ->";
				energyLevel += ((PlaneAdapter) nv).getEnergy() + " -> ";
				tem += ((PlaneAdapter) nv).getTemperature() + " -> ";
				hum += ((PlaneAdapter) nv).getHumidity() + " -> ";
			} else if (nv instanceof SubmarineAdapter) {
				function += " submarine ->";
				energyLevel += ((SubmarineAdapter) nv).getEnergy() + " -> ";
				tem += ((SubmarineAdapter) nv).getTemperature() + " -> ";
				hum += ((SubmarineAdapter) nv).getHumidity() + " -> ";
			}
		}

		System.out.println(function.substring(0, function.length() - 3));
		System.out.println(energyLevel.substring(0, energyLevel.length() - 3));
		System.out.println(tem.substring(0, tem.length() - 3));
		System.out.println(hum.substring(0, hum.length() - 3));

	}
}
