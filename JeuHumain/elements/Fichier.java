package elements;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fichier {

	private int nbLigne ;
	private int nbColonne ;
	private String cheminFichierOut ;

	public Fichier(String cheminFichierIn) throws IOException {
		
		BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(new FileInputStream(cheminFichierIn)));
		
		String nomFichier = cheminFichierIn.substring(0,cheminFichierIn.indexOf('.'));
		String extensionFichier = cheminFichierIn.substring(cheminFichierIn.lastIndexOf("."));
		
		String cheminFichierOut = nomFichier + "[EDIT]" + extensionFichier ;
		this.cheminFichierOut = cheminFichierOut;
		File fichierOut = new File(cheminFichierOut);
		FileWriter fichierOutEditable = new FileWriter(fichierOut);

		this.nbLigne = Integer.parseInt(bufferedreader.readLine()); 
		this.nbColonne = Integer.parseInt(bufferedreader.readLine());

		while (true) {
			String str = bufferedreader.readLine();
			if (str == null) {
				break;
			} else {
				String[] tableauMots = str.split(" ");
				for (String elt : tableauMots){
					fichierOutEditable.write(elt + "\n");
				}
			}
		}
		fichierOutEditable.close();
		bufferedreader.close();
	}

	public int getNbLigne() {
		return this.nbLigne;
	}
	
	public int getNbColonne() {
		return this.nbColonne;
	}
	
	public String getCheminFichierOut() {
		return this.cheminFichierOut;
	}
}
