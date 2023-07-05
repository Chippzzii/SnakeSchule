package actions;

import game.Richtung;
import game.Schlange;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (!(Schlange.kopf.getRichtung() == Richtung.RUNTER) && !Schlange.waitToMove) {
                    Schlange.kopf.setRichtung(Richtung.HOCH);
                    Schlange.waitToMove = true;
                }
                break;
            case KeyEvent.VK_DOWN:
                if (!(Schlange.kopf.getRichtung() == Richtung.HOCH) && !Schlange.waitToMove) {
                    Schlange.kopf.setRichtung(Richtung.RUNTER);
                    Schlange.waitToMove = true;
                }
                break;
            case KeyEvent.VK_LEFT:
                if (!(Schlange.kopf.getRichtung() == Richtung.RECHTS) && !Schlange.waitToMove) {
                    Schlange.kopf.setRichtung(Richtung.LINKS);
                    Schlange.waitToMove = true;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (!(Schlange.kopf.getRichtung() == Richtung.LINKS) && !Schlange.waitToMove) {
                    Schlange.kopf.setRichtung(Richtung.RECHTS);
                    Schlange.waitToMove = true;
                }
                break;

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
