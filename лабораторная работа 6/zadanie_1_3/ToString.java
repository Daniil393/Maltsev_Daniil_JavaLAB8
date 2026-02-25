package zadanie_1_3;

import java.lang.annotation.*;

/**
 * Пользовательская аннотация для управления формированием
 * строкового представления объекта.
 * <p>
 * Может применяться к: типу (классу) и полям класса
 * Доступна во время выполнения программы
 * ({@link RetentionPolicy#RUNTIME}), что позволяет
 * обрабатывать её с помощью рефлексии.
 * <p>
 * Имеет параметр {@code value}, определяющий,
 * включать ли элемент в строковое представление.</p>
 * <p>
 * По умолчанию используется значение {@link Mode#YES}
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ToString {
    Mode value() default Mode.YES;
}