import java.time.LocalDate;
import java.util.Objects;


public class CulturalEvent {
    protected String eventName;
    protected String eventLocation;
    protected LocalDate eventDate;

    public CulturalEvent(String eventName, String eventLocation, LocalDate eventDate) {
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.eventDate = eventDate;
    }

    // Геттери та сеттери для властивостей події

    public void displayEventInfo() {
        System.out.println("Event: " + eventName);
        System.out.println("Location: " + eventLocation);
        System.out.println("Date: " + eventDate);
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

