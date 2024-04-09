package InterfazGráficaAvanzada;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Multiplicidaddeventanas {
    public static void main(String[] args) {
        // Crear una instancia de la clase
        new Multiplicidaddeventanas();
    }

    public Multiplicidaddeventanas() {
        // Crear un nuevo JFrame
        JFrame frame = new JFrame("Multiplicidad de Ventanas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Crear un botón para abrir nuevas ventanas
        JButton openButton = new JButton("Abrir Nueva Ventana");
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear una nueva instancia de JFrame para representar una nueva ventana
                JFrame newFrame = new JFrame("Nueva Ventana");
                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cerrar solo esta ventana
                newFrame.setSize(300, 200);
                newFrame.setLocationRelativeTo(frame); // Abrir la nueva ventana cerca de la ventana principal
                newFrame.setVisible(true);
            }
        });

        // Agregar el botón al JFrame principal
        frame.add(openButton);
        frame.setLayout(new java.awt.FlowLayout());

        // Mostrar el JFrame principal
        frame.setVisible(true);
    }
}
