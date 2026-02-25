package zadanie_1_4;

import java.lang.annotation.*;

/**
 * Пользовательская аннотация для указания набора типов,
 * используемых при валидации класса или другой аннотации.
 * <p>
 * Может применяться к: типу (классу) и другой аннотации
 * <p>
 * Доступна во время выполнения программы
 * ({@link RetentionPolicy#RUNTIME})
 */
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Validate {

    /**
     * Возвращает список классов, используемых для проверки.
     *
     * @return массив объектов {@link Class}
     */
    Class<?>[] value();
}