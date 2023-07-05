package clock;

import actions.Kollision;
import game.Schlange;

public class GameClock extends Thread {
    static boolean spielen = true;

    public void run() {
        while (spielen) {
            try {
                sleep(200);
                Schlange.bewegen();
                Schlange.waitToMove = false;
                Kollision.kollisionFrucht();

                if (Kollision.kollisionWand() || Kollision.kollisionKoerper()) {
                    Kollision.gameOver();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
