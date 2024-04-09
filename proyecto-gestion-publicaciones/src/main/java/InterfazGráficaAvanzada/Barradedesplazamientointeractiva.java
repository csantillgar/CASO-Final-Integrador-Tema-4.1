package InterfazGráficaAvanzada;

import javax.swing.*;
import java.awt.*;

public class Barradedesplazamientointeractiva extends JFrame {
    public Barradedesplazamientointeractiva() {
        // Configuración básica del JFrame
        setTitle("Barra de Desplazamiento Interactiva");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Crear un panel con GridLayout para agregar varios componentes
        JPanel panel = new JPanel(new GridLayout(10, 1));

        // Agregar etiquetas de ejemplo al panel
        for (int i = 1; i <= 10; i++) {
            JLabel label = new JLabel("Etiqueta " + i);
            panel.add(label);
        }

        // Agregar el panel a un JScrollPane para habilitar la barra de desplazamiento
        JScrollPane scrollPane = new JScrollPane(panel);

        // Agregar el JScrollPane al JFrame
        add(scrollPane);

        // Hacer visible el JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        // Crear una instancia de Barradedesplazamientointeractiva y mostrarla
        SwingUtilities.invokeLater(Barradedesplazamientointeractiva::new);
    }
}
