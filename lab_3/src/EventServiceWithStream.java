import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EventServiceWithStream implements CulturalEventService {

    private List<CulturalEvent> events;

    EventServiceWithStream(List<CulturalEvent> array) {
        events = array;
    }

    @Override
    public List<CulturalEvent> searchEventsByName(String eventName) {
        return events.stream()
                .filter(event -> event.getEventName().equals(eventName))
                .collect(Collectors.toList());
    }

    @Override
    public List<CulturalEvent> sortEventsByEventName() {
        return events.stream()
                .sorted(Comparator.comparing(CulturalEvent::getEventName))
                .collect(Collectors.toList());
    }

    @Override
    public List<CulturalEvent> sortEventsByDate() {
        return events.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public List<CulturalEvent> removeOutdatedEvents(LocalDate currentDate) {
        return events.stream()
                .filter(event -> event.getEventDate().isAfter(currentDate))
                .collect(Collectors.toList());
    }

    @Override
    public List<CulturalEvent> searchEventsAfterDate(LocalDate date) {
        return events.stream()
                .filter(event -> event.getEventDate().isAfter(date))
                .collect(Collectors.toList());
    }
}

