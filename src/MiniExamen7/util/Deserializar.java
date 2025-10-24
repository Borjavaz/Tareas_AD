package MiniExamen7.util;

import MiniExamen7.modelo.Animal;

import java.io.*;
import java.util.List;

public class Deserializar {

    private static final String SERIAL_FILE_PATH = "/home/dam/Escritorio/AD/1ºTRIMESTRE/Tareas_AD/src/MiniExamen7/animais.ser";
    // Define a ruta do ficheiro de texto
    private static final String TEXT_FILE_PATH = "/home/dam/Escritorio/AD/1ºTRIMESTRE/Tareas_AD/src/MiniExamen7/animais_lidos.txt";


    public static List<Animal> deserializarAnimais() {
        List<Animal> listaLida = null;
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(SERIAL_FILE_PATH))) {

            listaLida = (List<Animal>) ois.readObject();

            System.out.println(" Deserialización completada. Total de Animais lidos: " + listaLida.size());

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao ler o ficheiro serializado: " + e.getMessage());
        }
        return listaLida;
    }

    // Parte do Exercizo 4: Escribe nun ficheiro de texto a información lida do ficheiro.
    public static void escribirAnimaisATexto(List<Animal> lista) {
        if (lista == null) {
            System.err.println("Non se pode escribir a ficheiro de texto, a lista de animais é nula.");
            return;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TEXT_FILE_PATH))) {
            for (Animal animal : lista) {
                writer.write(animal.toString());
                writer.newLine();
            }
            System.out.println(" Información lida escrita en ficheiro de texto: " + TEXT_FILE_PATH);
        } catch (IOException e) {
            System.err.println("Erro ao escribir o ficheiro de texto: " + e.getMessage());
        }
    }
}