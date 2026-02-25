package zadanie_3;

import java.util.List;

/**
 * Утилитный класс для операций редукции (свёртки) элементов списков.
 */
public class ReducerUtil {

    /**
     * Применяет операцию редукции {@code reducer} ко всем элементам списка {@code list},
     * начиная с начального значения {@code identity}.
     * <p>
     * Метод проходит по списку слева направо, последовательно применяя {@code reducer.apply}
     * к текущему результату и каждому элементу списка.
     *
     * @param <T> тип элементов списка и результата редукции
     * @param list список элементов для редукции
     * @param reducer операция редукции для двух элементов типа {@code T}
     * @param identity начальное значение для редукции
     * @return результат редукции всех элементов списка
     */
    public static <T> T reduce(List<T> list, Reducer<T> reducer, T identity) {
        T result = identity;

        for (T item : list)
            result = reducer.apply(result, item);

        return result;
    }
}