import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Entidades.Ambiente.Ambiente;
import Simulador.Simulador;
import Entidades.Interacciones;
import Entidades.Organismos.Organismo;
import Entidades.Organismos.Animales;
import Entidades.Organismos.Plantas;
import Usuarios_Sim.Autenticacion;
import Entidades.Organismos.Organismo.Posicion;
import AnálisisAvanzado.Datos;
import AnálisisAvanzado.Funciones;
import AnálisisAvanzado.Problemas;
import D_Poblacionales.Eventos.CambioClimatico;
import D_Poblacionales.Eventos.DesastreNatural;
import D_Poblacionales.Eventos.Enfermedad;
import D_Poblacionales.Eventos.EventoAleatorio;
import Simulador.Simulador;
public class Simulacion {
    Scanner scanner = new Scanner(System.in);
    private Simulador simulador = new Simulador();
    private Autenticacion autenticacion;
    private Datos datos;
    private Funciones funciones;
    private Problemas problemas;
    private Random random = new Random();
    private EventoAleatorio[] eventos = {new DesastreNatural(), new Enfermedad(), new CambioClimatico()};

    public Simulacion() {
        this.autenticacion = new Autenticacion();
        this.datos = new Datos();
        this.funciones = new Funciones();
        this.problemas = new Problemas();

        Animales carnivoroMacho1 = new Animales("Leon_M", new Posicion(0, 0), 100, 5, true, "Carnívoro", 50);
        Animales carnivoroHembra1 = new Animales("León_H", new Posicion(1, 1), 100, 5, true, "Carnívoro", 45);
        Animales carnivoroMacho2 = new Animales("Tigre_M", new Posicion(8, 2), 100, 5, true, "Carnívoro", 50);
        Animales carnivoroHembra2 = new Animales("Tigre_H", new Posicion(9, 3), 100, 5, true, "Carnívoro", 45);

        Animales herbivoroMacho1 = new Animales("Ñu_M", new Posicion(13, 2), 100, 5, true, "Herbívoro", 50);
        Animales herbivoroHembra1 = new Animales("Ñu_H",new Posicion(15, 3), 100, 5, true, "Herbívoro", 45);
        Animales herbivoroMacho2 = new Animales("Cebra_M", new Posicion(26, 2), 100, 5, true, "Herbívoro", 50);
        Animales herbivoroHembra2 = new Animales("Cebra_H", new Posicion(23, 3), 100, 5, true, "Herbívoro", 45);

        Animales omnivoroMacho1 = new Animales("Oso_M", new Posicion(34, 4), 100, 5, true, "Omnívoro", 50);
        Animales omnivoroHembra1 = new Animales("Oso_H", new Posicion(35, 5), 100, 5, true, "Omnívoro", 45);
        Animales omnivoroMacho2 = new Animales("Mono_M", new Posicion(46, 6), 100, 5, true, "Omnívoro", 50);
        Animales omnivoroHembra2 = new Animales("Mono_H", new Posicion(47, 7), 100, 5, true, "Omnívoro", 45);

        Plantas planta1 = new Plantas("Árbol_S", new Posicion(0, 0), 100, 5, true, "Arbol", "Sabana");
        Plantas planta2 = new Plantas("Árbol_B", new Posicion(1, 1), 100, 5, true, "Arbol", "Bosque");
        Plantas planta3 = new Plantas("Hierba_S", new Posicion(2, 2), 100, 5, true, "Hierba", "Sabana");
        Plantas planta4 = new Plantas("Arbusto", new Posicion(3, 3), 100, 5, true, "Arbusto", "Bosque");
        Plantas planta5 = new Plantas("Frutas", new Posicion(4, 4), 100, 5, true, "Fruto", "Bosque");


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
        System.out.println("Salir");

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
                break;
            case "Análisis":
                realizarAnalisis();

                break;
            case "Simulación":
                System.out.println("Comenzando simulación...");
                simulador.iniciarSimulacion();
                break;
            case "Salir":
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }

    private void realizarAnalisis() {
        // Assuming you have a list of animals and an environment already set up
        List<Animales> animales = Animales.getAnimalesList();
        Ambiente ambiente = new Ambiente("Arido", "Sabana", 1000);

        // Simulate environmental impact events
        D_Poblacionales.Eventos.CambioClimatico cambioClimatico = new D_Poblacionales.Eventos.CambioClimatico();
        D_Poblacionales.Eventos.DesastreNatural desastreNatural = new D_Poblacionales.Eventos.DesastreNatural();
        D_Poblacionales.Eventos.Enfermedad enfermedad = new D_Poblacionales.Eventos.Enfermedad();

        // Apply random events to animals
        animales.forEach(animal -> {
            cambioClimatico.aplicar(animal);
            desastreNatural.aplicar(animal);
            enfermedad.aplicar(animal);
        });

        // Perform analysis using Problemas class
        Problemas problemas = new Problemas();
        problemas.buscarEquilibrios(animales, ambiente);
        problemas.evaluarConservacion(animales, ambiente);

        // Example of a predicate to simulate an environmental change. You can customize this.
        problemas.simularImpactos(ambiente, amb -> amb.getRecursos() < 800);

        // Final data visualization
        System.out.println("Análisis finalizado.");
        System.out.println(Datos.visualizarDatos(animales));
    }

    public static void main(String[] args) {
        Simulacion simulacion = new Simulacion();
        simulacion.iniciar();
    }
}