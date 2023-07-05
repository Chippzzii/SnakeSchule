package gui;

import javax.swing.JFrame;

import actions.KeyHandler;

public class Gui {
	public static JFrame jf;
	Elemente e;
	public static int width = 580;
	public static int height = 620;
	public static int xoff = 20;
	public static int yoff = 20;

	public void spielfeldAnlegen() {
		jf = new JFrame("Friss die Frucht!");
		jf.setSize(width, height);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		jf.setLayout(null);
		jf.setResizable(false);
		jf.requestFocus();

		jf.addKeyListener(new KeyHandler());

		e = new Elemente();
		e.setBounds(0, 0, width, height);

		jf.add(e);
		e.setVisible(true);
		jf.setVisible(true);
	}
}
