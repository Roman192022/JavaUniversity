// Базовий клас "Культурна Подія"
import java.util.Objects;

public class CulturalEvent {
    protected String eventName;
    protected String eventLocation;
    protected String eventDate;

    public CulturalEvent(String eventName, String eventLocation, String eventDate) {
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.eventDate = eventDate;
    }

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

    public void displayEventInfo() {
        System.out.println("Event: " + eventName);
        System.out.println("Location: " + eventLocation);
        System.out.println("Date: " + eventDate);
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

    @Override
    public String toString() {
        return "CulturalEvent{" +
                "eventName='" + eventName + '\'' +
                ", eventLocation='" + eventLocation + '\'' +
                ", eventDate='" + eventDate + '\'' +
                '}';
    }
}


public class Exhibition extends CulturalEvent {
    private String theme;
    private String curator;
    private int numberOfArtworks;

    public Exhibition(String eventName, String eventLocation, String eventDate, String theme,
                      String curator, int numberOfArtworks) {
        super(eventName, eventLocation, eventDate);
        this.theme = theme;
        this.curator = curator;
        this.numberOfArtworks = numberOfArtworks;
    }

    // Додаткові методи чи властивості, специфічні для виставки

    public void displayCuratorInfo() {
        System.out.println("Curator of the exhibition: " + curator);
    }
}

// Ще дочірні класи для інших типів культурних подій
public class TheatrePerformance extends CulturalEvent {
    private String playTitle;
    private int durationInMinutes;
    private String mainActor;

    public TheatrePerformance(String eventName, String eventLocation, String eventDate,
                              String playTitle, int durationInMinutes, String mainActor) {
        super(eventName, eventLocation, eventDate);
        this.playTitle = playTitle;
        this.durationInMinutes = durationInMinutes;
        this.mainActor = mainActor;
    }

    // Додаткові методи чи властивості, специфічні для театральної вистави

    public void announceMainActor() {
        System.out.println("Main actor in the theatre performance: " + mainActor);
    }
}

public class FilmFestival extends CulturalEvent {
    private String filmFestivalName;
    private int numberOfFilms;
    private String filmGenre;

    public FilmFestival(String eventName, String eventLocation, String eventDate,
                        String filmFestivalName, int numberOfFilms, String filmGenre) {
        super(eventName, eventLocation, eventDate);
        this.filmFestivalName = filmFestivalName;
        this.numberOfFilms = numberOfFilms;
        this.filmGenre = filmGenre;
    }

    // Додаткові методи чи властивості, специфічні для кінофестивалю

    public void announceFilmFestivalInfo() {
        System.out.println("Film festival: " + filmFestivalName);
    }
}

// Інший дочірній клас
public class LiteraryReading extends CulturalEvent {
    private String author;
    private String bookTitle;
    private int durationInHours;

    public LiteraryReading(String eventName, String eventLocation, String eventDate,
                           String author, String bookTitle, int durationInHours) {
        super(eventName, eventLocation, eventDate);
        this.author = author;
        this.bookTitle = bookTitle;
        this.durationInHours = durationInHours;
    }

    // Додаткові методи чи властивості, специфічні для літературного читання

    public void announceAuthorInfo() {
        System.out.println("Author of the literary reading: " + author);
    }
}


