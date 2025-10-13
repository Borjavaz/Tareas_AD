package Practica4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LerProducto {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("/home/dam/Escritorio/AD/1ºTRIMESTRE/Tareas_AD/src/Practica4/serial.txt"))) {

            Producto p2 = (Producto) ois.readObject();
            System.out.println("Obxecto lido: " + p2);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao ler o ficheiro: " + e.getMessage());
        }
    }
}
