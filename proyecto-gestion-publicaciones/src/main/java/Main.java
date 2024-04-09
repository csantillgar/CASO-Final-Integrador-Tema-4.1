import ComparadoryContadordeContenido.Analisisdetexto;
import EditordeTextoInteractivo.Editordetexto;
import EditordeTextoInteractivo.NavegacionyListado;
import BúsquedadePalabrasyGestióndeContactos.Agendadecontactos;
import ValidacióndeEmailyDiseñoGráfico.ValidadordeEmail;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Agendadecontactos agenda = new Agendadecontactos(); // Instanciamos la agenda de contactos


        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Object[] options = {"Editar texto", "Analizar texto","Navegar y listar archivos", "Gestión de contactos","Validar email"};
                int n = JOptionPane.showOptionDialog(null,
                        "¿Qué quieres hacer?",
                        "Editor de Texto Interactivo",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);

                if (n == 0) {
                    JFrame frame = new JFrame("Editor de Texto Interactivo");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setSize(800, 600);
                    frame.setLayout(new BorderLayout());
                    frame.add(new Editordetexto(), BorderLayout.CENTER);
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                    frame.setResizable(true);
                } else if (n == 1) {
                    JFrame frame = new JFrame("Analizador de Texto");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setSize(800, 600);
                    frame.setLayout(new BorderLayout());
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                    frame.setResizable(true);
                    Analisisdetexto analisis = new Analisisdetexto();
                    File file1 = new File("ruta/al/archivo 1.txt");
                    try {
                        Map<String, Integer> wordCount = analisis.wordCount(file1);
                        System.out.println("Conteo de palabras: " + wordCount);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (n == 2) {
                    JFrame frame = new JFrame("Navegación y Listado de Documentos");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setSize(800, 600);
                    frame.setLayout(new BorderLayout());
                    Editordetexto editor = new Editordetexto();
                    frame.add(new NavegacionyListado(editor), BorderLayout.CENTER);
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                    frame.setResizable(true);
                } else if (n == 3) {
                    String email = JOptionPane.showInputDialog("Introduce una dirección de correo electrónico:");
                    boolean esValido = ValidadordeEmail.validarEmail(email);
                    if (esValido) {
                        JOptionPane.showMessageDialog(null, "El email ingresado es válido.", "Validación de Email", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "El email ingresado no es válido.", "Validación de Email", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (n == 4) {
                    // Gestión de contactos
                    gestionContactos(agenda);
                }
            }
        });

        Analisisdetexto analisis = new Analisisdetexto();
        File file1 = new File("java/archivostexto/archivo1.txt");
        File file2 = new File("java/archivostexto/archivo2.txt");
        try {
            boolean sonIguales = analisis.compararArchivos(file1, file2);
            System.out.println("Los archivos son iguales: " + sonIguales);
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file = new File("ruta/al/archivo.txt");
        try {
            Map<String, Integer> wordCount = analisis.wordCount(file);
            System.out.println("Conteo de palabras: " + wordCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] palabrasExcluidas = {"a", "de", "el", "la", "los", "las"};
        try {
            Map<String, Integer> wordCount = analisis.wordCount(file, palabrasExcluidas);
            System.out.println("Conteo de palabras excluyendo palabras comunes: " + wordCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void gestionContactos(Agendadecontactos agenda) {
        boolean continuar = true;
        while (continuar) {
            String[] opciones = {"Agregar contacto", "Buscar contacto", "Mostrar contactos", "Salir"};
            int opcion = JOptionPane.showOptionDialog(null,
                    "Selecciona una opción:",
                    "Gestión de Contactos",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);
            switch (opcion) {
                case 0:
                    agregarContacto(agenda);
                    break;
                case 1:
                    buscarContacto(agenda);
                    break;
                case 2:
                    mostrarContactos(agenda);
                    break;
                case 3:
                    continuar = false;
                    break;
                default:
                    break;
            }
        }
    }
    public static void agregarContacto(Agendadecontactos agenda) {
        String nombre = JOptionPane.showInputDialog("Introduce el nombre del contacto:");
        String telefono = JOptionPane.showInputDialog("Introduce el teléfono del contacto:");
        agenda.agregarContacto(nombre, telefono);
        JOptionPane.showMessageDialog(null, "Contacto agregado correctamente.");
    }
    public static void buscarContacto(Agendadecontactos agenda) {
        String nombreBuscar = JOptionPane.showInputDialog("Introduce el nombre del contacto a buscar:");
        String contactoEncontrado = String.valueOf(agenda.buscarContacto(nombreBuscar));
        if (!contactoEncontrado.equals("Contacto no encontrado")) {
            JOptionPane.showMessageDialog(null, "Contacto encontrado: " + contactoEncontrado, "Búsqueda de contacto", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Contacto no encontrado.", "Búsqueda de contacto", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void mostrarContactos(Agendadecontactos agenda) {
        Map<String, String> contactos = agenda.obtenerContactos();
        StringBuilder listaContactos = new StringBuilder();
        for (Map.Entry<String, String> entry : contactos.entrySet()) {
            listaContactos.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        JOptionPane.showMessageDialog(null, "Lista de contactos:\n" + listaContactos.toString());
    }
}