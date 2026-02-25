package zadanie_3;

/**
 * Класс-обёртка для строки.
 * <p>
 * Позволяет хранить строковое значение и работать с ним через методы доступа.
 */
public class StringWrapper {

    /** Хранимое строковое значение */
    private String value;

    /**
     * Создаёт пустую обёртку для строки.
     * Значение по умолчанию — пустая строка.
     */
    public StringWrapper() {
        this.value = "";
    }

    /**
     * Создаёт обёртку для строки с заданным значением.
     *
     * @param value строковое значение
     */
    public StringWrapper(String value) {
        this.value = value;
    }

    /**
     * Возвращает текущее значение строки.
     *
     * @return текущее строковое значение
     */
    public String getValue() {
        return value;
    }

    /**
     * Устанавливает новое значение строки.
     *
     * @param value новое строковое значение
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Возвращает строковое представление обёртки.
     *
     * @return строковое значение
     */
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}