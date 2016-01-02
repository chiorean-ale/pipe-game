package interfaceGraphique;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JFrame;

import elements.Plateau;
import exception.FormatPieceException;

public class FenetreJeu extends JFrame {
	private PanneauJeu panneauJeu;
	private PanneauScore panneauScore;
	private final Plateau plateau ;
	private int tailleFenetre ;

	public FenetreJeu(Plateau plateau, int tailleFenetre) {
		this.plateau = plateau;
		this.tailleFenetre = tailleFenetre;

		this.setTitle("Jeu des Tuyaux");
		this.setSize(new Dimension(this.tailleFenetre, this.tailleFenetre + 22)); // 22px: barre de menu
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLayout(new BorderLayout());

		this.panneauJeu = new PanneauJeu(this.plateau, this.tailleFenetre);
		this.panneauScore = new PanneauScore(this.plateau);

		this.panneauJeu.setPreferredSize(new Dimension(this.tailleFenetre, this.tailleFenetre));
		this.panneauScore.setPreferredSize(new Dimension(this.tailleFenetre, 50));

		this.add(this.panneauJeu, BorderLayout.NORTH);
		this.add(this.panneauScore, BorderLayout.SOUTH);

		this.pack();
		this.setVisible(true);

		this.panneauJeu.addMouseListener(new PlateauListener());
		this.panneauScore.getSaveButton().addMouseListener(new SaveBoutonListener());
		this.panneauScore.getStartArtificialIntelligenceButton().addMouseListener((new StartArtificialIntelligenceListener()));

	}

	class PlateauListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent event) {
			int[] echelle = panneauJeu.getEchelleFenetre();
			int abscisseClic = event.getX();
			int ordonneeClic = event.getY();
			int indiceAbscisseClic = abscisseClic/echelle[0];
			int indiceOrdonneeClic = ordonneeClic/echelle[1];
			try {
				plateau.getGrille()[indiceOrdonneeClic][indiceAbscisseClic].rotation();
			} catch (FormatPieceException e) {
				e.printStackTrace();
			} finally {
				try {
					plateau.rafraichir();
					panneauScore.majScoreBox();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (FormatPieceException e) {
					e.printStackTrace();
				} finally {
					repaint();
				}
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
		}
	}

	class SaveBoutonListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent mouseEvent) {
			try {
				plateau.enregistrer();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void mousePressed(MouseEvent mouseEvent) {

		}

		@Override
		public void mouseReleased(MouseEvent mouseEvent) {

		}

		@Override
		public void mouseEntered(MouseEvent mouseEvent) {

		}

		@Override
		public void mouseExited(MouseEvent mouseEvent) {

		}
	}

	class StartArtificialIntelligenceListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent mouseEvent) {
			new PopUpStartIA(plateau.getNbButs(), plateau);

		}

		@Override
		public void mousePressed(MouseEvent mouseEvent) {

		}

		@Override
		public void mouseReleased(MouseEvent mouseEvent) {

		}

		@Override
		public void mouseEntered(MouseEvent mouseEvent) {

		}

		@Override
		public void mouseExited(MouseEvent mouseEvent) {

		}
	}
}
