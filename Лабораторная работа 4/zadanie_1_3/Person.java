package zadanie_1_3;

/**
 * Класс {@code Person} представляет человека с именем, возрастом и городом проживания.
 * <p>
 * Реализует интерфейс {@link Сравнимое}, сравнивая людей по возрасту.
 */
public class Person implements Сравнимое<Person> {

    /** Имя человека. */
    private String name;

    /** Возраст человека. */
    private int age;

    /** Город проживания. */
    private String city;

    /**
     * Создаёт человека с пустыми полями и возрастом 0.
     */
    public Person() {
        this.name = "";
        this.age = 0;
        this.city = "";
    }

    /**
     * Создаёт человека с указанными именем, возрастом и городом.
     *
     * @param name имя человека
     * @param age возраст человека
     * @param city город проживания
     */
    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    /**
     * Возвращает имя человека.
     *
     * @return имя
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает имя человека.
     *
     * @param name имя
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Возвращает возраст человека.
     *
     * @return возраст
     */
    public int getAge() {
        return age;
    }

    /**
     * Устанавливает возраст человека.
     *
     * @param age возраст
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Возвращает город проживания человека.
     *
     * @return город
     */
    public String getCity() {
        return city;
    }

    /**
     * Устанавливает город проживания человека.
     *
     * @param city город
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Сравнивает текущего человека с другим человеком по возрасту.
     * <p>
     * Возвращает отрицательное число, если текущий человек младше {@code other},
     * положительное число, если старше, и 0 если возраст одинаковый.
     *
     * @param other другой объект {@code Person} для сравнения
     * @return результат сравнения по возрасту
     */
    @Override
    public int сравнить(Person other) {
        if (this.age < other.age)
            return -1;
        else if (this.age > other.age)
            return 1;
        else
            return 0;
    }

    /**
     * Возвращает строковое представление человека.
     *
     * @return строка формата "Person{name = ..., age = ..., city = ...}"
     */
    @Override
    public String toString() {
        return "Person{name = " + name + ", age = " + age + ", city = " + city + "}";
    }
}
