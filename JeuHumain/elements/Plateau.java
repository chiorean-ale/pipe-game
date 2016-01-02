package elements;


import java.io.*;
import java.util.ArrayList;

import exception.FormatFichierException;
import exception.FormatPieceException;

public class Plateau {
	private int nbLigne ;
	private int nbColonne ;
	private Piece[][] grille;
	private int nbButs =0;
	private int nbButsAtteints;
	private String cheminFichierOut;

	public Plateau (int nbLigne, int nbColonne, String cheminFichier) throws IOException, FormatPieceException, FormatFichierException {
		this.nbLigne = nbLigne ;
		this.nbColonne = nbColonne ;
		String nomFichier = cheminFichier.substring(0,cheminFichier.indexOf('['));
		String extensionFichier = cheminFichier.substring(cheminFichier.lastIndexOf("."));
		this.cheminFichierOut = nomFichier + "[UPDATED]" + extensionFichier ;
		this.grille = new Piece[this.nbLigne][this.nbColonne] ;
		this.remplirPlateau(cheminFichier);
	}

	public void afficherPlateau() {
		for (int indLigne=0 ; indLigne<this.nbLigne ; indLigne++) {
			for (int indColonne=0 ; indColonne<this.nbColonne ; indColonne++) {
				System.out.print(this.grille[indLigne][indColonne].getForme() + " ");
			}
			System.out.println();}
	}

	public void voirVoisinsPossibles() {
		for (int indLigne=0 ; indLigne<this.nbLigne ; indLigne++) {
			for (int indColonne=0 ; indColonne<this.nbColonne ; indColonne++) {
				if (this.grille[indLigne][indColonne].voisinsPossibles == null) {
					continue ;
				} else {
					Piece[] voisinsPossibleArray = this.grille[indLigne][indColonne].voisinsPossibles.toArray(new Piece[this.grille[indLigne][indColonne].voisinsPossibles.size()]);
					for (int indPosition=0 ; indPosition<voisinsPossibleArray.length ; indPosition++) {
						System.out.println(this.grille[indLigne][indColonne]);
						System.out.println(this.grille[indLigne][indColonne].estAtteint);
						System.out.println("Lig: " + indLigne);
						System.out.println("Col: " + indColonne);

						System.out.println();

						System.out.println(this.grille[voisinsPossibleArray[indPosition].ordonnee][voisinsPossibleArray[indPosition].abscisse]);
						System.out.println(this.grille[voisinsPossibleArray[indPosition].ordonnee][voisinsPossibleArray[indPosition].abscisse].estAtteint);
						System.out.println("Ord: "+ voisinsPossibleArray[indPosition].ordonnee);
						System.out.println("Abs: " + voisinsPossibleArray[indPosition].abscisse);

						System.out.println("---------------------------");

					}
					System.out.println("---------------------------");
				}
			}
		}
	}

	public void voirVoisinsReels() {
		for (int indLigne=0 ; indLigne<this.nbLigne ; indLigne++) {
			for (int indColonne=0 ; indColonne<this.nbColonne ; indColonne++) {
				if (this.grille[indLigne][indColonne].voisinsReels == null) {
					continue ;
				} else {
					Piece[] voisinsReelsArray = this.grille[indLigne][indColonne].voisinsReels.toArray(new Piece[this.grille[indLigne][indColonne].voisinsReels.size()]);
					for (int indPosition=0 ; indPosition<voisinsReelsArray.length ; indPosition++) {
						System.out.println(this.grille[indLigne][indColonne]);
						System.out.println(this.grille[indLigne][indColonne].estAtteint);
						System.out.println("Lig: " + indLigne);
						System.out.println("Col: " + indColonne);

						System.out.println();

						System.out.println(this.grille[voisinsReelsArray[indPosition].ordonnee][voisinsReelsArray[indPosition].abscisse]);
						System.out.println(this.grille[voisinsReelsArray[indPosition].ordonnee][voisinsReelsArray[indPosition].abscisse].estAtteint);
						System.out.println("Ord: "+ voisinsReelsArray[indPosition].ordonnee);
						System.out.println("Abs: " + voisinsReelsArray[indPosition].abscisse);

						System.out.println("---------------------------");

					}
					System.out.println("---------------------------");
				}
			}
		}
	}

	public Piece getSource() {
		Piece source = this.grille[0][0];
		for (int indLigne=0 ; indLigne<this.nbLigne ; indLigne++) {
			for (int indColonne=0 ; indColonne<this.nbColonne ; indColonne++) {
				if (this.grille[indLigne][indColonne].forme == "SO") {
					source = this.grille[indLigne][indColonne];
				}
			}
		}
		return source ;
	}

	public int getNbButs() {
		return this.nbButs;
	}

	public int getNbButsAtteints() {
		return this.nbButsAtteints;
	}

	public int getNbLigne() {
		return this.nbLigne;
	}

	public int getNbColonne() {
		return this.nbColonne;
	}

	public Piece[][] getGrille() {
		return this.grille;
	}

	public void remplirPlateau(String cheminFichier) throws IOException, FormatPieceException, FormatFichierException {
		BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(new FileInputStream(cheminFichier)));
		for (int indLigne=0 ; indLigne<this.nbLigne ; indLigne++) {
			for (int indColonne=0 ; indColonne<this.nbColonne ; indColonne++) {
				String str = bufferedreader.readLine();
				if (str == null) {
					throw new FormatFichierException(102, "tailles non valides");
				} else if (str.equals("SO")) {
					this.grille[indLigne][indColonne] = new Source(indLigne, indColonne, str);
				} else if (str.equals("GG")) {
					this.grille[indLigne][indColonne] = new But(indLigne, indColonne, str);
					this.nbButs += 1;
				} else if (str.equals("DH") || str.equals("DV")) {
					this.grille[indLigne][indColonne] = new TuyauDroit(indLigne, indColonne, str);
				} else if (str.equals("HD") || str.equals("DB") || str.equals("BG") || str.equals("GH")) {
					this.grille[indLigne][indColonne] = new TuyauAngle(indLigne, indColonne, str);
				} else if (str.equals("TH") || str.equals("TD") || str.equals("TB") || str.equals("TG")) {
					this.grille[indLigne][indColonne] = new TuyauTriangle(indLigne, indColonne, str);
				} else if (str.equals("XX")) {
					this.grille[indLigne][indColonne] = new TuyauCroix(indLigne, indColonne, str);
				} else if (str.equals("OO")) {
					this.grille[indLigne][indColonne] = new TuyauRien(indLigne, indColonne, str);
				} else {
					throw new FormatFichierException(101, "fichier non conforme");
				}
			}
		}
		bufferedreader.close();
		for (int indLigne=0 ; indLigne<this.nbLigne ; indLigne++) {
			for (int indColonne=0 ; indColonne<this.nbColonne ; indColonne++) {
				this.grille[indLigne][indColonne].setDefaultCoordonneesVoisins();
			}
		}
		this.setVoisinsPossibles();
		this.setVoisinsReels();
		this.definirFlux();

		for (int indLigne=0 ; indLigne<this.nbLigne ; indLigne++) {
			for (int indColonne=0 ; indColonne<this.nbColonne ; indColonne++) {
				if (this.grille[indLigne][indColonne].forme == "GG") {
					this.nbButs++;
				}
			}
		}
		this.setNbButsAtteints();
	}

	public void enregistrer() throws IOException {

		FileWriter fichierOut = new FileWriter (this.cheminFichierOut);
		fichierOut.write(this.nbLigne + "\n");
		fichierOut.write(this.nbColonne + "\n");
		for (int indLigne=0 ; indLigne<this.nbLigne; indLigne++) {
			for (int indColonne=0 ; indColonne<this.nbColonne-1 ; indColonne++) {
				fichierOut.write(this.grille[indLigne][indColonne].forme + " ");
			}
			fichierOut.write(this.grille[indLigne][this.nbColonne-1].forme + "\n");
		}
		fichierOut.close();
	}

	public void setNbButsAtteints() {
		this.nbButsAtteints =0;
		for (int indLigne=0 ; indLigne<this.nbLigne ; indLigne++) {
			for (int indColonne = 0; indColonne < this.nbColonne ; indColonne++) {
				if (this.grille[indLigne][indColonne].getEstAtteint() && this.grille[indLigne][indColonne].getForme().equals("GG")) {
					this.nbButsAtteints += 1;
				}
			}
		}
	}

	public void setVoisinsIA() {
		for (int indLigne=0 ; indLigne<this.nbLigne ; indLigne++) {
			for (int indColonne=0 ; indColonne<this.nbColonne ; indColonne++) {
				this.setVoisinsIAVerificationIndice(indLigne, indColonne);
			}
		}
	}

	public void setVoisinsIAVerificationIndice(int ordonnee, int abscisse) {
		ArrayList<Position> coordonneesVoisinsIA = this.grille[ordonnee][abscisse].getPositionVoisinsIA();
		if (coordonneesVoisinsIA == null) {
			return;
		} else {
			Position[] coordonneesVoisinsIAArray = coordonneesVoisinsIA.toArray(new Position[coordonneesVoisinsIA.size()]);
			for (int indPosition=0 ; indPosition<coordonneesVoisinsIAArray.length ; indPosition++) {
				if (coordonneesVoisinsIAArray[indPosition].getAbscisse()<0 || coordonneesVoisinsIAArray[indPosition].getAbscisse()>=this.nbColonne ||
						coordonneesVoisinsIAArray[indPosition].getOrdonnee()<0 || coordonneesVoisinsIAArray[indPosition].getOrdonnee()>=this.nbLigne) {
					this.grille[ordonnee][abscisse].getVoisinsIA().remove(coordonneesVoisinsIAArray[indPosition]);
				} else {
					this.grille[ordonnee][abscisse].getVoisinsIA().add(this.grille[coordonneesVoisinsIAArray[indPosition].getOrdonnee()][coordonneesVoisinsIAArray[indPosition].getAbscisse()]);
				}
			}
		}
	}

	public void setVoisinsPossibles() throws FormatPieceException {
		for (int indLigne=0 ; indLigne<this.nbLigne ; indLigne++) {
			for (int indColonne=0 ; indColonne<this.nbColonne ; indColonne++) {
				this.setVoisinsPossiblesVerificationIndice(indLigne, indColonne);
			}
		}
	}

	public void setVoisinsPossiblesVerificationIndice(int ordonnee, int abscisse) throws FormatPieceException {
		ArrayList<Position> coordonneesVoisins = this.grille[ordonnee][abscisse].getCoordonneesVoisins();
		if (coordonneesVoisins == null) {
			return;
		} else {
			Position[] coordonneesVoisinsArray = coordonneesVoisins.toArray(new Position[coordonneesVoisins.size()]);
			for (int indPosition=0 ; indPosition<coordonneesVoisinsArray.length ; indPosition++) {
				if (coordonneesVoisinsArray[indPosition].getAbscisse()<0 || coordonneesVoisinsArray[indPosition].getAbscisse()>=this.nbColonne ||
						coordonneesVoisinsArray[indPosition].getOrdonnee()<0 || coordonneesVoisinsArray[indPosition].getOrdonnee()>=this.nbLigne) {
					this.grille[ordonnee][abscisse].getCoordonneesVoisins().remove(coordonneesVoisinsArray[indPosition]);
				} else {						
					this.grille[ordonnee][abscisse].getVoisinsPossibles().add(this.grille[coordonneesVoisinsArray[indPosition].getOrdonnee()][coordonneesVoisinsArray[indPosition].getAbscisse()]);
				}
			}
		}
	}

	public void setVoisinsReels() throws FormatPieceException {
		for (int indLigne=0 ; indLigne<this.nbLigne ; indLigne++) {
			for (int indColonne=0 ; indColonne<this.nbColonne ; indColonne++) {
				this.setVoisinsReelsPiece(indLigne, indColonne);
			}
		}
	}

	public void setVoisinsReelsPiece(int ordonnee, int abscisse) {
		if (this.grille[ordonnee][abscisse].voisinsPossibles == null) {
			return;
		} else {
			Piece[] voisinsPossiblesArray = this.grille[ordonnee][abscisse].voisinsPossibles.toArray(new Piece[this.grille[ordonnee][abscisse].voisinsPossibles.size()]);
			for (int indPosition=0 ; indPosition<voisinsPossiblesArray.length ; indPosition++) {
				if (voisinsPossiblesArray[indPosition].voisinsPossibles.contains(this.grille[ordonnee][abscisse])) {
					this.setVoisinsReelsPieceCreateLink(ordonnee, abscisse, voisinsPossiblesArray, indPosition);
				} else {						
				}
			}
		}		
	}
	
	public void setVoisinsReelsPieceCreateLink(int ordonnee, int abscisse, Piece[] voisinsPossiblesArray, int indPosition) {
		if (this.grille[ordonnee][abscisse].voisinsReels.contains(voisinsPossiblesArray[indPosition]) &&
				voisinsPossiblesArray[indPosition].voisinsReels.contains(this.grille[ordonnee][abscisse])) {
			return ;
		} else if (this.grille[ordonnee][abscisse].voisinsReels.contains(voisinsPossiblesArray[indPosition])) {
			voisinsPossiblesArray[indPosition].voisinsReels.add(this.grille[ordonnee][abscisse]);
		} else {
			this.grille[ordonnee][abscisse].voisinsReels.add(voisinsPossiblesArray[indPosition]);
		}
	}

	public void rafraichir() throws FormatPieceException, IOException {
		for (int indLigne=0 ; indLigne<this.nbLigne ; indLigne++) {
			for (int indColonne=0 ; indColonne<this.nbColonne ; indColonne++) {
				this.grille[indLigne][indColonne].viderVoisins();
			}
		}
		
		for (int indLigne=0 ; indLigne<this.nbLigne ; indLigne++) {
			for (int indColonne=0 ; indColonne<this.nbColonne ; indColonne++) {
				this.grille[indLigne][indColonne].setDefaultCoordonneesVoisins();
			}
		}
		this.setVoisinsPossibles() ;
		this.setVoisinsReels();
		this.definirFlux();
		this.setNbButsAtteints();

	}

	public void definirFlux() {
		for (int indLigne=0 ; indLigne<this.nbLigne ; indLigne++) {
			for (int indColonne=0 ; indColonne<this.nbColonne ; indColonne++) {
				this.grille[indLigne][indColonne].estAtteint = false;
			}
		}
		this.getSource().setEstAtteint();
	}

}