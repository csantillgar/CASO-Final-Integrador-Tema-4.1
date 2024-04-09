package ValidacióndeEmailyDiseñoGráfico;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidadordeEmail {
    public static boolean validarEmail(String email) {
        // Patrón para validar direcciones de correo electrónico
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String email1 = "usuario@example.com";
        String email2 = "correo.invalido.com";

        System.out.println(email1 + " es un email válido: " + validarEmail(email1));
        System.out.println(email2 + " es un email válido: " + validarEmail(email2));
    }
}
