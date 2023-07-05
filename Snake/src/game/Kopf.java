package game;

public class Kopf {
	int x;
	int y;
	Richtung richtung = Richtung.RECHTS;
	
	public Kopf(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Richtung getRichtung() {
		return richtung;
	}

	public void setRichtung(Richtung richtung) {
		this.richtung = richtung;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	
	
	
	
	
}
