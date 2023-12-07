import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EventServiceWithStream implements CulturalEventService {

    @Override
    public <T extends Comparable<? super T>> void sortByDefault(List<T> events) {
        events = events.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public <T> void sortByComparator(List<T> events, Comparator<T> comparator) {
        events = events.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    @Override
    public <T extends CulturalEvent> List<T> sortAlphabetically(List<T> events) {
        events = events.stream()
                .sorted(Comparator.comparing(CulturalEvent::getEventName))
                .collect(Collectors.toList());
        return events;
    }

    @Override
    public <T> List<T> filterByCondition(List<T> events, Predicate<T> condition) {
        return events.stream()
                .filter(condition)
                .collect(Collectors.toList());
    }
}

