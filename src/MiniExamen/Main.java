package MiniExamen;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Inserto los 5 vehiculos
        VehiculoMetodos metodo = new VehiculoMetodos();

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

        //Insertar valores en inventario tienda
        InventarioTendaMetodos metodo2 = new InventarioTendaMetodos();

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



        // Consulta os IDs que teñen agora os vehículos e lístaos.
        System.out.println("\n--- IDs dos Vehículos Inseridos ---");
        List<Vehiculo> vehiculosDB = metodo.listarTodos();
        for (Vehiculo v : vehiculosDB) {
            System.out.println("ID: " + v.getId() + ", Marca: " + v.getMarca() + ", Modelo: " + v.getModelo());
        }

        // Serializar a táboa Vehiculo (Exporta as entradas da táboa Vehiculo nun ficheiro).
        MiniExamen.SerializarVehiculo.main(null);

        // Mostra unha mensaxe que poña “OFERTAS COCHES”.
        System.out.println("\n*** OFERTAS COCHES ***");

        // Modifica a porcentaxe de oferta dos vehículos en InventarioTenda para sumarlle 15.
        System.out.println("\n Modificando Porcentaxe Oferta (+15) ");
        List<InventarioTenda> inventario = metodo2.listarTodos();
        for (InventarioTenda it : inventario) {
            it.setPorcentaxeOferta(it.getPorcentaxeOferta() + 15);
            metodo2.modificar(it);
        }

        // Lista o prezo actual de venda do Ford Mustang. (Asume o ID do Mustang como 1)
        System.out.println("\n--- Prezo Actual Ford Mustang ---");
        InventarioTenda mustangInv = inventario.stream()
                .filter(i -> i.getIdVehiculo() == 1)
                .findFirst().orElse(null);

        if (mustangInv != null) {
            double porcentaxeActual = mustangInv.getPorcentaxeOferta();
            double novoPorcentaxe = porcentaxeActual + 15.0;

            mustangInv.setPorcentaxeOferta((int)novoPorcentaxe);

            double prezoVenda = mustangInv.getPrezoVenta();
            double prezoFinal = prezoVenda - (prezoVenda * novoPorcentaxe / 100.0);

            System.out.printf("Mustang (ID Vehículo 1): Prezo de Venda: %.2f, Oferta Inicial: %.0f%%, Oferta Final: %.0f%%, Prezo Final: %.2f%n",
                    prezoVenda, porcentaxeActual, novoPorcentaxe, prezoFinal);
        }

        // Lee as entradas de vehículo do ficheiro serializado e Escribe nun ficheiro de texto o lido

        System.out.println("\n Lectura do ficheiro serializado");
        MiniExamen.DeserializarVehiculo.main(null);
    }
}
