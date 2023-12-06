package org.example;

import java.time.LocalDate;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonFormat;


public class Concert extends CulturalEvent {
    private String genre;
    private int numberOfPerformers;
    private int ticketPrice;

    public Concert(String eventName, String eventLocation, LocalDate eventDate, String genre,
                   int numberOfPerformers, int ticketPrice) {
        super(eventName, eventLocation, eventDate);
        this.genre = genre;
        this.numberOfPerformers = numberOfPerformers;
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




