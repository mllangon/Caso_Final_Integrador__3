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
        String nombre1 = animal1.getNombre();
        String nombre2 = animal2.getNombre();

        if (nombre1.startsWith("Cria_") && nombre2.startsWith("Cria_")) {
            throw new IllegalArgumentException("Las crías no pueden reproducirse entre sí");
        }

        // Verifica si los nombres de los animales son iguales excepto por la última letra
        if (nombre1.substring(0, nombre1.length() - 1).equals(nombre2.substring(0, nombre2.length() - 1))) {
            boolean cerca = Math.abs(animal1.getPosicion().getX() - animal2.getPosicion().getX()) < 2 && Math.abs(animal1.getPosicion().getY() - animal2.getPosicion().getY()) < 2;

            if (cerca && random.nextInt(100) < 50) { // 50% de posibilidades de reproducirse
                if (animal1.getSalud() < 50 || animal2.getSalud() < 50) {
                    throw new IllegalArgumentException("Ambos animales deben tener una salud de al menos 50 para reproducirse");
                }

                double pesoPromedio = (animal1.getPeso() + animal2.getPeso()) / 2; // Asume que ambos animales tienen el mismo peso

                Animales nuevoAnimal = new Animales(
                        "Cria_" + animal1.getNombre() + "_" + animal2.getNombre(),
                        animal1.getPosicion(),
                        (animal1.getSalud() + animal2.getSalud()) / 2,
                        Math.max(animal1.getEdad(), animal2.getEdad()),
                        false,
                        animal1.getEspecie(),
                        pesoPromedio
                );

                System.out.println(animal1.getNombre() + " y " + animal2.getNombre() + " se han reproducido y han creado a " + nuevoAnimal.getNombre());

                return nuevoAnimal;
            }
        }

        throw new IllegalArgumentException("Los animales deben ser de la misma especie y de sexos opuestos para reproducirse");
    }
}