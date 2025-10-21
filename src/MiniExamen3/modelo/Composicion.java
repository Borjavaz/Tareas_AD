package MiniExamen3.modelo;

public class Composicion {
    private String codigop;
    private String codigoc;
    private Integer peso;

    public Composicion(String codigop, String codigoc, Integer peso) {
        this.codigop = codigop;
        this.codigoc = codigoc;
        this.peso = peso;
    }

    public Composicion() {}

    public String getCodigop() { return codigop; }
    public void setCodigop(String codigop) { this.codigop = codigop; }

    public String getCodigoc() { return codigoc; }
    public void setCodigoc(String codigoc) { this.codigoc = codigoc; }

    public Integer getPeso() { return peso; }
    public void setPeso(Integer peso) { this.peso = peso; }
}
