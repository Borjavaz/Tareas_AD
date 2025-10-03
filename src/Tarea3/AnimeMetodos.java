package Tarea3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnimeMetodos {

    // --- CREATE: Inserta un nuevo registro ---
    public void insert(Anime anime) {
        String sql = "INSERT INTO anime (nome, descripcion, data, puntuacion) VALUES (?, ?, ?, ?)";
        // try-with-resources asegura que la conexión y el PreparedStatement se cierren automáticamente
        try (Connection conn = new Conexion().conexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, anime.getNome());
            pstmt.setString(2, anime.getDescripcion());
            pstmt.setDate(3, anime.getData());
            pstmt.setInt(4, anime.getPuntuacion());

            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println(">> REXISTRO CREADO: " + anime.getNome());
            }
        } catch (SQLException e) {
            System.err.println("Error al insertar el registro: " + e.getMessage());
        }
    }

    // --- READ: Lee todos los registros ---
    public List<Anime> getAll() {
        List<Anime> animes = new ArrayList<>();
        String sql = "SELECT nome, descripcion, data, puntuacion FROM anime";

        try (Connection conn = new Conexion().conexion();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Anime anime = new Anime(
                        rs.getString("nome"),
                        rs.getString("descripcion"),
                        rs.getDate("data"),
                        rs.getInt("puntuacion")
                );
                animes.add(anime);
            }
        } catch (SQLException e) {
            System.err.println("Error al leer todos los registros: " + e.getMessage());
        }
        return animes;
    }

    // --- READ: Lee un registro filtrado por nombre ---
    public Anime getByNome(String nome) {
        String sql = "SELECT nome, descripcion, data, puntuacion FROM anime WHERE nome = ?";
        Anime anime = null;

        try (Connection conn = new Conexion().conexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nome);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) { // Solo esperamos una fila, ya que 'nome' es único
                    anime = new Anime(
                            rs.getString("nome"),
                            rs.getString("descripcion"),
                            rs.getDate("data"),
                            rs.getInt("puntuacion")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al leer registro por nombre: " + e.getMessage());
        }
        return anime;
    }

    // --- UPDATE: Actualiza un registro ---
    public void update(Anime anime) {
        // La actualización se basa en el campo 'nome' (asumiendo que es la clave)
        String sql = "UPDATE anime SET descripcion = ?, data = ?, puntuacion = ? WHERE nome = ?";

        try (Connection conn = new Conexion().conexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, anime.getDescripcion());
            pstmt.setDate(2, anime.getData());
            pstmt.setInt(3, anime.getPuntuacion());
            pstmt.setString(4, anime.getNome()); // WHERE clause

            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println(">> REXISTRO ACTUALIZADO: " + anime.getNome());
            } else {
                System.out.println(">> Non se atopou o rexistro a actualizar: " + anime.getNome());
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar el registro: " + e.getMessage());
        }
    }

    // --- DELETE: Elimina un registro ---
    public void delete(String nome) {
        String sql = "DELETE FROM anime WHERE nome = ?";

        try (Connection conn = new Conexion().conexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nome);

            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println(">> REXISTRO ELIMINADO: " + nome);
            } else {
                System.out.println(">> Non se atopou o rexistro a eliminar: " + nome);
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar el registro: " + e.getMessage());
        }
    }
}