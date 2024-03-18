package Usuarios_Sim;

import java.util.ArrayList;
import java.util.HashMap;

public class Actividades {
    private ArrayList<HashMap<String, String>> simulaciones = new ArrayList<>();

    public void agregarSimulacion(HashMap<String, String> simulacion) {
        simulaciones.add(simulacion);
    }

    public ArrayList<HashMap<String, String>> recuperarSimulaciones() {
        return simulaciones;
    }
}