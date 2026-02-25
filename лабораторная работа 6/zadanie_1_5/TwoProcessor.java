package zadanie_1_5;

/**
 * Обработчик для аннотации {@link Two}.
 * <p>
 * Класс предоставляет метод для чтения и вывода значений свойств {@code first} и {@code second}
 * из аннотации {@link Two}, если она присутствует на указанном классе.
 */
public class TwoProcessor {

    /**
     * Считывает и выводит значения аннотации {@link Two} для переданного класса.
     *
     * @param clas класс, который может быть аннотирован {@link Two}
     * @throws NullPointerException если переданный класс равен {@code null}
     */
    public static void process(Class<?> clas) {

        if (!clas.isAnnotationPresent(Two.class)) {
            System.out.println("Аннотация @Two отсутствует");
            return;
        }

        Two two = clas.getAnnotation(Two.class);

        String firstValue = two.first();
        int secondValue = two.second();

        System.out.println("Значения аннотации @Two: ");
        System.out.println("first = " + firstValue);
        System.out.println("second = " + secondValue);
    }
}