package Practica4;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CrearAutoresXML {
    public static void main(String[] args) {

        //Ruta do ficheiro
        String rutaFicheiro = "/home/dam/Escritorio/AD/1ºTRIMESTRE/Tareas_AD/src/Practica4/autores.xml";

        try {
            // Crear fábrica de XML
            XMLOutputFactory factory = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = factory.createXMLStreamWriter(new FileWriter(rutaFicheiro));

            // Declaración version XML
            writer.writeStartDocument("1.0");

            // Elemento raiz
            writer.writeStartElement("autores");

            // Primeiro autor
            writer.writeStartElement("autor");
            //Atributo do primeiro autor
            writer.writeAttribute("codigo", "a1");

            //Etiqueta nome
            writer.writeStartElement("nome");
            writer.writeCharacters("Alexandre Dumas");
            writer.writeEndElement();

            //Etiqueta titulo
            writer.writeStartElement("titulo");
            writer.writeCharacters("El conde de montecristo");
            writer.writeEndElement();

            //Etiqueta titulo
            writer.writeStartElement("titulo");
            writer.writeCharacters("Los miserables");
            writer.writeEndElement();

            //Pechamos o primer autor
            writer.writeEndElement();

            // Segundo autor
            writer.writeStartElement("autor");
            //Atributo do segundo autor
            writer.writeAttribute("codigo", "a2");

            //Etiqueta nome
            writer.writeStartElement("nome");
            writer.writeCharacters("Fiodor Dostoyevski");
            writer.writeEndElement();

            //Etiqueta titulo
            writer.writeStartElement("titulo");
            writer.writeCharacters("El idiota");
            writer.writeEndElement();

            //Etiqueta titulo
            writer.writeStartElement("titulo");
            writer.writeCharacters("Noches blancas");
            writer.writeEndElement();

            //Pechamos o segundo autor
            writer.writeEndElement();

            //Pechar o elemento raiz
            writer.writeEndElement();
            //Pechamos o documento
            writer.writeEndDocument();

            writer.flush();
            writer.close();

            System.out.println("Ficheiro XML creado correctamente ");

        } catch (XMLStreamException | IOException e) {
            System.out.println("Erro ao crear XML: " + e.getMessage());
        }
    }
}
