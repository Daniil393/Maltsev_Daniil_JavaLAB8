package zadanie_3;

import java.util.ArrayList;
import java.util.List;

public class Transformer {
    public static <T, P> List<P> transform(List<T> input, MyFunction<T, P> func) {
        List<P> result = new ArrayList<>();
        for (T item : input) {
            P mapped = func.apply(item);
            result.add(mapped);
        }
        return result;
    }
}