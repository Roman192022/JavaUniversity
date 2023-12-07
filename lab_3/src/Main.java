import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Створення об'єктів
        Concert concert1 = new Concert("Rock Night", "Main Arena", LocalDate.of(2023, 8, 15), "Rock", 5, 40);
        Concert concert2 = new Concert("Jazz Fusion", "Jazz Club", LocalDate.of(2023, 12, 12), "Jazz", 4, 35);
        Exhibition exhibition1 = new Exhibition("Impressionist Art", "Art Museum", LocalDate.of(2023, 7, 25), "Impressionism", "Jane Doe", 80);
        Exhibition exhibition2 = new Exhibition("Photography Expo", "Photo Gallery", LocalDate.of(2023, 12, 30), "Photography", "Alex Johnson", 120);
        TheatrePerformance theatrePerformance1 = new TheatrePerformance("Classic Play", "City Theatre", LocalDate.of(2023, 6, 30), "Romeo and Juliet", 150, "Emily Williams");
        TheatrePerformance theatrePerformance2 = new TheatrePerformance("Comedy Show", "Comedy Club", LocalDate.of(2023, 11, 20), "Laugh Out Loud", 120, "Mike Johnson");

        // Створення списку
        List<CulturalEvent> events = new ArrayList<>();
        events.add(concert1);
        events.add(concert2);
        events.add(exhibition1);
        events.add(exhibition2);
        events.add(theatrePerformance1);
        events.add(theatrePerformance2);

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

        // Сортування за замовчуванням (Comparable) з використанням Stream API
        serviceWithStream.sortByDefault(events);
        System.out.println("Sorted by default with Stream API:\n" + events);
        System.out.println("\n");

        // Сортування за алфавітним порядком (за назвою) з використанням Stream API
        List<CulturalEvent> eventsAlphabeticallyWithStream = serviceWithStream.sortAlphabetically(events);
        System.out.println("Sorted alphabetically with Stream API:\n" + eventsAlphabeticallyWithStream);
        System.out.println("\n");

        // Фільтрація без Stream API
        List<CulturalEvent> filteredEventsWithoutStream = serviceWithoutStream.filterByCondition(events, event -> event.getEventDate().isAfter(LocalDate.now()));
        System.out.println("Filtered events without Stream API (after today):\n" + filteredEventsWithoutStream);
        System.out.println("\n");

        // Фільтрація з використанням Stream API
        List<CulturalEvent> filteredEventsWithStream = serviceWithStream.filterByCondition(events, event -> event.getEventDate().isAfter(LocalDate.now()));
        System.out.println("Filtered events with Stream API (after today):\n" + filteredEventsWithStream);
        System.out.println("\n");
    }
}
