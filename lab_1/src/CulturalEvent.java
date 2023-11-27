
import java.util.Objects;

/**
 * Represents a cultural event
 */


public class CulturalEvent {
    private String eventName;
    private String eventLocation;
    private String eventDate;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }


    @Override
    public String toString() {
        return "CulturalEvent{" +
                "eventName='" + eventName + '\'' +
                ", eventLocation='" + eventLocation + '\'' +
                ", eventDate='" + eventDate + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CulturalEvent that = (CulturalEvent) o;
        return Objects.equals(eventName, that.eventName) &&
                Objects.equals(eventLocation, that.eventLocation) &&
                Objects.equals(eventDate, that.eventDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventName, eventLocation, eventDate);
    }


}

