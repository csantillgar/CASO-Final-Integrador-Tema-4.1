package BúsquedadePalabrasyGestióndeContactos;

import java.util.HashMap;
import java.util.Map;

public class Agendadecontactos {
    private Map<String, String> contactos; // Mapa para almacenar contactos (Nombre, Número)

    public Agendadecontactos() {
        contactos = new HashMap<>();
    }

    // Agregar un nuevo contacto al agenda
    public void agregarContacto(String nombre, String numero) {
        contactos.put(nombre, numero);
    }

    // Buscar un contacto por nombre
    public String buscarContacto(String nombre) {
        return contactos.getOrDefault(nombre, "Contacto no encontrado");
    }

    // Eliminar un contacto por nombre
    public void eliminarContacto(String nombre) {
        contactos.remove(nombre);
    }

    // Obtener todos los contactos
    public Map<String, String> obtenerContactos() {
        return contactos;
    }
}
