package zadanie_3;

import java.util.ArrayList;
import java.util.List;

public class Filter {

    public static <T> List<T> filter(List<T> source, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();

        for (T item : source)
            if (predicate.test(item)) result.add(item);
        return result;
    }
}