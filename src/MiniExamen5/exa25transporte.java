package MiniExamen5;

import MiniExamen5.util.Conexion; // Corregido: importación de Conexion
import MiniExamen5.modelo.Transporte;
import MiniExamen5.util.ConsultarCaracteristicas;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static MiniExamen5.util.SerializarFicheiros.ordenarImprimir;
import static MiniExamen5.util.leerFicheiros.leerFicheros;

public class exa25transporte {
    public static void main(String[] args) {
        Connection conn = null; // conn inicializado a null
        // Definir la ruta del archivo de códigos para evitar repetición
        String rutaCodigos = "/home/dam/Escritorio/AD/1ºTRIMESTRE/Tareas_AD/src/MiniExamen5/codigosTransportes.txt";

        try {
            // 1. Obtener la conexión y asignarla a 'conn' para usarla y cerrarla en finally
            conn = Conexion.getConexion(); // Se usa la conexión

            // 2. Leer los códigos
            List<String> codigos = leerFicheros(rutaCodigos);

            if (!codigos.isEmpty()) {
                // 3. Consultar la base de datos
                // Corregido: Llamada al método estático y añadido el ';'
                List<Transporte> vehiculos = ConsultarCaracteristicas.ConsultarCaracteristicas(conn,codigos);

                if (vehiculos != null && !vehiculos.isEmpty()) { // Verificar también si no es null
                    // 4. Ordenar, imprimir y escribir (incluyendo serialización)
                    ordenarImprimir(vehiculos);
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