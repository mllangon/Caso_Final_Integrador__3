package D_Poblacionales;

import Entidades.Organismos.Animales;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Resultados {

    public double calcularSaludPromedio(List<Animales> animales) {
        double sumaSalud = 0.0;
        for (Animales animal : animales) {
            sumaSalud += animal.getSalud();
        }
        return sumaSalud / animales.size();
    }

    public Map<String, Integer> calcularTendenciasPoblacionales(List<Animales> animales) {
        Map<String, Integer> tendencias = new HashMap<>();
        for (Animales animal : animales) {
            String especie = animal.getEspecie();
            tendencias.put(especie, tendencias.getOrDefault(especie, 0) + 1);
        }
        return tendencias;
    }

    public void imprimirEstadisticas(double saludPromedio, Map<String, Integer> tendenciasPoblacionales) {
        System.out.println("Salud promedio: " + saludPromedio);
        System.out.println("Tendencias poblacionales:");
        for (Map.Entry<String, Integer> entry : tendenciasPoblacionales.entrySet()) {
            System.out.println("Especie: " + entry.getKey() + ", Cantidad: " + entry.getValue());
        }
    }
}