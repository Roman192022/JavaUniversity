import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class EventServiceWithoutStream implements CulturalEventService {

    @Override
    public <T> void sortByComparator(List<T> events, Comparator<T> comparator) {
        events.sort(comparator);
    }

    @Override
    public <T extends CulturalEvent> List<T> sortAlphabetically(List<T> events) {
        events.sort(Comparator.comparing(CulturalEvent::getEventName));
        return events;
    }

    @Override
    public <T extends Comparable<? super T>> void sortByDefault(List<T> events) {
        events.sort(Comparator.naturalOrder());
    }

    @Override
    public <T extends CulturalEvent> void sortByEventAge(List<T> events) {
        events.sort(Comparator.comparing(CulturalEvent::getEventDate).reversed());
    }

    @Override
    public List<Person> filterByAgeRange(List<Person> persons, int minAge, int maxAge) {
        // Використовуємо цикл для фільтрації
        return persons.stream()
                .filter(person -> {
                    int age = java.time.Period.between(person.getDateOfBirth(), java.time.LocalDate.now()).getYears();
                    return age >= minAge && age <= maxAge;
                })
                .collect(Collectors.toList());
    }

    @Override
    public <T extends CulturalEvent> List<T> filterByDate(List<T> events, java.time.LocalDate date) {
        // Використовуємо цикл для фільтрації
        return List.copyOf(events).stream()
                .filter(event -> event.getEventDate().isAfter(date))
                .toList();
    }

    @Override
    public <T extends CulturalEvent> List<T> filterByName(List<T> events, String eventName) {
        // Використовуємо цикл для фільтрації
        return events.stream()
                .filter(event -> event.getEventName().equalsIgnoreCase(eventName))
                .collect(Collectors.toList());
    }

    @Override
    public <T extends CulturalEvent> List<Person> getAttendees(List<Person> persons, T event) {
        // Використовуємо цикл для фільтрації
        return persons.stream()
                .filter(person -> person.getAttendedEvents().contains(event))
                .collect(Collectors.toList());
    }
}

