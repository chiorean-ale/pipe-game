package interfaceGraphique;

import elements.Plateau;

import javax.swing.*;
import java.awt.*;

public class PanneauScore extends JPanel {
    private Plateau plateau;
    private JLabel scoreBox ;
    private JButton startArtificialIntelligenceButton ;
    private JButton saveButton ;

    public PanneauScore(Plateau plateau) {

        super();
        this.setBackground(Color.GRAY);

        this.plateau = plateau;
        this.scoreBox = new JLabel();
        this.scoreBox.setFont(new Font("Verdana", 1, 20));
        this.majScoreBox();

        this.saveButton = new JButton("Sauvegarder partie");
        this.startArtificialIntelligenceButton = new JButton("Utiliser IA");

        this.setLayout(new GridBagLayout());
        this.add(this.saveButton);
        this.add(this.scoreBox);
        this.add(this.startArtificialIntelligenceButton);

    }

    public JButton getSaveButton() {
        return this.saveButton;
    }

    public JButton getStartArtificialIntelligenceButton() {
        return this.startArtificialIntelligenceButton;
    }

    public void majScoreBox() {
        this.scoreBox.setText("    SCORE: " + this.plateau.getNbButsAtteints() + " / " + this.plateau.getNbButs() + "    ");
    }

}
