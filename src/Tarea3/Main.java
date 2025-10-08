package Tarea3;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        AnimeMetodos met = new AnimeMetodos();

        System.out.println("Insertando anime...");
        Anime novo = new Anime("Inazuma", "Arriba, chuta, la victoria es tuya", Date.valueOf("2025-11-7"), 10);
        met.insertar(novo);

        System.out.println("\nListando todos los animes:");
        met.listarTodos().forEach(System.out::println);

        System.out.println("\nActualizando anime...");
        Anime actualizado = new Anime("Inazuma", "Aventura épica de piratas", Date.valueOf("2025-11-7"), 9);
        met.actualizar(actualizado);

        System.out.println("\nLeyendo anime actualizado:");
        System.out.println(met.buscarPorNome("Inazuma"));

        System.out.println("\nEliminando anime...");
        met.eliminar("Inazuma");

        System.out.println("\nListando de nuevo:");
        met.listarTodos().forEach(System.out::println);
    }
}
