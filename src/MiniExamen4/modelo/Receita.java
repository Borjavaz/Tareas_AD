package MiniExamen4.modelo;

import java.io.Serializable;

public class Receita implements Serializable {
    private int codr;
    private String nome;

    public Receita(int codr, String nome) {
        this.codr = codr;
        this.nome = nome;
    }

    public Receita() {}

    public int getCodr() { return codr; }
    public void setCodr(int codr) { this.codr = codr; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    @Override
    public String toString() {
        return codr + " " + nome;
    }
}