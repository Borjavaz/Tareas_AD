package MiniExamen7.util;

import MiniExamen7.dao.AnimalDAO;
import MiniExamen7.modelo.Animal;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class Serializar {

    // Define a ruta do ficheiro serializado
    private static final String SERIAL_FILE_PATH = "/home/dam/Escritorio/AD/1ºTRIMESTRE/Tareas_AD/src/MiniExamen7/animais.ser";

    public static void serializarAnimais() {
        AnimalDAO dao = new AnimalDAO();
        List<Animal> listaAnimais = dao.listarTodos();

        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(SERIAL_FILE_PATH))) {

            oos.writeObject(listaAnimais);
            System.out.println(" Serialización completada. Animais gardados en: " + SERIAL_FILE_PATH);

        } catch (IOException e) {
            System.err.println("Erro ao gardar o ficheiro serializado: " + e.getMessage());
        }
    }
}