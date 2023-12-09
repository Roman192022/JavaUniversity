import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// 
public interface CulturalEventService {

    List<CulturalEvent> searchEventsByName(List<CulturalEvent> events, String eventName);

    List<Person> getPeopleWhoAttendedEvent(List<Person> people, CulturalEvent event);

    List<CulturalEvent> sortEventsByDate(List<CulturalEvent> events);

    List<CulturalEvent> removeOutdatedEvents(List<CulturalEvent> events, LocalDate currentDate);

    List<CulturalEvent> searchEventsAfterDate(List<CulturalEvent> events, LocalDate date);

}

