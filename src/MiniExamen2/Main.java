package MiniExamen2;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        // Definir la ruta del archivo de códigos para evitar repetición
        String rutaCodigos = "/home/dam/Escritorio/AD/1ºTRIMESTRE/Tareas_AD/src/MiniExamen2/codigosUnidades.txt";


        try {
            // 1. Obtener la conexión a la base de datos (se necesita una instancia de Conexion)
            Conexion c = new Conexion(); // Crear instancia
            conn = c.conexion(); // Llamar al método de instancia

            // 2. Leer los códigos
            // Llamar al método estático en GestorUnidades
            List<String> codigos = GestorUnidades.leerCodigos(rutaCodigos);

            if (!codigos.isEmpty()) {
                // 3. Consultar la base de datos
                // Llamar al método estático en GestorUnidades
                List<UnidadSororitas> unidades = GestorUnidades.consultarUnidades(conn, codigos);

                if (unidades != null && !unidades.isEmpty()) { // Verificar también si no es null
                    // 4. Ordenar, imprimir y escribir
                    // Llamar al método estático en GestorUnidades
                    GestorUnidades.ordenarImprimir(unidades);
                } else {
                    System.out.println("No se encontraron unidades en la base de datos para los códigos proporcionados.");
                }
            } else {
                System.out.println("El fichero de códigos está vacío o no existe.");
            }

        } catch (SQLException e) {
            System.err.println("ERROR de base de datos: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("ERROR crítico en el proceso: " + e.getMessage());
        } finally {
            // Asegurarse de cerrar la conexión
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Conexión a BD cerrada.");
                } catch (SQLException e) {
                    System.err.println("Error al cerrar conexión: " + e.getMessage());
                }
            }
        }
    }
}