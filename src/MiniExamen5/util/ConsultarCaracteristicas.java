package MiniExamen5.util;

import MiniExamen5.modelo.Transporte;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConsultarCaracteristicas {
    // Se elimina el '::text' que es de PostgreSQL y se añade el 'cod' al SELECT
    public static List<Transporte> ConsultarCaracteristicas(Connection conn, List<String> codigos) throws SQLException {
        List<Transporte> vehiculos = new ArrayList<>(); // Renombrado a vehiculos

        if (codigos.isEmpty()) {
            return vehiculos;
        }

        // Construye una sentencia SQL preparada con tantos placeholders (?) como códigos haya
        String placeholders = String.join(",", Collections.nCopies(codigos.size(), "?"));
        // Se añade 'cod' al SELECT
        String sql = "SELECT cod, tipo, capacidade, consumo FROM transportes WHERE cod IN (" + placeholders + ")";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Asigna cada código al placeholder correspondiente
            for (int i = 0; i < codigos.size(); i++) {
                pstmt.setString(i + 1, codigos.get(i));
            }

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String cod = rs.getString("cod"); // Se obtiene el código
                    String tipo = rs.getString("tipo");
                    double capacidade = rs.getDouble("capacidade");
                    double consumo = rs.getDouble("consumo");
                    // Se usa el constructor corregido de 4 argumentos: cod, tipo, capacidad, consumo
                    vehiculos.add(new Transporte(cod, tipo, capacidade, consumo));
                }
            }
        }
        return vehiculos;
    }
}