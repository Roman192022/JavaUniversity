import java.time.LocalDate;

/**
 * Concrete builder for creating a Theatre Performance event.
 */

public class TheatrePerformanceBuilder extends CulturalEventBuilder {
    public void buildName() {
        culturalEvent.setEventName("Theatre Performance");
    }

    public void buildLocation() {
        culturalEvent.setEventLocation("City Theatre");
    }

    public void buildDate(LocalDate date) {
        culturalEvent.setEventDate(date);
    }


    @Override
    public String toString() {
        return "TheatrePerformance:[" + super.toString() + "]";
    }
}
