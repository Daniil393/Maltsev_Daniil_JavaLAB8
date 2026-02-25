import java.util.Scanner;

/**
 * Утилитный класс для безопасного чтения данных с консоли.
 * <p>
 * Поддерживает ввод целых чисел, вещественных чисел и строк с проверкой корректности ввода.
 */
public class InputHelper {

    /**
     * Считывает целое число с консоли с повторным запросом при некорректном вводе.
     *
     * @param sc объект {@link Scanner} для чтения ввода
     * @param prompt строка для пользователя
     * @return введённое целое число
     */
    public static int ReadInt(Scanner sc, String prompt) {
        int number;
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                number = sc.nextInt();
                sc.nextLine();
                return number;
            }

            else {
                System.out.println("Ошибка: введите целое число.");
                sc.nextLine();
            }
        }
    }

    /**
     * Считывает число с плавающей запятой (double) с консоли с повторным запросом при некорректном вводе.
     *
     * @param sc объект {@link Scanner} для чтения ввода
     * @param prompt строка для пользователя
     * @return введённое число типа double
     */
    public static double ReadDouble(Scanner sc, String prompt) {
        double number;
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                number = sc.nextDouble();
                sc.nextLine();
                return number;
            }

            else {
                System.out.println("Ошибка: введите целое или вещественное число.");
                sc.nextLine();
            }
        }
    }

    /**
     * Считывает непустую строку с консоли с повторным запросом при пустом вводе.
     *
     * @param sc объект {@link Scanner} для чтения ввода
     * @param prompt строка для пользователя
     * @return введённая непустая строка
     */
    public static String ReadString(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            if (!input.isEmpty()) { return input; }
            else { System.out.println("Ошибка: строка не может быть пустой"); }
        }
    }
}
