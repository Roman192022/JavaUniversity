import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EventServiceWithStream implements CulturalEventService {

    @Override
    public <T> void sortByComparator(List<T> events, Comparator<T> comparator) {
        events.sort(comparator);
    }

    @Override
    public <T extends CulturalEvent> List<T> sortAlphabetically(List<T> events) {
        return events.stream()
                .sorted(Comparator.comparing(CulturalEvent::getEventName))
                .collect(Collectors.toList());
    }
    @Override
    public <T extends Comparable<? super T>> void sortByDefault(List<T> events) {
        events.sort(Comparator.naturalOrder());
    }
    @Override
    public <T extends CulturalEvent> void sortByEventAge(List<T> events) {
        events = events.stream()
                .sorted(Comparator.comparing(CulturalEvent::getEventDate).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> filterByAgeRange(List<Person> persons, int minAge, int maxAge) {
        return persons.stream()
                .filter(person -> {
                    int age = java.time.Period.between(person.getDateOfBirth(), java.time.LocalDate.now()).getYears();
                    return age >= minAge && age <= maxAge;
                })
                .collect(Collectors.toList());
    }

    @Override
    public <T extends CulturalEvent> List<T> filterByDate(List<T> events, java.time.LocalDate date) {
        return events.stream()
                .filter(event -> event.getEventDate().isAfter(date))
                .collect(Collectors.toList());
    }

    @Override
    public <T extends CulturalEvent> List<T> filterByName(List<T> events, String eventName) {
        return events.stream()
                .filter(event -> event.getEventName().equalsIgnoreCase(eventName))
                .collect(Collectors.toList());
    }

    @Override
    public <T extends CulturalEvent> List<Person> getAttendees(List<Person> persons, T event) {
        return persons.stream()
                .filter(person -> person.getAttendedEvents().contains(event))
                .collect(Collectors.toList());
    }
}
