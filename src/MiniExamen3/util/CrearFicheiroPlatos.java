package MiniExamen3.util;

import MiniExamen3.modelo.Platos;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CrearFicheiroPlatos {
    public static void main(String[] args) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("platoss"))) {
            Platos p1 = new Platos(1, "platocarnico1");
            Platos p2 = new Platos(2, "platocarnico2");

            oos.writeObject(p1);
            oos.writeObject(p2);

            System.out.println("Ficheiro 'platoss' creado correctamente.");
        } catch (IOException e) {
            System.out.println("Erro ao crear o ficheiro: " + e.getMessage());
        }
    }
}
