package Practica4;

import java.io.Serializable;

public class ProductoTransient implements Serializable {
    private String nome;
    private transient int  num1;
    private double num2;

    public ProductoTransient (String nome,int num1, double num2) {
        this.nome = nome;
        this.num1 = num1;
        this.num2 = num2;
    }

    public ProductoTransient () {}

    @Override
    public String toString() {
        return "Producto Transient{" +
                "nome ='" + nome + '\'' +
                ", num1 ='" + num1 + '\'' +
                ", num2 =" + num2 + '\'' + '}';
    }
}
