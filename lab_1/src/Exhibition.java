import java.time.LocalDate;
import java.util.Objects;

public class Exhibition extends CulturalEvent {
    private String theme;
    private String curator;
    private int numberOfArtworks;

    public Exhibition(String eventName, String eventLocation, LocalDate eventDate, String theme,
                      String curator, int numberOfArtworks) {
        super(eventName, eventLocation, eventDate);
        this.theme = theme;
        this.curator = curator;
        this.numberOfArtworks = numberOfArtworks;
    }

    public void displayCuratorInfo() {
        System.out.println("Curator of the exhibition: " + curator);
    }

    @Override
    public String toString() {
        return "Exhibition{" +
                "theme='" + theme + '\'' +
                ", curator='" + curator + '\'' +
                ", numberOfArtworks=" + numberOfArtworks +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exhibition that = (Exhibition) o;
        return numberOfArtworks == that.numberOfArtworks &&
                Objects.equals(theme, that.theme) &&
                Objects.equals(curator, that.curator) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), theme, curator, numberOfArtworks);
    }
}

