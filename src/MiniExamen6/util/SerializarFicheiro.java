package MiniExamen6.util;

import MiniExamen6.dao.LibroDAO;
import MiniExamen6.modelo.Libro;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class SerializarFicheiro {
    public static void main(String[] args) {

        LibroDAO metodo = new LibroDAO();
        System.out.println("Listando libros de la BD para serializar...");
        // La conexión se establecerá al llamar a listarTodos
        List<Libro> listaLibros = LibroDAO.listarTodos();

        String filePath = "/home/dam/Escritorio/AD/1ºTRIMESTRE/Tareas_AD/src/MiniExamen6/libros.pkl";

        // 2. Serializar la lista completa de libros
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(filePath))) {

            // Serializa la lista completa como un único objeto
            oos.writeObject(listaLibros);

            System.out.println("Lista de " + listaLibros.size() + " Libros gardados correctamente no ficheiro: " + filePath);

        } catch (IOException e) {
            System.out.println("Erro ao gardar o ficheiro: " + e.getMessage());
        }
    }
}
