import model.CulturalEvent;
import model.Concert;
import model.Exhibition;
import model.TheatrePerformance;
import org.example.services.Serializer;
import org.example.services.JsonSerializer;
import org.example.services.XmlSerializer;

import org.example.services.*;


import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Створення об'єктів для тестування
        Concert concert = new Concert("Music Festival", "City Park", /*LocalDate.of(2023, 12, 7),*/ "Rock", 5, 30);
        Exhibition exhibition = new Exhibition("Art Expo", "Art Gallery", /*LocalDate.of(2023, 10, 7),*/ "Modern Art", "John Doe", 100);
        TheatrePerformance theatrePerformance = new TheatrePerformance("Hamlet", "Royal Theatre", /*LocalDate.of(2023, 5, 17),*/ "Hamlet", 120, "John Smith");

        // Серіалізація та десеріалізація в JSON
        try {
            // Серіалізація
            JsonSerializer<Concert> jsonSerializerConcert = new JsonSerializer<>();
            jsonSerializerConcert.serialize(concert, "D:\\University\\3 course\\V semester\\Java\\events_1.json");

            JsonSerializer<Exhibition> jsonSerializerExhibition = new JsonSerializer<>();
            jsonSerializerExhibition.serialize(exhibition, "D:\\University\\3 course\\V semester\\Java\\events_1.json");

            JsonSerializer<TheatrePerformance> jsonSerializerTheatre = new JsonSerializer<>();
            jsonSerializerTheatre.serialize(theatrePerformance, "D:\\University\\3 course\\V semester\\Java\\events_1.json");

            // Десеріалізація
            Concert deserializedConcert = jsonSerializerConcert.deserialize("D:\\University\\3 course\\V semester\\Java\\events_2.json", Concert.class);
            Exhibition deserializedExhibition = jsonSerializerExhibition.deserialize("D:\\University\\3 course\\V semester\\Java\\events_2.json", Exhibition.class);
            TheatrePerformance deserializedTheatre = jsonSerializerTheatre.deserialize("D:\\University\\3 course\\V semester\\Java\\events_2.json", TheatrePerformance.class);

            System.out.println("Deserialized Concert: " + deserializedConcert);
            System.out.println("Deserialized Exhibition: " + deserializedExhibition);
            System.out.println("Deserialized Theatre Performance: " + deserializedTheatre);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Серіалізація та десеріалізація в XML
        try {
            // Серіалізація
            XmlSerializer<Concert> xmlSerializerConcert = new XmlSerializer<>();
            xmlSerializerConcert.serialize(concert, "D:\\University\\3 course\\V semester\\Java\\events_1.xml");

            XmlSerializer<Exhibition> xmlSerializerExhibition = new XmlSerializer<>();
            xmlSerializerExhibition.serialize(exhibition, "D:\\University\\3 course\\V semester\\Java\\events_1.xml");

            XmlSerializer<TheatrePerformance> xmlSerializerTheatre = new XmlSerializer<>();
            xmlSerializerTheatre.serialize(theatrePerformance, "D:\\University\\3 course\\V semester\\Java\\events_1.xml");

            // Десеріалізація
            Concert xmlDeserializedConcert = xmlSerializerConcert.deserialize("D:\\University\\3 course\\V semester\\Java\\events_2.xml", Concert.class);
            Exhibition xmlDeserializedExhibition = xmlSerializerExhibition.deserialize("D:\\University\\3 course\\V semester\\Java\\events_2.xml", Exhibition.class);
            TheatrePerformance xmlDeserializedTheatre = xmlSerializerTheatre.deserialize("D:\\University\\3 course\\V semester\\Java\\events_2.xml", TheatrePerformance.class);

            System.out.println("XML Deserialized Concert: " + xmlDeserializedConcert);
            System.out.println("XML Deserialized Exhibition: " + xmlDeserializedExhibition);
            System.out.println("XML Deserialized Theatre Performance: " + xmlDeserializedTheatre);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
