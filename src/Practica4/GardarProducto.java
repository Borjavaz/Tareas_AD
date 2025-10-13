package Practica4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class GardarProducto {
    public static void main(String[] args) {
        // Crear un obxecto con valores
        Producto p1 = new Producto("Melon", 14, 3.5);

        // Gardar no ficheiro do Escritorio
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("/home/dam/Escritorio/AD/1ºTRIMESTRE/Tareas_AD/src/Practica4/serial.txt"))) {

            oos.writeObject(p1);
            System.out.println("Obxecto gardado correctamente");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
