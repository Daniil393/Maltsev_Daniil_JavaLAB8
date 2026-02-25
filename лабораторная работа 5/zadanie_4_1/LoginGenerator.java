package zadanie_4_1;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс для генерации логинов студентов на основе их фамилий.
 * <p>
 * Если фамилия встречается впервые, логин равен самой фамилии.
 * Если фамилия повторяется, к фамилии добавляется порядковый номер.
 */
public class LoginGenerator {

    /** Словарь для отслеживания количества студентов с одинаковой фамилией */
    private Map<String, Integer> LastNameCount = new HashMap<>();

    /**
     * Генерирует логин для указанного студента на основе его фамилии.
     *
     * @param student объект студента
     * @return сгенерированный логин
     */
    public String generateLogin(Student student) {
        String ln = student.getLastName();

        // Проверяет, есть ли такая фамилия в словаре. Если есть - берёт её текущее количество. Если нет - возвращает 0
        int count = LastNameCount.getOrDefault(ln, 0) + 1;
        LastNameCount.put(ln, count);

        if (count == 1)
            return ln;
        else
            return ln + count;
    }

    /**
     * Возвращает строковое представление объекта LoginGenerator.
     * <p>
     * Формат: "LoginGenerator: {LastNameCount}".
     *
     * @return строковое представление генератора логинов
     */
    @Override
    public String toString() {
        return "LoginGenerator: " + LastNameCount.toString();
    }
}