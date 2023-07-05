package gui;

import game.Richtung;
import game.Schlange;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Elemente extends JLabel {
    Point p;

    public void paint(Graphics g) {
        super.paint(g);
        try {
            BufferedImage upImage = ImageIO.read(new File("src/resources/PacmanUp.png"));
            BufferedImage downImage = ImageIO.read(new File("src/resources/PacmanDown.png"));
            BufferedImage leftImage = ImageIO.read(new File("src/resources/PacmanLeft.png"));
            BufferedImage rightImage = ImageIO.read(new File("src/resources/PacmanRechts.png"));
            BufferedImage beacon = ImageIO.read(new File("src/resources/tabletten.png"));

            // Hintergrund Frame
            g.setColor(Color.GRAY);
            g.fillRect(0, 0, Gui.width, Gui.height);

            // Hintergrund Spielfeld
            g.setColor(Color.WHITE);
            g.fillRect(Gui.xoff, Gui.yoff, 512, 512);

            // Frucht
            p = Schlange.point(Schlange.frucht.getX(), Schlange.frucht.getY());
            g.drawImage(beacon, p.x, p.y, 32,32,null);

            p = Schlange.point(Schlange.kopf.getX(), Schlange.kopf.getY());
            if (Schlange.kopf.getRichtung() == Richtung.HOCH) {
                g.drawImage(upImage, p.x, p.y, 32, 32, null);
            } else if (Schlange.kopf.getRichtung() == Richtung.RUNTER) {
                g.drawImage(downImage, p.x, p.y, 32, 32, null);
            } else if (Schlange.kopf.getRichtung() == Richtung.LINKS) {
                g.drawImage(leftImage, p.x, p.y, 32, 32, null);
            } else if (Schlange.kopf.getRichtung() == Richtung.RECHTS) {
                g.drawImage(rightImage, p.x, p.y, 32, 32, null);
            }

            // Schwanzteile
            g.setColor(Color.YELLOW);
            for (int i = 0; i < Schlange.schwanz.size(); i++) {
                p = Schlange.point(Schlange.schwanz.get(i).getX(), Schlange.schwanz.get(i).getY());
                g.fillOval(p.x, p.y, 32, 32);
            }


            // "Grid" Spielfeld (16x16)
            g.setColor(Color.BLUE);
            for (int x = 0; x < 16; x++) {
                for (int y = 0; y < 16; y++) {
                    g.drawRect(x * 32 + Gui.xoff, y * 32 + Gui.yoff, 32, 32);
                }
            }

            //Punkte
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 18));
            g.drawString(String.format("Punkte: %d ***** Highscore: %d", Schlange.punkte, Schlange.highscore), Gui.jf.getWidth() / 2 - 125, 570);

            // Rand Spielfeld
            g.setColor(Color.BLACK);
            g.drawRect(Gui.xoff, Gui.yoff, 512, 512);

            // "Neuzeichnen" des Frames
            repaint();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
