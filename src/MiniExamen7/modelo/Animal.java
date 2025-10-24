package MiniExamen7.modelo;

import java.io.Serializable;

public class Animal implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String nome;
    private String especie;
    private int anoChegada;
    private String descricion;

    // Construtor completo BD
    public Animal(int id, String nome, String especie, int anoChegada, String descricion) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.anoChegada = anoChegada;
        this.descricion = descricion;
    }

    // Construtor para inserción (autoxerado o ID)
    public Animal(String nome, String especie, int anoChegada, String descricion) {
        this.nome = nome;
        this.especie = especie;
        this.anoChegada = anoChegada;
        this.descricion = descricion;
    }

    // Getters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getEspecie() { return especie; }
    public int getAnoChegada() { return anoChegada; }
    public String getDescricion() { return descricion; }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", especie='" + especie + '\'' +
                ", anoChegada=" + anoChegada +
                ", descricion='" + descricion + '\'' +
                '}';
    }
}