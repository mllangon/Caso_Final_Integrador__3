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
import Entidades.Ambiente.Zona;
import Simulador.Simulador;
import java.util.ArrayList;
public class Simulacion {
    Scanner scanner = new Scanner(System.in);
    List<Zona> zonas = new ArrayList<>();
    List<Animales> animales = Animales.getAnimalesList();
    private Simulador simulador = new Simulador(zonas);
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

        Ambiente ambiente = new Ambiente("Arido", "Sabana", 500);
        Ambiente ambiente2 = new Ambiente("Húmedo", "Bosque", 1000);
        Ambiente ambiente3 = new Ambiente("Soleado", "Pradera", 700);

        Zona zona1 = new Zona(new ArrayList<>());
        zona1.setAmbiente(ambiente);
        zonas.add(zona1);

        Zona zona2 = new Zona(new ArrayList<>());
        zona2.setAmbiente(ambiente2);
        zonas.add(zona2);

        Zona zona3 = new Zona(new ArrayList<>());
        zona3.setAmbiente(ambiente3);
        zonas.add(zona3);
    }
    public void iniciar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\033[0;31m" + "Bienvenido a EcoSim");
        System.out.println("\033[0;31m" + "Por favor, introduce tu usuario:" + "\033[0m");
        String usuario = scanner.nextLine();
        System.out.println("\033[0;31m" + "Por favor, introduce tu contraseña:" + "\033[0m");
        String contrasena = scanner.nextLine();

        if (autenticacion.verificarCredenciales(usuario, contrasena)) {
            System.out.println("\033[0;31m" + "Has iniciado sesión correctamente." + "\033[0m");
            mostrarMenu();
        } else {
            System.out.println("\033[0;31m" + "Las credenciales proporcionadas son incorrectas." + "\033[0m");
        }
    }

    private void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\033[0;31m" + "Elige una opción:" + "\033[0m");
        System.out.println("Población");
        System.out.println("Análisis");
        System.out.println("Simulación");
        System.out.println("Salir");

        String opcion = scanner.nextLine();

        switch (opcion) {
            case "Población":
                List<Animales> animales = Animales.getAnimalesList();
                List<Plantas> plantas = Plantas.getPlantasList();

                System.out.println("\033[0;31m" + "Animales:" + "\033[0m");
                for (Animales animal : animales) {
                    System.out.println(animal);
                }
                System.out.println("\033[0;31m" + "Plantas:" + "\033[0m");
                for (Plantas planta : plantas) {
                    System.out.println(planta);
                }
                break;
            case "Análisis":
                Datos datos = new Datos();
                Funciones funciones = new Funciones();
                Problemas problemas = new Problemas();

                // Muestra los posibles eventos
                System.out.println("\033[0;31m" + "Posibles eventos:" + "\033[0m");
                for (EventoAleatorio evento : eventos) {
                    System.out.println(evento.getClass().getSimpleName());
                }

                // Muestra los datos de los ambientes
                System.out.println("\033[0;31m" + "Datos de los ambientes:" + "\033[0m");
                for (Zona zona : zonas) {
                    Ambiente ambiente = zona.getAmbiente();
                    System.out.println("Ambiente: " + ambiente.getClima() + ", " + ambiente.getTerreno() + ", Recursos: " + ambiente.getRecursos());
                }

                // Muestra los datos de los animales
                System.out.println("\033[0;31m" + "Datos de los animales:" + "\033[0m");
                for (Animales animal : Animales.getAnimalesList()) {
                    System.out.println("Nombre: " + animal.getNombre() + ", Especie: " + animal.getEspecie() + ", Salud: " + animal.getSalud() + ", Edad: " + animal.getEdad() + ", Estado Reproductivo: " + (animal.isEstadoReproductivo() ? "Sí" : "No") + ", Peso: " + animal.getPeso());
                }
                break;
            case "Simulación":
                System.out.println("\033[0;31m" + "Comenzando simulación..." + "\033[0m");
                simulador.iniciarSimulacion();
                break;
            case "Salir":
                System.out.println("\033[0;31m" + "Saliendo..." + "\033[0m");
                break;
            default:
                System.out.println("\033[0;31m" + "Opción no válida." + "\033[0m");
                break;
        }
    }

    public static void main(String[] args) {
        Simulacion simulacion = new Simulacion();
        simulacion.iniciar();
    }
}