import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Person {
    private String name;
    private int age;
    private List<CulturalEvent> attendedEvents;

    private Person(PersonBuilder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.attendedEvents = new ArrayList<>(builder.attendedEvents);
    }


    public static class PersonBuilder {
        private String name;
        private int age;
        private List<CulturalEvent> attendedEvents = new ArrayList<>();

        public PersonBuilder(String name, int age) {
            this.name = name;
            this.age = age;
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

    public int getAge() {
        return age;
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
                Objects.equals(attendedEvents, person.attendedEvents);
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, age, attendedEvents);
    }
}
