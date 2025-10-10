package MiniExamen;

import java.sql.Date;

public class Vehiculo {

    private String marca;
    private String modelo;
    private int ano;
    private String descripcion;

    public Vehiculo (String marca, String modelo, int ano, String descripcion) {

        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.descripcion = descripcion;
    }

    public String getMarca() {return marca;}
    public void setMarca(String marca) {this.marca = marca;}

    public String getModelo() {return modelo;}
    public void setModelo(String modelo) {this.modelo = modelo;}

    public int getAno() {return ano;}
    public void setAno(int ano) {this.ano = ano;}

    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}


    @Override
    public String toString() {
        return "Vehiculo{" +
                "marca ='" + marca + '\'' +
                ", modelo ='" + modelo + '\'' +
                ", ano =" + ano +
                ", descripcio =" + descripcion +
                '}';
    }
}