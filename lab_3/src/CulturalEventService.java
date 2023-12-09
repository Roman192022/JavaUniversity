import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//
public interface CulturalEventService {

    List<CulturalEvent> searchEventsByName(String eventName);

    List<CulturalEvent> sortEventsByEventName();

    List<CulturalEvent> sortEventsByDate();

    List<CulturalEvent> searchEventsAfterDate(LocalDate date);


}

