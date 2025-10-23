package MiniExamen6.modelo;

import java.io.Serializable;

public class InventarioLibraria implements Serializable {

    private int id;
    private int idLibro;
    private double prezoCompra;
    private double prezoVenda;
    private int desconto;

    public  InventarioLibraria(int id, int idLibro,  double prezoCompra, double prezoVenda, int desconto) {
        this.id = id;
        this.idLibro = idLibro;
        this.prezoCompra = prezoCompra;
        this.prezoVenda = prezoVenda;
        this.desconto = desconto;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdLibro() {
        return idLibro;
    }
    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }
    public double getPrezoCompra() {
        return prezoCompra;
    }
    public void setPrezoCompra(double prezoCompra) {
        this.prezoCompra = prezoCompra;
    }
    public double getPrezoVenda() {
        return prezoVenda;
    }
    public void setPrezoVenda(double prezoVenda) {
        this.prezoVenda = prezoVenda;
    }
    public int getDesconto() {
        return desconto;
    }
    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }
    @Override
    public String toString() {
        return "InventarioLibraria{" +
                " id=" + id +
                ", idLibro ='" + idLibro + '\'' +
                ", prezoCompra  ='" + prezoCompra + '\'' +
                ", prezoVenda =" + prezoVenda + '\'' +
                ", desconto =" + desconto +
                '}';
    }
}
