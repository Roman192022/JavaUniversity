package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTablesDB {
    public static void createTables() {
        try (Connection connection = ConnectionDB.getConnection();
             Statement statement = connection.createStatement()) {
            // Create CulturalEvent table
            statement.execute("CREATE TABLE CulturalEvent (" +
                    "eventID SERIAL PRIMARY KEY," +
                    "eventName VARCHAR(255)," +
                    "eventLocation VARCHAR(255)," +
                    "eventDate DATE)");

            // Create Concert table
            statement.execute("CREATE TABLE Concert (" +
                    "concertID SERIAL PRIMARY KEY," +
                    "eventID INT REFERENCES CulturalEvent(eventID)," +
                    "genre VARCHAR(255)," +
                    "numberOfPerformers INT," +
                    "ticketPrice INT)");

            // Create Exhibition table
            statement.execute("CREATE TABLE Exhibition (" +
                    "exhibitionID SERIAL PRIMARY KEY," +
                    "eventID INT REFERENCES CulturalEvent(eventID)," +
                    "theme VARCHAR(255)," +
                    "curator VARCHAR(255)," +
                    "numberOfArtworks INT)");

            // Create TheatrePerformance table
            statement.execute("CREATE TABLE TheatrePerformance (" +
                    "theatrePerformancenID SERIAL PRIMARY KEY," +
                    "eventID INT REFERENCES CulturalEvent(eventID)," +
                    "playTitle VARCHAR(255)," +
                    "durationInMinutes INT," +
                    "mainActor VARCHAR(255))");

            // Create Person table
            statement.execute("CREATE TABLE Person (" +
                    "personID SERIAL PRIMARY KEY," +
                    "name VARCHAR(255), " +
                    "dateOfBirth DATE," +
                    "email VARCHAR(255))");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

