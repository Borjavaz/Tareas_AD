package Tarea3;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimeMetodos {
    private final Conexion conexion = new Conexion();

    // CREATE
    public void insertar(Anime anime) {
        String sql = "INSERT INTO anime (nome, descripcion, data, puntuacion) VALUES (?, ?, ?, ?)";
        try (Connection conn = conexion.conexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, anime.getNome());
            ps.setString(2, anime.getDescripcion());
            ps.setDate(3, anime.getData());
            ps.setInt(4, anime.getPuntuacion());
            ps.executeUpdate();

            System.out.println("Registro insertado correctamente.");

        } catch (SQLException e) {
            System.err.println("Error al insertar: " + e.getMessage());
        }
    }

    // READ - todos los registros
    public List<Anime> listarTodos() {
        List<Anime> lista = new ArrayList<>();
        String sql = "SELECT * FROM anime";

        try (Connection conn = conexion.conexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Anime anime = new Anime(
                        rs.getString("nome"),
                        rs.getString("descripcion"),
                        rs.getDate("data"),
                        rs.getInt("puntuacion")
                );
                lista.add(anime);
            }

        } catch (SQLException e) {
            System.err.println("Error al leer datos: " + e.getMessage());
        }
        return lista;
    }

    // READ - filtrado por nombre
    public Anime buscarPorNome(String nome) {
        String sql = "SELECT * FROM anime WHERE nome = ?";
        try (Connection conn = conexion.conexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Anime(
                        rs.getString("nome"),
                        rs.getString("descripcion"),
                        rs.getDate("data"),
                        rs.getInt("puntuacion")
                );
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar: " + e.getMessage());
        }
        return null;
    }

    // UPDATE
    public void actualizar(Anime anime) {
        String sql = "UPDATE anime SET descripcion = ?, data = ?, puntuacion = ? WHERE nome = ?";
        try (Connection conn = conexion.conexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, anime.getDescripcion());
            ps.setDate(2, anime.getData());
            ps.setInt(3, anime.getPuntuacion());
            ps.setString(4, anime.getNome());
            int filas = ps.executeUpdate();

            System.out.println(filas + " registro actualizado.");

        } catch (SQLException e) {
            System.err.println("Error al actualizar: " + e.getMessage());
        }
    }

    // DELETE
    public void eliminar(String nome) {
        String sql = "DELETE FROM anime WHERE nome = ?";
        try (Connection conn = conexion.conexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nome);
            int filas = ps.executeUpdate();

            System.out.println(filas + " registro eliminado.");

        } catch (SQLException e) {
            System.err.println("Error al eliminar: " + e.getMessage());
        }
    }
}
