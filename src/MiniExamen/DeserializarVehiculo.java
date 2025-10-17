package MiniExamen;

import Practica4.Producto;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class DeserializarVehiculo {
    public static void main(String[] args) {
        String filePath = "/home/dam/Escritorio/AD/1ºTRIMESTRE/Tareas_AD/src/MiniExamen/serial.txt";

        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(filePath))) {

            // Leer el objeto completo (la lista) y hacer un casting
            List<Vehiculo> listaLeida = (List<Vehiculo>) ois.readObject();

            System.out.println("Lista de Vehiculos lida correctamente. Total: " + listaLeida.size());

            // Recorrer la lista para mostrar cada vehículo
            for (Vehiculo v : listaLeida) {
                System.out.println("Obxecto lido: " + v);
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao ler o ficheiro: " + e.getMessage());
        }
    }
}
