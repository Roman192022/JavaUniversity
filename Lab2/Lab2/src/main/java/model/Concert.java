package model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Concert extends CulturalEvent {
    @JsonProperty("genre")
    private String genre;
    @JsonProperty("numberOfPerformers")
    private int numberOfPerformers;
    @JsonProperty("ticketPrice")
    private int ticketPrice;

    public Concert() {
    }
    public Concert(String eventName, String eventLocation,  String genre,
                   int numberOfPerformers, int ticketPrice) {
        super(eventName, eventLocation);
        this.genre = genre;
        this.numberOfPerformers = numberOfPerformers;
        this.ticketPrice = ticketPrice;
    }

    // геттери
    public String getGenre() {
        return this.genre;
    }
    public int getNumberOfPerformers() {
        return this.numberOfPerformers;
    }
    public int getTicketPrice() {
        return this.ticketPrice;
    }


    // сеттери
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void setNumberOfPerformers(int numberOfPerformers) {
        this.numberOfPerformers = numberOfPerformers;
    }
    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }



    public void announceTicketPrice() {
        System.out.println("Ticket price for the concert: " + ticketPrice);
    }

    @Override
    public String toString() {
        return "Concert{" + '\n' +
                "   genre='" + genre + "',\n" +
                "   numberOfPerformers=" + numberOfPerformers + ",\n" +
                "   ticketPrice=" + ticketPrice + "\n" +
                super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Concert concert = (Concert) o;
        return numberOfPerformers == concert.numberOfPerformers &&
                Objects.equals(genre, concert.genre) &&
                ticketPrice == concert.ticketPrice &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), genre, numberOfPerformers, ticketPrice);
    }
}


