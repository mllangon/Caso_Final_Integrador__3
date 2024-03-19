package Entidades.Organismos;

import java.util.ArrayList;
import java.util.List;

public class Plantas extends Organismo {
    private String tipo;
    private String especie;

    private static List<Plantas> plantasList = new ArrayList<>();


    public Plantas(String nombre, Posicion posicion, int salud, int edad, boolean estadoReproductivo, String tipo, String especie) {
        super(nombre, posicion, salud, edad, estadoReproductivo);
        this.tipo = tipo;
        this.especie = especie;
        plantasList.add(this);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public static List<Plantas> getPlantasList() {
        return plantasList;
    }
    @Override
    public String toString() {
        return "Animal: " + this.getNombre();
    }
}