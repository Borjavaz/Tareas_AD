package MiniExamen7.util;

import MiniExamen7.dao.AnimalDAO;
import MiniExamen7.modelo.Animal;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class XML {

    private static final String FILE_PATH = "/home/dam/Escritorio/AD/1ºTRIMESTRE/Tareas_AD/src/MiniExamen7/animais.xml";

    public static void exportarAnimaisAXML() {
        AnimalDAO dao = new AnimalDAO();
        List<Animal> listaAnimais = dao.listarTodos();

        try {
            XMLOutputFactory factory = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = factory.createXMLStreamWriter(new FileWriter(FILE_PATH));

            writer.writeStartDocument("UTF-8", "1.0");
            writer.writeStartElement("animais");

            for (Animal animal : listaAnimais) {
                writer.writeStartElement("animal");
                writer.writeAttribute("id", String.valueOf(animal.getId()));
                writer.writeAttribute("nome", animal.getNome());
                writer.writeAttribute("especie", animal.getEspecie());
                writer.writeAttribute("anoChegada", String.valueOf(animal.getAnoChegada()));

                writer.writeStartElement("descricion");
                writer.writeCharacters(animal.getDescricion());
                writer.writeEndElement(); // Fin descricion

                writer.writeEndElement(); // Fin animal
            }

            writer.writeEndElement(); // Cierra <animais>
            writer.writeEndDocument();

            writer.flush();
            writer.close();

            System.out.println(" Ficheiro XML 'animais.xml' creado correctamente en: " + FILE_PATH);

        } catch (XMLStreamException | IOException e) {
            System.err.println("Erro ao crear XML: " + e.getMessage());
        }
    }
}