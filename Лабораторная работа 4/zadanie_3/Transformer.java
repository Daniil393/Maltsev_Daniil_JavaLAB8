package zadanie_3;

import java.util.ArrayList;
import java.util.List;

/**
 * Утилитный класс для преобразования элементов списков с помощью функций.
 */
public class Transformer {

    /**
     * Преобразует элементы входного списка {@code input} с помощью функции {@code func}.
     * <p>
     * Для каждого элемента {@code item} из {@code input} вызывается {@code func.apply(item)},
     * а результат добавляется в новый список. Порядок элементов сохраняется.
     *
     * @param <T> тип элементов исходного списка
     * @param <P> тип элементов результирующего списка
     * @param input исходный список элементов
     * @param func функция преобразования элементов типа {@code T} в элементы типа {@code P}
     * @return новый список, содержащий результаты применения функции ко всем элементам исходного списка
     */
    public static <T, P> List<P> transform(List<T> input, MyFunction<T, P> func) {
        List<P> result = new ArrayList<>();
        for (T item : input) {
            P mapped = func.apply(item);
            result.add(mapped);
        }
        return result;
    }
}