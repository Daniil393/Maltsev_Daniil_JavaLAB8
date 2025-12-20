package zadanie_4_1;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class StudentFileReader {

    private String filePath;

    public StudentFileReader(String filePath) {
        this.filePath = filePath;
    }

    public List<Student> readStudents() {

        List<Student> list = new ArrayList<>();

        // BufferedReader - класс, который читает текст из символьного потока ввода, буферизируя символы
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();

            // \\d - означает одна цифра (0-9); + - один или более
            if (line == null || !line.matches("\\d+"))
                throw new IllegalArgumentException("Первая строка должна содержать число учеников");

            // Преобразование строки в число
            int n = Integer.parseInt(line.trim());
            if (n < 0 || n > 100)
                throw new IllegalArgumentException("Количество учеников должно быть от 0 до 100");

            // чтение n строк с фамилиями и именами
            // Проверяется: строка существует, содержит хотя бы один пробел ("Фамилия Имя")
            for (int i = 0; i < n; i++) {
                line = br.readLine();
                if (line == null || !line.contains(" "))
                    throw new IllegalArgumentException("Некорректная строка: " + line);

                // split("\\s+") - разделяет строку по одному или нескольким пробелам
                // \\s - любой пробельный символ (пробел, табуляция и т. д.); + - один или более
                String[] parts = line.trim().split("\\s+");

                // Если имя или фамилия отсутствуют - ошибка
                if (parts.length != 2)
                    throw new IllegalArgumentException("Формат строки должен быть: Фамилия Имя");

                // Добавление нового студента в список
                list.add(new Student(parts[1], parts[0]));
            }

            // Если файл не найден, недоступен или повреждён - выдаётся исключение
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла: " + e.getMessage());
        }
        return list;
    }

    @Override
    public String toString() {
        return "zadanie_4_1.StudentFileReader reading from " + filePath;
    }
}