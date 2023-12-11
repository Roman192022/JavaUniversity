package model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TheatrePerformance extends CulturalEvent {
    @JsonProperty("playTitle")
    private String playTitle;
    @JsonProperty("durationInMinutes")
    private int durationInMinutes;
    @JsonProperty("mainActor")
    private String mainActor;

    public TheatrePerformance() {
    }
    public TheatrePerformance(String eventName, String eventLocation,
                              String playTitle, int durationInMinutes, String mainActor) {
        super(eventName, eventLocation);
        this.playTitle = playTitle;
        this.durationInMinutes = durationInMinutes;
        this.mainActor = mainActor;
    }


    // геттери
    public String getPlayTitle() {
        return this.playTitle;
    }
    public int getDurationInMinutes() {
        return this.durationInMinutes;
    }
    public String getMainActor() {
        return this.mainActor;
    }


    // сеттери
    public void setPlayTitle(String playTitle) {
        this.playTitle = playTitle;
    }
    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }
    public void setMainActor(String mainActor) {
        this.mainActor = mainActor;
    }

    public void announceMainActor() {
        System.out.println("Main actor in the theatre performance: " + mainActor);
    }

    @Override
    public String toString() {
        return "TheatrePerformance{\n" +
                "   playTitle='" + playTitle + ",\n" +
                "   durationInMinutes=" + durationInMinutes + ",\n" +
                "   mainActor='" + mainActor + ",\n" +
                super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TheatrePerformance that = (TheatrePerformance) o;
        return durationInMinutes == that.durationInMinutes &&
                Objects.equals(playTitle, that.playTitle) &&
                Objects.equals(mainActor, that.mainActor) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), playTitle, durationInMinutes, mainActor);
    }
}
