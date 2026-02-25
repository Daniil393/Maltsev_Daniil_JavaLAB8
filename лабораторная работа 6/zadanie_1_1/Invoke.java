package zadanie_1_1;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

/**
 * Аннотация для методов, которые должны быть вызваны
 * через рефлексию или в специальных обработчиках.
 * <p>
 * Может использоваться для пометки методов, которые требуется автоматически вызвать.
 * Применяется только к методам.
 * <p>
 * Доступна во время выполнения через {@link java.lang.reflect.Method#getAnnotations()}.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Invoke {
}