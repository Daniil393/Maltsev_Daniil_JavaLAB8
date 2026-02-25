package zadanie_1_2;

import java.lang.reflect.Field;

/**
 * Класс для обработки пользовательской аннотации {@link Default}.
 * <p>
 * Позволяет определить, к какому типу по умолчанию относится класс
 * или его поля, аннотированные {@code @Default}.
 */
public class DefaultProcessor {

    /**
     * Обрабатывает указанный класс, проверяя наличие аннотации {@link Default}.
     *     Если аннотация присутствует на классе, выводит тип по умолчанию для класса.
     *     Если аннотация присутствует на полях класса, выводит типы по умолчанию для этих полей.
     *     Если аннотация отсутствует ни на классе, ни на полях, выводит соответствующее сообщение.
     *
     * @param clas объект {@link Class}, который необходимо обработать
     */
    public static void process(Class<?> clas) {
        boolean found = false;

        // Проверка аннотации на самом классе
        if (clas.isAnnotationPresent(Default.class)) {
            Default annotation = clas.getAnnotation(Default.class);
            System.out.println("Аннотация на классе:");
            System.out.println("Тип по умолчанию: " + annotation.value().getName());
            found = true;
        }

        // Проверка аннотаций на полях
        for (Field field : clas.getDeclaredFields()) {
            if (field.isAnnotationPresent(Default.class)) {
                Default annotation = field.getAnnotation(Default.class);
                System.out.println("Аннотация на поле: " + field.getName());
                System.out.println("Тип по умолчанию: " + annotation.value().getName());
                found = true;
            }
        }

        if (!found) {
            System.out.println("Аннотация @Default не найдена.");
        }
    }
}