package Entidades.Ambiente;

import Entidades.Organismos.Animales;

import java.util.List;

public class Zona {
    private Ambiente ambiente;

    private List<Animales> animalesEnZona;

    public Zona(List<Animales> animalesEnZona) {
        this.animalesEnZona = animalesEnZona;
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