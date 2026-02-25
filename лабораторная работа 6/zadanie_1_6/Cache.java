package zadanie_1_6;

import java.lang.annotation.*;

/**
 * Аннотация {@code @Cache} предназначена для классов и доступна во время выполнения программы.
 * <p>
 * Аннотация может хранить массив строк {@link #value()}, которые обычно
 * используются для указания ключей или параметров кэширования.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Cache {

    /**
     * Свойство {@code value} является необязательным и по умолчанию представляет пустой массив.
     */
    String[] value() default {};
}