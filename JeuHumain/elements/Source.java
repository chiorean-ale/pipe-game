package elements;

public class Source extends Piece {

	public Source (int abscisse, int ordonnee, String forme) {
		super(abscisse, ordonnee, true, forme, 1) ;
	}
	
	@Override
	public void setDefaultCoordonneesVoisins() {
		Position voisinHaut = new Position(super.ordonnee-1, super.abscisse);
		Position voisinDroite = new Position(super.ordonnee, super.abscisse+1);
		Position voisinBas = new Position(super.ordonnee+1, super.abscisse);
		Position voisinGauche = new Position(super.ordonnee, super.abscisse-1);
		super.coordonneesVoisins.add(voisinHaut);
		super.coordonneesVoisins.add(voisinDroite);
		super.coordonneesVoisins.add(voisinBas);
		super.coordonneesVoisins.add(voisinGauche);
	}
}
