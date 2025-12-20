package zadanie_4_1;

import java.util.HashMap;
import java.util.Map;

public class LoginGenerator {

    private Map<String, Integer> LastNameCount = new HashMap<>();

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

    @Override
    public String toString() {
        return "zadanie_4_1.LoginGenerator: " + LastNameCount.toString();
    }
}