package Entidades.Ambiente;

import Entidades.Organismos.Animales;

import java.util.List;

public class Zona {
    private String nombre;
    private Ambiente ambiente;
    private List<Animales> animalesEnZona;

    public Zona(String nombre, List<Animales> animalesEnZona) {
        this.nombre = nombre;
        this.animalesEnZona = animalesEnZona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Animales> getAnimalesEnZona() {
        return animalesEnZona;
    }

    public Ambiente getAmbiente() {
        return this.ambiente;
    }

    public void setAmbiente(Ambiente ambiente) {
        this.ambiente = ambiente;
    }
}