import java.util.Comparator;
import java.util.List;

public class EventServiceWithoutStream implements CulturalEventService {

    @Override
    public <T extends Comparable<? super T>> void sortByDefault(List<T> events) {

        events.sort(Comparator.naturalOrder());
    }

    @Override
    public <T> void sortByComparator(List<T> events, Comparator<T> comparator) {

        events.sort(comparator);
    }

    @Override
    public <T extends CulturalEvent> List<T> sortAlphabetically(List<T> events) {
        events.sort(Comparator.comparing(CulturalEvent::getEventName));
        return events;
    }

    @Override
    public <T> List<T> filterByCondition(List<T> events, java.util.function.Predicate<T> condition) {
        return List.copyOf(events).stream()
                .filter(condition)
                .toList();
    }
}

