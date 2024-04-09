package BúsquedadePalabrasyGestióndeContactos;

import java.util.HashMap;
import java.util.Map;

public class Buscadordepalabras {
    // Método para contar la frecuencia de palabras en un texto
    public Map<String, Integer> contarPalabras(String texto) {
        Map<String, Integer> frecuenciaPalabras = new HashMap<>();

        // Dividir el texto en palabras utilizando espacios como delimitadores
        String[] palabras = texto.split("\\s+");

        // Contar la frecuencia de cada palabra
        for (String palabra : palabras) {
            frecuenciaPalabras.put(palabra, frecuenciaPalabras.getOrDefault(palabra, 0) + 1);
        }

        return frecuenciaPalabras;
    }
}
