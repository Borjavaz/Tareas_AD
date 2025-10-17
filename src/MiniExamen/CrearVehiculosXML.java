package MiniExamen;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CrearVehiculosXML {

    public static void main(String[] args) {
        String rutaFicheiro = "/home/dam/Escritorio/AD/1ºTRIMESTRE/Tareas_AD/src/MiniExamen/vehiculos.xml";

        try {
            // 1. Crear la fábrica y el escritor (Writer)
            XMLOutputFactory factory = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = factory.createXMLStreamWriter(new FileWriter(rutaFicheiro));

            // 2. Declaración de la versión XML
            writer.writeStartDocument("UTF-8", "1.0");

            // 3. Elemento raíz
            writer.writeStartElement("vehiculos");

            // --- Primer coche: Ford Mustang 2021 ---
            writer.writeStartElement("vehiculo");
            writer.writeAttribute("marca", "Ford");
            writer.writeAttribute("modelo", "Mustang");
            writer.writeAttribute("ano", "2021");

            writer.writeStartElement("descricion");
            writer.writeCharacters("Deportivo americano icónico.");
            writer.writeEndElement(); // Fin descricion
            writer.writeEndElement(); // Fin vehiculo

            // --- Segundo coche: Tesla Model S 2023 ---
            writer.writeStartElement("vehiculo");
            writer.writeAttribute("marca", "Tesla");
            writer.writeAttribute("modelo", "Model S");
            writer.writeAttribute("ano", "2023");

            writer.writeStartElement("descricion");
            writer.writeCharacters("Sedán eléctrico de luxo con gran autonomía.");
            writer.writeEndElement();
            writer.writeEndElement();

            // --- Tercer coche: Honda Civic 2020 ---
            writer.writeStartElement("vehiculo");
            writer.writeAttribute("marca", "Honda");
            writer.writeAttribute("modelo", "Civic");
            writer.writeAttribute("ano", "2020");

            writer.writeStartElement("descricion");
            writer.writeCharacters("Compacto de gran fiabilidade.");
            writer.writeEndElement();
            writer.writeEndElement();

            // --- Cuarto coche: Chevrolet Corvette 2022 ---
            writer.writeStartElement("vehiculo");
            writer.writeAttribute("marca", "Chevrolet");
            writer.writeAttribute("modelo", "Corvette");
            writer.writeAttribute("ano", "2022");

            writer.writeStartElement("descricion");
            writer.writeCharacters("Deportivo americano con motor V8.");
            writer.writeEndElement();
            writer.writeEndElement();

            // --- Quinto coche: Toyota Prius 2022 ---
            writer.writeStartElement("vehiculo");
            writer.writeAttribute("marca", "Toyota");
            writer.writeAttribute("modelo", "Prius");
            writer.writeAttribute("ano", "2022");

            writer.writeStartElement("descricion");
            writer.writeCharacters("Híbrido de baixo consumo e ecolóxico.");
            writer.writeEndElement();
            writer.writeEndElement();

            // 4. Cierre de elementos y documento
            writer.writeEndElement(); // Cierra <vehiculos>
            writer.writeEndDocument(); // Cierra el documento

            // 5. Finalizar y cerrar el escritor
            writer.flush();
            writer.close();

            System.out.println("Ficheiro XML 'vehiculos.xml' creado correctamente en: " + rutaFicheiro);

        } catch (XMLStreamException | IOException e) {
            System.err.println("Erro ao crear XML: " + e.getMessage());
        }
    }
}
