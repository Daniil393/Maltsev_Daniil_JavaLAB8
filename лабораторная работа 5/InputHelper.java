import java.util.Scanner;

/**
 * Утилитный класс для безопасного ввода данных с консоли.
 * <p>
 * Содержит методы для ввода целых чисел, вещественных чисел и строк с проверкой корректности.
 */
public class InputHelper {

    /**
     * Считывает целое число с консоли с повторным запросом при ошибке.
     *
     * @param sc {@link Scanner} для чтения данных
     * @param prompt сообщение для пользователя
     * @return введенное целое число
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
     * Считывает вещественное число с консоли с повторным запросом при ошибке.
     *
     * @param sc {@link Scanner} для чтения данных
     * @param prompt сообщение для пользователя
     * @return введенное число типа {@code double}
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
     * Считывает непустую строку с консоли.
     * <p>
     * Повторяет запрос, пока пользователь не введет непустую строку.
     *
     * @param sc {@link Scanner} для чтения данных
     * @param prompt сообщение для пользователя
     * @return введенная непустая строка
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