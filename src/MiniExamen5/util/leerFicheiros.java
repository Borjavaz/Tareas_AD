package MiniExamen5.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class leerFicheiros {
    public static List<String> leerFicheros(String rutaFichero) {
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
}