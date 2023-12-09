import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {

            // Приклад успішної валідації
            Person person1 = new Person.PersonBuilder("John", LocalDate.of(2000, 6, 15), "john_doe@example.com")
                    .addAttendedEvent(new Concert("Rock Night", "Main Arena", LocalDate.of(2023, 8, 15), "Rock", 5, 40))
                    .addAttendedEvent(new Exhibition("Impressionist Art", "Art Museum", LocalDate.of(2023, 7, 25), "Impressionism", "Jane Doe", 80))
                    .addAttendedEvent(new TheatrePerformance("Classic Play", "City Theatre", LocalDate.of(2023, 6, 30), "Romeo and Juliet", 150, "Emily Williams"))
                    .build();

            System.out.println("");
            System.out.println(person1);
            System.out.println("");

            // Приклад невдалої валідації (не допустима дата народження)
            Person person2 = new Person.PersonBuilder("", LocalDate.of(2024, 1, 11), "alice_smith@company.org")
                    .build();

            System.out.println(person2);
            System.out.println("");


            // Невдала валідація через недопустимий email

            Person person3 = new Person.PersonBuilder("Jake", LocalDate.of(1999, 4, 21), "jake_email_example.com")
                    .build();

            System.out.println(person3);


    }
}