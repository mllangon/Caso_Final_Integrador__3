package Entidades.Organismos;

public class Animales extends Organismo {
    private String especie;
    private String alimentacion;

    public Animales(Posicion posicion, int salud, int edad, boolean estadoReproductivo, String especie, double peso) {
        super(posicion, salud, edad, estadoReproductivo);
        this.especie = especie;
        this.alimentacion = alimentacion;
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
}