import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Person {
    private String name;
    private int age;
    private List<CulturalEvent> attendedEvents;

    private Person(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.attendedEvents = builder.attendedEvents;
    }

    public static class Builder {
        private String name;
        private int age;
        private List<CulturalEvent> attendedEvents = new ArrayList<>();

        public Builder(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Builder addAttendedEvent(CulturalEvent event) {
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
        return "Person {\n" +
                "name='" + name + "'" + "," + '\n' +
                "age=" + age + "," + '\n' +
                "attendedEvents=" + attendedEvents + '\n' +
                '}';
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
