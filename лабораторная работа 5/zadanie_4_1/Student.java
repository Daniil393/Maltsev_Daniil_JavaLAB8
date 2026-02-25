package zadanie_4_1;

/**
 * Класс, представляющий студента с именем и фамилией.
 * <p>
 * Содержит методы для получения имени и фамилии, а также строковое представление.
 */
public class Student {

    /** Имя студента */
    private String firstName;

    /** Фамилия студента */
    private String lastName;

    /**
     * Создает объект Student с указанными именем и фамилией.
     *
     * @param firstName имя студента
     * @param lastName фамилия студента
     */
    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Возвращает имя студента.
     *
     * @return имя
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Возвращает фамилию студента.
     *
     * @return фамилия
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Возвращает строковое представление студента.
     * <p>
     * Формат: "Фамилия Имя".
     *
     * @return строковое представление студента
     */
    @Override
    public String toString() {
        return lastName + " " + firstName;
    }
}