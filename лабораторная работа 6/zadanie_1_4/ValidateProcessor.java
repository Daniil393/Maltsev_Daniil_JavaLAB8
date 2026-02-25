package zadanie_1_4;

/**
 * Класс-обработчик пользовательской аннотации {@link Validate}.
 * <p>
 * Позволяет получить список классов, указанных в аннотации
 * {@code @Validate}, и вывести их в консоль.
 */
public class ValidateProcessor {

    /**
     * Обрабатывает переданный класс и проверяет наличие
     * аннотации {@link Validate}.
     * <p>
     * Если аннотация присутствует, метод:
     *     Получает её экземпляр;
     *     Извлекает массив классов из параметра {@code value};
     *     Выводит имена указанных классов в консоль.
     * <p>
     * Если аннотация отсутствует, выводится соответствующее сообщение.
     *
     * @param clas объект {@link Class}, который необходимо проверить
     */
    public static void process(Class<?> clas) {
        if (!clas.isAnnotationPresent(Validate.class)) {
            System.out.println("Аннотация @Validate отсутствует");
            return;
        }

        Validate validate = clas.getAnnotation(Validate.class);

        Class<?>[] classes = validate.value();

        System.out.println("Классы, указанные в @Validate: ");

        for (Class<?> c : classes) {
            System.out.println(" - " + c.getName());
        }
    }
}