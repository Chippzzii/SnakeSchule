package actions;

import game.Schlange;
import game.Schwanz;

import javax.swing.*;


public class Kollision {
	public static boolean kollisionKoerper() {
		for (int i = 0; i < Schlange.schwanz.size(); i++) {
			if (Schlange.kopf.getX() == Schlange.schwanz.get(i).getX()
					&& Schlange.kopf.getY() == Schlange.schwanz.get(i).getY() && !Schlange.schwanz.get(i).isWait()) {
				return true;
			}
		}
		return false;
	}

	public static boolean kollisionWand() {
		return (Schlange.kopf.getX() < 0 || Schlange.kopf.getX() > 15 || Schlange.kopf.getY() < 0
				|| Schlange.kopf.getY() > 15);

	}

	public static void kollisionFrucht() {
		if (Schlange.kopf.getX() == Schlange.frucht.getX() && Schlange.kopf.getY() == Schlange.frucht.getY()) {
			Schlange.addSchwanz();
			Schlange.frucht.reset();

			Schlange.punkte += 1;
			if (Schlange.punkte > Schlange.highscore) {

			}
		}
	}

	public static void gameOver() {
		int input = JOptionPane.showConfirmDialog(null, "Nochmal?", "Game Over", JOptionPane.YES_NO_OPTION);

		if (input == 1) {
			System.exit(0);
		} else {
			Schlange.punkte = 0;
			Schlange.schwanz.clear();
			Schlange.kopf.setX(7);
			Schlange.kopf.setY(7);
			Schlange.frucht.reset();
		}
	}
}
