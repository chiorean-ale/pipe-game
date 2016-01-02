package interfaceGraphique;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JFrame;

import elements.Plateau;
import exception.FormatPieceException;

public class FenetreSolution extends JFrame {
    private PanneauJeu panneauJeu;
    private final Plateau plateau ;
    private int tailleFenetre ;

    public FenetreSolution(Plateau plateau, int tailleFenetre) {
        this.plateau = plateau;
        this.tailleFenetre = tailleFenetre;

        this.setTitle("Jeu des Tuyaux");
        this.setSize(new Dimension(this.tailleFenetre, this.tailleFenetre + 22)); // 22px: barre de menu
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.setLayout(new BorderLayout());

        this.panneauJeu = new PanneauJeu(this.plateau, this.tailleFenetre);

        this.panneauJeu.setPreferredSize(new Dimension(this.tailleFenetre, this.tailleFenetre));

        this.add(this.panneauJeu, BorderLayout.NORTH);

        this.pack();
        this.setVisible(true);

    }

}
