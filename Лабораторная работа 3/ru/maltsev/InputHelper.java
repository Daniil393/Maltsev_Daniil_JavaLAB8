package ru.maltsev;

import java.util.Scanner;

public class InputHelper {

    public static String readNumberString(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();

            try {
                Integer.parseInt(input);
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число.");
            }
        }
    }
}