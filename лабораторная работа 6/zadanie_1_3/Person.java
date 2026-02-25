package zadanie_1_3;

/**
 * Класс, демонстрирующий использование пользовательской аннотации {@link ToString}.
 */
@ToString
public class Person {

    /**
     * Имя человека.
     * По умолчанию включается в строковое представление.
     */
    private String name;

    /**
     * Возраст человека.
     * По умолчанию включается в строковое представление.
     */
    private int age;

    /**
     * Пароль пользователя.
     * Исключается из строкового представления,
     * так как помечен {@code @ToString(Mode.NO)}.
     */
    @ToString(Mode.NO)
    private String password;

    /**
     * Конструктор для создания объекта {@code Person}.
     *
     * @param name имя человека
     * @param age возраст
     * @param password пароль
     */
    public Person(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }
}