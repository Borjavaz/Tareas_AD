package MiniExamen;

public class Main {
    public static void main(String[] args) {

        //Inserto los 5 vehiculos
        VehiculoMetodos metodo = new VehiculoMetodos();

        //Insertar valores en inventario tienda
        InventarioTendaMetodos metodo2 = new InventarioTendaMetodos();



        Vehiculo mustang = new Vehiculo(0, "Ford", "Mustang", 2021, "Deportivos americanos icónicos");
        metodo.insertarVehiculo(mustang);
        Vehiculo tesla = new Vehiculo(0, "Tesla", "Model S", 2023, "Sedán eléctrico de luxo con gran autonomía");
        metodo.insertarVehiculo(tesla);
        Vehiculo honda = new Vehiculo(0, "Honda", "Civic", 2020, "Compacto de gran fiabilidade");
        metodo.insertarVehiculo(honda);
        Vehiculo chevrolet = new Vehiculo(0, "Chevrolet", "Corvette", 2022, "Deportivo americano con motor V8");
        metodo.insertarVehiculo(chevrolet);
        Vehiculo toyota = new Vehiculo(0, "Toyota", "Prius", 2022, "Híbrido de baixo consumo e ecolóxico.");
        metodo.insertarVehiculo(toyota);




        InventarioTenda novo1 = new InventarioTenda(0, 1, 25000.00, 30000.00, 10);
        metodo2.insertarInventarioTenda(novo1);
        InventarioTenda novo2 = new InventarioTenda(0, 2, 40000.00, 50000.00, 12);
        metodo2.insertarInventarioTenda(novo2);
        InventarioTenda novo3 = new InventarioTenda(0, 3, 18000.00, 22000.00, 5);
        metodo2.insertarInventarioTenda(novo3);
        InventarioTenda novo4 = new InventarioTenda(0, 4, 60000.00, 70000.00, 8);
        metodo2.insertarInventarioTenda(novo4);
        InventarioTenda novo5 = new InventarioTenda(0, 5, 25000.00, 30000.00, 6);
        metodo2.insertarInventarioTenda(novo5);



    }
}
