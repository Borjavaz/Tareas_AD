package MiniExamen3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlatosDAO {

    public double calcularGraxaTotal(Connection con, int codp) throws SQLException {
        double graxaTotal = 0.0;

        String sql = """
                SELECT c.graxa, co.peso
                FROM composicion co
                JOIN componentes c ON co.codigoc = c.codigoc
                WHERE co.codp = ?
                """;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, codp);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                double graxa = rs.getDouble("graxa");
                double peso = rs.getDouble("peso");
                graxaTotal += (peso / 100.0) * graxa;
            }
        }
        return graxaTotal;
    }
}
