import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Створюємо 6 реалістичних об'єктів культурних подій
        CulturalEvent concert1 = new Concert("Rock Concert", "Music Hall", LocalDate.now().plusDays(10), "Rock", 5, 50);
        CulturalEvent exhibition1 = new Exhibition("Modern Art Exhibition", "Art Gallery", LocalDate.now().plusDays(15), "Modern Art", "Curator1", 100);
        CulturalEvent theatrePerformance1 = new TheatrePerformance("Shakespearean Play", "City Theatre", LocalDate.now().plusDays(20), "Hamlet", 120, "John Doe");

        CulturalEvent concert2 = new Concert("Jazz Night", "Jazz Club", LocalDate.now().plusDays(12), "Jazz", 4, 40);
        CulturalEvent exhibition2 = new Exhibition("Impressionist Art Exhibition", "Museum of Fine Arts", LocalDate.now().plusDays(18), "Impressionism", "Curator2", 80);
        CulturalEvent theatrePerformance2 = new TheatrePerformance("Comedy Play", "Comedy Theatre", LocalDate.now().plusDays(25), "The Comedy of Errors", 90, "Jane Doe");

        // Створюємо список культурних подій
        List<CulturalEvent> events = new ArrayList<>();
        events.add(concert1);
        events.add(exhibition1);
        events.add(theatrePerformance1);
        events.add(concert2);
        events.add(exhibition2);
        events.add(theatrePerformance2);

        // Створюємо 4 реалістичні об'єкти Person
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

        // Створюємо інстанції сервісних класів
        CulturalEventService serviceWithStream = new EventServiceWithStream();
        CulturalEventService serviceWithoutStream = new EventServiceWithoutStream();

        // Проводимо тести

        // Пошук подій за назвою
        System.out.println("Search events by name:");
        List<CulturalEvent> searchResultWithStream = serviceWithStream.searchEventsByName(events, "Rock Concert");
        List<CulturalEvent> searchResultWithoutStream = serviceWithoutStream.searchEventsByName(events, "Rock Concert");
        System.out.println("With Stream API: " + searchResultWithStream);
        System.out.println("Without Stream API: " + searchResultWithoutStream);

        // Отримання людей, які відвідали певну подію
        System.out.println("\nPeople who attended an event:");
        List<Person> peopleWithStream = serviceWithStream.getPeopleWhoAttendedEvent(List.of(person1, person2, person3, person4), concert1);
        List<Person> peopleWithoutStream = serviceWithoutStream.getPeopleWhoAttendedEvent(List.of(person1, person2, person3, person4), concert1);
        System.out.println("With Stream API: " + peopleWithStream);
        System.out.println("Without Stream API: " + peopleWithoutStream);

        // Сортування подій за датою
        System.out.println("\nSort events by date:");
        List<CulturalEvent> sortedEventsWithStream = serviceWithStream.sortEventsByDate(events);
        List<CulturalEvent> sortedEventsWithoutStream = serviceWithoutStream.sortEventsByDate(events);
        System.out.println("With Stream API: " + sortedEventsWithStream);
        System.out.println("Without Stream API: " + sortedEventsWithoutStream);

        // Видалення застарілих подій
        System.out.println("\nRemove outdated events:");
        LocalDate currentDate = LocalDate.now().plusDays(17);
        List<CulturalEvent> updatedEventsWithStream = serviceWithStream.removeOutdatedEvents(events, currentDate);
        List<CulturalEvent> updatedEventsWithoutStream = serviceWithoutStream.removeOutdatedEvents(events, currentDate);
        System.out.println("With Stream API: " + updatedEventsWithStream);
        System.out.println("Without Stream API: " + updatedEventsWithoutStream);

        // Пошук подій, які відбудуться після певної дати
        System.out.println("\nSearch events after a date:");
        LocalDate searchDate = LocalDate.now().plusDays(15);
        List<CulturalEvent> eventsAfterDateWithStream = serviceWithStream.searchEventsAfterDate(events, searchDate);
        List<CulturalEvent> eventsAfterDateWithoutStream = serviceWithoutStream.searchEventsAfterDate(events, searchDate);
        System.out.println("With Stream API: " + eventsAfterDateWithStream);
        System.out.println("Without Stream API: " + eventsAfterDateWithoutStream);
    }
}
