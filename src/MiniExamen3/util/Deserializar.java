package MiniExamen3.util;

import MiniExamen3.modelo.Platos;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Deserializar {

    public static List<Platos> lerPlatos(String nomeFicheiro) {
        List<Platos> lista = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeFicheiro))) {
            while (true) {
                try {
                    Platos p = (Platos) ois.readObject();
                    lista.add(p);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Erro lendo o ficheiro: " + e.getMessage());
        }
        return lista;
    }
}
