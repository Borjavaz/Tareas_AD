package Practica4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class GardarProductoTransient {
    public static void main(String[] args) {
        ProductoTransient p = new ProductoTransient("Melon", 123, 3.5);

        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("/home/dam/Escritorio/AD/1ºTRIMESTRE/Tareas_AD/src/Practica4/serial2.txt"))) {

            oos.writeObject(p);
            System.out.println("Obxecto gardado correctamente ");

        } catch (IOException e) {
            System.out.println("Erro ao gardar: " + e.getMessage());
        }
    }
}
