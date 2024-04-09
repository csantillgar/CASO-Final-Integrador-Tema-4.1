package InterfazGráficaAvanzada;

import javax.swing.*;
import java.awt.event.*;

public class Seguimientodelraton extends JFrame {
    private JLabel coordinatesLabel;

    public Seguimientodelraton() {
        setTitle("Seguimiento del Ratón");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        coordinatesLabel = new JLabel();
        addMouseListener(new MouseHandler());

        JPanel panel = new JPanel();
        panel.add(coordinatesLabel);
        add(panel);

        setVisible(true);
    }

    private class MouseHandler extends MouseAdapter {
        @Override
        public void mouseMoved(MouseEvent e) {
            updateCoordinates(e.getX(), e.getY());
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            updateCoordinates(e.getX(), e.getY());
        }

        private void updateCoordinates(int x, int y) {
            coordinatesLabel.setText("Coordenadas: (" + x + ", " + y + ")");
        }
    }

    public static void main(String[] args) {
        new Seguimientodelraton();
    }
}
