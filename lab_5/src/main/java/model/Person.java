package model;

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

    private Person(PersonBuilder builder) {
        this.name = builder.name;
        this.dateOfBirth = builder.dateOfBirth;
        this.email = builder.email;

    }

    public static class PersonBuilder {
        private String name;
        private LocalDate dateOfBirth;

        private String email;

        public PersonBuilder(String name, LocalDate dateOfBirth, String email) {

            this.name = name;
            this.dateOfBirth = dateOfBirth;
            this.email = email;

        }

        public Person build() {
            List<String> validationErrors = new ArrayList<>();

            try {
                validateName(this.name);
            } catch (IllegalArgumentException e) {validationErrors.add(e.getMessage());}

            try {
                validateEmail(this.email);
            } catch (IllegalArgumentException e) {validationErrors.add(e.getMessage());}

            try {
                validateDateOfBirth(this.dateOfBirth);
            } catch (IllegalArgumentException e) {validationErrors.add(e.getMessage());}




            if (!validationErrors.isEmpty()) {
                // Виведення всіх повідомлень про виключення
                throw new IllegalArgumentException(String.join( "\n", validationErrors));

            }

            return new Person(this);
        }



        private void validateName(String name) {
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException("Invalid name!");
            }
        }


        // Валідація поля dateOfBirth
        private void validateDateOfBirth(LocalDate dateOfBirth) {

            LocalDate currentDate = LocalDate.now();
            if (dateOfBirth == null) {
                throw new IllegalArgumentException("Date of birth cannot be null!");
            }

            if (dateOfBirth.isAfter(currentDate)) {
                throw new IllegalArgumentException("Date of birth cannot be in the future!");
            }

            final int MINIMUM_AGE = 6;
            final int MAXIMUM_AGE = 130;

            int age = Period.between(dateOfBirth, currentDate).getYears();
            if (age < MINIMUM_AGE) {
                throw new IllegalArgumentException("Person is too young!");
            }

            if (age > MAXIMUM_AGE) {
                throw new IllegalArgumentException("Person is too old!");
            }
        }


        private void validateEmail(String email) {
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            Pattern pattern = Pattern.compile(emailRegex);
            Matcher matcher = pattern.matcher(email);

            if (!matcher.matches()) {
                throw new IllegalArgumentException("Invalid email format!");
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



    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Person {\n");
        builder.append("   name='").append(name).append("',\n");
        builder.append("   date of birth=").append(dateOfBirth).append(",\n");
        builder.append("   email='").append(email).append("',\n");
        return builder.toString();
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return dateOfBirth == person.dateOfBirth &&
                Objects.equals(name, person.name) &&
                Objects.equals(email, person.email);
    }


    @Override
    public int hashCode() {

        return Objects.hash(name, dateOfBirth, email);
    }
}

