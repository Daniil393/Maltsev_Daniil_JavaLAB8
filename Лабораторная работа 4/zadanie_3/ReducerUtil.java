package zadanie_3;

import java.util.List;

public class ReducerUtil {

    public static <T> T reduce(List<T> list, Reducer<T> reducer, T identity) {
        T result = identity;

        for (T item : list)
            result = reducer.apply(result, item);

        return result;
    }
}