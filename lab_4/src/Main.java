import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        try {
            // Приклад успішної валідації
            Person person1 = new Person.PersonBuilder("John", 25, "john_doe@example.com")
                    .addAttendedEvent(new Concert("Rock Night", "Main Arena", LocalDate.of(2023, 8, 15), "Rock", 5, 40))
                    .addAttendedEvent(new Exhibition("Impressionist Art", "Art Museum", LocalDate.of(2023, 7, 25), "Impressionism", "Jane Doe", 80))
                    .addAttendedEvent(new TheatrePerformance("Classic Play", "City Theatre", LocalDate.of(2023, 6, 30), "Romeo and Juliet", 150, "Emily Williams"))
                    .build();

            System.out.println(person1);

            // Приклад невдалої валідації (вік не допустимий)
            Person person2 = new Person.PersonBuilder("Alice", 200, "alice_smith@company.org")
                    .build();

            // Цей рядок не буде виконано через виключення
            System.out.println(person2);


            // Невдала валідація через недопустимий email

            Person person3 = new Person.PersonBuilder("Jake", 25, "jake_email_example.com")
                    .build();

            // Цей рядок не буде виконано через виключення
            System.out.println(person3);


        } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}