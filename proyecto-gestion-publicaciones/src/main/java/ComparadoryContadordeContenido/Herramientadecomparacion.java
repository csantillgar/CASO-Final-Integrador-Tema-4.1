package ComparadoryContadordeContenido;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Herramientadecomparacion {
    // Método para comparar el contenido de dos archivos y determinar si son iguales
    public boolean compararArchivos(File file1, File file2) throws IOException {
        // Leer el contenido de ambos archivos
        String contenido1 = new String(Files.readAllBytes(file1.toPath()));
        String contenido2 = new String(Files.readAllBytes(file2.toPath()));

        // Comparar el contenido de los archivos
        return contenido1.equals(contenido2);
    }
}
