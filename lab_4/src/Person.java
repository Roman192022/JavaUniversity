import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.LocalDate;
import java.time.Period;


public class Person {
    private String name;
    private LocalDate dateOfBirth;
    private String email;
    private List<CulturalEvent> attendedEvents;
    private List<String> validationErrors; // Список для зберігання повідомлень про виключення


    private Person(PersonBuilder builder) {
        this.name = builder.name;
        this.dateOfBirth = builder.dateOfBirth;
        this.email = builder.email;
        this.attendedEvents = new ArrayList<>(builder.attendedEvents);
        this.validationErrors = builder.validationErrors;
    }

    public static class PersonBuilder {
        private String name;
        private LocalDate dateOfBirth;

        private String email;
        private List<CulturalEvent> attendedEvents = new ArrayList<>();

        private List<String> validationErrors = new ArrayList<>(); // Список для зберігання повідомлень про виключення


        public PersonBuilder(String name, LocalDate dateOfBirth, String email) {


            validateName(name);
            validateDateOfBirth(dateOfBirth);
            validateEmail(email);

            this.name = name;
            this.dateOfBirth = dateOfBirth;
            this.email = email;



        }

        public PersonBuilder addAttendedEvent(CulturalEvent event) {
            validateEvent(event);
            attendedEvents.add(event);
            return this;
        }

        public Person build() {
            if (!validationErrors.isEmpty()) {
                // Виведення всіх повідомлень про виключення
                for (String error : validationErrors) {
                    System.out.println("Validation Error: " + error);
                }
                System.out.println("");
                // Повернення null, оскільки не можна створити об'єкт Person
                return null;
            }

            return new Person(this);
        }

        private void validateName(String name) {
            if (name == null || name.isEmpty()) {
                validationErrors.add("Name cannot be null or empty");
            }
        }


        // Валідація поля dateOfBirth
        private void validateDateOfBirth(LocalDate dateOfBirth) {
            LocalDate currentDate = LocalDate.now();
            try {
                Objects.requireNonNull(dateOfBirth);
            } catch (Exception e) {
                validationErrors.add("Date of birth cannot be null.");
            }

            if (dateOfBirth.isAfter(currentDate)) {
                validationErrors.add("Date of birth cannot be in the future.");
            }

            final int MINIMUM_AGE = 6;
            final int MAXIMUM_AGE = 130;

            int age = Period.between(dateOfBirth, currentDate).getYears();
            if (age < MINIMUM_AGE) {
                validationErrors.add("Person is too young.");
            }

            if (age > MAXIMUM_AGE) {
                validationErrors.add("Person is too old.");
            }
        }


        private void validateEmail(String email) {
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            Pattern pattern = Pattern.compile(emailRegex);
            Matcher matcher = pattern.matcher(email);

            if (!matcher.matches()) {
                validationErrors.add("Invalid email format.");
            }
        }

        private void validateEvent(CulturalEvent event) {
            if (event == null) {
                validationErrors.add("Attended event cannot be null");
            }
        }
    }



    public String getName() {

        return name;
    }

    public LocalDate getDateOfBirth() {

        return dateOfBirth;
    }

    public String getEmail() {

        return email;
    }

    public List<CulturalEvent> getAttendedEvents() {

        return new ArrayList<>(attendedEvents);
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Person {\n");
        builder.append("   name='").append(name).append("',\n");
        builder.append("   date of birth=").append(dateOfBirth).append(",\n");
        builder.append("   email='").append(email).append("',\n");

        builder.append("   attendedEvents=[");
        if (!attendedEvents.isEmpty()) {
            builder.append('\n');
            for (CulturalEvent event : attendedEvents) {
                builder.append("      '").append(event.getEventName()).append("',\n");
            }
            builder.deleteCharAt(builder.length() - 2);  // Видалення останньої коми
        }
        builder.append("   ]\n");

        builder.append('}');
        return builder.toString();
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return dateOfBirth == person.dateOfBirth &&
                Objects.equals(name, person.name) &&
                Objects.equals(email, person.email) &&
                Objects.equals(attendedEvents, person.attendedEvents);
    }


    @Override
    public int hashCode() {

        return Objects.hash(name, dateOfBirth, email, attendedEvents);
    }
}

