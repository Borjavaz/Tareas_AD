package MiniExamen6.util;

import MiniExamen6.modelo.Libro;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class DeserializarFicheiro {
    public static void main(String[] args) {
        String filePath = "/home/dam/Escritorio/AD/1ºTRIMESTRE/Tareas_AD/src/MiniExamen6/libros.pkl";

        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(filePath))) {

            // Leer el objeto completo (la lista) y hacer un casting
            List<Libro> listaLeida = (List<Libro>) ois.readObject();

            System.out.println("Lista de Libros lida correctamente. Total: " + listaLeida.size());

            // Recorrer la lista para mostrar cada libro
            for (Libro libro : listaLeida) {
                System.out.println("Obxecto lido: " + libro);
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao ler o ficheiro: " + e.getMessage());
        }
    }
}
