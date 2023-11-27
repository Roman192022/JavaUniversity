import java.time.LocalDate;

/**
 * Concrete builder for creating a Concert event.
 */
public class ConcertBuilder extends CulturalEventBuilder {

    public void buildName() {
        culturalEvent.setEventName("Concert");
    }

    public void buildLocation() {
        culturalEvent.setEventLocation("Concert Hall ABC");
    }

    public void buildDate(LocalDate date) {
        culturalEvent.setEventDate(date);
    }


    @Override
    public String toString() {
        return "Concert:[" + super.toString() + "]";
    }
}