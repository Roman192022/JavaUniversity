import java.util.Date;

public class Main {
    public static void main(String[] args) {
        CulturalEventOrganizer organizer = new CulturalEventOrganizer();
        CulturalEventBuilder concertBuilder = new ConcertBuilder();
        CulturalEventBuilder exhibitionBuilder = new ExhibitionBuilder();
        CulturalEventBuilder theatrePerformanceBuilder = new TheatrePerformanceBuilder();

        organizer.setCulturalEventBuilder(concertBuilder);
        organizer.setCulturalEventBuilder(exhibitionBuilder);
        organizer.setCulturalEventBuilder(theatrePerformanceBuilder);

    }
}
