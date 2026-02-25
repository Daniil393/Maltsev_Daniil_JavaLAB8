package zadanie_5_1;

import java.io.*;
import java.util.*;

/**
 * Класс для извлечения звонких согласных русской азбуки из текстового файла.
 * <p>
 * Звонкие согласные, которые ищет класс: б, в, г, д, ж, з, й, л, м, н, р.
 * Результат хранится в {@link Set} в отсортированном порядке (TreeSet).
 */
public class VoicedConsonantsFromFile {

    /** Множество всех русских звонких согласных */
    private static final Set<Character> voiced = Set.of('б','в','г','д','ж','з','й','л','м','н','р');

    /**
     * Обрабатывает указанный файл и возвращает множество всех встреченных
     * звонких согласных русского алфавита в нижнем регистре.
     *
     * @param filePath путь к текстовому файлу
     * @return множество встреченных звонких согласных, отсортированных по алфавиту
     * @throws RuntimeException если произошла ошибка чтения файла
     */
    public static Set<Character> processFile(String filePath) {

        Set<Character> result = new TreeSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            int ch;
            while ((ch = br.read()) != -1) {
                char c = Character.toLowerCase((char) ch);

                if (isRussianLetter(c) && voiced.contains(c)) {
                    result.add(c);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла: " + e.getMessage());
        }

        return result;
    }

    /**
     * Проверяет, является ли символ русской буквой.
     *
     * @param c символ для проверки
     * @return {@code true}, если символ русская буква, иначе {@code false}
     */
    private static boolean isRussianLetter(char c) {
        return (c >= 'а' && c <= 'я') || c == 'ё';
    }
}