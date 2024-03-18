package Entidades;

import Entidades.Organismos.Organismo;
import Entidades.Organismos.Plantas;
import Entidades.Ambiente.Ambiente;

public class Interacciones {

    public void predacion(Organismo depredador, Organismo presa) {
        depredador.setSalud(depredador.getSalud() + 10);
        presa.setSalud(presa.getSalud() - 10);
    }

    public void competenciaPorRecursos(Organismo organismo1, Organismo organismo2, Ambiente ambiente) {
        if (organismo1.getSalud() > organismo2.getSalud()) {
            organismo1.setSalud(organismo1.getSalud() + ambiente.getRecursos() / 2);
            ambiente.setRecursos(ambiente.getRecursos() / 2);
        } else {
            organismo2.setSalud(organismo2.getSalud() + ambiente.getRecursos() / 2);
            ambiente.setRecursos(ambiente.getRecursos() / 2);
        }
    }

    public void polinizacion(Plantas planta1, Plantas planta2) {
        planta2.setSalud(planta2.getSalud() + planta1.getSalud() / 2);
        planta1.setSalud(planta1.getSalud() / 2);
    }
}