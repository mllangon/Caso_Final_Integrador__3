package AnálisisAvanzado;

import Entidades.Organismos.Animales;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Datos {

    public static String visualizarDatos(List<Animales> animales) {
        Map<String, Integer> conteoEspecies = contarEspecies(animales);
        StringBuilder sb = new StringBuilder();

        sb.append("Resumen de la simulación:\n");
        for (Map.Entry<String, Integer> entry : conteoEspecies.entrySet()) {
            sb.append("Especie: ").append(entry.getKey()).append(", Cantidad: ").append(entry.getValue()).append("\n");
        }

        return sb.toString();
    }

    private static Map<String, Integer> contarEspecies(List<Animales> animales) {
        Map<String, Integer> conteoEspecies = new HashMap<>();
        for (Animales animal : animales) {
            String especie = animal.getEspecie();
            conteoEspecies.put(especie, conteoEspecies.getOrDefault(especie, 0) + 1);
        }
        return conteoEspecies;
    }
}