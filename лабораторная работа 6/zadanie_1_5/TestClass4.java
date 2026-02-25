package zadanie_1_5;

/**
 * Тестовый класс, аннотированный пользовательской аннотацией {@link Two}.
 * <p>
 * Аннотация {@code @Two} указывает два значения:
 * <ul>
 *     <li>{@code first} — строковое значение ("Hello")</li>
 *     <li>{@code second} — числовое значение (15)</li>
 * </ul>
 * <p>
 * Класс используется только для демонстрации работы обработчика {@link TwoProcessor}.
 */
@Two(first = "Hello", second = 15)
public class TestClass4 {
}