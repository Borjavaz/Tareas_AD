package Tarea3;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        AnimeMetodos metodo = new AnimeMetodos();

        System.out.println("Insertando anime...");
        Anime novo = new Anime("Inazuma", "Arriba, chuta, la victoria es tuya", Date.valueOf("2025-11-7"), 9);
        metodo.insertar(novo);

        System.out.println("\nListando todos los animes:");
        metodo.listarTodos().forEach(System.out::println);

        System.out.println("\nActualizando anime...");
        Anime actualizado = new Anime("Inazuma", "INAZUMA CAMPEON!!!", Date.valueOf("2025-11-10"), 10);
        metodo.actualizar(actualizado);

        System.out.println("\nLeyendo anime actualizado:");
        System.out.println(metodo.buscarPorNome("Inazuma"));

        System.out.println("\nEliminando anime...");
        metodo.eliminar("Inazuma");

        System.out.println("\nListando de nuevo:");
        metodo.listarTodos().forEach(System.out::println);

    }
}
