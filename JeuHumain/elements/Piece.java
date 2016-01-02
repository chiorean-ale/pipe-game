package elements;

import java.util.ArrayList;

import exception.FormatPieceException;

public class Piece {

	// Type 2: Tuyau Droit
	// Type 3: Tuyau Angle
	// Type 4: Tuyau Triangle
	// Type 5: Tuyau Croix
	// Type 6: Tuyau Vide

	protected int abscisse ;
	protected int ordonnee ;
	protected boolean estAtteint ;
	protected String forme ;
	private int nbRotationsPossibles ;
	protected ArrayList<Position> coordonneesVoisins = new ArrayList<Position>() ;
	protected ArrayList<Piece> voisinsPossibles = new ArrayList<Piece>();
	protected ArrayList<Piece> voisinsReels = new ArrayList<Piece>();

	private ArrayList<Position> positionVoisinsIA = new ArrayList<Position>();
	private ArrayList<Piece> voisinsIA = new ArrayList<Piece>();


	public Piece(int ordonnee, int abscisse, boolean estAtteint, String forme, int nbRotationsPossibles) {
		this.abscisse = abscisse ;
		this.ordonnee = ordonnee ;
		this.estAtteint = estAtteint ;
		this.forme = forme ;
		this.nbRotationsPossibles = nbRotationsPossibles;

		this.setVoisinsIA();
	}

	public ArrayList<Position> getPositionVoisinsIA() {
		return this.positionVoisinsIA;
	}

	public ArrayList<Piece> getVoisinsIA() {
		return this.voisinsIA;
	}

	public void setVoisinsIA() {
		Position voisinHaut = new Position(this.ordonnee-1, this.abscisse);
		Position voisinDroite = new Position(this.ordonnee, this.abscisse+1);
		Position voisinBas = new Position(this.ordonnee+1, this.abscisse);
		Position voisinGauche = new Position(this.ordonnee, this.abscisse-1);
		this.positionVoisinsIA.add(voisinHaut);
		this.positionVoisinsIA.add(voisinDroite);
		this.positionVoisinsIA.add(voisinBas);
		this.positionVoisinsIA.add(voisinGauche);
	}

	public int getNbRotationPossibles() {
		return this.nbRotationsPossibles;
	}

	public void setEstAtteint() {
		this.estAtteint = true;
		if (this.voisinsReels == null) {
			return;
		} else if (this.getForme().equals("GG")) {
			return ;
		} else {
			Piece[] voisinsArray = this.voisinsReels.toArray(new Piece[this.voisinsReels.size()]);
			for (int indPosition=0 ; indPosition<voisinsArray.length ; indPosition++) {
				if (voisinsArray[indPosition].estAtteint) {
					continue ;
				} else {
					voisinsArray[indPosition].setEstAtteint();
				}
			}
		}
	}
	
	public void viderVoisins() {
		this.coordonneesVoisins = new ArrayList<Position>() ;
		this.voisinsPossibles = new ArrayList<Piece>();
		this.voisinsReels = new ArrayList<Piece>();
		
	}

	public ArrayList<Position> getCoordonneesVoisins() {
		return this.coordonneesVoisins;
	}

	public boolean getEstAtteint() {
		return estAtteint ;
	}

	public String getForme() {
		return this.forme;
	}

	public ArrayList getVoisinsReels() throws FormatPieceException {
		return this.voisinsReels;
	}
	
	public ArrayList getVoisinsPossibles() throws FormatPieceException {
		return this.voisinsPossibles;
	}

	public void rotation() throws FormatPieceException {		
	}

	public void setDefaultCoordonneesVoisins() throws FormatPieceException {
	}
	
}
