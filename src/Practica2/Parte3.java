package Practica2;

import java.io.*;
import java.util.Scanner;

public class Parte3{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        String rutaDirectorio = "/home/dam/Escritorio/AD/1ºTRIMESTRE/AD/src/Practica2";
        String nombreFichero = "texto3.txt";

        System.out.println("Introduce la cadena que quieres escribir y leer: ");
        String cadena = sc.nextLine();

        // Grabar tres veces a cadea e amosar tamaño
        escribirCadenas(rutaDirectorio, nombreFichero, cadena, 5);

        // Ler as cadeas e amosar o que queda por ler
        leerCadenas(rutaDirectorio, nombreFichero);
    }

    public static void escribirCadenas(String rutaDirectorio, String nombreFichero, String cadena, int veces) {
        File fichero = new File(rutaDirectorio, nombreFichero);

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fichero))) {
            for (int i = 1; i <= veces; i++) {
                System.out.println("Escribindo a cadea: " + cadena);
                dos.writeUTF(cadena);
                System.out.println("Tamaño do ficheiro: " + dos.size() + " bytes\n");
            }
            System.out.println("Tamaño final do ficheiro: " + dos.size() + " bytes\n");
        } catch (IOException e) {
            System.out.println("Ocorreu un erro ao escribir o ficheiro: " + e.getMessage());
        }
    }

    public static void leerCadenas(String rutaDirectorio, String nombreFichero) {
        File fichero = new File(rutaDirectorio, nombreFichero);

        if (!fichero.exists()) {
            System.out.println("O ficheiro non existe.");
            return;
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream(fichero))) {
            while (dis.available() > 0) {
                System.out.println("Quedan: " + dis.available() + " bytes por ler");
                String cadena = dis.readUTF();
                System.out.println("Cadea: " + cadena + "\n");
            }
            System.out.println("Xa non queda nada por ler");
        } catch (IOException e) {
            System.out.println("Ocorreu un erro ao ler o ficheiro: " + e.getMessage());
        }
    }
}
