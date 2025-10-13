package Practica4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LerProductoTransient {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("/home/dam/Escritorio/AD/1ºTRIMESTRE/Tareas_AD/src/Practica4/serial2.txt"))) {

            ProductoTransient p = (ProductoTransient) ois.readObject();
            System.out.println("Obxecto lido: " + p);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
