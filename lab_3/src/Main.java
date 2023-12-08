import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Створення об'єктів
        Concert concert1 = new Concert("Rock Night", "Main Arena", LocalDate.of(2023, 8, 15), "Rock", 5, 40);
        Concert concert2 = new Concert("Jazz Fusion", "Jazz Club", LocalDate.of(2023, 12, 12), "Jazz", 4, 35);
        Concert concert3 = new Concert("Pop Extravaganza", "Pop Stadium", LocalDate.of(2023, 11, 5), "Pop", 6, 45);

        Exhibition exhibition1 = new Exhibition("Impressionist Art", "Art Museum", LocalDate.of(2023, 7, 25), "Impressionism", "Jane Doe", 80);
        Exhibition exhibition2 = new Exhibition("Photography Expo", "Photo Gallery", LocalDate.of(2023, 12, 30), "Photography", "Alex Johnson", 120);
        Exhibition exhibition3 = new Exhibition("Modern Sculptures", "Sculpture Center", LocalDate.of(2023, 9, 10), "Sculpture", "John Smith", 50);

        TheatrePerformance theatrePerformance1 = new TheatrePerformance("Classic Play", "City Theatre", LocalDate.of(2023, 6, 30), "Romeo and Juliet", 150, "Emily Williams");
        TheatrePerformance theatrePerformance2 = new TheatrePerformance("Comedy Show", "Comedy Club", LocalDate.of(2023, 11, 20), "Laugh Out Loud", 120, "Mike Johnson");
        TheatrePerformance theatrePerformance3 = new TheatrePerformance("Mystery Drama", "Mystery Theater", LocalDate.of(2023, 10, 5), "Secrets Unveiled", 130, "Sophia Anderson");

        // Створення списку подій
        List<CulturalEvent> events = new ArrayList<>();
        events.add(concert1);
        events.add(concert2);
        events.add(concert3);
        events.add(exhibition1);
        events.add(exhibition2);
        events.add(exhibition3);
        events.add(theatrePerformance1);
        events.add(theatrePerformance2);
        events.add(theatrePerformance3);

        // Створення об'єктів осіб
        Person person1 = new Person.PersonBuilder("Alice", LocalDate.of(1990, 5, 15))
                .addAttendedEvent(concert1)
                .addAttendedEvent(exhibition2)
                .addAttendedEvent(theatrePerformance3)
                .build();

        Person person2 = new Person.PersonBuilder("Bob", LocalDate.of(1985, 9, 3))
                .addAttendedEvent(exhibition1)
                .addAttendedEvent(theatrePerformance1)
                .build();

        Person person3 = new Person.PersonBuilder("Charlie", LocalDate.of(2000, 3, 22))
                .addAttendedEvent(concert3)
                .addAttendedEvent(theatrePerformance2)
                .build();

        Person person4 = new Person.PersonBuilder("David", LocalDate.of(1998, 7, 10))
                .addAttendedEvent(concert2)
                .addAttendedEvent(exhibition3)
                .addAttendedEvent(theatrePerformance1)
                .build();

        // Створення списку осіб
        List<Person> persons = new ArrayList<>();
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);

        // Використання сервісних методів
        CulturalEventService serviceWithoutStream = new EventServiceWithoutStream();
        CulturalEventService serviceWithStream = new EventServiceWithStream();

        // Сортування за замовчуванням (Comparable) без Stream API
        serviceWithoutStream.sortByDefault(events);
        System.out.println("Sorted by default without Stream API:\n" + events);
        System.out.println("\n");

        // Сортування за компаратором без Stream API
        serviceWithoutStream.sortByComparator(events, Comparator.comparing(CulturalEvent::getEventDate));
        System.out.println("Sorted by event date without Stream API:\n" + events);
        System.out.println("\n");

        // Сортування за алфавітним порядком (за назвою) без Stream API
        List<CulturalEvent> eventsAlphabeticallyWithoutStream = serviceWithoutStream.sortAlphabetically(events);
        System.out.println("Sorted alphabetically without Stream API:\n" + eventsAlphabeticallyWithoutStream);
        System.out.println("\n");

        // Сортування за давністю подій з використанням Stream API
        serviceWithStream.sortByEventAge(events);
        System.out.println("Sorted by event age with Stream API:\n" + events);
        System.out.println("\n");

        // Фільтрація за діапазоном віку осіб
        List<Person> filteredPersonsByAge = serviceWithStream.filterByAgeRange(persons, 25, 35);
        System.out.println("Filtered persons by age with Stream API (25-35 years old):\n" + filteredPersonsByAge);
        System.out.println("\n");

        // Фільтрація подій, які відбулися після певної дати
        List<CulturalEvent> filteredEventsByDate = serviceWithStream.filterByDate(events, LocalDate.of(2023, 9, 1));
        System.out.println("Filtered events by date with Stream API (after 2023-09-01):\n" + filteredEventsByDate);
        System.out.println("\n");

        // Фільтрація подій за назвою події
        List<CulturalEvent> filteredEventsByName = serviceWithStream.filterByName(events, "Rock Night");
        System.out.println("Filtered events by name with Stream API (Rock Night):\n" + filteredEventsByName);
        System.out.println("\n");

        // Отримання списку людей, які відвідали певну подію
        List<Person> attendees = serviceWithStream.getAttendees(persons, concert1);
        System.out.println("Attendees of the concert Rock Night:\n" + attendees);
    }
}
