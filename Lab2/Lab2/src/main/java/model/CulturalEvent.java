package model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CulturalEvent {
    public String eventName;
    public String eventLocation;

    public CulturalEvent() {
    }
    public CulturalEvent(String eventName, String eventLocation) {
        this.eventName = eventName;
        this.eventLocation = eventLocation;
    }


    // геттери
    public String getEventName() {
        return eventName;
    }

    public String getEventLocation() {
        return eventLocation;
    }




    // сеттери

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }



    public void displayEventInfo() {
        System.out.println("Event: " + eventName);
        System.out.println("Location: " + eventLocation);
    }

    @Override
    public String toString() {
        return  "   eventName='" + eventName + "',\n" +
                "   eventLocation='" + eventLocation + "\n}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CulturalEvent that = (CulturalEvent) o;
        return Objects.equals(eventName, that.eventName) &&
                Objects.equals(eventLocation, that.eventLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventName, eventLocation);
    }
}

