package MiniExamen7.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    // ACTUALIZA ESTES VALORES
    private static final String URL = "jdbc:postgresql://10.0.9.122:5432/probas2";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin";

    public static Connection conectar() throws SQLException {
        // Asegúrate de ter o driver JDBC de MySQL/PostgreSQL no classpath
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}