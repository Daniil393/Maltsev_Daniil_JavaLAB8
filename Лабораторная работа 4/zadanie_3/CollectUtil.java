package zadanie_3;

import java.util.List;

public class CollectUtil {

    public static <T, P> P collect(List<T> source, CollectorFactory<P> factory, Collector<P, T> adder) {
        P result = factory.create();

        for (T element : source)
            adder.add(result, element);

        return result;
    }
}