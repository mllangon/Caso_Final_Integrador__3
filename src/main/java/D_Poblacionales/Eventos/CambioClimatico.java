package D_Poblacionales.Eventos;
import java.util.Random;
import Entidades.Organismos.Animales;

public class CambioClimatico extends EventoAleatorio {
    @Override
    public void aplicar(Animales animal) {
        if (random.nextBoolean()) {
            double alimentacion = Double.parseDouble(animal.getAlimentacion());
            alimentacion -= random.nextInt(10);
            animal.setAlimentacion(String.valueOf(alimentacion));
        }
    }
}