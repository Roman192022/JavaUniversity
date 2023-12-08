import java.util.List;

public interface CulturalEventService {

    // Метод сортування за замовчуванням
    <T extends Comparable<? super T>> void sortByDefault(List<T> events);

    // Метод сортування за компаратором
    <T> void sortByComparator(List<T> events, java.util.Comparator<T> comparator);

    // Метод сортування за назвою події в алфавітному порядку
    <T extends CulturalEvent> List<T> sortAlphabetically(List<T> events);

    // Метод сортування за давністю подій
    <T extends CulturalEvent> void sortByEventAge(List<T> events);

    // Метод фільтрування колекції person за вказаним діапазоном віку людини
    List<Person> filterByAgeRange(List<Person> persons, int minAge, int maxAge);

    // Метод фільтрування подій, які відбулися після певної дати
    <T extends CulturalEvent> List<T> filterByDate(List<T> events, java.time.LocalDate date);

    // Метод фільтрування подій за назвою події
    <T extends CulturalEvent> List<T> filterByName(List<T> events, String eventName);

    // Метод, який повертає список людей, які відвідали певну подію
    <T extends CulturalEvent> List<Person> getAttendees(List<Person> persons, T event);
}









