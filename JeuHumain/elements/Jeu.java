package elements;

import java.io.IOException;

import exception.FormatFichierException;
import exception.FormatPieceException;
import interfaceGraphique.FenetreJeu;

public class Jeu {

	private Plateau plateau;
	private Fichier fichier;
	private FenetreJeu fenetreJeu;
	
	public Jeu(String cheminFichier) throws IOException, FormatPieceException, FormatFichierException {
		this.fichier = new Fichier(cheminFichier);
		this.plateau = new Plateau(this.fichier.getNbLigne(), this.fichier.getNbColonne(), this.fichier.getCheminFichierOut());
		this.fenetreJeu = new FenetreJeu(this.plateau, 700);
	}
}
