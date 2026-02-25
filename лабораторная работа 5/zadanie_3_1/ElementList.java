package zadanie_3_1;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, представляющий список целочисленных элементов.
 * <p>
 * Обеспечивает хранение и доступ к списку {@link Integer}.
 */
public class ElementList {

    /** Внутренний список целых чисел */
    private List<Integer> list;

    /**
     * Создает объект ElementList с указанным списком чисел.
     * <p>
     * Переданный список копируется, чтобы избежать изменения внешнего списка.
     *
     * @param list исходный список целых чисел
     * @throws IllegalArgumentException если список равен {@code null}
     */
    public ElementList(List<Integer> list) {
        if (list == null)
            throw new IllegalArgumentException("Список пустой");

        this.list = new ArrayList<>(list);
    }

    /**
     * Возвращает внутренний список чисел.
     *
     * @return список целых чисел
     */
    public List<Integer> getList() {
        return list;
    }

    /**
     * Возвращает строковое представление списка.
     * <p>
     * Формат соответствует стандартному {@link java.util.List}.
     *
     * @return строковое представление списка
     */
    @Override
    public String toString() {
        return list.toString();
    }
}