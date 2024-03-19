package Entidades.Ambiente;

public class Ambiente {
    private String tipo;
    private String subtipo;
    private String clima;
    private String terreno;
    private int recursos;

    public Ambiente(String clima, String terreno, int recursos) {
        this.clima = clima;
        this.terreno = terreno;
        this.recursos = recursos;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getTerreno() {
        return terreno;
    }

    public void setTerreno(String terreno) {
        this.terreno = terreno;
    }

    public int getRecursos() {
        return recursos;
    }

    public void setRecursos(int recursos) {
        this.recursos = recursos;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setSubtipo(String subtipo) {
        this.subtipo = subtipo;
    }
    public String getTipo() {
        return this.tipo;
    }
    public String getSubtipo() {
        return this.subtipo;
    }
}