package MiniExamen;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehiculoMetodos {
    private final MiniExamen.Conexion conexion = new MiniExamen.Conexion();

    // CREATE
    public void insertarVehiculo(Vehiculo vehiculo) {
        String sql = "INSERT INTO vehiculo (marca, modelo, ano, descripcion) VALUES (?, ?, ?, ?)";
        try (Connection conn = conexion.conexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, vehiculo.getMarca());
            ps.setString(2, vehiculo.getModelo());
            ps.setInt(3, vehiculo.getAno());
            ps.setString(4, vehiculo.getDescripcion());
            ps.executeUpdate();

            System.out.println("Registro insertado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }

    // READ - todos los registros

    public List<Vehiculo> listarTodos() {
        List<Vehiculo> lista = new ArrayList<>();
        String sql = "SELECT * FROM vehiculo";

        try (Connection conn = conexion.conexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Vehiculo vehiculo = new Vehiculo(
                        rs.getInt("id"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("ano"),
                        rs.getString("descripcion")
                );
                lista.add(vehiculo);
            }

        } catch (SQLException e) {
            System.err.println("Error al leer datos: " + e.getMessage());
        }
        return lista;
    }

    // UPDATE
    public void modificar(Vehiculo vehiculo) {
        String sql = "UPDATE vehiculo SET marca = ?, modelo = ?, ano = ?, descripcion = ? WHERE id = ?";
        try (Connection conn = conexion.conexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, vehiculo.getMarca());
            ps.setString(2, vehiculo.getModelo());
            ps.setInt(3, vehiculo.getAno());
            ps.setString(4, vehiculo.getDescripcion());
            ps.setInt(5, vehiculo.getId());
            int filas = ps.executeUpdate();

            System.out.println(filas + " registro actualizado.");

        } catch (SQLException e) {
            System.err.println("Error al actualizar: " + e.getMessage());
        }
    }

    // En VehiculoMetodos.java

    // Nuevo método para eliminar
    public void eliminarVehiculoYInventario(InventarioTendaMetodos metodoInventario, int id, String modelo) {

        // Primero, eliminar todos los registros de inventario asociados (clave foránea)
        metodoInventario.eliminarInventario(id);

        // Segundo, eliminar el vehículo (usando ID y Modelo, según su solicitud)
        String sql = "DELETE FROM vehiculo WHERE id = ? AND modelo = ?";
        try (Connection conn = conexion.conexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.setString(2, modelo);
            int filas = ps.executeUpdate();

            System.out.println(filas + " registro de vehículo eliminado (ID: " + id + ", Modelo: " + modelo + ").");

        } catch (SQLException e) {
            System.err.println("Error al eliminar vehículo: " + e.getMessage());
        }
    }
}
