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

        Animales carnivoroMacho1 = new Animales("Leon_M", new Posicion(0, 0), 100, 5, true, "Carnívoro", 50);
        Animales carnivoroHembra1 = new Animales("León_H", new Posicion(1, 1), 100, 5, true, "Carnívoro", 45);
        Animales carnivoroMacho2 = new Animales("Tigre_M", new Posicion(2, 2), 100, 5, true, "Carnívoro", 50);
        Animales carnivoroHembra2 = new Animales("Tigre_H", new Posicion(3, 3), 100, 5, true, "Carnívoro", 45);

        Animales herbivoroMacho1 = new Animales("Ñu_M", new Posicion(2, 2), 100, 5, true, "Herbívoro", 50);
        Animales herbivoroHembra1 = new Animales("Ñu_H",new Posicion(3, 3), 100, 5, true, "Herbívoro", 45);
        Animales herbivoroMacho2 = new Animales("Cebra_M", new Posicion(2, 2), 100, 5, true, "Herbívoro", 50);
        Animales herbivoroHembra2 = new Animales("Cebra_H", new Posicion(3, 3), 100, 5, true, "Herbívoro", 45);

        Animales omnivoroMacho1 = new Animales("Oso_M", new Posicion(4, 4), 100, 5, true, "Omnívoro", 50);
        Animales omnivoroHembra1 = new Animales("Oso_H", new Posicion(5, 5), 100, 5, true, "Omnívoro", 45);
        Animales omnivoroMacho2 = new Animales("Mono_M", new Posicion(6, 6), 100, 5, true, "Omnívoro", 50);
        Animales omnivoroHembra2 = new Animales("Mono_H", new Posicion(7, 7), 100, 5, true, "Omnívoro", 45);

        Plantas planta1 = new Plantas("Árbol_S", new Posicion(0, 0), 100, 5, true, "Arbol", "Sabana");
        Plantas planta2 = new Plantas("Árbol_B", new Posicion(1, 1), 100, 5, true, "Arbol", "Bosque");
        Plantas planta3 = new Plantas("Hierba_S", new Posicion(2, 2), 100, 5, true, "Hierba", "Sabana");
        Plantas planta4 = new Plantas("Arbusto", new Posicion(3, 3), 100, 5, true, "Arbusto", "Bosque");
        Plantas planta5 = new Plantas("Frutas", new Posicion(4, 4), 100, 5, true, "Fruto", "Bosque");

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
                Plantas planta1 = new Plantas("Árbol_S", new Posicion(0, 0), 100, 5, true, "Arbol", "Sabana");
                Plantas planta2 = new Plantas("Árbol_B", new Posicion(1, 1), 100, 5, true, "Arbol", "Bosque");
                Plantas planta3 = new Plantas("Hierba_S", new Posicion(2, 2), 100, 5, true, "Hierba", "Sabana");
                Plantas planta4 = new Plantas("Arbusto", new Posicion(3, 3), 100, 5, true, "Arbusto", "Bosque");
                Plantas planta5 = new Plantas("Frutas", new Posicion(4, 4), 100, 5, true, "Fruto", "Bosque");
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