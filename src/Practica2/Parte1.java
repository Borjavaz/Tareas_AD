package Practica2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Parte1 {
    public static void main(String[] args) {

        String rutaDirectorio = "/home/dam/Escritorio/AD/1ºTRIMESTRE/AD/src/Practica2";
        String nombreFicheroOrigen = "texto1.txt";
        String nombreFicheroDestino = "texto2.txt";

        // Copiar byte a byte
        copiarTexto(rutaDirectorio, nombreFicheroOrigen, nombreFicheroDestino);

        // Añadir el contenido de texto1.txt a texto2.txt
        añadirTexto(rutaDirectorio, nombreFicheroOrigen, nombreFicheroDestino);

    }

    // Método que copia byte a byte
    public static void copiarTexto(String rutaDirectorio, String nombreFicheroOrigen, String nombreFicheroDestino) {
        File origen = new File(rutaDirectorio, nombreFicheroOrigen);
        File destino = new File(rutaDirectorio, nombreFicheroDestino);

        // Comprobamos si existe el fichero origen
        if (!origen.exists()) {
            System.out.println("El fichero origen no existe.");
            return;
        }

        try (
                FileInputStream fis = new FileInputStream(origen);
                FileOutputStream fos = new FileOutputStream(destino)
        ) {
            int byteLeido;
            // Leemos un byte y lo escribimos en el fichero destino
            while ((byteLeido = fis.read()) != -1) {
                fos.write(byteLeido);
            }
            System.out.println("Copia realizada correctamente");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al copiar el fichero: " + e.getMessage());
        }
    }
    // Método que añade el contenido del fichero origen al fichero destino
    public static void añadirTexto(String rutaDirectorio, String nombreFicheroOrigen, String nombreFicheroDestino) {
        File origen = new File(rutaDirectorio, nombreFicheroOrigen);
        File destino = new File(rutaDirectorio, nombreFicheroDestino);

        if (!origen.exists()) {
            System.out.println("El fichero origen no existe.");
            return;
        }

        try (FileInputStream fis = new FileInputStream(origen);
             FileOutputStream fos = new FileOutputStream(destino, true)) {

            int byteLeido;
            while ((byteLeido = fis.read()) != -1) {
                fos.write(byteLeido);
            }
            System.out.println("Contenido añadido correctamente");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al añadir el contenido: " + e.getMessage());
        }
    }
}

