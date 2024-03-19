package Simulador;

import Entidades.Organismos.Organismo;
import Entidades.Organismos.Animales;
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

public class Simulador {
    private Random random = new Random();
    private EventoAleatorio[] eventos = {new DesastreNatural(), new CambioClimatico()};
    private Crecimiento crecimiento = new Crecimiento();
    private Reproduccion reproduccion = new Reproduccion();
    private List<Animales> animalesMovidos = new ArrayList<>();

    public void iniciarSimulacion() {
        int dia = 1;
        while (true) {
            System.out.println("Día " + dia + " de la simulación:");
            desplazarAnimales();
            aplicarEventos();
            pelear();
            mostrarResultados();

            System.out.println("Presione Enter para el siguiente turno o escriba 'salir' para terminar la simulación.");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if ("salir".equalsIgnoreCase(input)) {
                break;
            }
            dia++;
            animalesMovidos.clear();
        }
    }

    public void desplazarAnimales() {
        List<Animales> animales = Animales.getAnimalesList();
        if (animales != null) {
            for (Animales animal : animales) {
                if (!animalesMovidos.contains(animal)) {
                    Organismo.Posicion posicion = animal.getPosicion();
                    if (posicion != null) {
                        posicion.setX(posicion.getX() + random.nextInt(3) - 1);
                        posicion.setY(posicion.getY() + random.nextInt(3) - 1);
                        System.out.println(animal.getNombre() + " se ha movido a la posición (" + posicion.getX() + ", " + posicion.getY() + ")");
                        animalesMovidos.add(animal);
                        break;
                    }
                }
            }
        }
    }

    public void aplicarEventos() {
        List<Animales> animales = Animales.getAnimalesList();
        if (animales != null) {
            for (Animales animal : animales) {
                if (animal != null) {
                    if (random.nextInt(100) < 10) { // 10% de probabilidad de que ocurra un evento
                        int eventoIndex = random.nextInt(eventos.length);
                        EventoAleatorio evento = eventos[eventoIndex];
                        if (evento != null) {
                            evento.aplicar(animal);
                            System.out.println("Se ha aplicado el evento " + evento.getClass().getSimpleName() + " a " + animal.getNombre());
                        }
                    }
                }
            }
        }
    }

    public void pelear() {
        List<Animales> animales = Animales.getAnimalesList();
        if (animales != null) {
            for (Animales animal1 : animales) {
                if (animal1 != null) {
                    for (Animales animal2 : animales) {
                        if (animal2 != null && !animal1.equals(animal2) && animal1.getPosicion().equals(animal2.getPosicion())) {
                            if (animal1.getSalud() > animal2.getSalud()) {
                                animal2.setSalud(0);
                                System.out.println(animal1.getNombre() + " ha ganado la pelea contra " + animal2.getNombre());
                            } else {
                                animal1.setSalud(0);
                                System.out.println(animal2.getNombre() + " ha ganado la pelea contra " + animal1.getNombre());
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