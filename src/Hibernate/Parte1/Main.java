package Hibernate.Parte1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PokedexDAO dao = new PokedexDAO();

        try {
            System.out.println("=== SECUENCIA POKEDEX ===\n");

            // 1. Inserir 10 pokemons
            System.out.println("1. INSERINDO 10 POKEMONS:");
            dao.insertar(new Pokedex("Pikachu", 6.0, "Pokémon eléctrico"));
            dao.insertar(new Pokedex("Charmander", 8.5, "Pokémon de lume"));
            dao.insertar(new Pokedex("Bulbasaur", 6.9, "Pokémon de planta"));
            dao.insertar(new Pokedex("Squirtle", 9.0, "Pokémon de auga"));
            dao.insertar(new Pokedex("Eevee", 6.5, "Evolución múltiple"));
            dao.insertar(new Pokedex("Jigglypuff", 5.5, "Pokémon de canto"));
            dao.insertar(new Pokedex("Meowth", 4.2, "Pokémon que fala"));
            dao.insertar(new Pokedex("Psyduck", 19.6, "Dores de cabeza"));
            dao.insertar(new Pokedex("Snorlax", 460.0, "Pokémon durmión"));
            dao.insertar(new Pokedex("Gyarados", 235.0, "Pokémon de auga"));
            System.out.println("10 pokemons inseridos\n");

            // 2. Listar pokemons
            System.out.println("2. LISTANDO POKEMONS:");
            listarPokemons(dao);

            // 3. Modificar dúas entradas
            System.out.println("3. MODIFICANDO DUAS ENTRADAS:");

            // Modificación con obxecto
            Pokedex pikachu = dao.buscarPorId(1L);
            pikachu.setPeso(6.5);
            pikachu.setMisc("MODIFICADO - Pokémon eléctrico");
            dao.actualizar(pikachu);
            System.out.println("Pikachu modificado con obxecto");

            // Modificación con query
            dao.actualizarPeso(2L, 9.0);
            System.out.println("Charmander modificado con query\n");

            // 4. Listar despois das modificacións
            System.out.println("4. LISTANDO DESPOIS DAS MODIFICACIÓNS:");
            listarPokemons(dao);

            // 5. Eliminar todos
            System.out.println("5. ELIMINANDO TODOS OS POKEMONS:");
            dao.eliminarTodos();
            System.out.println("Pokemons eliminados. Total restante: " + dao.contar());

        } finally {
            dao.close();
        }
    }

    private static void listarPokemons(PokedexDAO dao) {
        List<Pokedex> pokemons = dao.listarTodos();
        for (Pokedex p : pokemons) {
            System.out.println(p);
        }
        System.out.println("Total: " + pokemons.size() + " pokemons\n");
    }
}
