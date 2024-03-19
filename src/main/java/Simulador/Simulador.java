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
import java.util.Random;
import java.util.Scanner;

public class Simulador {
    private Random random = new Random();
    private EventoAleatorio[] eventos = {new DesastreNatural(), new Enfermedad(), new CambioClimatico()};
    private Crecimiento crecimiento = new Crecimiento();
    private Reproduccion reproduccion = new Reproduccion();

    public void iniciarSimulacion() {
        int dia = 1;
        while (true) {
            System.out.println("Día " + dia + " de la simulación:");
            desplazarAnimales();
            aplicarEventos();
            mostrarResultados();

            System.out.println("Presione Enter para el siguiente turno o escriba 'salir' para terminar la simulación.");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if ("salir".equalsIgnoreCase(input)) {
                break;
            }
            dia++;
        }
    }

    public void desplazarAnimales() {
        List<Animales> animales = Animales.getAnimalesList();
        for (Animales animal : animales) {
            Organismo.Posicion posicion = animal.getPosicion();
            posicion.setX(posicion.getX() + random.nextInt(3) - 1);
            posicion.setY(posicion.getY() + random.nextInt(3) - 1);
            System.out.println(animal.getNombre() + " se ha movido a la posición (" + posicion.getX() + ", " + posicion.getY() + ")");
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

    public void mostrarResultados() {
        List<Animales> animales = Animales.getAnimalesList();
        for (Animales animal : animales) {
            System.out.println(animal.getNombre() + " está en la posición (" + animal.getPosicion().getX() + ", " + animal.getPosicion().getY() + ")");
        }
    }
}