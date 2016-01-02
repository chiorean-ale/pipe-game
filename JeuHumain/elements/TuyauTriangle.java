package elements;

import exception.FormatPieceException;

public class TuyauTriangle extends Piece {
	private int id ;

	// id: 40 forme "TH"
	// id: 41 forme "TD"
	// id: 42 forme "TB"
	// id: 43 forme "TG"
	
	public int getId() {
		return this.id;
	}
	
	public TuyauTriangle (int abscisse, int ordonnee, String forme) throws FormatPieceException {
		super(abscisse, ordonnee, false, forme, 4) ;
		this.setId(forme);
	}

	public void setId(String forme) throws FormatPieceException {
		if (forme.equals("TH")) {		// triangle Gauche-Haut-Droit
			this.id = 40 ;
		} else if (forme.equals("TD")) { // triangle Haut-Droit-Bas
			this.id = 41 ;
		} else if (forme.equals("TB")) { // triangle Gauche-Bas-Droite
			this.id = 42 ;
		} else if (forme.equals("TG")) {	// triangle Haut-Gauche-Bas
			this.id = 43 ;
		} else {
			throw new FormatPieceException(4, "non tuyauTriangle");
		}
	}
	
	
	@Override
	public void rotation() throws FormatPieceException {
		switch (this.id) {
		case 40:
			this.id = 41 ;
			super.forme = "TD";
			break ;
		case 41:
			this.id = 42 ;
			super.forme = "TB";
			break ;
		case 42:
			this.id = 43 ;
			super.forme = "TG";
			break;
		case 43:
			this.id = 40 ;
			super.forme = "TH";
			break;
		default:
			throw new FormatPieceException(4, "non tuyauTriangle");
		}
		this.setDefaultCoordonneesVoisins();
	}

	@Override
	public void setDefaultCoordonneesVoisins() throws FormatPieceException {
		switch (this.id) {
		case 40:
			Position triangleHautVoisinHaut = new Position(super.ordonnee-1, super.abscisse);
			Position triangleHautVoisinDroite = new Position(super.ordonnee, super.abscisse+1);
			Position triangleHautVoisinGauche = new Position(super.ordonnee, super.abscisse-1);
			super.coordonneesVoisins.add(triangleHautVoisinHaut);
			super.coordonneesVoisins.add(triangleHautVoisinDroite);
			super.coordonneesVoisins.add(triangleHautVoisinGauche);
			break ;
		case 41:
			Position triangleDroiteVoisinHaut = new Position(super.ordonnee-1, super.abscisse);
			Position triangleDroiteVoisinDroite = new Position(super.ordonnee, super.abscisse+1);
			Position triangleDroiteVoisinBas = new Position(super.ordonnee+1, super.abscisse);
			super.coordonneesVoisins.add(triangleDroiteVoisinHaut);
			super.coordonneesVoisins.add(triangleDroiteVoisinDroite);
			super.coordonneesVoisins.add(triangleDroiteVoisinBas);
			break ;
		case 42 :
			Position triangleBasVoisinDroite = new Position(super.ordonnee, super.abscisse+1);
			Position triangleBasVoisinBas = new Position(super.ordonnee+1, super.abscisse);
			Position triangleBasVoisinGauche = new Position(super.ordonnee, super.abscisse-1);
			super.coordonneesVoisins.add(triangleBasVoisinDroite);
			super.coordonneesVoisins.add(triangleBasVoisinBas);
			super.coordonneesVoisins.add(triangleBasVoisinGauche);
			break ;
		case 43 :
			Position triangleGaucheVoisinHaut = new Position(super.ordonnee-1, super.abscisse);
			Position triangleGaucheVoisinBas = new Position(super.ordonnee+1, super.abscisse);
			Position triangleGaucheVoisinGauche = new Position(super.ordonnee, super.abscisse-1);
			super.coordonneesVoisins.add(triangleGaucheVoisinHaut);
			super.coordonneesVoisins.add(triangleGaucheVoisinBas);
			super.coordonneesVoisins.add(triangleGaucheVoisinGauche);
			break ;
		default:
			throw new FormatPieceException(4, "non tuyauTriangle");
		}
	}
}
