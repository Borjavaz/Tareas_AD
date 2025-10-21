package MiniExamen4.util;

import MiniExamen4.modelo.Receita;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializarFicheiro {
    public static void main(String[] args) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("receitasnutri"))) {
            Receita r1 = new Receita(1, "smoothiefresa");
            Receita r2 = new Receita(2, "mueslicaseiro");

            oos.writeObject(r1);
            oos.writeObject(r2);

            System.out.println("Ficheiro 'receitasnutri' creado correctamente.");
        } catch (IOException e) {
            System.out.println("Erro ao crear o ficheiro: " + e.getMessage());
        }
    }
}