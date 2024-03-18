package D_Poblacionales.Eventos;

import java.util.Random;
import Entidades.Organismos.Animales;

public class Enfermedad extends EventoAleatorio {
    @Override
    public void aplicar(Animales animal) {
        int reduccionSalud = random.nextInt(30);
        animal.setSalud(animal.getSalud() - reduccionSalud);
        if (random.nextBoolean()) {
            animal.setEstadoReproductivo(false);
        }
    }
}
