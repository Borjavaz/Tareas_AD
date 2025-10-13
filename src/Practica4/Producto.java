package Practica4;

import java.io.Serializable;

public class Producto implements Serializable {

    private String nome;
    private int num1;
    private double num2;


    public Producto (String nome,int num1, double num2) {
        this.nome = nome;
        this.num1 = num1;
        this.num2 = num2;
    }

    public Producto() {}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public int getNum1() {return num1;}
    public void setNum1(int num1) {this.num1 = num1;}

    public double getNum2() {return num2;}
    public void setNum2(double num2) {this.num2 = num2;}


    @Override
    public String toString() {
        return "Producto{" +
                "nome ='" + nome + '\'' +
                ", num1 ='" + num1 + '\'' +
                ", num2 =" + num2 + '\'' + '}';
    }
}