package MiniExamen7.dao;

import MiniExamen7.modelo.Animal;
import MiniExamen7.modelo.Inventario;
import MiniExamen7.util.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventarioDAO {

    // INSERT Inventario
    public void insertarInventario(Inventario inventario) {
        String sql = "INSERT INTO InventarioZooloxico (IdAnimal, CustoMantemento, PrezoEntrada, PorcentaxeDesconto) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, inventario.getIdAnimal());
            ps.setDouble(2, inventario.getCustoMantemento());
            ps.setDouble(3, inventario.getPrezoEntrada());
            ps.setInt(4, inventario.getPorcentaxeDesconto());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao insertar Inventario (IdAnimal " + inventario.getIdAnimal() + "): " + e.getMessage());
        }
    }

    // Modifica o campo AnoChegada na táboa Animal
    public void modificarAnoChegada(String nomeAnimal, int novoAno) {
        String sql = "UPDATE Animal SET AnoChegada = ? WHERE Nome = ?";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, novoAno);
            ps.setString(2, nomeAnimal);
            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.println(" Ano de chegada de '" + nomeAnimal + "' actualizado a: " + novoAno);
            } else {
                System.out.println("Erro: Non se atopou o animal '" + nomeAnimal + "' para modificar o ano.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao actualizar o AnoChegada: " + e.getMessage());
        }
    }

    // Devolve unha lista de todos os animais ordenada polo AnoChegada
    public List<Animal> ordenarPorAnoChegada() {
        List<Animal> lista = new ArrayList<>();
        // Ordenamos por AnoChegada de forma ascendente (os máis antigos primeiro)
        String sql = "SELECT * FROM Animal ORDER BY AnoChegada ASC, Id ASC";

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
            System.err.println("Erro ao ordenar e ler datos de Animal: " + e.getMessage());
        }
        return lista;

        }
    // UPDATE Desconto
    public void aumentarDescontos(int incremento) {
        String sql = "UPDATE InventarioZooloxico SET PorcentaxeDesconto = PorcentaxeDesconto + ?";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, incremento);
            int filas = ps.executeUpdate();
            System.out.println("Actualizados " + filas + " descontos (+ " + incremento + "%).");

        } catch (SQLException e) {
            System.err.println("Erro ao actualizar descontos: " + e.getMessage());
        }
    }

    // Calcular Prezo Final
    public double calcularPrezoFinalEntrada(String nomeAnimal) {
        String sql = """
            SELECT i.PrezoEntrada, i.PorcentaxeDesconto
            FROM InventarioZooloxico i
            JOIN Animal a ON i.IdAnimal = a.Id
            WHERE a.Nome = ?
            """;
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nomeAnimal);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                double prezoEntrada = rs.getDouble("PrezoEntrada");
                int desconto = rs.getInt("PorcentaxeDesconto");
                double prezoFinal = prezoEntrada * (1 - desconto / 100.0);
                return Math.round(prezoFinal * 100.0) / 100.0; // Redondear a 2 decimais
            }
        } catch (SQLException e) {
            System.err.println("Erro ao calcular prezo final para " + nomeAnimal + ": " + e.getMessage());
        }
        return 0.0;
    }
}