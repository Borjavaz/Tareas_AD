package MiniExamen2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.sql.*;
import java.util.*;

public class GestorUnidades {

    public static List<String> leerCodigos(String rutaFichero) {
        List<String> codigos = new ArrayList<>();
        System.out.println("Leyendo códigos desde: " + rutaFichero);

        try (BufferedReader br = new BufferedReader(new FileReader(rutaFichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String codigo = linea.trim();
                if (!codigo.isEmpty()) {
                    codigos.add(codigo);
                }
            }
        } catch (IOException e) {
            System.err.println("ERROR al leer el archivo de códigos: " + e.getMessage());
        }
        return codigos;
    }
    public static List<UnidadSororitas> consultarUnidades(Connection conn, List<String> codigos) throws SQLException {
        List<UnidadSororitas> unidades = new ArrayList<>();

        if (codigos.isEmpty()) {
            return unidades;
        }

        // Construye una sentencia SQL preparada con tantos placeholders (?) como códigos haya
        String placeholders = String.join(",", Collections.nCopies(codigos.size(), "?"));
        String sql = "SELECT nome, puntos FROM adeptaSororitas WHERE cod::text IN (" + placeholders + ")";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Asigna cada código al placeholder correspondiente
            for (int i = 0; i < codigos.size(); i++) {
                pstmt.setString(i + 1, codigos.get(i));
            }

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String nombre = rs.getString("nome");
                    int puntos = rs.getInt("puntos");
                    unidades.add(new UnidadSororitas(nombre, puntos));
                }
            }
        }
        return unidades;
    }

    public static void ordenarImprimir(List<UnidadSororitas> unidades) {
        // Ordenar en ORDEN DESCENDENTE por los puntos
        unidades.sort(Comparator.comparing(UnidadSororitas::getPuntos).reversed());

        System.out.println("\n--- Listado Ordenado ---");

        String rutaSalida = "/home/dam/Escritorio/AD/1ºTRIMESTRE/Tareas_AD/src/MiniExamen2/puntosOrdeados.txt";

        try (PrintWriter pw = new PrintWriter(new FileWriter(rutaSalida))) {
            for (UnidadSororitas unidad : unidades) {
                String linea = unidad.toString();

                // Imprimir en consola
                System.out.println(linea);

                // Escribir en el fichero
                pw.println(linea);
            }
            System.out.println("\nDatos exportados a: " + rutaSalida);
        } catch (IOException e) {
            System.err.println("ERROR al escribir el fichero de salida: " + e.getMessage());
        }
    }
}