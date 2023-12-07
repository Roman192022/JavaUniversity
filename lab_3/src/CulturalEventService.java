import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.function.Predicate;

public class CulturalEventService {

    // Метод для сортування списку за замовчуванням (Comparable)
    public void sortByDefault(List<CulturalEvent> events) {

        Collections.sort(events);
    }

    // Метод для сортування списку за вказаним компаратором (Comparator)
    public <T> void sortByComparator(List<T> events, Comparator<T> comparator) {

        events.sort(comparator);
    }

    // Метод для сортування списку за алфавітним порядком (за назвою)
    public <T extends CulturalEvent> List<T> sortAlphabetically(List<T> events) {
        events.sort(Comparator
                .comparing(CulturalEvent::getEventName));
        return events;
    }

    // Методи з використанням Stream API

    // Метод для сортування списку за замовчуванням (Comparable) з використанням Stream API
    public <T extends Comparable<? super T>> List<T> sortByDefaultWithStream(List<T> events) {
        return events.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    // Метод для сортування списку за вказаним компаратором (Comparator) з використанням Stream API
    public <T> List<T> sortByComparatorWithStream(List<T> events, Comparator<T> comparator) {
        return events.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    // Метод для сортування списку за алфавітним порядком (за назвою) з використанням Stream API
    public <T extends CulturalEvent> List<T> sortAlphabeticallyWithStream(List<T> events) {
        return events.stream()
                .sorted(Comparator.comparing(CulturalEvent::getEventName))
                .collect(Collectors.toList());
    }

    // Метод для фільтрації списку за певною умовою з використанням Stream API
    public <T> List<T> filterByConditionWithStream(List<T> events, Predicate<T> condition) {
        return events.stream()
                .filter(condition)
                .collect(Collectors.toList());
    }



}
