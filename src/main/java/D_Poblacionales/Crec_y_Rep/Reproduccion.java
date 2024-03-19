package D_Poblacionales.Crec_y_Rep;

import D_Poblacionales.Eventos.CambioClimatico;
import D_Poblacionales.Eventos.DesastreNatural;
import D_Poblacionales.Eventos.Enfermedad;
import D_Poblacionales.Eventos.EventoAleatorio;
import Entidades.Organismos.Animales;
import java.util.Random;

public class Reproduccion {

    private EventoAleatorio[] eventos = {new DesastreNatural(), new Enfermedad(), new CambioClimatico()};
    private Random random = new Random();

    public void aplicarEventoAleatorio(Animales animal) {
        int eventoIndex = random.nextInt(eventos.length);
        eventos[eventoIndex].aplicar(animal);
    }

    public Animales reproducir(Animales animal1, Animales animal2) {
        if (!animal1.getEspecie().equals(animal2.getEspecie())) {
            throw new IllegalArgumentException("Los animales deben ser de la misma especie para reproducirse");
        }

        if (!animal1.isEstadoReproductivo() || !animal2.isEstadoReproductivo()) {
            throw new IllegalArgumentException("Ambos animales deben estar en estado reproductivo para reproducirse");
        }

        if (animal1.getSalud() < 50 || animal2.getSalud() < 50) {
            throw new IllegalArgumentException("Ambos animales deben tener una salud de al menos 50 para reproducirse");
        }

        double alimentacion = Double.parseDouble(animal1.getAlimentacion());

        Animales nuevoAnimal = new Animales(
                "Nombre del nuevo animal",
                animal1.getPosicion(),
                (animal1.getSalud() + animal2.getSalud()) / 2,
                Math.max(animal1.getEdad(), animal2.getEdad()),
                false,
                animal1.getEspecie(),
                alimentacion
        );

        return nuevoAnimal;
    }
}