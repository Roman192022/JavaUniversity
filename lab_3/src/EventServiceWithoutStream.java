import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class EventServiceWithoutStream implements CulturalEventService {

    private List<CulturalEvent> events;

    EventServiceWithoutStream(List<CulturalEvent> array) {

        events = array;
    }

    @Override
    public List<CulturalEvent> searchEventsByName(String eventName) {
        List<CulturalEvent> result = new ArrayList<>();
        for (CulturalEvent event : events) {
            if (event.getEventName().equals(eventName)) {
                result.add(event);
            }
        }
        return result;
    }

    public List<CulturalEvent> sortEventsByEventName() {
        List<CulturalEvent> result = events;
        Collections.sort(result);
        return result;
    }


    @Override
    public List<CulturalEvent> sortEventsByDate() {
        List<CulturalEvent> result = events;
        Collections.sort(result);
        return result;
    }

    @Override
    public List<CulturalEvent> removeOutdatedEvents(LocalDate currentDate) {
        List<CulturalEvent> result = new ArrayList<>();
        for (CulturalEvent event : events) {
            if (event.getEventDate().isAfter(currentDate)) {
                result.add(event);
            }
        }
        return result;
    }

    @Override
    public List<CulturalEvent> searchEventsAfterDate(LocalDate date) {
        List<CulturalEvent> result = new ArrayList<>();
        for (CulturalEvent event : events) {
            if (event.getEventDate().isAfter(date)) {
                result.add(event);
            }
        }
        return result;
    }









}



