import java.util.Scanner;
import Usuarios_Sim.Autenticacion;

public class Simulacion {
    private Autenticacion autenticacion;

    public Simulacion() {
        this.autenticacion = new Autenticacion();
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido a SimEco");
        System.out.println("Por favor, introduce tu usuario:");
        String usuario = scanner.nextLine();
        System.out.println("Por favor, introduce tu contraseña:");
        String contrasena = scanner.nextLine();

        if (autenticacion.verificarCredenciales(usuario, contrasena)) {
            System.out.println("Has iniciado sesión correctamente.");
            mostrarMenu();
        } else {
            System.out.println("Las credenciales proporcionadas son incorrectas.");
        }
    }

    private void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Elige una opción:");
        System.out.println("Población");
        System.out.println("Análisis");
        System.out.println("Simulación");

        String opcion = scanner.nextLine();

        switch (opcion) {
            case "Población":
                // Aquí implementar la funcionalidad para la opción "Población"
                break;
            case "Análisis":
                // Aquí implementar la funcionalidad para la opción "Análisis"
                break;
            case "Simulación":
                // Aquí implementar la funcionalidad para la opción "Simulación"
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }

    public static void main(String[] args) {
        Simulacion simulacion = new Simulacion();
        simulacion.iniciar();
    }
}