package zadanie_7_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Класс для обработки текстового файла со строками вида "Имя:Номер".
 * <p>
 * Задача класса:
 *     Прочитать все строки из файла
 *     Удалить записи без номера
 *     Привести имена к виду с первой заглавной буквой и остальными строчными
 *     Сгруппировать имена по их номеру
 * <p>
 * Результатом является {@link Map}, где ключ — номер (Integer), а значение — список имен.
 */
public class PeopleFileProcessor {

    /**
     * Обрабатывает указанный файл и возвращает карту "номер → список имен".
     * <p>
     * Игнорируются пустые строки и записи без номера.
     * Имена приводятся к капитализированному виду (первая буква заглавная).
     *
     * @param filePath путь к текстовому файлу
     * @return {@link Map} с номерами и списками имен
     * @throws IOException если произошла ошибка чтения файла
     */
    public static Map<Integer, List<String>> processFile(String filePath) throws IOException {

        return Files.lines(Path.of(filePath)).map(String::trim).filter(line -> !line.isEmpty())
                .map(line -> line.split(":")).filter(parts ->
                        parts.length == 2 && !parts[1].isEmpty())
                .collect(Collectors.groupingBy(parts -> Integer.parseInt(parts[1]),
                        Collectors.mapping(parts -> capitalize(parts[0]), Collectors.toList())));
    }

    /**
     * Приводит строку к виду с первой заглавной буквой и остальными строчными.
     *
     * @param name имя для капитализации
     * @return имя с первой заглавной буквой
     */
    private static String capitalize(String name) {
        if (name.isEmpty()) return name;
        name = name.toLowerCase();
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }
}