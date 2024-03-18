package D_Poblacionales.Eventos;

import java.util.Random;
import Entidades.Organismos.Animales;

public class DesastreNatural extends EventoAleatorio {
    @Override
    public void aplicar(Animales animal) {
        int reduccionSalud = random.nextInt(50);
        animal.setSalud(animal.getSalud() - reduccionSalud);
    }
}