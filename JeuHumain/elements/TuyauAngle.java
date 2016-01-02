package elements;

import exception.FormatPieceException;

public class TuyauAngle extends Piece {
	private int id ;
	// id: 30 forme "HD"
	// id: 31 forme "DB"
	// id: 32 forme "BG"
	// id: 33 forme "GH"
	
	public int getId() {
		return this.id;
	}

	public TuyauAngle (int abscisse, int ordonnee, String forme) throws FormatPieceException {
		super(abscisse, ordonnee, false, forme, 4) ;
		this.setId(forme);
	}

	public void setId(String forme) throws FormatPieceException {
		if (forme.equals("HD")) {		// angle Haut-Droit
			this.id = 30 ;
		} else if (forme.equals("DB")) { // angle Droit-Bas
			this.id = 31 ;
		} else if (forme.equals("BG")) { // angle Bas-Gauche
			this.id = 32 ;
		} else if (forme.equals("GH")) {	// angle Gauche-Haut
			this.id = 33 ;
		} else {
			throw new FormatPieceException(3, "non tuyauAngle");
		}
	}

	@Override
	public void rotation() throws FormatPieceException {
		switch (this.id) {
		case 30:
			this.id = 31 ;
			super.forme = "DB";
			break ;
		case 31:
			this.id = 32 ;
			super.forme = "BG";
			break ;
		case 32:
			this.id = 33 ;
			super.forme = "GH";
			break ;
		case 33:
			this.id = 30 ;
			super.forme = "HD";
			break ;
		default:
			throw new FormatPieceException(3, "non tuyauAngle");
		}
		this.setDefaultCoordonneesVoisins();
	}

	@Override
	public void setDefaultCoordonneesVoisins() throws FormatPieceException {
		switch (this.id) {
		case 30:
			Position hautDroiteVoisinHaut = new Position(super.ordonnee-1, super.abscisse);
			Position hautDroiteVoisinDroite = new Position(super.ordonnee, super.abscisse+1);
			super.coordonneesVoisins.add(hautDroiteVoisinHaut);
			super.coordonneesVoisins.add(hautDroiteVoisinDroite);
			break ;
		case 31:
			Position droitBasVoisinDroite = new Position(super.ordonnee, super.abscisse+1);
			Position droitBasVoisinBas = new Position(super.ordonnee+1, super.abscisse);
			super.coordonneesVoisins.add(droitBasVoisinDroite);
			super.coordonneesVoisins.add(droitBasVoisinBas);
			break ;
		case 32 :
			Position basGaucheVoisinBas = new Position(super.ordonnee+1, super.abscisse);
			Position basGaucheVoisinGauche = new Position(super.ordonnee, super.abscisse-1);
			super.coordonneesVoisins.add(basGaucheVoisinBas);
			super.coordonneesVoisins.add(basGaucheVoisinGauche);
			break ;
		case 33 :
			Position gaucheHautVoisinHaut = new Position(super.ordonnee-1, super.abscisse);
			Position gaucheHautVoisinGauche = new Position(super.ordonnee, super.abscisse-1);
			super.coordonneesVoisins.add(gaucheHautVoisinHaut);
			super.coordonneesVoisins.add(gaucheHautVoisinGauche);
			break ;
		default:
			throw new FormatPieceException(3, "non tuyauAngle");
		}
	}
}
