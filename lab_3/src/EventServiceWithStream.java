import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class EventServiceWithStream implements CulturalEventService {

    @Override
    public List<CulturalEvent> searchEventsByName(List<CulturalEvent> events, String eventName) {
        return events.stream()
                .filter(event -> event.getEventName().equals(eventName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> getPeopleWhoAttendedEvent(List<Person> people, CulturalEvent event) {
        return people.stream()
                .filter(person -> person.getAttendedEvents().contains(event))
                .collect(Collectors.toList());
    }

    @Override
    public List<CulturalEvent> sortEventsByDate(List<CulturalEvent> events) {
        return events.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public List<CulturalEvent> removeOutdatedEvents(List<CulturalEvent> events, LocalDate currentDate) {
        return events.stream()
                .filter(event -> event.getEventDate().isAfter(currentDate))
                .collect(Collectors.toList());
    }

    @Override
    public List<CulturalEvent> searchEventsAfterDate(List<CulturalEvent> events, LocalDate date) {
        return events.stream()
                .filter(event -> event.getEventDate().isAfter(date))
                .collect(Collectors.toList());
    }
}

