package MiniExamen6;

import MiniExamen6.dao.InventarioLibrariaDAO;
import MiniExamen6.dao.LibroDAO;
import MiniExamen6.modelo.InventarioLibraria;
import MiniExamen6.modelo.Libro;
import MiniExamen6.util.DeserializarFicheiro;
import MiniExamen6.util.ExportarXML;
import MiniExamen6.util.SerializarFicheiro;

import java.util.List;

public class main {
    public static void main(String[] args) {
            LibroDAO libroMetodos = new LibroDAO();
            InventarioLibrariaDAO inventarioMetodos = new InventarioLibrariaDAO();


            System.out.println("---- INSERTANDO LIBROS ----");

        Libro l1 = new Libro(0,"O señor dos aneis", "J.R.R. Tolkien", 1954, "Saga épica de fantasía.");
        Libro l2 = new Libro(1,"1984", "George Orwell", 1949, "Distopía sobre o control estatal.");
        Libro l3 = new Libro(2,"Cem anos de soidade", "Gabriel García Márquez", 1967, "Realismo máxico en Macondo.");
        Libro l4 = new Libro(3,"Don Quixote", "Miguel de Cervantes", 1605, "Clásico da literatura española.");
        Libro l5 = new Libro(4,"A volta ao mundo en 80 días", "Jules Verne", 1872, "Aventura clásica.");

            libroMetodos.insertarLibro(l1);
            libroMetodos.insertarLibro(l2);
            libroMetodos.insertarLibro(l3);
            libroMetodos.insertarLibro(l4);
            libroMetodos.insertarLibro(l5);


        System.out.println("✅ Libros insertados correctamente.\n");


            System.out.println("---- CONSULTANDO IDs DOS LIBROS ----");
            List<Libro> listaLibros = libroMetodos.listarTodos();

            for (Libro libro : listaLibros) {
                System.out.println("ID: " + libro.getId() + " | Título: " + libro.getTitulo());
            }

            System.out.println();

            System.out.println("---- INSERTANDO INVENTARIO ----");

            // Usa los IDs obtenidos (ajusta si cambian en tu BD)
            inventarioMetodos.insertarInventario(new InventarioLibraria(listaLibros.get(0).getId(), 0, 20, 30,5));
            inventarioMetodos.insertarInventario(new InventarioLibraria(listaLibros.get(1).getId(), 1, 10, 15,10));
            inventarioMetodos.insertarInventario(new InventarioLibraria(listaLibros.get(2).getId(), 2, 12, 18,8));
            inventarioMetodos.insertarInventario(new InventarioLibraria(listaLibros.get(3).getId(), 3, 25, 40,6));
            inventarioMetodos.insertarInventario(new InventarioLibraria(listaLibros.get(4).getId(), 4, 8, 12,4));

            System.out.println(" Inventario insertado correctamente.\n");


            System.out.println("---- AUMENTANDO DESCONTOS ----");
            inventarioMetodos.aumentarDescontos(10);


            System.out.println("---- CALCULANDO PREZO FINAL ----");
            double prezoFinal = inventarioMetodos.calcularPrezoFinal("1984");
            System.out.println("O prezo final de 'O principiño' con desconto é: " + prezoFinal + " €\n");


            System.out.println("---- EXPORTANDO A XML ----");
            ExportarXML exportarXML = new ExportarXML();


            System.out.println("---- SERIALIZANDO LISTA ----");
            SerializarFicheiro.main(null);

            System.out.println("Deserializar");
            DeserializarFicheiro.main(null);

        }
}
