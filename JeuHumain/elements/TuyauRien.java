package elements;


import exception.FormatPieceException;

public class TuyauRien extends Piece {
	private int id ;

	// id: 60 forme "OO"
	
	public int getId() {
		return this.id;
	}

	public TuyauRien (int abscisse, int ordonnee, String forme) throws FormatPieceException {
		super(abscisse, ordonnee, false, forme, 1) ;
		this.setId(forme);
	}

	public void setId(String forme) throws FormatPieceException {
		if (forme.equals("OO")) {
			this.id = 60 ;
		} else {
			throw new FormatPieceException(6, "non tuyauVide");
		}
	}

	@Override
	public void rotation() throws FormatPieceException {
		switch (this.id) {
		case 60:
			break ;
		default:
			throw new FormatPieceException(6, "non tuyauVide");
		}
	}

	@Override
	public void setDefaultCoordonneesVoisins() throws FormatPieceException {
		super.coordonneesVoisins = null;
	}
}
