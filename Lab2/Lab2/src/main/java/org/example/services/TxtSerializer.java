package org.example.services;


import model.CulturalEvent;
import model.Concert;
import model.Exhibition;
import model.TheatrePerformance;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TxtSerializer<T> implements Serializer<T> {
    @Override
    public void serialize(T entity, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(convertToTxt(entity));
        }
    }

    private String convertToTxt(T entity) {
        if (entity instanceof Concert) {
            Concert concert = (Concert) entity;
            return String.format("Concert: eventName=%s, eventLocation=%s, genre=%s, numberOfPerformers=%d, ticketPrice=%s\n",
                    concert.getEventName(), concert.getEventLocation(),
                    concert.getGenre(), concert.getNumberOfPerformers(), concert.getTicketPrice());
        }

        else if (entity instanceof Exhibition) {
            Exhibition exhibition = (Exhibition) entity;
            return String.format("TheatrePerformance: eventName=%s, eventLocation=%s, theme=%s, curator=%d, numberOfArtwork=%s\n",
                    exhibition.getEventName(), exhibition.getEventLocation(),
                    exhibition.getTheme(), exhibition.getCurator(), exhibition.getNumberOfArtwork());
        }

        else if (entity instanceof TheatrePerformance) {
            TheatrePerformance theatrePerformance = (TheatrePerformance) entity;
            return String.format("TheatrePerformance: eventName=%s, eventLocation=%s, playTitle=%s, durationInMinutes=%d, mainActor=%s\n",
                    theatrePerformance.getEventName(), theatrePerformance.getEventLocation(),
                    theatrePerformance.getPlayTitle(), theatrePerformance.getDurationInMinutes(), theatrePerformance.getMainActor());
        }

        throw new RuntimeException("The instance must be Concert, Exhibition or TheatrePerformance" );
    }







    @Override
    public T deserialize(String filename, Class<T> entityType) throws IOException {
        String content = new String(Files.readAllBytes(Path.of(filename)));
        return convertFromTxt(content, entityType);
    }

    private T convertFromTxt(String content, Class<T> entityType) {
        if (entityType == Concert.class) {
            return (T) convertConcertFromTxt(content);
        } else if (entityType == Exhibition.class) {
            return (T) convertExhibitionFromTxt(content);
        } else if (entityType == TheatrePerformance.class) {
            return (T) convertTheatrePerformanceFromTxt(content);
        }

        return null; // Ви можете визначити власні логіку для інших класів, якщо потрібно.
    }

    private Concert convertConcertFromTxt(String content) {
        Pattern pattern = Pattern.compile("Concert: eventName=(.*), eventLocation=(.*), genre=(.*), numberOfPerformers=(\\d+), ticketPrice=(\\d+)");
        Matcher matcher = pattern.matcher(content);

        if (matcher.find()) {
            String eventName = matcher.group(1);
            String eventLocation = matcher.group(2);
            String genre = matcher.group(3);
            int numberOfPerformers = Integer.parseInt(matcher.group(4));
            int ticketPrice = Integer.parseInt(matcher.group(5));

            return new Concert(eventName, eventLocation, genre, numberOfPerformers, ticketPrice);
        }

        throw new RuntimeException("Incorrect representation of class Concert");

    }


    private Exhibition convertExhibitionFromTxt(String content) {
        Pattern pattern = Pattern.compile("Exhibition: eventName=(.*), eventLocation=(.*), theme=(.*), curator=(.*), numberOfArtwork=(\\d+)");
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            String eventName = matcher.group(1);
            String eventLocation = matcher.group(2);
            String theme = matcher.group(3);
            String curator = matcher.group(4);
            int numberOfArtwork = Integer.parseInt(matcher.group(5));

            return new Exhibition(eventName, eventLocation, theme, curator, numberOfArtwork);
        }
        throw new RuntimeException("Incorrect representation of class Exhibition");
    }

    private TheatrePerformance convertTheatrePerformanceFromTxt(String content) {
        Pattern pattern = Pattern.compile("TheatrePerformance: eventName=(.*), eventLocation=(.*), playTitle=(.*), durationInMinutes=(\\d+), mainActor=(.*)");
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            String eventName = matcher.group(1);
            String eventLocation = matcher.group(2);
            String playTitle = matcher.group(3);
            int durationInMinutes = Integer.parseInt(matcher.group(4));
            String mainActor = matcher.group(5);

            return new TheatrePerformance(eventName, eventLocation, playTitle, durationInMinutes, mainActor);
        }
        throw new RuntimeException("Incorrect representation of class TheatrePerformance");
    }


}
