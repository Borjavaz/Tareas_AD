package MiniExamen2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection conexion() {

        final String url = "jdbc:postgresql://10.0.9.122:5432/probas";
        final String usuario = "postgres";
        final String contraseña = "admin";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, usuario, contraseña);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar coa base de datos: " + e.getMessage());
        }
        return conn;
    }
}

