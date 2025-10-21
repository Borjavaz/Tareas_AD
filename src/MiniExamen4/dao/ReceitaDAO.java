package MiniExamen4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReceitaDAO {

    public double calcularSumaCalorias(Connection con, int codReceita) throws SQLException {
        double sumaCalorias = 0.0;

        // Esta consulta solo necesita obtener el peso y las calorías por 100g
        String sql = """
                SELECT 
                    c.peso, 
                    p.calorias_100g
                FROM 
                    composicion c
                JOIN 
                    productos p ON c.cod_prod = p.cod_prod
                WHERE 
                    c.codr = ?
                """;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, codReceita);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                double peso = rs.getDouble("peso");
                double caloriasPor100g = rs.getDouble("calorias_100g");

                // Aplica la lógica de cálculo y acumula el total
                sumaCalorias += (peso / 100.0) * caloriasPor100g;
            }

            return sumaCalorias;

        } catch (SQLException e) {
            System.err.println("Error al calcular la suma de calorías para la receta " + codReceita + ": " + e.getMessage());
            throw e;
        }
    }

    public double calcularSumaAzucares(Connection con, int codReceita) throws SQLException {
        double sumaAzucares = 0.0;

        // Esta consulta solo necesita obtener el peso y los azúcares por 100g
        String sql = """
                SELECT 
                    c.peso, 
                    p.azucres_100g
                FROM 
                    composicion c
                JOIN 
                    productos p ON c.cod_prod = p.cod_prod
                WHERE 
                    c.codr = ?
                """;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, codReceita);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                double peso = rs.getDouble("peso");
                double azucaresPor100g = rs.getDouble("azucres_100g");

                // Aplica la lógica de cálculo y acumula el total
                sumaAzucares += (peso / 100.0) * azucaresPor100g;
            }

            return sumaAzucares;

        } catch (SQLException e) {
            System.err.println("Error al calcular la suma de azúcares para la receta " + codReceita + ": " + e.getMessage());
            throw e;
        }
    }
}