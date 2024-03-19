import java.util.List;
import java.util.Scanner;
import Entidades.Organismos.Organismo;
import Entidades.Organismos.Animales;
import Entidades.Organismos.Plantas;
import Usuarios_Sim.Autenticacion;
import Entidades.Organismos.Organismo.Posicion;

public class Simulacion {
    private Autenticacion autenticacion;

    public Simulacion() {
        this.autenticacion = new Autenticacion();
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido a EcoSim");
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
                Animales carnivoroMacho1 = new Animales(new Posicion(0, 0), 100, 5, true, "Carnívoro", 50);
                Animales carnivoroHembra1 = new Animales(new Posicion(1, 1), 100, 5, true, "Carnívoro", 45);

                // Añadir herbívoros
                Animales herbivoroMacho1 = new Animales(new Posicion(2, 2), 100, 5, true, "Herbívoro", 50);
                Animales herbivoroHembra1 = new Animales(new Posicion(3, 3), 100, 5, true, "Herbívoro", 45);

                // Añadir omnívoros
                Animales omnivoroMacho1 = new Animales(new Posicion(4, 4), 100, 5, true, "Omnívoro", 50);
                Animales omnivoroHembra1 = new Animales(new Posicion(5, 5), 100, 5, true, "Omnívoro", 45);
                List<Animales> animales = Animales.getAnimalesList();
                List<Plantas> plantas = Plantas.getPlantasList();

                System.out.println("Animales:");
                for (Animales animal : animales) {
                    System.out.println(animal);
                }

                System.out.println("Plantas:");
                for (Plantas planta : plantas) {
                    System.out.println(planta);
                }
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