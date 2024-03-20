package Simulador;

import Entidades.Organismos.Organismo;
import Entidades.Organismos.Animales;
import Entidades.Ambiente.Zona;
import D_Poblacionales.Crec_y_Rep.Crecimiento;
import D_Poblacionales.Crec_y_Rep.Reproduccion;
import D_Poblacionales.Eventos.CambioClimatico;
import D_Poblacionales.Eventos.DesastreNatural;
import D_Poblacionales.Eventos.Enfermedad;
import D_Poblacionales.Eventos.EventoAleatorio;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Collections;

public class Simulador {
    private List<Animales> animalesMovidos = new ArrayList<>();
    private List<Zona> zonas;
    public Simulador(List<Zona> zonas) {
        if (zonas == null) {
            throw new IllegalArgumentException("La lista de zonas no puede ser null");
        }
        this.zonas = zonas;
    }
    private Random random = new Random();
    private EventoAleatorio[] eventos = {new DesastreNatural(), new CambioClimatico()};
    private Crecimiento crecimiento = new Crecimiento();
    private Reproduccion reproduccion = new Reproduccion();
    private static final int MAX_DIAS = 100;

    public void iniciarSimulacion() {
        int dia = 1;
        while (dia <= MAX_DIAS) {
            System.out.println("Día " + dia + " de la simulación:");
            desplazarAnimales();
            aplicarEventos();
            pelear();
            mostrarResultados();
            dia++;
            animalesMovidos.clear();;

            // Imprime los animales que se han reproducido
            List<Animales> animales = Animales.getAnimalesList();
            List<Animales> nuevosAnimales = new ArrayList<>();
            for (int i = 0; i < animales.size() - 1; i++) {
                for (int j = i + 1; j < animales.size(); j++) {
                    try {
                        Animales nuevoAnimal = reproduccion.reproducir(animales.get(i), animales.get(j));
                        nuevosAnimales.add(nuevoAnimal);
                        System.out.println(nuevoAnimal.getNombre() + " ha nacido");
                    } catch (IllegalArgumentException e) {
                        // Ignora la excepción y continúa con la siguiente pareja de animales
                    }
                }
            }
            animales.addAll(nuevosAnimales);

            System.out.println("Presione Enter para el siguiente turno o escriba 'salir' para terminar la simulación.");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if ("salir".equalsIgnoreCase(input)) {
                System.out.println("Simulación terminada.");
                break;
            }
            dia++;
            animalesMovidos.clear();
        }
    }

    public void desplazarAnimales() {
        List<Animales> animales = Animales.getAnimalesList();
        Collections.shuffle(animales); // Aleatoriza la lista de animales
        for (Animales animal : animales) {
            if (!animalesMovidos.contains(animal)) {
                Organismo.Posicion posicion = animal.getPosicion();
                posicion.setX(posicion.getX() + random.nextInt(3) - 1);
                posicion.setY(posicion.getY() + random.nextInt(3) - 1);
                System.out.println(animal.getNombre() + " se ha movido a la posición (" + posicion.getX() + ", " + posicion.getY() + ")");
                animalesMovidos.add(animal);
                break;
            }
        }
    }

    public void aplicarEventos() {
        for (Zona zona : zonas) {
            if (random.nextInt(100) < 80) { // Aumenta la probabilidad de que ocurra un evento al 100%
                int eventoIndex = random.nextInt(eventos.length);
                eventos[eventoIndex].aplicar(zona);
                System.out.println("Se ha aplicado el evento " + eventos[eventoIndex].getClass().getSimpleName() + " a la zona " + zona.getNombre());
            }
        }
    }
    public void pelear() {
        List<Animales> copiaAnimales = new ArrayList<>(Animales.getAnimalesList());

        for (Animales animal : copiaAnimales) {
            for (Animales animal2 : copiaAnimales) {
                if (!animal.equals(animal2) && !animal.getNombre().equals(animal2.getNombre())) {
                    String nombre1 = animal.getNombre();
                    String nombre2 = animal2.getNombre();
                    boolean mismoNombre = nombre1.substring(0, nombre1.length() - 2).equals(nombre2.substring(0, nombre2.length() - 2));
                    boolean diferenteSexo = !nombre1.substring(nombre1.length() - 1).equals(nombre2.substring(nombre2.length() - 1));

                    if (mismoNombre && diferenteSexo && Math.abs(animal.getPosicion().getX() - animal2.getPosicion().getX()) < 2 && Math.abs(animal.getPosicion().getY() - animal2.getPosicion().getY()) < 2) {
                        if (random.nextInt(100) < 50) { // Aumenta la probabilidad de las peleas al 50%
                            if (animal.getSalud() > animal2.getSalud()) {
                                animal2.setSalud(0);
                                System.out.println(animal.getNombre() + " ha ganado la pelea contra " + animal2.getNombre());
                            } else {
                                animal.setSalud(0);
                                System.out.println(animal2.getNombre() + " ha ganado la pelea contra " + animal.getNombre());
                            }
                            System.out.println(animal.getNombre() + " tiene ahora " + animal.getSalud() + " de vida");
                            System.out.println(animal2.getNombre() + " tiene ahora " + animal2.getSalud() + " de vida");

                            if (animal.getSalud() <= 0) {
                                Animales.getAnimalesList().remove(animal);
                                System.out.println(animal.getNombre() + " ha muerto y ha sido removido del juego");
                            }
                            if (animal2.getSalud() <= 0) {
                                Animales.getAnimalesList().remove(animal2);
                                System.out.println(animal2.getNombre() + " ha muerto y ha sido removido del juego");
                            }
                        }
                    }
                }
            }
        }
    }

    public void mostrarResultados() {
        for (Animales animal : animalesMovidos) {
            System.out.println(animal.getNombre() + " está en la posición (" + animal.getPosicion().getX() + ", " + animal.getPosicion().getY() + ") y tiene " + animal.getSalud() + " de vida");
        }
    }
}