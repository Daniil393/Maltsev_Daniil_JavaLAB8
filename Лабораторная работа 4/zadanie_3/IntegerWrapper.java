package zadanie_3;

/**
 * Класс-обёртка для целого числа.
 * <p>
 * Позволяет хранить целочисленное значение и работать с ним через методы доступа.
 */
public class IntegerWrapper {

    /** Хранимое целочисленное значение */
    private int value;

    /**
     * Создаёт обёртку с нулевым значением.
     */
    public IntegerWrapper() {
        this.value = 0;
    }

    /**
     * Создаёт обёртку с заданным значением.
     *
     * @param value целочисленное значение
     */
    public IntegerWrapper(int value) {
        this.value = value;
    }

    /**
     * Возвращает текущее значение числа.
     *
     * @return текущее целочисленное значение
     */
    public int getValue() {
        return value;
    }

    /**
     * Устанавливает новое значение числа.
     *
     * @param value новое целочисленное значение
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Возвращает строковое представление обёртки.
     *
     * @return строковое представление текущего значения
     */
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}