package MiniExamen7;

import MiniExamen7.dao.AnimalDAO;
import MiniExamen7.dao.InventarioDAO;
import MiniExamen7.modelo.Animal;
import MiniExamen7.modelo.Inventario;
import MiniExamen7.util.Serializar;
import MiniExamen7.util.Deserializar;
import MiniExamen7.util.XML;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnimalDAO animalDao = new AnimalDAO();
        InventarioDAO inventarioDao = new InventarioDAO();

        System.out.println("---- INICIANDO XESTIÓN DO ZOOLÓXICO ----\n");

        // **************** INSERCIÓN DE ANIMAIS ****************
        System.out.println("---- Inserta na táboa Animal os seguintes animais ----");
        Animal simba = new Animal("Simba", "León", 2019, "Rei da sabana, forte e respectado.");
        Animal dumbo = new Animal("Dumbo", "Elefante", 2021, "Elefante xigante con orellas enormes.");
        Animal marty = new Animal("Marty", "Cebra", 2020, "Moi sociable e amante de correr.");
        Animal gloria = new Animal("Gloria", "Hipopótamo", 2022, "Tranquila pero con moita forza.");
        Animal skipper = new Animal("Skipper", "Pingüín", 2023, "Moi intelixente e líder nato.");

        animalDao.insertarAnimal(simba);
        animalDao.insertarAnimal(dumbo);
        animalDao.insertarAnimal(marty);
        animalDao.insertarAnimal(gloria);
        animalDao.insertarAnimal(skipper);

        System.out.println("\n---- Consulta os IDs actuais dos animais e lístaos ----");
        List<Animal> listaAnimais = animalDao.listarTodos();

        int idSimba = 0, idDumbo = 0, idMarty = 0, idGloria = 0, idSkipper = 0;

        for (Animal animal : listaAnimais) {
            System.out.println("ID: " + animal.getId() + " | Nome: " + animal.getNome());
            // Asignar IDs para o Inventario
            switch (animal.getNome()) {
                case "Simba": idSimba = animal.getId(); break;
                case "Dumbo": idDumbo = animal.getId(); break;
                case "Marty": idMarty = animal.getId(); break;
                case "Gloria": idGloria = animal.getId(); break;
                case "Skipper": idSkipper = animal.getId(); break;
            }
        }
        System.out.println();

        System.out.println("---- Inserta na táboa InventarioZooloxico as seguintes entradas ----");
        inventarioDao.insertarInventario(new Inventario(idSimba, 300.00, 15.00, 5));
        inventarioDao.insertarInventario(new Inventario(idDumbo, 500.00, 18.00, 10));
        inventarioDao.insertarInventario(new Inventario(idMarty, 250.00, 12.00, 8));
        inventarioDao.insertarInventario(new Inventario(idGloria, 400.00, 17.00, 6));
        inventarioDao.insertarInventario(new Inventario(idSkipper, 150.00, 10.00, 4));

        System.out.println(" ");

        System.out.println("----  Exporta as entradas da táboa Animal a XML ----");
        XML.exportarAnimaisAXML();
        System.out.println();

        System.out.println("---- Exporta as entradas da táboa Animal nun ficheiro (Serialización) ----");
        Serializar.serializarAnimais();
        System.out.println();

        // Modifica a porcentaxe de desconto dos animais... sumándolle 15 a todos.
        System.out.println("---- Modifica a porcentaxe de desconto (+15%) ----");
        inventarioDao.aumentarDescontos(15);
        System.out.println();

        // Lista o prezo actual da entrada para Simba (aplicando PorcentaxeDesconto sobre PrezoEntrada).
        System.out.println("---- Lista o prezo actual da entrada para Simba ----");
        double prezoFinal = inventarioDao.calcularPrezoFinalEntrada("Simba");
        System.out.println("O prezo final da entrada para 'Simba' con desconto é: " + prezoFinal + " €");
        System.out.println();


        //Modifica a data de chegada de Marty a 2018 (anterior)
        System.out.println("---- Modificando o Ano de Chegada de Marty a 2018 ----");
        inventarioDao.modificarAnoChegada("Marty", 2018);

        // Ordenar por orde de chegada
        System.out.println("---- Animais ordenados por Orde de Chegada (AnoChegada ASC) ----");
        List<Animal> animaisOrdenados = inventarioDao.ordenarPorAnoChegada();
        for (Animal animal : animaisOrdenados) {
            System.out.println("ID: " + animal.getId() + " | Nome: " + animal.getNome() + " | Ano Chegada: " + animal.getAnoChegada());
        }
        System.out.println();

        // **************** LECTURA E ESCRITURA FINAL ****************

        // ✅ Le as entradas de animais do ficheiro serializado. (Exercicio 2)
        System.out.println("----  Le as entradas de animais do ficheiro serializado ----");
        List<Animal> listaLida = Deserializar.deserializarAnimais();

        // ✅ Escribe nun ficheiro de texto a información lida do ficheiro.
        if (listaLida != null) {
            System.out.println("\n----  Escribe nun ficheiro de texto a información lida ----");
            Deserializar.escribirAnimaisATexto(listaLida);
        }

        System.out.println("\n---- PROGRAMA FINALIZADO ----");
    }
}


