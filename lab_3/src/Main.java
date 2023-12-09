import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Створення 6 об'єктів культурних подій
        CulturalEvent concert1 = new Concert("Rock Concert", "Music Hall", LocalDate.now().plusDays(10), "Rock", 5, 50);
        CulturalEvent exhibition1 = new Exhibition("Modern Art Exhibition", "Art Gallery", LocalDate.now().plusDays(15), "Modern Art", "Curator1", 100);
        CulturalEvent theatrePerformance1 = new TheatrePerformance("Shakespearean Play", "City Theatre", LocalDate.now().plusDays(20), "Hamlet", 120, "John Doe");

        CulturalEvent concert2 = new Concert("Jazz Night", "Jazz Club", LocalDate.now().plusDays(12), "Jazz", 4, 40);
        CulturalEvent exhibition2 = new Exhibition("Impressionist Art Exhibition", "Museum of Fine Arts", LocalDate.now().plusDays(18), "Impressionism", "Curator2", 80);
        CulturalEvent theatrePerformance2 = new TheatrePerformance("Comedy Play", "Comedy Theatre", LocalDate.now().plusDays(25), "The Comedy of Errors", 90, "Jane Doe");

        // Створення списку культурних подій
        List<CulturalEvent> culturalEvents = new ArrayList<>();
        culturalEvents.add(concert1);
        culturalEvents.add(exhibition1);
        culturalEvents.add(theatrePerformance1);
        culturalEvents.add(concert2);
        culturalEvents.add(exhibition2);
        culturalEvents.add(theatrePerformance2);

        // Створення 4 об'єкти Person
        Person person1 = new Person.PersonBuilder("John", LocalDate.of(1990, 5, 15))
                .addAttendedEvent(concert1)
                .addAttendedEvent(exhibition1)
                .addAttendedEvent(theatrePerformance2)
                .build();

        Person person2 = new Person.PersonBuilder("Jane", LocalDate.of(1985, 8, 22))
                .addAttendedEvent(concert2)
                .addAttendedEvent(theatrePerformance1)
                .build();

        Person person3 = new Person.PersonBuilder("Bob", LocalDate.of(1992, 3, 10))
                .addAttendedEvent(exhibition2)
                .addAttendedEvent(theatrePerformance1)
                .build();

        Person person4 = new Person.PersonBuilder("Alice", LocalDate.of(1988, 12, 5))
                .addAttendedEvent(concert1)
                .addAttendedEvent(exhibition2)
                .build();


        CulturalEventService serviceWithStream = new EventServiceWithStream(culturalEvents);
        CulturalEventService serviceWithoutStream = new EventServiceWithoutStream(culturalEvents);


        // Пошук подій за назвою
        System.out.println("Search events by name:");
        List<CulturalEvent> searchResultWithStream = serviceWithStream.searchEventsByName("Rock Concert");
        List<CulturalEvent> searchResultWithoutStream = serviceWithoutStream.searchEventsByName("Rock Concert");
        System.out.println("With Stream API: " + searchResultWithStream);
        System.out.println("Without Stream API: " + searchResultWithoutStream);

        // Сортування подій за назвою
        System.out.println("\nSort events by name:");
        List<CulturalEvent> sortedEventsNameWithStream = serviceWithStream.sortEventsByEventName();
        List<CulturalEvent> sortedEventsNameWithoutStream = serviceWithoutStream.sortEventsByEventName();
        System.out.println("With Stream API: " + sortedEventsNameWithStream);
        System.out.println("Without Stream API: " + sortedEventsNameWithoutStream);

        // Сортування подій за датою
        System.out.println("\nSort events by date:");
        List<CulturalEvent> sortedEventsDateWithStream = serviceWithStream.sortEventsByDate();
        List<CulturalEvent> sortedEventsDateWithoutStream = serviceWithoutStream.sortEventsByDate();
        System.out.println("With Stream API: " + sortedEventsDateWithStream);
        System.out.println("Without Stream API: " + sortedEventsDateWithoutStream);


        // Пошук подій, які відбудуться після певної дати
        System.out.println("\nSearch events after a date:");
        LocalDate searchDate = LocalDate.now().plusDays(15);
        List<CulturalEvent> eventsAfterDateWithStream = serviceWithStream.searchEventsAfterDate(searchDate);
        List<CulturalEvent> eventsAfterDateWithoutStream = serviceWithoutStream.searchEventsAfterDate(searchDate);
        System.out.println("With Stream API: " + eventsAfterDateWithStream);
        System.out.println("Without Stream API: " + eventsAfterDateWithoutStream);
    }
}
