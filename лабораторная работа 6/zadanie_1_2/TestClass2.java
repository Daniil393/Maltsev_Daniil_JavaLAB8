package zadanie_1_2;

/**
 * Тестовый класс для демонстрации работы пользовательской аннотации {@link Default}.
 * <p>
 * Используется совместно с {@link DefaultProcessor}
 * для проверки корректности обработки аннотаций во время выполнения программы.
 */
@Default(String.class)
public class TestClass2 {

    /**
     * Поле с аннотацией {@link Default}, указывающей,
     * что типом по умолчанию является {@link Integer}.
     */
    @Default(Integer.class)
    private Object numberField;

    /**
     * Обычное поле без аннотации.
     * Используется для демонстрации того, что обработчик
     * игнорирует элементы без {@link Default}.
     */
    private String name;
}