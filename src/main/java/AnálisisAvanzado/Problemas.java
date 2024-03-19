package AnálisisAvanzado;

import Entidades.Ambiente.Ambiente;
import Entidades.Organismos.Organismo;
import Entidades.Organismos.Animales;
import java.util.List;
import java.util.function.Predicate;

public class Problemas {
    private Funciones funciones;
    private Datos datos;

    public Problemas() {
        this.funciones = new Funciones();
        this.datos = new Datos();
    }

    public void buscarEquilibrios(List<Animales> animales, Ambiente ambiente) {
        this.funciones.registrarInteraccionAmbiente("equilibrioEspecies", (organismo, amb) -> {
            System.out.println("Evaluando equilibrio en el ambiente.");
        });

        for (Animales animal : animales) {
            this.funciones.ejecutarInteraccionAmbiente("equilibrioEspecies", animal, ambiente);
        }

        System.out.println(Datos.visualizarDatos(animales));
    }

    public void evaluarConservacion(List<Animales> animales, Ambiente ambiente) {
        this.funciones.registrarInteraccionAmbiente("conservacion", (organismo, amb) -> {
            amb.setRecursos(amb.getRecursos() + 100);
            System.out.println("Aplicando estrategia de conservación: aumento de recursos.");
        });

        animales.forEach(animal -> this.funciones.ejecutarInteraccionAmbiente("conservacion", animal, ambiente));
    }

    public void simularImpactos(Ambiente ambiente, Predicate<Ambiente> cambio) {
        if (cambio.test(ambiente)) {
            System.out.println("El cambio es aplicable y se evaluarán los impactos.");
            ambiente.setClima("Desértico");
        } else {
            System.out.println("El cambio no se aplicará bajo las condiciones actuales.");
        }
    }
}
