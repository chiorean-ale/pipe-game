package intelligenceArtificielle;

import elements.Piece;
import elements.Plateau;
import exception.FormatPieceException;
import interfaceGraphique.FenetreSolution;
import interfaceGraphique.PopUpNoAnswer;

import java.io.IOException;
import java.util.ArrayList;


public class ResoudreIA {
    private Plateau plateau ;
    private int nbButsAttendus ;
    private ArrayList<Piece> voisinsProfondeur;
    private Boolean solutionObtenue ;

    public ResoudreIA(int nbButsAttendus, Plateau plateau ) throws FormatPieceException, IOException {
        this.nbButsAttendus = nbButsAttendus;
        this.plateau = plateau;
        this.solutionObtenue = false;
        this.plateau.setVoisinsIA();
        this.resoudreIA();
    }

    public void resoudreIA() throws FormatPieceException, IOException {
        int profondeur = 0 ;
        while (!this.solutionObtenue && this.majVoisinsProfondeur()) {
            profondeur ++ ;
            System.out.println("Recherche profondeur: " + profondeur + " ...");
            this.rechercheProfondeur(0);
        }
        if (this.solutionObtenue) {
            this.afficherReponse();
        } else {
            this.afficherNoAnswer();
        }
    }

    public void rechercheProfondeur(int indicePieceToTest) throws FormatPieceException, IOException {
        if (this.solutionObtenue) {
            return;
        } else {
            if (indicePieceToTest == this.voisinsProfondeur.size()) {
                return;
            } else {
                int nbRotation =0 ;
                while (!this.solutionObtenue && nbRotation<this.voisinsProfondeur.get(indicePieceToTest).getNbRotationPossibles()) {
                    this.tournePiece(this.voisinsProfondeur.get(indicePieceToTest));
                    if (resultatAttendu()) {
                        this.solutionObtenue = true;
                        break ;
                    } else {
                        this.rechercheProfondeur(indicePieceToTest + 1);
                    }
                    nbRotation++;
                }
            }
        }

    }

    public Boolean majVoisinsProfondeur() throws FormatPieceException {
        Boolean nouvellePiece = false ;
        if (this.voisinsProfondeur == null && this.plateau.getSource().getVoisinsIA() == null) {
            return false;
        } else if (this.voisinsProfondeur == null) {
            this.voisinsProfondeur = this.plateau.getSource().getVoisinsIA();
            return true;
        } else {
            for (Piece voisin : this.voisinsProfondeur.toArray(new Piece[this.voisinsProfondeur.size()])) {
                for (Piece voisinDeVoisin : voisin.getVoisinsIA().toArray(new Piece[voisin.getVoisinsIA().size()])) {
                    if (this.voisinsProfondeur.contains(voisinDeVoisin)) {
                        continue;
                    } else {
                        this.voisinsProfondeur.add(voisinDeVoisin);
                        nouvellePiece = true;
                    }
                }
            }
            return nouvellePiece;
        }
    }

    public void tournePiece(Piece piece) throws FormatPieceException, IOException {
        piece.rotation();
        this.plateau.rafraichir();
    }

    public Boolean resultatAttendu() {
        return (this.nbButsAttendus <= this.plateau.getNbButsAtteints());
    }

    public void afficherNoAnswer() {
        new PopUpNoAnswer(this.nbButsAttendus, this.plateau);
    }

    public void afficherReponse() {
        new FenetreSolution(this.plateau, 700);
    }
}
