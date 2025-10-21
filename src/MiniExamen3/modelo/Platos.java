package MiniExamen3.modelo;

import java.io.Serializable;

public class Platos implements Serializable {
    private int codigop;
    private String nomep;

    public Platos(int codigop, String nomep) {
        this.codigop = codigop;
        this.nomep = nomep;
    }

    public Platos() {}

    public int getCodigop() { return codigop; }
    public void setCodigop(int codigop) { this.codigop = codigop; }

    public String getNomep() { return nomep; }
    public void setNomep(String nomep) { this.nomep = nomep; }

    @Override
    public String toString() {
        return codigop + " " + nomep;
    }
}
