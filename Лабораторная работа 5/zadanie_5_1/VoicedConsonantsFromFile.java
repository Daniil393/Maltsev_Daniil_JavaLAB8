package zadanie_5_1;

import java.io.*;
import java.util.*;

public class VoicedConsonantsFromFile {

    private static final Set<Character> voiced = Set.of('б','в','г','д','ж','з','й','л','м','н','р');

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

    private static boolean isRussianLetter(char c) {
        return (c >= 'а' && c <= 'я') || c == 'ё';
    }
}