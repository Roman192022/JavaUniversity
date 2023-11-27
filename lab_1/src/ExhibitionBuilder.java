import java.time.LocalDate;

/**
 * Concrete builder for creating an Exhibition event.
 */
 class ExhibitionBuilder extends CulturalEventBuilder {
    public void buildName() {
        culturalEvent.setEventName("Art Exhibition");
    }

    public void buildLocation() {
        culturalEvent.setEventLocation("Art Gallery XYZ");
    }

    public void buildDate(LocalDate date) {
        culturalEvent.setEventDate(date);
    }


    @Override
    public String toString() {
        return "Exhibition:[" + super.toString() + "]";
    }
}

