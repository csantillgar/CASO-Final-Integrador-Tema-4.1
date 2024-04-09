package BúsquedadePalabrasyGestióndeContactos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Agendadecontactos {
    private List<Contacto> contactos;

    public Agendadecontactos() {
        contactos = new ArrayList<>();
    }

    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
    }

    public Contacto buscarContacto(String nombre) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                return contacto;
            }
        }
        return null;
    }

    public void mostrarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("No hay contactos en la agenda.");
        } else {
            System.out.println("Lista de contactos:");
            for (Contacto contacto : contactos) {
                System.out.println(contacto);
            }
        }
    }

    public void agregarContacto(String nombre, String telefono) {
    }

    public Map<String, String> obtenerContactos() {
        return null;
    }

}

