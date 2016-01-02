package elements;

import exception.FormatPieceException;

public class TuyauCroix extends Piece {
	private int id ;

	// id: 50 forme "XX"
	
	public int getId() {
		return this.id;
	}

	public TuyauCroix (int abscisse, int ordonnee, String forme) throws FormatPieceException {
		super(abscisse, ordonnee, false, forme, 1) ;
		this.setId(forme);
	}

	public void setId(String forme) throws FormatPieceException {
		if (forme.equals("XX")) {
			this.id = 50 ;
		} else {
			throw new FormatPieceException(5, "non tuyauCroix");
		}
	}

	@Override
	public void rotation() throws FormatPieceException {
		switch (this.id) {
		case 50:
			break ;
		default:
			throw new FormatPieceException(5, "non tuyauCroix");
		}
	}
	
	@Override
	public void setDefaultCoordonneesVoisins() throws FormatPieceException {
		switch (this.id) {
		case 50:
			Position voisinHaut = new Position(super.ordonnee-1, super.abscisse);
			Position voisinDroite = new Position(super.ordonnee, super.abscisse+1);
			Position voisinBas = new Position(super.ordonnee+1, super.abscisse);
			Position voisinGauche = new Position(super.ordonnee, super.abscisse-1);
			super.coordonneesVoisins.add(voisinHaut);
			super.coordonneesVoisins.add(voisinDroite);
			super.coordonneesVoisins.add(voisinBas);
			super.coordonneesVoisins.add(voisinGauche);
			break;
		default:
			throw new FormatPieceException(5, "non tuyauCroix");
		}
	}
}
