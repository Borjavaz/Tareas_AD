package MiniExamen;

public class InventarioTenda {
    private int id; // ID del registro de inventario (autogenerado)
    private int idVehiculo; // Clave foránea al vehículo
    private double PrezoMayorista;
    private double PrezoVenta;
    private int PorcentaxeOferta;

    // Constructor con todos los campos
    public InventarioTenda(int id, int idVehiculo, double PrezoMayorista, double PrezoVenta, int PorcentaxeOferta) {

        this.id = id;
        this.idVehiculo = idVehiculo;
        this.PrezoMayorista = PrezoMayorista;
        this.PrezoVenta = PrezoVenta;
        this.PorcentaxeOferta = PorcentaxeOferta;
    }

    // Getters y Setters
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public int getIdVehiculo() {return idVehiculo;}
    public void setIdVehiculo(int idVehiculo) {this.idVehiculo = idVehiculo;}

    public double getPrezoMayorista() {return PrezoMayorista;}
    public void setPrezoMayorista(double PrezoMayorista) {this.PrezoMayorista = PrezoMayorista;}

    public double getPrezoVenta() {return PrezoVenta;}
    public void setPrezoVenta(double PrezoVenta) {this.PrezoVenta = PrezoVenta;}

    public int getPorcentaxeOferta() {return PorcentaxeOferta;}
    public void setPorcentaxeOferta(int PorcentaxeOferta) {this.PorcentaxeOferta = PorcentaxeOferta;}

    @Override
    public String toString() {
        return "InventarioTenda{" +
                "id=" + id +
                ", idVehiculo=" + idVehiculo +
                ", PrezoMayorista=" + PrezoMayorista +
                ", PrezoVenta=" + PrezoVenta +
                ", PorcentaxeOferta=" + PorcentaxeOferta + "%" +
                '}';
    }
}