package MiniExamen6.dao;

import MiniExamen.Vehiculo;
import MiniExamen6.modelo.Libro;
import MiniExamen6.util.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {

    // INSERT

    public void insertarLibro(Libro libro) {
        String sql = "INSERT INTO libro (titulo, autor, anoPublicacion, descripcion) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setInt(3, libro.getAnoPublicacion());
            ps.setString(4, libro.getDescripcion());
            ps.executeUpdate();

            System.out.println("Registro insertado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }

    // READ

    public static List<Libro> listarTodos() {
        List<Libro> lista = new ArrayList<>();
        String sql = "SELECT * FROM libro";

        try (Connection conn = Conexion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Libro libro = new Libro(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getInt("anoPublicacion"),
                        rs.getString("descripcion")
                );
                lista.add(libro);
            }

        } catch (SQLException e) {
            System.err.println("Error al leer datos: " + e.getMessage());
        }
        return lista;
    }
}
