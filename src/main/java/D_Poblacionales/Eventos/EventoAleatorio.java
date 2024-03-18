package D_Poblacionales.Eventos;

import java.util.Random;
import Entidades.Organismos.Animales;

public abstract class EventoAleatorio {
    protected Random random = new Random();

    public abstract void aplicar(Animales animal);
}