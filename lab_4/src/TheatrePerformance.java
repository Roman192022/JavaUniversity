import java.time.LocalDate;
import java.util.Objects;

public class TheatrePerformance extends CulturalEvent {
    private String playTitle;
    private int durationInMinutes;
    private String mainActor;

    public TheatrePerformance(String eventName, String eventLocation, LocalDate eventDate,
                              String playTitle, int durationInMinutes, String mainActor) {
        super(eventName, eventLocation, eventDate);
        this.playTitle = playTitle;
        this.durationInMinutes = durationInMinutes;
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
