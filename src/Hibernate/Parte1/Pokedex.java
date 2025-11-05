package Hibernate.Parte1;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pokedex")
public class Pokedex implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "peso")
    private Double peso;

    @Column(name = "misc")
    private String misc;

    // Constructores
    public Pokedex() {}

    public Pokedex(String nome, Double peso, String misc) {
        this.nome = nome;
        this.peso = peso;
        this.misc = misc;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Double getPeso() { return peso; }
    public void setPeso(Double peso) { this.peso = peso; }

    public String getMisc() { return misc; }
    public void setMisc(String misc) { this.misc = misc; }

    @Override
    public String toString() {
        return String.format("Pokedex{id=%d, nome='%s', peso=%.1f, misc='%s'}",
                id, nome, peso, misc);
    }
}