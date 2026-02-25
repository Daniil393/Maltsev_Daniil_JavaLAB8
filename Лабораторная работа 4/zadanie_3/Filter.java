package zadanie_3;

import java.util.ArrayList;
import java.util.List;

/**
 * Утилитный класс для фильтрации элементов коллекции с помощью предикатов.
 */
public class Filter {

    /**
     * Фильтрует элементы исходного списка {@code source} с помощью предиката {@code predicate}.
     * <p>
     * Все элементы, для которых {@code predicate.test(item)} возвращает {@code true},
     * включаются в результирующий список. Порядок элементов сохраняется.
     *
     * @param <T> тип элементов списка
     * @param source исходный список элементов
     * @param predicate условие фильтрации
     * @return новый список, содержащий только элементы, удовлетворяющие условию
     */
    public static <T> List<T> filter(List<T> source, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();

        for (T item : source)
            if (predicate.test(item)) result.add(item);
        return result;
    }
}