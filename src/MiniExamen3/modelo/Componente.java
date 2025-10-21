package MiniExamen3.modelo;

public class Componente {
    private String codigoc;
    private String nome;
    private Integer graxa;

    public Componente(String codigoc, String nome, Integer graxa) {
        this.codigoc = codigoc;
        this.nome = nome;
        this.graxa = graxa;
    }

    public Componente() {}

    public String getCodigoc() { return codigoc; }
    public void setCodigoc(String codigoc) { this.codigoc = codigoc; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Integer getGraxa() { return graxa; }
    public void setGraxa(Integer graxa) { this.graxa = graxa; }
}
