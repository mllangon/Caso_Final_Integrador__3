package Entidades.Organismos;

public class Plantas extends Organismo {
    private String tipo;
    private String especie;

    public Plantas(Posicion posicion, int salud, int edad, boolean estadoReproductivo, String tipo, String especie) {
        super(posicion, salud, edad, estadoReproductivo);
        this.tipo = tipo;
        this.especie = especie;
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
}