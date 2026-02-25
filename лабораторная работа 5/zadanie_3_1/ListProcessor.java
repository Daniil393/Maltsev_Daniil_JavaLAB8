package zadanie_3_1;

/**
 * Класс, обрабатывающий список целых чисел ({@link ElementList}) с возможностью
 * удаления конкретного элемента ({@link Element}) из списка.
 */
public class ListProcessor {

    /** Список целых чисел для обработки */
    private ElementList elementList;

    /** Элемент, который будет удаляться из списка */
    private Element element;

    /**
     * Создает объект ListProcessor для указанного списка и элемента.
     *
     * @param elementList список для обработки
     * @param element элемент, который будет удаляться
     * @throws IllegalArgumentException если {@code elementList} или {@code element} равны {@code null}
     */
    public ListProcessor(ElementList elementList, Element element) {
        if (elementList == null || element == null)
            throw new IllegalArgumentException("Объекты не могут быть null");

        this.elementList = elementList;
        this.element = element;
    }

    /**
     * Удаляет все вхождения значения элемента {@link #element} из списка {@link #elementList}.
     */
    public void removeElement() {
        elementList.getList().removeIf(x -> x.equals(element.getValue()));
    }

    /**
     * Возвращает строковое представление объекта ListProcessor.
     * <p>
     * Формат: "Обработчик списка: удаление{element}".
     *
     * @return строковое представление ListProcessor
     */
    @Override
    public String toString() {
        return "Обработчик списка: удаление" + element;
    }
}