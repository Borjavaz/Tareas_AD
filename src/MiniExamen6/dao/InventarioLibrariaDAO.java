package MiniExamen6.dao;

import MiniExamen6.modelo.InventarioLibraria;
import MiniExamen6.util.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InventarioLibrariaDAO {

    // INSERT

    public void insertarInventario(InventarioLibraria invent) {
        String sql = "INSERT INTO InventarioLibraria (idLibrp, prezpCompra, prezoVenta, desconto) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, invent.getIdLibro());
            ps.setDouble(2, invent.getPrezoCompra());
            ps.setDouble(3, invent.getPrezoVenda());
            ps.setInt(4, invent.getDesconto());
            ps.executeUpdate();

            System.out.println("Registro insertado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }

    public void aumentarDescontos(int incremento) {
        String sql = "UPDATE InventarioLibraria SET desconto = desconto + ?";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, incremento);
            int filas = ps.executeUpdate();
            System.out.println("Actualizados " + filas + " descontos (+ " + incremento + "%).");

        } catch (SQLException e) {
            System.out.println("Erro ao actualizar descontos: " + e.getMessage());
        }
    }

    public double calcularPrezoFinal(String tituloLibro) {
        String sql = """
            SELECT i.prezoVenta, i.desconto
            FROM InventarioLibraria i
            JOIN Libro l ON i.idLibro = l.Id
            WHERE l.titulo = ?
            """;
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, tituloLibro);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                double prezoVenta = rs.getDouble("prezoVenta");
                int desconto = rs.getInt("desconto");
                return prezoVenta - (prezoVenta * desconto / 100.0);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao calcular prezo final: " + e.getMessage());
        }
        return 0;
    }


}
