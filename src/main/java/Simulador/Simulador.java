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
import java.util.Collections;

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
        List<Animales> animales = Animales.getAnimalesList();
        for (Animales animal : animales) {
            if (random.nextInt(100) < 10) { // 10% de probabilidad de que ocurra un evento
                int eventoIndex = random.nextInt(eventos.length);
                eventos[eventoIndex].aplicar(animal);
                System.out.println("Se ha aplicado el evento " + eventos[eventoIndex].getClass().getSimpleName() + " a " + animal.getNombre());
            }
        }
    }

    public void pelear() {
        List<Animales> copiaAnimales = new ArrayList<>(Animales.getAnimalesList());

        for (Animales animal : copiaAnimales) {
            for (Animales animal2 : copiaAnimales) {
                String nombre1 = animal.getNombre();
                String nombre2 = animal2.getNombre();
                // Verifica si los nombres de los animales son iguales excepto por la última letra
                boolean mismoNombre = nombre1.substring(0, nombre1.length() - 1).equals(nombre2.substring(0, nombre2.length() - 1));

                if (!animal.equals(animal2) && !mismoNombre && Math.abs(animal.getPosicion().getX() - animal2.getPosicion().getX()) < 2 && Math.abs(animal.getPosicion().getY() - animal2.getPosicion().getY()) < 2) {
                    if (random.nextInt(100) < 50) { // Aumenta la probabilidad de las peleas al 50%
                        if (animal.getSalud() > animal2.getSalud()) {
                            animal2.setSalud(0);
                            System.out.println(animal.getNombre() + " ha ganado la pelea contra " + animal2.getNombre());
                        } else {
                            animal.setSalud(0);
                            System.out.println(animal2.getNombre() + " ha ganado la pelea contra " + animal.getNombre());
                        }
                        // Muestra la nueva vida de cada animal
                        System.out.println(animal.getNombre() + " tiene ahora " + animal.getSalud() + " de vida");
                        System.out.println(animal2.getNombre() + " tiene ahora " + animal2.getSalud() + " de vida");

                        // Verifica si la vida de algún animal llegó a 0 y, de ser así, lo remueve del juego
                        if (animal.getSalud() <= 0) {
                            Animales.getAnimalesList().remove(animal);
                            System.out.println(animal.getNombre() + " ha muerto y ha sido removido de la simulación");
                        }
                        if (animal2.getSalud() <= 0) {
                            Animales.getAnimalesList().remove(animal2);
                            System.out.println(animal2.getNombre() + " ha muerto y ha sido removido de la simulación");
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