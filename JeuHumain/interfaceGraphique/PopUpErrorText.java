package interfaceGraphique;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PopUpErrorText extends JDialog{
    private JLabel description ;
    private JButton recommencerButton ;

    public PopUpErrorText() {
        this.description = new JLabel("Réponse non conforme (non numérique)");
        this.recommencerButton = new JButton("Recommencer");

        this.setTitle("ERROR - Configuration IA");
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
}

