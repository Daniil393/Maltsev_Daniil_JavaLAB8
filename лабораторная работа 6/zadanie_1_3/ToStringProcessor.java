package zadanie_1_3;

import java.lang.reflect.Field;

/**
 * Класс-обработчик пользовательской аннотации {@link ToString}.
 *
 * <p>Формирует строковое представление объекта с использованием рефлексии.
 * В строку включаются только те поля, для которых значение аннотации
 * {@code @ToString} равно {@link Mode#YES}.</p>
 */
public class ToStringProcessor {

    /**
     * Формирует строковое представление переданного объекта.
     * <p>
     * Алгоритм работы метода:
     * <ul>
     *     <li>Проверяет наличие аннотации {@link ToString} у класса.</li>
     *     <li>Если аннотация отсутствует или имеет значение {@link Mode#NO},
     *     возвращает соответствующее сообщение.</li>
     *     <li>С помощью рефлексии получает все поля класса.</li>
     *     <li>Включает в результирующую строку только те поля,
     *     у которых аннотация отсутствует (по умолчанию {@link Mode#YES})
     *     или явно указано {@link Mode#YES}.</li>
     *     <li>Поля с {@code @ToString(Mode.NO)} исключаются.</li>
     * </ul>
     *
     * @param obj объект, для которого формируется строковое представление
     * @return строковое представление объекта с учётом аннотации {@link ToString}
     */
    public static String buildString(Object obj) {
        Class<?> clas = obj.getClass();

        if (!clas.isAnnotationPresent(ToString.class) ||
                clas.getAnnotation(ToString.class).value() == Mode.NO) {
            return "Аннотация @ToString отсутствует";
        }

        StringBuilder result = new StringBuilder();
        result.append(clas.getSimpleName()).append(" { ");

        Field[] fields = clas.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            Mode mode = Mode.YES;

            if (field.isAnnotationPresent(ToString.class)) {
                mode = field.getAnnotation(ToString.class).value();
            }

            if (mode == Mode.YES) {
                try {
                    result.append(field.getName()).append("=").append(field.get(obj)).append(", ");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        if (result.lastIndexOf(", ") == result.length() - 2) {
            result.delete(result.length() - 2, result.length());
        }
        result.append(" }");

        return result.toString();
    }
}