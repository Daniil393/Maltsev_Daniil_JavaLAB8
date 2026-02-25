package zadanie_4_1;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

/**
 * Класс для чтения списка студентов из текстового файла.
 * <p>
 * Формат файла:
 *     Первая строка — количество студентов (целое число от 0 до 100)
 *     Каждая следующая строка — студент в формате: "Фамилия Имя"
 * При нарушении формата выбрасывается {@link IllegalArgumentException}.
 */
public class StudentFileReader {

    /** Путь к файлу для чтения */
    private String filePath;

    /**
     * Создает объект StudentFileReader для указанного файла.
     *
     * @param filePath путь к файлу с данными студентов
     */
    public StudentFileReader(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Считывает студентов из файла и возвращает список объектов {@link Student}.
     *
     * @return список студентов
     * @throws IllegalArgumentException если файл имеет неправильный формат
     * @throws RuntimeException если произошла ошибка ввода-вывода
     */
    public List<Student> readStudents() {

        List<Student> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();

            if (line == null || !line.matches("\\d+"))
                throw new IllegalArgumentException("Первая строка должна содержать число учеников");

            int n = Integer.parseInt(line.trim());
            if (n < 0 || n > 100)
                throw new IllegalArgumentException("Количество учеников должно быть от 0 до 100");

            for (int i = 0; i < n; i++) {
                line = br.readLine();
                if (line == null || !line.contains(" "))
                    throw new IllegalArgumentException("Некорректная строка: " + line);

                String[] parts = line.trim().split("\\s+");

                if (parts.length != 2)
                    throw new IllegalArgumentException("Формат строки должен быть: Фамилия Имя");

                list.add(new Student(parts[1], parts[0]));
            }

        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла: " + e.getMessage());
        }
        return list;
    }

    /**
     * Возвращает строковое представление объекта StudentFileReader.
     * <p>
     * Формат: "StudentFileReader reading from {filePath}".
     *
     * @return строковое представление объекта
     */
    @Override
    public String toString() {
        return "StudentFileReader reading from " + filePath;
    }
}