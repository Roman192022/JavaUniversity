package model;

import java.time.LocalDate;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Exhibition extends CulturalEvent {
    @JsonProperty("theme")
    private String theme;
    @JsonProperty("curator")
    private String curator;
    @JsonProperty("numberOfArtworks")
    private int numberOfArtworks;

    public Exhibition() {
    }
    public Exhibition(String eventName, String eventLocation, String theme,
                      String curator, int numberOfArtworks) {
        super(eventName, eventLocation/*, eventDate*/);
        this.theme = theme;
        this.curator = curator;
        this.numberOfArtworks = numberOfArtworks;
    }

    // геттери
    public String getTheme() {
        return this.theme;
    }
    public String getCurator() {
        return this.curator;
    }
    public int getNumberOfArtwork() {
        return this.numberOfArtworks;
    }


    // сеттери
    public void setTheme(String theme) {
        this.theme = theme;
    }
    public void setCurator(String curator) {
        this.curator = curator;
    }
    public void setNumberOfArtwork(int numberOfArtworks) {
        this.numberOfArtworks = numberOfArtworks;
    }


    @Override
    public String toString() {
        return "Exhibition{\n" +
                "   theme='" + theme + ",\n" +
                "   curator='" + curator + ",\n" +
                "   numberOfArtworks=" + numberOfArtworks + ",\n" +
                super.toString();
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

