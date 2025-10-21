package MiniExamen4.modelo;

public class Composicion {

    private int codr;
    private int cod_prod;
    private double peso;

    public Composicion(int codr, int cod_prod, double peso) {
        this.codr = codr;
        this.cod_prod = cod_prod;
        this.peso = peso;
    }
    public int getCodr() {
        return codr;
    }
    public void setCodr(int codr) {
        this.codr = codr;
    }
    public int getCod_prod() {
        return cod_prod;
    }
    public void setCod_prod(int cod_prod) {
        this.cod_prod = cod_prod;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
}
