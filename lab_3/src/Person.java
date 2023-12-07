import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.time.LocalDate;
import java.time.Period;


public class Person {
    private String name;
    private LocalDate dateOfBirth;
    private List<CulturalEvent> attendedEvents;


    private Person(PersonBuilder builder) {
        this.name = builder.name;
        this.dateOfBirth = builder.dateOfBirth;
        this.attendedEvents = new ArrayList<>(builder.attendedEvents);
    }

    public static class PersonBuilder {
        private String name;
        private LocalDate dateOfBirth;

        private List<CulturalEvent> attendedEvents = new ArrayList<>();


        public PersonBuilder(String name, LocalDate dateOfBirth) {

            this.name = name;
            this.dateOfBirth = dateOfBirth;
        }

        public PersonBuilder addAttendedEvent(CulturalEvent event) {
            attendedEvents.add(event);
            return this;
        }

        public Person build() {

            return new Person(this);
        }
    }



    public String getName() {

        return name;
    }

    public LocalDate getDateOfBirth() {

        return dateOfBirth;
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
                Objects.equals(attendedEvents, person.attendedEvents);
    }


    @Override
    public int hashCode() {

        return Objects.hash(name, dateOfBirth, attendedEvents);
    }
}

