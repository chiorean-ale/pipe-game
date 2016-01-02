package interfaceGraphique;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import elements.Piece;
import elements.Plateau;

public class PanneauJeu extends JPanel {

	private Color colorPieceAtteinte = Color.BLUE ;
	private Color colorPieceNonAtteinte = Color.BLACK;
	private Color colorBut = Color.GRAY;
	private Color colorSource = Color.GRAY;
	private Plateau plateau ;
	private int tailleFenetre ;

	public PanneauJeu(Plateau plateau, int tailleFenetre) {
		super();
		this.plateau = plateau ;
		this.tailleFenetre = tailleFenetre ;


	}

	private int[] getMilieuCasePx(int abscisse, int ordonnee) {
		int[] milieu = new int[2];
		int[] echelle = this.getEchelleFenetre();
		milieu[0] = (2*abscisse+1)*echelle[0]/2 ;
		milieu[1] = (2*ordonnee+1)*echelle[1]/2 ;
		return milieu ;
	}

	public int[] getEchelleFenetre() {
		int[] echelle = new int[2];
		echelle[0] = this.tailleFenetre/this.plateau.getNbColonne();
		echelle[1] = this.tailleFenetre/this.plateau.getNbLigne();
		return echelle ;
	}



	public void paintComponent(Graphics graph) {
		graph.setColor(Color.WHITE);
		graph.fillRect(0, 0, this.getWidth(), this.getHeight());
	    
		for (int indLigne=0 ; indLigne<this.plateau.getNbLigne() ; indLigne++) {
			for (int indColonne=0 ; indColonne<this.plateau.getNbColonne() ; indColonne++) {
				this.dessinePiece(graph, this.plateau.getGrille()[indLigne][indColonne], indLigne, indColonne);
			}
		}				
	}

	private void setColor(Graphics graph, Piece piece) {
		if (piece.getEstAtteint()) {
			graph.setColor(this.colorPieceAtteinte);
		} else {
			graph.setColor(this.colorPieceNonAtteinte);
		}
	}

	private void dessinePiece(Graphics graph, Piece piece, int indLigne, int indColonne){
		if (piece.getForme().equals("SO")) {
			this.dessineSource(graph, piece, indLigne, indColonne) ;

		} else if (piece.getForme().equals("GG")) {
			this.dessineBut(graph, piece, indLigne, indColonne) ;

		} else if (piece.getForme().equals("DH")) {
			this.dessineTuyauDH(graph, piece, indLigne, indColonne) ;

		} else if (piece.getForme().equals("DV")) {
			this.dessineTuyauDV(graph, piece, indLigne, indColonne) ;

		} else if (piece.getForme().equals("HD")) {
			this.dessineTuyauHD(graph, piece, indLigne, indColonne) ;

		} else if (piece.getForme().equals("DB")) {
			this.dessineTuyauDB(graph, piece, indLigne, indColonne) ;

		} else if (piece.getForme().equals("BG")) {
			this.dessineTuyauBG(graph, piece, indLigne, indColonne) ;

		} else if (piece.getForme().equals("GH")) {
			this.dessineTuyauGH(graph, piece, indLigne, indColonne) ;

		} else if (piece.getForme().equals("TH")) {
			this.dessineTuyauTH(graph, piece, indLigne, indColonne) ;

		} else if (piece.getForme().equals("TD")) {
			this.dessineTuyauTD(graph, piece, indLigne, indColonne) ;

		} else if (piece.getForme().equals("TB")) {
			this.dessineTuyauTB(graph, piece, indLigne, indColonne) ;

		} else if (piece.getForme().equals("TG")) {
			this.dessineTuyauTG(graph, piece, indLigne, indColonne) ;

		} else if (piece.getForme().equals("XX")) {
			this.dessineTuyauXX(graph, piece, indLigne, indColonne) ;

		} else if (piece.getForme().equals("OO")) {
			this.dessineTuyauOO(graph, piece, indLigne, indColonne) ;
		}
	}



	private void dessineTuyauOO(Graphics graph, Piece piece, int indLigne, int indColonne) {
	}

	private void dessineTuyauXX(Graphics graph, Piece piece, int indLigne, int indColonne) {
		this.dessineTuyauGauche(graph, piece, indLigne, indColonne);
		this.dessineTuyauHaut(graph, piece, indLigne, indColonne);
		this.dessineTuyauDroite(graph, piece, indLigne, indColonne);
		this.dessineTuyauBas(graph, piece, indLigne, indColonne);
	}

	private void dessineTuyauTG(Graphics graph, Piece piece, int indLigne, int indColonne) {
		this.dessineTuyauGauche(graph, piece, indLigne, indColonne);
		this.dessineTuyauHaut(graph, piece, indLigne, indColonne);
		this.dessineTuyauBas(graph, piece, indLigne, indColonne);
	}

	private void dessineTuyauTB(Graphics graph, Piece piece, int indLigne, int indColonne) {
		this.dessineTuyauGauche(graph, piece, indLigne, indColonne);
		this.dessineTuyauDroite(graph, piece, indLigne, indColonne);
		this.dessineTuyauBas(graph, piece, indLigne, indColonne);
	}

	private void dessineTuyauTD(Graphics graph, Piece piece, int indLigne, int indColonne) {
		this.dessineTuyauHaut(graph, piece, indLigne, indColonne);
		this.dessineTuyauDroite(graph, piece, indLigne, indColonne);
		this.dessineTuyauBas(graph, piece, indLigne, indColonne);
	}

	private void dessineTuyauTH(Graphics graph, Piece piece, int indLigne, int indColonne) {
		this.dessineTuyauGauche(graph, piece, indLigne, indColonne);
		this.dessineTuyauHaut(graph, piece, indLigne, indColonne);
		this.dessineTuyauDroite(graph, piece, indLigne, indColonne);
	}

	private void dessineTuyauGH(Graphics graph, Piece piece, int indLigne, int indColonne) {
		this.dessineTuyauGauche(graph, piece, indLigne, indColonne);
		this.dessineTuyauHaut(graph, piece, indLigne, indColonne);
	}

	private void dessineTuyauBG(Graphics graph, Piece piece, int indLigne, int indColonne) {
		this.dessineTuyauGauche(graph, piece, indLigne, indColonne);
		this.dessineTuyauBas(graph, piece, indLigne, indColonne);
	}

	private void dessineTuyauDB(Graphics graph, Piece piece, int indLigne, int indColonne) {
		this.dessineTuyauDroite(graph, piece, indLigne, indColonne);
		this.dessineTuyauBas(graph, piece, indLigne, indColonne);
	}

	private void dessineTuyauHD(Graphics graph, Piece piece, int indLigne, int indColonne) {
		this.dessineTuyauHaut(graph, piece, indLigne, indColonne);
		this.dessineTuyauDroite(graph, piece, indLigne, indColonne);
	}

	private void dessineTuyauDH(Graphics graph, Piece piece, int indLigne, int indColonne) {
		this.dessineTuyauGauche(graph, piece, indLigne, indColonne);
		this.dessineTuyauDroite(graph, piece, indLigne, indColonne);
	}

	private void dessineTuyauDV(Graphics graph, Piece piece, int indLigne, int indColonne) {
		this.dessineTuyauHaut(graph, piece, indLigne, indColonne);
		this.dessineTuyauBas(graph, piece, indLigne, indColonne);
	}

	private void dessineBut(Graphics graph, Piece piece, int indLigne, int indColonne) {
		int[] milieu = this.getMilieuCasePx(indColonne, indLigne);
		int[] echelle = this.getEchelleFenetre();
		graph.setColor(this.colorBut);
		graph.fillRect(milieu[0]-2*echelle[0]/5, milieu[1]-2*echelle[1]/5, 4*echelle[0]/5, 4*echelle[1]/5);
		this.setColor(graph, piece);
		this.dessineTuyauGauche(graph, piece, indLigne, indColonne);
		this.dessineTuyauHaut(graph, piece, indLigne, indColonne);
		this.dessineTuyauDroite(graph, piece, indLigne, indColonne);
		this.dessineTuyauBas(graph, piece, indLigne, indColonne);	}

	private void dessineSource(Graphics graph, Piece piece, int indLigne, int indColonne) {
		int[] milieu = this.getMilieuCasePx(indColonne, indLigne);
		int[] echelle = this.getEchelleFenetre();
		graph.setColor(this.colorSource);
		graph.fillOval(milieu[0]-2*echelle[0]/5, milieu[1]-2*echelle[1]/5, 4*echelle[0]/5, 4*echelle[1]/5);
		this.setColor(graph, piece);
		this.dessineTuyauGauche(graph, piece, indLigne, indColonne);
		this.dessineTuyauHaut(graph, piece, indLigne, indColonne);
		this.dessineTuyauDroite(graph, piece, indLigne, indColonne);
		this.dessineTuyauBas(graph, piece, indLigne, indColonne);
		
	}

	private void dessineTuyauBas(Graphics graph, Piece piece, int indLigne, int indColonne) {
		int[] milieu = this.getMilieuCasePx(indColonne, indLigne);
		int[] echelle = this.getEchelleFenetre();
		this.setColor(graph, piece);
		graph.fillRect(milieu[0]-echelle[0]/6, milieu[1]-echelle[1]/6, 2*echelle[0]/6, 2*echelle[1]/3);
	}

	private void dessineTuyauHaut(Graphics graph, Piece piece, int indLigne, int indColonne) {
		int[] milieu = this.getMilieuCasePx(indColonne, indLigne);
		int[] echelle = this.getEchelleFenetre();
		this.setColor(graph, piece);
		graph.fillRect(milieu[0]-echelle[0]/6, milieu[1]-echelle[1]/2, 2*echelle[0]/6, 2*echelle[1]/3);
	}

	private void dessineTuyauDroite(Graphics graph, Piece piece, int indLigne, int indColonne) {
		int[] milieu = this.getMilieuCasePx(indColonne, indLigne);
		int[] echelle = this.getEchelleFenetre();
		this.setColor(graph, piece);
		graph.fillRect(milieu[0]-echelle[0]/6, milieu[1]-echelle[1]/6, 2*echelle[0]/3, 2*echelle[1]/6);
	}

	private void dessineTuyauGauche(Graphics graph, Piece piece, int indLigne, int indColonne) {
		int[] milieu = this.getMilieuCasePx(indColonne, indLigne);
		int[] echelle = this.getEchelleFenetre();
		this.setColor(graph, piece);
		graph.fillRect(milieu[0]-echelle[0]/2, milieu[1]-echelle[1]/6, 2*echelle[0]/3, 2*echelle[1]/6);

	}






}
