package game;

import gui.Gui;

import java.awt.*;
import java.util.ArrayList;

public class Schlange {
    public static int punkte = 0, highscore = 0;
    public static boolean waitToMove = false;
    public static Kopf kopf = new Kopf(7, 7);
    public static ArrayList<Schwanz> schwanz = new ArrayList<>();
    public static Frucht frucht = new Frucht();

    public static void addSchwanz() {
        if (schwanz.size() < 1) {
            schwanz.add(new Schwanz(kopf.getX(), kopf.getY()));
        } else {
            schwanz.add(new Schwanz(schwanz.get(schwanz.size() - 1).x, schwanz.get(schwanz.size() - 1).y));
        }
    }

    public static void bewegen() {
        if (schwanz.size() >= 2) {
            for (int i = schwanz.size() - 1; i >= 1; i--) {
                if (schwanz.get(i).isWait()) {
                    schwanz.get(i).setWait(false);
                } else {
                    schwanz.get(i).setX(schwanz.get(i - 1).getX());
                    schwanz.get(i).setY(schwanz.get(i - 1).getY());
                }
            }
        }

        if (schwanz.size() >= 1) {
            if (schwanz.get(0).isWait()) {
                schwanz.get(0).setWait(false);
            } else {
                schwanz.get(0).setX(kopf.getX());
                schwanz.get(0).setY(kopf.getY());
            }
        }

        switch (kopf.getRichtung()) {
            case RECHTS:
                kopf.setX(kopf.getX() + 1);
                break;
            case LINKS:
                kopf.setX(kopf.getX() - 1);
                break;
            case HOCH:
                kopf.setY(kopf.getY() - 1);
                break;
            case RUNTER:
                kopf.setY(kopf.getY() + 1);
                break;
        }
    }

    public static Point point(int x, int y) {
        Point p = new Point(0, 0);
        p.x = x * 32 + Gui.xoff;
        p.y = y * 32 + Gui.yoff;
        return p;
    }

}
