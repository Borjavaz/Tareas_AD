package MiniExamen;

public class InventarioTenda {
    private int idVehiculo;
    private double PrezoMayorista;
    private double PrezoVenta;
    private int PorcentaxeOferta;

    public InventarioTenda(int idVehiculo, double PrezoMayorista, double PrezoVenta, int PorcentaxeOferta) {

        this.idVehiculo = idVehiculo;
        this.PrezoMayorista = PrezoMayorista;
        this.PrezoVenta = PrezoVenta;
        this.PorcentaxeOferta = PorcentaxeOferta;
    }

    public int getIdVehiculo() {return idVehiculo;}
    public void setIdVehiculo(int idVehiculo) {this.idVehiculo = idVehiculo;}

    public double getPrezoMayorista() {return PrezoMayorista;}
    public void setPrezoMayorista(double PrezoMayorista) {this.PrezoMayorista = PrezoMayorista;}

    public double getPrezoVenta() {return PrezoVenta;}
    public void setPrezoVenta(double PrezoVenta) {this.PrezoVenta = PrezoVenta;}

    public int getPorcentaxeOferta() {return PorcentaxeOferta;}
    public void setPorcentaxeOferta(int PorcentaxeOferta) {this.PorcentaxeOferta = PorcentaxeOferta;}

}
