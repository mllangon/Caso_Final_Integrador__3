package AnálisisAvanzado;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import Entidades.Organismos.Organismo;
import Entidades.Ambiente.Ambiente;

public class Funciones {
    private Map<String, BiConsumer<Organismo, Organismo>> interaccionesOrganismos;
    private Map<String, BiConsumer<Organismo, Ambiente>> interaccionesAmbiente;

    public Funciones() {
        this.interaccionesOrganismos = new HashMap<>();
        this.interaccionesAmbiente = new HashMap<>();
    }

    public void registrarInteraccionOrganismos(String clave, BiConsumer<Organismo, Organismo> accion) {
        interaccionesOrganismos.put(clave, accion);
    }

    public void ejecutarInteraccionOrganismos(String clave, Organismo org1, Organismo org2) {
        if (interaccionesOrganismos.containsKey(clave)) {
            interaccionesOrganismos.get(clave).accept(org1, org2);
        } else {
            System.out.println("Interacción no registrada: " + clave);
        }
    }

    public void registrarInteraccionAmbiente(String clave, BiConsumer<Organismo, Ambiente> accion) {
        interaccionesAmbiente.put(clave, accion);
    }

    public void ejecutarInteraccionAmbiente(String clave, Organismo org, Ambiente ambiente) {
        if (interaccionesAmbiente.containsKey(clave)) {
            interaccionesAmbiente.get(clave).accept(org, ambiente);
        } else {
            System.out.println("Interacción no registrada: " + clave);
        }
    }
}
