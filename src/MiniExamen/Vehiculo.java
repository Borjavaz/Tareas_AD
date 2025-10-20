package MiniExamen;

import java.io.Serializable;
import java.sql.Date;

public class Vehiculo implements Serializable {

    private int id;
    private String marca;
    private String modelo;
    private int ano;
    private String descripcion;

    public Vehiculo (int id,String marca, String modelo, int ano, String descripcion) {

        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.descripcion = descripcion;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

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
                "id=" + id +
                "marca ='" + marca + '\'' +
                ", modelo ='" + modelo + '\'' +
                ", ano =" + ano +
                ", descripcion =" + descripcion +
                '}';
    }
}