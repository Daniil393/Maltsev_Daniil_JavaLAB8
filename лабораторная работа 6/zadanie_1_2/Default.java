package zadanie_1_2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

/**
 * Аннотация {@code @Default} предназначена для указания типа по умолчанию.
 * <p>
 * Характеристики аннотации:
 *     Может применяться к типам (классам) и полям
 *     Доступна во время выполнения программы (RetentionPolicy.RUNTIME)
 *     Имеет обязательное свойство {@code value} типа {@link Class}
 * <p>
 * Используется совместно с обработчиком, который через рефлексию
 * получает значение {@code value} и выводит имя класса по умолчанию.
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Default {

    /**
     * Указывает класс, который должен использоваться по умолчанию.
     *
     * @return класс по умолчанию
     */
    Class<?> value();
}