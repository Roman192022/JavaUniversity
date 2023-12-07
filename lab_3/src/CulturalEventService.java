import java.util.Comparator;
import java.util.List;

public interface CulturalEventService {

    // Сортування колекції за замовчуванням (за допомогою Comparable).
    <T extends Comparable<? super T>> void sortByDefault(List<T> events);

    // Сортування колекції за допомогою вказаного компаратора.
    <T> void sortByComparator(List<T> events, Comparator<T> comparator);

    // Сортування колекції за назвою події в алфавітним порядком (за допомогою методу compareTo у CulturalEvent).
    <T extends CulturalEvent> List<T> sortAlphabetically(List<T> events);

    // Фільтрування колекції за певною умовою, заданою предикатом.
    <T> List<T> filterByCondition(List<T> events, java.util.function.Predicate<T> condition);
}









