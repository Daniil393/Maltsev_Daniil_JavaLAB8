package zadanie_2_4;

import zadanie_1_4.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестовый класс для проверки корректности работы
 * {@link ValidateProcessor}.
 * <p>
 * Проверяется:
 * <ul>
 *     <li>Корректное извлечение классов из аннотации {@link Validate}</li>
 *     <li>Выброс {@link IllegalArgumentException} при передаче пустого массива типов</li>
 * </ul>
 *
 * Используется фреймворк JUnit 5.
 */
class ValidateProcessorTest {

    /**
     * Тестовый класс с корректной аннотацией {@link Validate},
     * содержащей два типа: {@link String} и {@link Integer}.
     */
    @Validate({String.class, Integer.class})
    static class TestClassValid {
    }

    /**
     * Тестовый класс с аннотацией {@link Validate},
     * содержащей пустой массив типов.
     * Используется для проверки выброса исключения.
     */
    @Validate({})
    static class TestClassEmpty {
    }

    /**
     * Проверяет, что аннотация {@link Validate} корректно
     * присутствует у класса и массив типов извлекается
     * в правильном порядке.
     */
    @Test
    void testValidAnnotationExtraction() {
        Validate annotation = TestClassValid.class.getAnnotation(Validate.class);
        assertNotNull(annotation);

        Class<?>[] classes = annotation.value();

        assertEquals(2, classes.length);
        assertEquals(String.class, classes[0]);
        assertEquals(Integer.class, classes[1]);
    }

    /**
     * Проверяет, что при передаче класса с пустым массивом типов
     * в аннотации {@link Validate} метод
     * {@link ValidateProcessor#process(Class)}
     * выбрасывает {@link IllegalArgumentException}.
     */
    @Test
    void testEmptyAnnotationThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                ValidateProcessor.process(TestClassEmpty.class)
        );
    }
}