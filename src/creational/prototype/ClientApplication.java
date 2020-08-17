package creational.prototype;

import javafx.geometry.Point3D;

public class ClientApplication {

	public static void main(String[] args) {
		try {
			Swordsman swordsman = new Swordsman();
			swordsman.attack();
			swordsman.move(new Point3D(-10, 0, 0), 20);
			System.out.println(swordsman);
			Swordsman swordsman2 = (Swordsman) swordsman.clone();
			System.out.println("cloned swardsman" + swordsman2);

			General general = new General();
			general.boostMorale();
			System.out.println(general);
			general.clone();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
