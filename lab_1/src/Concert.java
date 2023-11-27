public class Concert extends CulturalEvent {
    private String genre;
    private int numberOfPerformers;
    private String ticketPrice;

    public Concert(String eventName, String eventLocation, String eventDate, String genre,
                   int numberOfPerformers, String ticketPrice) {
        super(eventName, eventLocation, eventDate);
        this.genre = genre;
        this.numberOfPerformers = numberOfPerformers;
        this.ticketPrice = ticketPrice;
    }

    // Додаткові методи чи властивості, специфічні для концерту

    public void announceTicketPrice() {
        System.out.println("Ticket price for the concert: " + ticketPrice);
    }
}

