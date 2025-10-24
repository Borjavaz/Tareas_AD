package MiniExamen7.dao;

import MiniExamen7.modelo.Animal;
import MiniExamen7.util.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalDAO {

    // INSERT Animal
    public void insertarAnimal(Animal animal) {
        String sql = "INSERT INTO Animal (Nome, Especie, AnoChegada, Descricion) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, animal.getNome());
            ps.setString(2, animal.getEspecie());
            ps.setInt(3, animal.getAnoChegada());
            ps.setString(4, animal.getDescricion());
            ps.executeUpdate();

            System.out.println("Animal insertado correctamente: " + animal.getNome());

        } catch (SQLException e) {
            System.err.println("Erro ao insertar Animal: " + e.getMessage());
        }
    }

    // READ ALL Animals
    public List<Animal> listarTodos() {
        List<Animal> lista = new ArrayList<>();
        String sql = "SELECT * FROM Animal";

        try (Connection conn = Conexion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Animal animal = new Animal(
                        rs.getInt("Id"),
                        rs.getString("Nome"),
                        rs.getString("Especie"),
                        rs.getInt("AnoChegada"),
                        rs.getString("Descricion")
                );
                lista.add(animal);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao ler datos de Animal: " + e.getMessage());
        }
        return lista;
    }
}