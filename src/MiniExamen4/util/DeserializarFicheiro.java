package MiniExamen4.util;

import MiniExamen4.modelo.Receita;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DeserializarFicheiro {

    public static List<Receita> lerReceita(String nomeFicheiro) {
        List<Receita> lista = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeFicheiro))) {
            while (true) {
                try {
                    Receita r = (Receita) ois.readObject();
                    lista.add(r);
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