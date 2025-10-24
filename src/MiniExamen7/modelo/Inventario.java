package MiniExamen7.modelo;

import java.io.Serializable;

public class Inventario implements Serializable {

    private int idAnimal;
    private double custoMantemento;
    private double prezoEntrada;
    private int porcentaxeDesconto;

    private static final long serialVersionUID = 1L;

    // Construtor para inserción
    public Inventario(int idAnimal, double custoMantemento, double prezoEntrada, int porcentaxeDesconto) {
        this.idAnimal = idAnimal;
        this.custoMantemento = custoMantemento;
        this.prezoEntrada = prezoEntrada;
        this.porcentaxeDesconto = porcentaxeDesconto;
    }

    // Getters
    public int getIdAnimal() { return idAnimal; }
    public double getCustoMantemento() { return custoMantemento; }
    public double getPrezoEntrada() { return prezoEntrada; }
    public int getPorcentaxeDesconto() { return porcentaxeDesconto; }
}