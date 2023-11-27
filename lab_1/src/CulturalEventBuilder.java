
import java.util.Objects;

/**
 * Abstract builder for creating different types of cultural events.
 */
public abstract class CulturalEventBuilder {
    protected CulturalEvent culturalEvent;

    public CulturalEvent getCulturalEvent() {
        return culturalEvent;
    }

    public void createNewEvent() {
        culturalEvent = new CulturalEvent();
    }

    public abstract void buildName();
    public abstract void buildLocation();
    public abstract void buildDate(String date);

    @Override
    public String toString() {
        return "CulturalEventBuilder{" +
                "culturalEvent=" + culturalEvent +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CulturalEventBuilder that = (CulturalEventBuilder) o;
        return Objects.equals(culturalEvent, that.culturalEvent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(culturalEvent);
    }
}

