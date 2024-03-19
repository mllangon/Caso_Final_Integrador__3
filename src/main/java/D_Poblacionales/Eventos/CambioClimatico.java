package D_Poblacionales.Eventos;
import java.util.Random;
import Entidades.Organismos.Animales;

public class CambioClimatico extends EventoAleatorio {
    @Override
    public void aplicar(Animales animal) {
        if (random.nextBoolean()) {
            String alimentacionStr = animal.getAlimentacion();
            if (alimentacionStr != null) {
                double alimentacion = Double.parseDouble(alimentacionStr);
                alimentacion -= random.nextInt(10);
                animal.setAlimentacion(String.valueOf(alimentacion));
            }
        }
    }
}