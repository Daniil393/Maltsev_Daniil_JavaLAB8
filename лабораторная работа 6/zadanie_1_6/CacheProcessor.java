package zadanie_1_6;

/**
 * Класс {@code CacheProcessor} предназначен для обработки аннотации {@link Cache}.
 * <p>
 * Основная задача класса — проверить, присутствует ли аннотация {@code @Cache} на указанном классе,
 * и вывести список строк, указанных в свойстве {@code value} аннотации.
 */
public class CacheProcessor {

    /**
     * Обрабатывает аннотацию {@link Cache} у указанного класса.
     * <p>
     * Если аннотация присутствует, выводит список кешируемых областей,
     * указанных в свойстве {@code value}. Если массив пуст, выводится сообщение об этом.
     * Если аннотация отсутствует, выводится соответствующее сообщение.
     *
     * @param clas класс для проверки аннотации @Cache
     */
    public static void process(Class<?> clas) {

        if (!clas.isAnnotationPresent(Cache.class)) {
            System.out.println("Аннотация @Cache отсутствует");
            return;
        }

        Cache cache = clas.getAnnotation(Cache.class);

        String[] areas = cache.value();

        if (areas.length == 0) {
            System.out.println("Список кешируемых областей пуст");
        }
        else {
            System.out.println("Кешируемые области:");
            for (String area : areas) {
                System.out.println(" - " + area);
            }
        }
    }
}