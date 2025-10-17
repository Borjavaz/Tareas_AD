package MiniExamen;

import Practica4.Producto;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class SerializarVehiculo {
    public static void main(String[] args) {

        VehiculoMetodos metodo = new VehiculoMetodos();
        System.out.println("Listando vehículos de la BD para serializar...");
        // La conexión se establecerá al llamar a listarTodos
        List<Vehiculo> listaVehiculos = metodo.listarTodos();

        String filePath = "/home/dam/Escritorio/AD/1ºTRIMESTRE/Tareas_AD/src/MiniExamen/serial.txt";

        // 2. Serializar la lista completa de vehículos
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(filePath))) {

            // Serializa la lista completa como un único objeto
            oos.writeObject(listaVehiculos);

            System.out.println("Lista de " + listaVehiculos.size() + " Vehiculos gardados correctamente no ficheiro: " + filePath);

        } catch (IOException e) {
            System.out.println("Erro ao gardar o ficheiro: " + e.getMessage());
        }
    }
}
