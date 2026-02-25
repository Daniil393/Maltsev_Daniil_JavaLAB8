package zadanie_3_1;

/**
 * Класс, представляющий элемент с целочисленным значением.
 * <p>
 * Используется для хранения и доступа к целочисленным данным,
 * с возможностью изменения значения.
 */
public class Element {

    /** Значение элемента */
    private Integer value;

    /**
     * Создает элемент с указанным целочисленным значением.
     *
     * @param value целочисленное значение элемента
     */
    public Element(Integer value) {
        this.value = value;
    }

    /**
     * Возвращает значение элемента.
     *
     * @return значение типа {@link Integer}
     */
    public Integer getValue() {
        return value;
    }

    /**
     * Устанавливает новое значение элемента.
     *
     * @param value новое значение типа {@link Integer}
     */
    public void setValue(Integer value) {
        this.value = value;
    }

    /**
     * Возвращает строковое представление элемента.
     * <p>
     * Формат: "E= {value}".
     *
     * @return строковое представление элемента
     */
    @Override
    public String toString() {
        return "E= " + value;
    }
}