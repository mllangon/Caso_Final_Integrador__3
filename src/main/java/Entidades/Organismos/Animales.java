package Entidades.Organismos;

import java.util.ArrayList;
import java.util.List;

public class Animales extends Organismo {
    private String especie;
    private String alimentacion;

    private static List<Animales> animalesList = new ArrayList<>();

    public Animales(Posicion posicion, int salud, int edad, boolean estadoReproductivo, String especie, double peso) {
        super(posicion, salud, edad, estadoReproductivo);
        this.especie = especie;
        this.alimentacion = alimentacion;
        animalesList.add(this);
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getAlimentacion() {
        return alimentacion;
    }

    public void setAlimentacion(String Alimentacion) {
        this.alimentacion = alimentacion;
    }

    public static List<Animales> getAnimalesList() {
        return animalesList;
    }
}