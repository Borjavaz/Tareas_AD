package MiniExamen;

import Tarea3.Anime;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {

        //Inserto los 5 vehiculos

        VehiculoMetodos metodo = new VehiculoMetodos();


        Vehiculo mustang = new Vehiculo("Ford", "Mustang", 2021, "Deportivos americanos icónicos");
        metodo.insertarVehiculo(mustang);
        Vehiculo tesla = new Vehiculo("Tesla", "Model S", 2023, "Sedán eléctrico de luxo con gran autonomía");
        metodo.insertarVehiculo(tesla);
        Vehiculo honda = new Vehiculo("Honda", "Civic", 2020, "Compacto de gran fiabilidade");
        metodo.insertarVehiculo(honda);
        Vehiculo chevrolet = new Vehiculo("Chevrolet", "Corvette", 2022, "Deportivo americano con motor V8");
        metodo.insertarVehiculo(chevrolet);
        Vehiculo toyota = new Vehiculo("Toyota", "Prius", 2022, "Híbrido de baixo consumo e ecolóxico.");
        metodo.insertarVehiculo(toyota);

        System.out.println("Listando todos los vehiculos:");
        metodo.listarTodos().forEach(System.out::println);

        System.out.println("Modificar un vehiculo:");
        Vehiculo actualizado = new Vehiculo("Toyota", "Yaris",2020, "Coche seguro");
        metodo.modificar(actualizado);

        //Insertar valores en inventario tienda

        InventarioTendaMetodos metodo2 = new InventarioTendaMetodos();

        InventarioTenda novo1 = new InventarioTenda(1,25000.00,30000.00, 10);
        metodo2.insertarInventarioTenda(novo1);
        InventarioTenda novo2 = new InventarioTenda(2,40000.00,50000.00, 12);
        metodo2.insertarInventarioTenda(novo2);
        InventarioTenda novo3 = new InventarioTenda(3,18000.00,22000.00, 5);
        metodo2.insertarInventarioTenda(novo3);
        InventarioTenda novo4 = new InventarioTenda(4,60000.00,70000.00, 8);
        metodo2.insertarInventarioTenda(novo4);
        InventarioTenda novo5 = new InventarioTenda(5,25000.00,30000.00, 6);
        metodo2.insertarInventarioTenda(novo5);


    }
}
