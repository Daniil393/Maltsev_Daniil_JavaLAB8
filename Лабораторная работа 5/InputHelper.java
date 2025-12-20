import java.util.Scanner;

// Класс для безопасного ввода данных
public class InputHelper {

    // проверка на целое число
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

    public static String ReadString(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            if (!input.isEmpty()) { return input; }
            else { System.out.println("Ошибка: строка не может быть пустой"); }
        }
    }
}