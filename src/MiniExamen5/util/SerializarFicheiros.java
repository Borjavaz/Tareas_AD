package MiniExamen5.util;

import MiniExamen5.modelo.Transporte;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream; // Importación para serialización binaria
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;

public class SerializarFicheiros {

    public static void ordenarImprimir(List<Transporte> vehiculos) {
        // Ordenar en ORDEN DESCENDENTE por el rendimiento
        vehiculos.sort(Comparator.comparing(Transporte::getRendemento).reversed());

        System.out.println("\n--- Listado Ordenado ---");

        // Rutas
        String rutaListado = "/home/dam/Escritorio/AD/1ºTRIMESTRE/Tareas_AD/src/MiniExamen5/transportesRes.dat";
        String rutaSerializacion = "/home/dam/Escritorio/AD/1ºTRIMESTRE/Tareas_AD/src/MiniExamen5/vehiculos.ser"; // Fichero de serialización real

        // *************** Tarea 1: Imprimir en consola y guardar listado legible (tal como estaba) ***************
        try (PrintWriter pw = new PrintWriter(new FileWriter(rutaListado))) {
            for (Transporte vehiculo : vehiculos) {
                String linea = vehiculo.toString();

                // Imprimir en consola
                System.out.println(linea);

                // Escribir en el fichero de listado legible
                pw.println(linea);
            }
            System.out.println("\nListado (String) exportado a: " + rutaListado);
        } catch (IOException e) {
            System.err.println("ERROR al escribir el fichero de listado legible: " + e.getMessage());
        }


        // *************** Tarea 2: Guardar los objetos mediante SERIALIZACIÓN BINARIA ***************
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaSerializacion))) {
            // Escribir la lista completa de objetos de Transporte
            oos.writeObject(vehiculos);
            System.out.println("Objetos serializados (binario) en: " + rutaSerializacion);
        } catch (IOException e) {
            System.err.println("ERROR al serializar los objetos: " + e.getMessage());
        }
    }
}