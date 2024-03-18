package AnálisisAvanzado;
import Entidades.Organismos.Animales;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Funciones {

    public String buscarEquilibrioEcológico(List<Animales> animales) {
        Map<String, Integer> conteoEspecies = new HashMap<>();
        for (Animales animal : animales) {
            String especie = animal.getEspecie();
            conteoEspecies.put(especie, conteoEspecies.getOrDefault(especie, 0) + 1);
        }

        int conteoPromedio = animales.size() / conteoEspecies.size();
        for (int conteo : conteoEspecies.values()) {
            if (Math.abs(conteo - conteoPromedio) > conteoPromedio * 0.1) {
                return "El ecosistema no está en equilibrio";
            }
        }

        return "El ecosistema está en equilibrio";
    }

    public String evaluarEstrategiaConservacion(int estrategia, List<Animales> animales) {
        Map<String, Integer> conteoEspeciesInicial = contarEspecies(animales);
        String especieEnPeligro = "EspecieEnPeligro"; // Supongamos que esta es la especie en peligro

        // Aplicamos la estrategia de conservación
        for (int i = 0; i < estrategia; i++) {
            animales.add(new Animales(especieEnPeligro));
        }

        Map<String, Integer> conteoEspeciesFinal = contarEspecies(animales);

        // Evaluamos la estrategia de conservación
        double aumentoEspecieEnPeligro = (double) conteoEspeciesFinal.get(especieEnPeligro) / conteoEspeciesInicial.get(especieEnPeligro) - 1;
        if (aumentoEspecieEnPeligro < 0.1) {
            return "La estrategia de conservación no es efectiva";
        }

        for (String especie : conteoEspeciesInicial.keySet()) {
            if (!especie.equals(especieEnPeligro)) {
                double disminucion = (double) conteoEspeciesInicial.get(especie) / conteoEspeciesFinal.get(especie) - 1;
                if (disminucion > 0.05) {
                    return "La estrategia de conservación no es efectiva";
                }
            }
        }

        return "La estrategia de conservación es efectiva";
    }

    private Map<String, Integer> contarEspecies(List<Animales> animales) {
        Map<String, Integer> conteoEspecies = new HashMap<>();
        for (Animales animal : animales) {
            String especie = animal.getEspecie();
            conteoEspecies.put(especie, conteoEspecies.getOrDefault(especie, 0) + 1);
        }
        return conteoEspecies;
    }
}
