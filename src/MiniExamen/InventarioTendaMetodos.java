package MiniExamen;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventarioTendaMetodos {
    private final MiniExamen.Conexion conexion = new MiniExamen.Conexion();

    // El objeto a insertar debe ser de tipo InventarioTenda
    public void insertarInventarioTenda(InventarioTenda inventariotenda) {

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

    // El método debe devolver una lista de InventarioTenda
    public List<InventarioTenda> listarTodos() {
        List<InventarioTenda> lista = new ArrayList<>(); // ¡CORRECCIÓN!
        String sql = "SELECT * FROM inventariotenda";

        try (Connection conn = conexion.conexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                // Instanciar el objeto correcto: InventarioTenda
                InventarioTenda inventario = new InventarioTenda(
                        rs.getInt("Id"),
                        rs.getInt("IdVehiculo"),
                        rs.getDouble("PrezoMayorista"),
                        rs.getDouble("PrezoVenta"),
                        rs.getInt("PorcentaxeOferta")
                );
                lista.add(inventario);
            }

        } catch (SQLException e) {
            System.err.println("Error al leer datos: " + e.getMessage());
        }
        return lista;
    }

    // UPDATE
    public void modificar(InventarioTenda inventario) { // ¡CORRECCIÓN!
        String sql = "UPDATE inventariotenda SET IdVehiculo = ?, PrezoMayorista = ?, PrezoVenta = ?, PorcentaxeOferta = ? WHERE Id = ?";
        try (Connection conn = conexion.conexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, inventario.getIdVehiculo());
            ps.setDouble(2, inventario.getPrezoMayorista());
            ps.setDouble(3, inventario.getPrezoVenta());
            ps.setInt(4, inventario.getPorcentaxeOferta());
            ps.setInt(5, inventario.getId());
            int filas = ps.executeUpdate();

            System.out.println(filas + " registro de inventario actualizado (ID Inventario: " + inventario.getId() + ").");

        } catch (SQLException e) {
            System.err.println("Error al actualizar inventario: " + e.getMessage());
        }
    }

    // En InventarioTendaMetodos.java

    // Método para eliminar
    public void eliminarInventario(int idVehiculo) {
        String sql = "DELETE FROM inventariotenda WHERE idVehiculo = ?";
        try (Connection conn = conexion.conexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idVehiculo);
            int filas = ps.executeUpdate();

            System.out.println(filas + " registros de inventario eliminados para el Vehículo ID: " + idVehiculo + ".");

        } catch (SQLException e) {
            System.err.println("Error al eliminar inventario por ID de Vehículo: " + e.getMessage());
        }
    }
}