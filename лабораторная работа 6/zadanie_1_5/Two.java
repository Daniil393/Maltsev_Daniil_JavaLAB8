package zadanie_1_5;

import java.lang.annotation.*;

/**
 * Пользовательская аннотация {@code @Two}.
 * <p>
 * Может применяться к: типу (классу)
 * Доступна во время выполнения (RUNTIME)
 * Имеет два обязательных свойства:
 * {@code first} — строковое значение
 * {@code second} — целочисленное значение
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Two {
    String first();
    int second();
}