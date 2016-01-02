import java.io.IOException;
import exception.FormatFichierException;
import exception.FormatPieceException;

import elements.Jeu;


public class Main {

	public static void main(String[] args) throws IOException, FormatPieceException, FormatFichierException {
		new Jeu("fichier.txt");
	}
}
