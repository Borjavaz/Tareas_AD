package MiniExamen6.util;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ExportarXML {
    public void main(String[] args) {
        String rutaFicheiro = "/home/dam/Escritorio/AD/1ºTRIMESTRE/Tareas_AD/src/MiniExamen6/libros.xml";

        try {
            // 1. Crear la fábrica y el escritor (Writer)
            XMLOutputFactory factory = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = factory.createXMLStreamWriter(new FileWriter(rutaFicheiro));

            // 2. Declaración de la versión XML
            writer.writeStartDocument("UTF-8", "1.0");

            // 3. Elemento raíz
            writer.writeStartElement("libros");

            // --- Primer Libro: O señor dos aneis ---
            writer.writeStartElement("libro");
            writer.writeAttribute("titulo", "O señor dos aneis");
            writer.writeAttribute("autor", "J.R.R. Tolkien");
            writer.writeAttribute("anoPublicacion", "1954");

            writer.writeStartElement("descricion");
            writer.writeCharacters("Saga épica de fantasía.");
            writer.writeEndElement(); // Fin descricion
            writer.writeEndElement(); // Fin libro

            // --- Segundo Libro: 1984 ---
            writer.writeStartElement("libro");
            writer.writeAttribute("titulo", "1984");
            writer.writeAttribute("autor", "George Orwell");
            writer.writeAttribute("anoPublicacion", "1949");

            writer.writeStartElement("descricion");
            writer.writeCharacters("Distopía sobre o control estatal.");
            writer.writeEndElement(); // Fin descricion
            writer.writeEndElement(); // Fin libro

            // --- Tercer Libro: Cem anos de soidade ---
            writer.writeStartElement("libro");
            writer.writeAttribute("titulo", "Cem anos de soidade");
            writer.writeAttribute("autor", "Gabriel García Márquez");
            writer.writeAttribute("anoPublicacion", "1967");

            writer.writeStartElement("descricion");
            writer.writeCharacters("Realismo máxico en Macondo.");
            writer.writeEndElement(); // Fin descricion
            writer.writeEndElement(); // Fin libro

            // --- Cuarto Libro: Don Quixote ---
            writer.writeStartElement("libro");
            writer.writeAttribute("titulo", "Don Quixote");
            writer.writeAttribute("autor", "Miguel de Cervantes");
            writer.writeAttribute("anoPublicacion", "1605");

            writer.writeStartElement("descricion");
            writer.writeCharacters("Clásico da literatura española.");
            writer.writeEndElement(); // Fin descricion
            writer.writeEndElement(); // Fin libro

            // --- Quinto Libro: A volta ao mundo en 80 días ---
            writer.writeStartElement("libro");
            writer.writeAttribute("titulo", "A volta ao mundo en 80 días");
            writer.writeAttribute("autor", "Jules Verne");
            writer.writeAttribute("anoPublicacion", "1872");

            writer.writeStartElement("descricion");
            writer.writeCharacters("Aventura clásica.");
            writer.writeEndElement(); // Fin descricion
            writer.writeEndElement(); // Fin libro

            // 4. Cierre de elementos y documento
            writer.writeEndElement(); // Cierra <libros>
            writer.writeEndDocument(); // Cierra el documento

            // 5. Finalizar y cerrar el escritor
            writer.flush();
            writer.close();

            System.out.println("Ficheiro XML 'libros.xml' creado correctamente en: " + rutaFicheiro);

        } catch (XMLStreamException | IOException e) {
            System.err.println("Erro ao crear XML: " + e.getMessage());
        }
    }
}
