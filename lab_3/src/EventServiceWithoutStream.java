import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EventServiceWithoutStream implements CulturalEventService {

    @Override
    public List<CulturalEvent> searchEventsByName(List<CulturalEvent> events, String eventName) {
        List<CulturalEvent> result = new ArrayList<>();
        for (CulturalEvent event : events) {
            if (event.getEventName().equals(eventName)) {
                result.add(event);
            }
        }
        return result;
    }

    @Override
    public List<Person> getPeopleWhoAttendedEvent(List<Person> people, CulturalEvent event) {
        List<Person> result = new ArrayList<>();
        for (Person person : people) {
            if (person.getAttendedEvents().contains(event)) {
                result.add(person);
            }
        }
        return result;
    }

    @Override
    public List<CulturalEvent> sortEventsByDate(List<CulturalEvent> events) {
        Collections.sort(events);
        return events;
    }

    @Override
    public List<CulturalEvent> removeOutdatedEvents(List<CulturalEvent> events, LocalDate currentDate) {
        List<CulturalEvent> result = new ArrayList<>();
        for (CulturalEvent event : events) {
            if (event.getEventDate().isAfter(currentDate)) {
                result.add(event);
            }
        }
        return result;
    }

    @Override
    public List<CulturalEvent> searchEventsAfterDate(List<CulturalEvent> events, LocalDate date) {
        List<CulturalEvent> result = new ArrayList<>();
        for (CulturalEvent event : events) {
            if (event.getEventDate().isAfter(date)) {
                result.add(event);
            }
        }
        return result;
    }
}



