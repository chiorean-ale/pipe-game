package interfaceGraphique;


import elements.Plateau;
import exception.FormatPieceException;
import intelligenceArtificielle.ResoudreIA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.text.NumberFormat;

public class PopUpStartIA extends JDialog implements MouseListener {
    private int nbPuits ;
    private JLabel description ;
    private JFormattedTextField nbPuitsAttendus ;
    private JButton validerButton ;
    private Plateau plateau;

    public PopUpStartIA(int nbPuits, Plateau plateau ) {
        this.plateau = plateau;
        this.nbPuits = nbPuits;
        this.description = new JLabel("Nombre de puits MINI à atteindre: ( . / " + this.nbPuits + " )");
        this.validerButton = new JButton("Valider");
        this.nbPuitsAttendus = new JFormattedTextField(NumberFormat.getIntegerInstance());

        this.setTitle("Configuration IA");
        this.setSize(new Dimension(300, 100));
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);

        this.setLayout(new BorderLayout());

        this.nbPuitsAttendus.setFont(new Font("Verdana", 1, 12));

        this.validerButton.addMouseListener(this);

        this.add(this.description, BorderLayout.NORTH);
        this.add(this.nbPuitsAttendus, BorderLayout.CENTER);
        this.add(this.validerButton, BorderLayout.SOUTH);

        this.setVisible(true);


    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        try {
            int answer = Integer.parseInt(this.nbPuitsAttendus.getText());
            if (answer<1 || answer>this.nbPuits) {
                new PopUpErrorNumber(this.nbPuits);
            } else {
                SwingUtilities.windowForComponent((Component)mouseEvent.getSource()).dispose();
                new ResoudreIA(answer, plateau);
            }
        } catch (NumberFormatException e) {
            new PopUpErrorText();
        } catch (FormatPieceException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
