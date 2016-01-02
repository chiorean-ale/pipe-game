package elements;

import exception.FormatPieceException;

public class TuyauDroit extends Piece {

	private int id ;

	// id: 20 forme "DH"
	// id: 21 forme "DV"
	
	public int getId() {
		return this.id;
	}

	public TuyauDroit (int abscisse, int ordonnee, String forme) throws FormatPieceException {
		super(abscisse, ordonnee, false, forme, 2) ;
		this.setId(forme);
	}

	public void setId(String forme) throws FormatPieceException {
		if (forme.equals("DH")) {
			this.id = 20 ;
		} else if (forme.equals("DV")) {
			this.id = 21 ;
		} else {
			throw new FormatPieceException(2, "non tuyauDroit");
		}
	}

	@Override
	public void rotation() throws FormatPieceException {
		switch (this.id) {
		case 20:
			this.id = 21 ;
			super.forme = "DV";
			break ;
		case 21:
			this.id = 20 ;
			super.forme = "DH";
			break ;
		default:
			throw new FormatPieceException(2, "non tuyauDroit");
		}
		this.setDefaultCoordonneesVoisins();
	}
	
	@Override
	public void setDefaultCoordonneesVoisins() throws FormatPieceException {
		switch (this.id) {
		case 20:
			Position droitVerticalVoisinDroit = new Position(super.ordonnee, super.abscisse+1);
			Position droitVerticalVoisinGauche = new Position(super.ordonnee, super.abscisse-1);
			super.coordonneesVoisins.add(droitVerticalVoisinDroit);
			super.coordonneesVoisins.add(droitVerticalVoisinGauche);
			break ;
		case 21:
			Position droitHorizontalVoisinHaut = new Position(super.ordonnee-1, super.abscisse);
			Position droitHorizontalVoisinBas = new Position(super.ordonnee+1, super.abscisse);
			super.coordonneesVoisins.add(droitHorizontalVoisinHaut);
			super.coordonneesVoisins.add(droitHorizontalVoisinBas);
			break ;
		default:
			throw new FormatPieceException(2, "non tuyauDroit");
		}
	}

}
