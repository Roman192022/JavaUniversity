import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        // Створення об'єктів класів CulturalEvent, Concert, Exhibition, TheatrePerformance

        CulturalEvent culturalEvent = new CulturalEvent("Generic Event", "Some Location", LocalDate.of(2023, 1,1));
        Concert concert = new Concert("Awesome Concert", "Concert Hall", LocalDate.of(2023,2,15), "Rock", 4, 50);
        Exhibition exhibition = new Exhibition("Art Exhibition", "Art Gallery", LocalDate.of(2023,3,20), "Modern Art", "John Curator", 100);
        TheatrePerformance theatrePerformance = new TheatrePerformance("Drama Play", "Theatre", LocalDate.of(2023,4,10), "Hamlet", 120, "John Actor");

        // Вивід інформації про події

        culturalEvent.displayEventInfo();
        System.out.println();

        concert.displayEventInfo();
        concert.announceTicketPrice();
        System.out.println();

        exhibition.displayEventInfo();
        exhibition.displayCuratorInfo();
        System.out.println();

        theatrePerformance.displayEventInfo();
        theatrePerformance.announceMainActor();
        System.out.println();

        // Створення об'єктів класу Person за допомогою Builder

        Person person1 = new Person.PersonBuilder("John Doe", 30)
                .addAttendedEvent(concert)
                .addAttendedEvent(exhibition)
                .build();

        Person person2 = new Person.PersonBuilder("Adam Brown", 20)
                .addAttendedEvent(theatrePerformance)
                .addAttendedEvent(exhibition)
                .build();

        // Вивід інформації про осіб та події, на яких вони побували

        System.out.println(person1);
        System.out.println(person2);

    }
}
