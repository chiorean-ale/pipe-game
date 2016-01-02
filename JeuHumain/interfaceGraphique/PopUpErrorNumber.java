package interfaceGraphique;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PopUpErrorNumber extends JDialog implements MouseListener{
    private JLabel description ;
    private JButton recommencerButton ;

    public PopUpErrorNumber(int nbButs ) {
        this.description = new JLabel("Réponse non conforme (<1 ou >" + nbButs + ")");
        this.recommencerButton = new JButton("Recommencer");

        this.setTitle("ERROR - Configuration IA");
        this.setSize(new Dimension(325, 70));
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);

        this.setLayout(new BorderLayout());

        this.recommencerButton.addMouseListener(this);

        this.add(this.description, BorderLayout.NORTH);
        this.add(this.recommencerButton, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        SwingUtilities.windowForComponent((Component)mouseEvent.getSource()).dispose();
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

