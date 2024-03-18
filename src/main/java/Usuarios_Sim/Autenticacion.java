package Usuarios_Sim;
import java.util.HashMap;

public class Autenticacion {
    private HashMap<String, String> usuarios = new HashMap<>();

    public void registrarUsuario(String usuario, String contrasena) {
        usuarios.put(usuario, contrasena);
    }

    public boolean verificarCredenciales(String usuario, String contrasena) {
        String contrasenaGuardada = usuarios.get(usuario);
        if (contrasenaGuardada != null && contrasenaGuardada.equals(contrasena)) {
            return true;
        } else {
            return false;
        }
    }
}