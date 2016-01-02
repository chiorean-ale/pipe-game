package elements;

public class Position {
	private int abscisse ;
	private int ordonnee ;
	
	public Position (int ordonnee, int abscisse) {
		this.ordonnee = ordonnee ;
		this.abscisse = abscisse ;
	}
	
	public int getAbscisse() {
		return this.abscisse;
	}
	
	public int getOrdonnee() {
		return this.ordonnee ;
	}
}
