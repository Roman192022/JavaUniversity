import model.CulturalEvent;
import model.Concert;
import model.Exhibition;
import model.CulturalEvent;
import model.Concert;
import model.Exhibition;
import model.TheatrePerformance;
import org.example.services.Serializer;
import org.example.services.JsonSerializer;
import org.example.services.XmlSerializer;

import org.example.services.*;


import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        TheatrePerformance theatrePerformance = new TheatrePerformance("Hamlet", "Royal Theatre", "Hamlet", 120, "John Smith");

        // Серіалізація та десеріалізація в JSON
        try {
            // Серіалізація
            JsonSerializer<Concert> jsonSerializerConcert = new JsonSerializer<>();

            JsonSerializer<TheatrePerformance> jsonSerializerTheatre = new JsonSerializer<>();
            jsonSerializerTheatre.serialize(theatrePerformance, "D:\\University\\3 course\\V semester\\Java\\events_1.json");

            // Десеріалізація
            Concert deserializedConcert = jsonSerializerConcert.deserialize("D:\\University\\3 course\\V semester\\Java\\events_2.json", Concert.class);
            System.out.println("Deserialized Concert: " + deserializedConcert);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Серіалізація та десеріалізація в XML
        try {
            // Серіалізація

            XmlSerializer<Exhibition> xmlSerializerExhibition = new XmlSerializer<>();

            XmlSerializer<TheatrePerformance> xmlSerializerTheatre = new XmlSerializer<>();
            xmlSerializerTheatre.serialize(theatrePerformance, "D:\\University\\3 course\\V semester\\Java\\events_1.xml");

            // Десеріалізація

            Exhibition xmlDeserializedExhibition = xmlSerializerExhibition.deserialize("D:\\University\\3 course\\V semester\\Java\\events_2.xml", Exhibition.class);
            System.out.println("XML Deserialized Exhibition: " + xmlDeserializedExhibition);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}