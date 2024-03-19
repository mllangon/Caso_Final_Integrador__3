package D_Poblacionales.Eventos;

import java.util.Random;
import Entidades.Organismos.Animales;
import Entidades.Ambiente.Zona;

public abstract class EventoAleatorio {
    protected Random random = new Random();

    public void aplicar(Zona zona) {
        for (Animales animal : zona.getAnimalesEnZona()) {
            if (random.nextBoolean()) {
                int salud = animal.getSalud();
                salud -= random.nextInt(10);
                animal.setSalud(salud);
            }
        }
    }

    public void aplicar(Animales animal) {
        if (random.nextBoolean()) {
            int salud = animal.getSalud();
            salud -= random.nextInt(10);
            animal.setSalud(salud);
        }
    }
}