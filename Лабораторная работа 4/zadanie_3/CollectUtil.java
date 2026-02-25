package zadanie_3;

import java.util.List;

/**
 * Утилитный класс для сбора элементов из списка в произвольные коллекции
 * с помощью фабрики и добавляющего механизма.
 */
public class CollectUtil {

    /**
     * Составляет новую коллекцию из элементов исходного списка {@code source}.
     * <p>
     * Метод использует фабрику {@code factory} для создания новой коллекции
     * и объект {@code adder} для добавления элементов в эту коллекцию.
     *
     * @param <T> тип элементов исходного списка
     * @param <P> тип результирующей коллекции
     * @param source исходный список элементов
     * @param factory фабрика для создания новой коллекции типа {@code P}
     * @param adder механизм добавления элементов типа {@code T} в коллекцию типа {@code P}
     * @return новая коллекция, содержащая все элементы из {@code source}
     */
    public static <T, P> P collect(List<T> source, CollectorFactory<P> factory, Collector<P, T> adder) {
        P result = factory.create();

        for (T element : source)
            adder.add(result, element);

        return result;
    }
}