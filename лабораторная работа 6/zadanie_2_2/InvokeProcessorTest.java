package zadanie_2_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zadanie_1_1.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Тестовый класс для проверки корректности работы {@link InvokeProcessor}.
 * <p>
 * Проверяет, что методы, помеченные аннотацией {@link Invoke},
 * корректно обнаруживаются через Reflection API и вызываются без исключений.
 * <p>
 * Тест также проверяет побочный эффект вызова методов —
 * изменение состояния объекта (установка логических флагов).
 * <p>
 * Используется фреймворк JUnit 5.
 */
class InvokeProcessorTest {

    /**
     * Тестируемый объект, содержащий методы с аннотацией {@link Invoke}.
     */
    private TestSubject testSubject;

    /**
     * Подготавливает новый экземпляр тестируемого класса перед каждым тестом.
     * <p>
     * Аннотация {@link BeforeEach} гарантирует,
     * что состояние объекта будет сброшено перед выполнением каждого тестового метода.
     */
    // Подготовка тестового экземпляра
    @BeforeEach
    void setUp() {
        testSubject = new TestSubject();
    }

    /**
     * Проверяет, что методы, помеченные аннотацией {@link Invoke},
     * корректно находятся с использованием Reflection API.
     * <p>
     * Ожидается, что будет найдено ровно два метода.
     */
    @Test
    void shouldFindMethodsAnnotatedWithInvoke() {
        Method[] methods = testSubject.getClass().getDeclaredMethods();
        List<Method> annotatedMethods = new ArrayList<>();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Invoke.class)) {
                annotatedMethods.add(method);
            }
        }

        assertEquals(2, annotatedMethods.size(),
                "Должно быть найдено 2 метода с аннотацией @Invoke");
    }

    /**
     * Проверяет корректность вызова методов, помеченных {@link Invoke}.
     * <p>
     * Тест выполняет следующие проверки:
     * <ul>
     *     <li>Методы вызываются без выброса исключений</li>
     *     <li>Методы с аннотацией {@code @Invoke} изменяют состояние объекта</li>
     *     <li>Методы без аннотации не вызываются</li>
     * </ul>
     */
    @Test
    void shouldInvokeAnnotatedMethodsAndChangeState() {
        assertFalse(testSubject.isMethodOneCalled());
        assertFalse(testSubject.isMethodThreeCalled());

        assertDoesNotThrow(() ->
                InvokeProcessor.process(testSubject)
        );

        assertTrue(testSubject.isMethodOneCalled(),
                "methodOne должен быть вызван");

        assertTrue(testSubject.isMethodThreeCalled(),
                "methodThree должен быть вызван");

        assertFalse(testSubject.isMethodTwoCalled(),
                "methodTwo не должен быть вызван");
    }

    /**
     * Вспомогательный тестовый класс.
     * <p>
     * Содержит методы с аннотацией {@link Invoke} и без неё.
     * Используется для проверки работы {@link InvokeProcessor}.
     */
    // Вспомогательный класс для теста
    static class TestSubject {

        /**
         * Флаг вызова метода {@link #methodOne()}.
         */
        private boolean methodOneCalled = false;

        /**
         * Флаг вызова метода {@link #methodTwo()}.
         */
        private boolean methodTwoCalled = false;

        /**
         * Флаг вызова метода {@link #methodThree()}.
         */
        private boolean methodThreeCalled = false;

        /**
         * Метод, помеченный аннотацией {@link Invoke}.
         * <p>
         * При вызове устанавливает соответствующий флаг в {@code true}.
         */
        @Invoke
        private void methodOne() {
            methodOneCalled = true;
        }

        /**
         * Метод без аннотации.
         * <p>
         * Не должен вызываться {@link InvokeProcessor}.
         */
        private void methodTwo() {
            methodTwoCalled = true;
        }

        /**
         * Метод, помеченный аннотацией {@link Invoke}.
         * <p>
         * При вызове устанавливает соответствующий флаг в {@code true}.
         */
        @Invoke
        private void methodThree() {
            methodThreeCalled = true;
        }

        /**
         * @return {@code true}, если {@link #methodOne()} был вызван
         */
        public boolean isMethodOneCalled() {
            return methodOneCalled;
        }

        /**
         * @return {@code true}, если {@link #methodTwo()} был вызван
         */
        public boolean isMethodTwoCalled() {
            return methodTwoCalled;
        }

        /**
         * @return {@code true}, если {@link #methodThree()} был вызван
         */
        public boolean isMethodThreeCalled() {
            return methodThreeCalled;
        }
    }
}