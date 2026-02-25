import zadanie_1_1.*;
import zadanie_1_2.*;
import zadanie_1_3.*;
import zadanie_1_4.*;
import zadanie_1_5.*;
import zadanie_1_6.*;

import java.util.*;

/**
 * Основной класс для демонстрации работы с пользовательскими аннотациями.
 * <p>
 * Предоставляет текстовое меню для запуска обработки различных аннотаций:
 * <ul>
 *     <li>1 - {@link Invoke}</li>
 *     <li>2 - {@link Default}</li>
 *     <li>3 - {@link ToString}</li>
 *     <li>4 - {@link Validate}</li>
 *     <li>5 - {@link Two}</li>
 *     <li>6 - {@link Cache}</li>
 * </ul>
 * <p>
 * Каждый пункт вызывает соответствующий процессор, который демонстрирует
 * работу аннотаций на примерах тестовых классов.
 */
public class Main {

    /**
     * Главный метод программы.
     * <p>
     * Реализует интерактивное консольное меню с выбором различных лабораторных заданий.
     * Включает обработку пользовательского ввода, создание объектов и вызов соответствующих методов.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Лабораторная работа 6 ===");
            System.out.println("1 - Invoke");
            System.out.println("2 - Default");
            System.out.println("3 - ToString");
            System.out.println("4 - Validate");
            System.out.println("5 - Two");
            System.out.println("6 - Cache");
            System.out.println("0 - Выход");
            System.out.print("Ваш выбор: ");

            String choice = sc.nextLine();

            switch (choice) {

                case "1":
                    System.out.println("\nЗапуск обработки Invoke\n");

                    TestClass testObject = new TestClass();
                    InvokeProcessor.process(testObject);

                    break;

                case "2":
                    System.out.println("\nЗапуск обработки Default\n");

                    DefaultProcessor.process(TestClass2.class);

                    break;

                case "3":
                    System.out.println("\nЗапуск обработки ToString\n");

                    Person person = new Person("Arthur", 25, "12345");

                    String result = ToStringProcessor.buildString(person);
                    System.out.println(result);

                    break;

                case "4":
                    System.out.println("\nЗапуск обработки Validate\n");
                    ValidateProcessor.process(TestClass3.class);

                    break;

                case "5":
                    System.out.println("\nЗапуск обработки Two\n");

                    TwoProcessor.process(TestClass4.class);

                    break;

                case "6":
                    System.out.println("\nЗапуск обработки Cache\n");

                    System.out.println("TestClass5:");
                    CacheProcessor.process(TestClass5.class);

                    System.out.println();

                    System.out.println("TestClass6:");
                    CacheProcessor.process(TestClass6.class);

                    break;

                case "0":
                    System.out.println("Выход из программы");
                    sc.close();
                    return;

                default:
                    System.out.println("Ошибка: выберите пункт из меню (0-6) ");
            }
        }
    }
}
