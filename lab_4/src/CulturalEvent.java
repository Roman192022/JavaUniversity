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


    // геттери
    public String getEventName() {
        return eventName;
    }

    public String getEventLocation() {
        return eventLocation;
    }
    public LocalDate getEventDate() {
        return eventDate;
    }



    // сеттери

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }
    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }



    public void displayEventInfo() {
        System.out.println("Event: " + eventName);
        System.out.println("Location: " + eventLocation);
        System.out.println("Date: " + eventDate);
    }

    @Override
    public String toString() {
        return  "   eventName='" + eventName + "',\n" +
                "   eventLocation='" + eventLocation + "',\n" +
                "   eventDate=" + eventDate + "\n}";
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

