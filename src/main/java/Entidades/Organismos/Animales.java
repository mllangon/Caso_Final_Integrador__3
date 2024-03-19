package Entidades.Organismos;

import java.util.ArrayList;
import java.util.List;

public class Animales extends Organismo {
    private String especie;
    private String alimentacion;

    private double peso;

    private static List<Animales> animalesList = new ArrayList<>();

    public Animales(String nombre,Posicion posicion, int salud, int edad, boolean estadoReproductivo, String especie, double peso) {
        super(nombre, posicion, salud, edad, estadoReproductivo);
        this.especie = especie;
        this.alimentacion = alimentacion;
        this.peso = peso;
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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    @Override
    public String toString() {
        return "Animal: " + this.getNombre();
    }
}