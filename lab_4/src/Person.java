import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Person {
    private String name;
    private int age;
    private String email;
    private List<CulturalEvent> attendedEvents;

    private Person(PersonBuilder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.email = builder.email;
        this.attendedEvents = new ArrayList<>(builder.attendedEvents);

    }

    public static class PersonBuilder {
        private String name;
        private int age;

        private String email;
        private List<CulturalEvent> attendedEvents = new ArrayList<>();

        public PersonBuilder(String name, int age, String email) {
            validateName(name);
            validateAge(age);
            validateEmail(email);
            this.name = name;
            this.age = age;
            this.email = email;
        }

        public PersonBuilder addAttendedEvent(CulturalEvent event) {
            validateEvent(event);
            attendedEvents.add(event);
            return this;
        }

        public Person build() {

            return new Person(this);
        }

        private void validateName(String name) {
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException("Name cannot be null or empty");
            }
        }

        private void validateAge(int age) {
            if (age < 0 || age > 150) {
                throw new IllegalArgumentException("Age must be between 0 and 150");
            }
        }

        private void validateEmail(String email) {
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            Pattern pattern = Pattern.compile(emailRegex);
            Matcher matcher = pattern.matcher(email);

            if (!matcher.matches()) {
                throw new IllegalArgumentException("Invalid email format.");
            }
        }

        private void validateEvent(CulturalEvent event) {
            if (event == null) {
                throw new IllegalArgumentException("Attended event cannot be null");
            }
        }
    }



    public String getName() {

        return name;
    }

    public int getAge() {

        return age;
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
        builder.append("   age=").append(age).append(",\n");
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
        return age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(email, person.email) &&
                Objects.equals(attendedEvents, person.attendedEvents);
    }


    @Override
    public int hashCode() {

        return Objects.hash(name, age, email, attendedEvents);
    }
}

