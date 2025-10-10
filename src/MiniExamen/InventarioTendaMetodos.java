package MiniExamen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InventarioTendaMetodos {

    public void insertarInventarioTenda(InventarioTenda inventariotenda) {
        final MiniExamen.Conexion conexion = new MiniExamen.Conexion();


        String sql = "INSERT INTO inventariotenda (idVehiculo, PrezoMayorista, PrezoVenta, PorcentaxeOferta) VALUES (?, ?, ?, ?)";
        try (Connection conn = conexion.conexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, inventariotenda.getIdVehiculo());
            ps.setDouble(2, inventariotenda.getPrezoMayorista());
            ps.setDouble(3, inventariotenda.getPrezoVenta());
            ps.setInt(4, inventariotenda.getPorcentaxeOferta());
            ps.executeUpdate();

            System.out.println("Registro insertado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }
}
