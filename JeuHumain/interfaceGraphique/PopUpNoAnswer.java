package interfaceGraphique;


import elements.Plateau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PopUpNoAnswer extends JDialog{
    private int nbButsAttendus;
    private Plateau plateau ;
    private JLabel description ;
    private JButton recommencerButton ;

    public PopUpNoAnswer(int nbButsAttendus, Plateau plateau ) {
        this.nbButsAttendus = nbButsAttendus;
        this.plateau = plateau;
        this.description = new JLabel("Pas de solution trouvé pour: " + this.nbButsAttendus + " / " + this.plateau.getNbButs());
        this.recommencerButton = new JButton("Recommencer");

        this.setTitle("ERROR - Pas de solution");
        this.setSize(new Dimension(275, 70));
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);

        this.setLayout(new BorderLayout());

        this.recommencerButton.addMouseListener(new RecommencerButtonListener());

        this.add(this.description, BorderLayout.NORTH);
        this.add(this.recommencerButton, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    class RecommencerButtonListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            //TODO: fermer PopUpErrorText
            new PopUpStartIA(nbButsAttendus, plateau);
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