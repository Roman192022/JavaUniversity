package org.example;

import java.io.IOException;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        try {
            // Створюємо об'єкти для тестування
            Concert concert = new Concert("Rock Concert", "City Hall", LocalDate.now(), "Rock", 5, 30);
            TheatrePerformance theatrePerformance = new TheatrePerformance("Hamlet", "Theatre Royal", LocalDate.now(), "Hamlet", 120, "John Doe");
            Exhibition exhibition = new Exhibition("Modern Art Exhibition", "Art Gallery", LocalDate.now(), "Modern Art", "Jane Smith", 50);

            // Створюємо екземпляри серіалізаторів
            Serializer jsonSerializer = new JsonSerializer();
            Serializer xmlSerializer = new XmlSerializer();

            // Серіалізація та запис в файли
            jsonSerializer.writeToFile(concert, "D:\\University\\3 course\\V semester\\Java\\events_1.json");
            xmlSerializer.writeToFile(concert, "D:\\University\\3 course\\V semester\\Java\\events_1.xml");

            jsonSerializer.writeToFile(theatrePerformance, "D:\\University\\3 course\\V semester\\Java\\events_1.json");
            xmlSerializer.writeToFile(theatrePerformance, "D:\\University\\3 course\\V semester\\Java\\events_1.xml");

            jsonSerializer.writeToFile(exhibition, "D:\\University\\3 course\\V semester\\Java\\events_1.json");
            xmlSerializer.writeToFile(exhibition, "D:\\University\\3 course\\V semester\\Java\\events_1.xml");

            // Десеріалізація та виведення інформації
            Concert jsonDeserializedConcert = jsonSerializer.readFromFile("D:\\University\\3 course\\V semester\\Java\\events_2.json", Concert.class);
            System.out.println("Deserialized from JSON (Concert): " + jsonDeserializedConcert);

            TheatrePerformance xmlDeserializedTheatrePerformance = xmlSerializer.readFromFile("D:\\University\\3 course\\V semester\\Java\\events_2.xml", TheatrePerformance.class);
            System.out.println("Deserialized from XML (TheatrePerformance): " + xmlDeserializedTheatrePerformance);

            Exhibition jsonDeserializedExhibition = jsonSerializer.readFromFile("D:\\University\\3 course\\V semester\\Java\\events_2.json", Exhibition.class);
            System.out.println("Deserialized from JSON (Exhibition): " + jsonDeserializedExhibition);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

