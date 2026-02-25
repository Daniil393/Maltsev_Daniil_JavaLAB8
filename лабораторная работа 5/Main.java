import zadanie_1_1.*;
import zadanie_2_1.*;
import zadanie_3_1.*;
import zadanie_4_1.*;
import zadanie_5_1.*;
import zadanie_6_5.*;
import zadanie_7_1.*;
import zadanie_7_2.*;

import java.util.*;

/**
 * Главный класс приложения для демонстрации лабораторной работы 5.
 * <p>
 * Программа предоставляет интерактивное консольное меню с выбором различных заданий:
 *     Работа с дробями {@link zadanie_1_1.Fraction}
 *     Структурные шаблоны: подсчет мяуканий {@link zadanie_2_1.Cat}
 *     Удаление элементов из списка {@link zadanie_3_1.ListProcessor}
 *     Формирование и печать уникального логина для студента {@link zadanie_4_1.LoginGenerator}
 *     Работа с текстовым файлом и множеством {@link zadanie_5_1.VoicedConsonantsFromFile}
 *     Перенос элементов из одной очереди в другую в обратном порядке {@link zadanie_6_5.QueueReverser}
 *     Построение полилинии из точек с использованием Stream API {@link zadanie_7_1.Polyline}
 *     Обработка текстового файла с именами и номерами людей {@link zadanie_7_2.PeopleFileProcessor}
 * <p>
 * Меню работает в цикле до выбора выхода (опция 0). Все вводимые значения проверяются на корректность
 * с использованием {@link InputHelper}.
 * <p>
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
            System.out.println("\n=== Лабораторная работа 5 ===");
            System.out.println("1 - Шаблоны. Класс дробь");
            System.out.println("2 - Структурные шаблоны. Количество мяуканий");
            System.out.println("3 - Удаление элементов из списка");
            System.out.println("4 - Формирование и печать уникального логина для студента");
            System.out.println("5 - Сет. Работа с файлом");
            System.out.println("6 - элементы из очереди L1 в очередь L2 в обратном порядке");
            System.out.println("7 - Стрим. Точки на координатной плоскости");
            System.out.println("8 - Работа с текстовым файлом. Имя и номер человека");
            System.out.println("0 - Выход");
            System.out.print("Ваш выбор: ");

            String choice = sc.nextLine();

            switch (choice) {

                case "1":
                    System.out.println("\n=== Работа с дробью ===");

                    int numerator1 = InputHelper.ReadInt(sc, "Введите числитель первой дроби: ");
                    int denominator1 = InputHelper.ReadInt(sc, "Введите знаменатель первой дроби: ");
                    int numerator2 = InputHelper.ReadInt(sc, "Введите числитель второй дроби: ");
                    int denominator2 = InputHelper.ReadInt(sc, "Введите знаменатель второй дроби: ");

                    Fraction fraction1 = new Fraction(numerator1, denominator1);
                    Fraction fraction2 = new Fraction(numerator2, denominator2);

                    System.out.println("\nСозданная первая дробь: " + fraction1);
                    System.out.println("Вещественное значение: " + fraction1.getValue());
                    System.out.println("\nСозданная вторая дробь: " + fraction2);
                    System.out.println("Вещественное значение: " + fraction2.getValue());

                    while (true) {

                        System.out.println("\nВыберите действие: ");
                        System.out.println("1 - Изменить дробь(-и)");
                        System.out.println("2 - Сравнить дроби");
                        System.out.println("0 - Назад в главное меню");
                        System.out.print("Ваш выбор: ");

                        String subChoice1 = sc.nextLine();

                        switch (subChoice1){

                            case "1":

                                while (true) {

                                    System.out.println("\nКакую дробь изменить?");
                                    System.out.println("1 - первую дробь");
                                    System.out.println("2 - вторую дробь");
                                    System.out.println("3 - обе дроби");
                                    System.out.println("0 - вернуться назад");

                                    String subChoice2 = sc.nextLine();

                                    switch (subChoice2) {

                                        case "1":

                                            System.out.println("\n=== Изменение дробей ===");

                                            System.out.println("\nИзменение первой дроби: ");
                                            int newNumerator1 = InputHelper.ReadInt(sc, "Введите новый числитель: ");
                                            int newDenominator1 = InputHelper.ReadInt(sc, "Введите новый знаменатель: ");
                                            fraction1.setNumerator(newNumerator1);
                                            fraction1.setDenominator(newDenominator1);
                                            System.out.println("Измененная дробь: " + fraction1);

                                            break;

                                        case "2":

                                            System.out.println("\n=== Изменение дробей ===");

                                            System.out.println("\nИзменение второй дроби: ");
                                            int newNumerator2 = InputHelper.ReadInt(sc, "Введите новый числитель: ");
                                            int newDenominator2 = InputHelper.ReadInt(sc, "Введите новый знаменатель: ");
                                            fraction2.setNumerator(newNumerator2);
                                            fraction2.setDenominator(newDenominator2);
                                            System.out.println("Измененная дробь: " + fraction2);

                                            break;

                                        case "3":

                                            System.out.println("\n=== Изменение дробей ===");

                                            System.out.println("\nИзменение первой дроби: ");
                                            int newNumerator3 = InputHelper.ReadInt(sc, "Введите новый числитель: ");
                                            int newDenominator3 = InputHelper.ReadInt(sc, "Введите новый знаменатель: ");
                                            fraction1.setNumerator(newNumerator3);
                                            fraction1.setDenominator(newDenominator3);

                                            System.out.println("\nИзменение второй дроби: ");
                                            int newNumerator4 = InputHelper.ReadInt(sc, "Введите новый числитель: ");
                                            int newDenominator4 = InputHelper.ReadInt(sc, "Введите новый знаменатель: ");
                                            fraction2.setNumerator(newNumerator4);
                                            fraction2.setDenominator(newDenominator4);

                                            System.out.println("Измененные дроби: " + fraction1 + " и " + fraction2);

                                            break;

                                        case "0":
                                            System.out.println("Возвращение в меню");
                                            break;

                                        default:
                                            System.out.println("Ошибка: выберите пункт из меню (0-3) ");
                                    }
                                    if (subChoice2.equals("0")) break;
                                }
                                break;

                            case "2":

                                System.out.println("\n=== Сравнение дробей ===");
                                System.out.println("Первая дробь: " + fraction1);
                                System.out.println("Вторая дробь: " + fraction2);

                                if (fraction1.equals(fraction2))
                                    System.out.println("Дроби равны");
                                else
                                    System.out.println("Дроби не равны");

                                break;

                            case "0":
                                System.out.println("Возвращение в меню");
                                break;

                            default:
                                System.out.println("Ошибка: выберите пункт из меню (0-2) ");
                        }
                        if (subChoice1.equals("0")) break;
                    }
                    break;

                case "2":

                    String catName = InputHelper.ReadString(sc, "Введите кличку кота: ");
                    Cat cat = new Cat(catName);

                    System.out.println("\nСоздан - " + cat);

                    while (true) {

                        System.out.println("\nВыберите действие: ");
                        System.out.println("1 - Кот мяукает один раз");
                        System.out.println("2 - Кот мяукает несколько раз");
                        System.out.println("3 - Проверить количество мяуканий");
                        System.out.println("0 - Назад в меню");
                        System.out.println("Ваш выбор: ");

                        String choice1 = sc.nextLine();

                        switch (choice1) {

                            case "1":

                                System.out.println("\nКот/кошка мяукнул(-а) один раз");
                                cat.meow();
                                break;

                            case "2":

                                int times = InputHelper.ReadInt(sc, "Сколько раз мяукнуть?");
                                cat.meow(times);
                                System.out.println("\n--- Множественное мяу ---");
                                break;

                            case "3":

                                int count = cat.getMeowCount();
                                String form = MeowUtils.declension(count);
                                System.out.println(cat + " мяукнул(-а) " + count + " " + form);
                                break;

                            case "0":
                                System.out.println("Возвращение в главное меню...");
                                break;

                            default:
                                System.out.println("Ошибка: выберите пункт (0-3)");
                                break;
                        }
                        if (choice1.equals("0")) break;
                    }
                    break;

                case "3":

                    System.out.println("\n=== Удаление всех элементов E из списка L ===");

                    int listSize = InputHelper.ReadInt(sc, "Введите размер списка L");

                    while (listSize <= 0) {
                        System.out.println("Ошибка: размер списка должен быть больше нуля");
                        listSize = InputHelper.ReadInt(sc, "Введите размер списка L");
                    }

                    List<Integer> L = new ArrayList<>();

                    for (int i = 0; i < listSize; i++) {
                        int value = InputHelper.ReadInt(sc, "Введите элемент L[" + i + "]: ");
                        L.add(value);
                    }

                    System.out.println("\nВведите количество элементов E, которые нужно удалить: ");
                    int eCount = InputHelper.ReadInt(sc, "Количество элементов для удаления: ");

                    while (eCount <= 0) {
                        System.out.println("Ошибка: должно быть хотя бы одно значение E");
                        eCount = InputHelper.ReadInt(sc, "Количество элементов E: ");
                    }

                    List<Integer> E = new ArrayList<>();

                    for (int i = 0; i < eCount; i++) {
                        int value1 = InputHelper.ReadInt(sc, "Введите значение E[" + i + "]: ");
                        E.add(value1);
                    }

                    System.out.println("\nИсходный список L: " + L);
                    System.out.println("Элементы E для удаления: " + E);

                    ElementList elementList = new ElementList(L);

                    for (Integer value : E) {
                        Element element = new Element(value);
                        ListProcessor processor = new ListProcessor(elementList, element);
                        processor.removeElement();
                    }

                    System.out.println("\nРезультат после удаления всех E: " + elementList.getList());

                    break;

                case "4":

                    System.out.println("\n=== Генерация логинов для студентов ===");

                    String filePath = InputHelper.ReadString(sc, "Введите путь к файлу с именами и фамилиями студентов: ");

                    try {
                        StudentFileReader reader = new StudentFileReader(filePath);

                        List<Student> students = reader.readStudents();

                        System.out.println("\nСчитаные студенты: ");
                        for (Student s : students)
                            System.out.println(" - " + s);

                        LoginGenerator generator = new LoginGenerator();

                        System.out.println("\nСформированные логины: ");
                        for (Student s : students) {
                            String login = generator.generateLogin(s);
                            System.out.println(s + " -> " + login);
                        }

                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }

                    break;

                case "5":
                    System.out.println("\n=== Сет. Работа с файлом ===");

                    String path = InputHelper.ReadString(sc, "Введите путь к текстовому файлу: ");

                    try {
                        Set<Character> result = VoicedConsonantsFromFile.processFile(path);

                        if (result.isEmpty()) {
                            System.out.println("Звонкие согласные буквы не найдены.");
                        } else {
                            System.out.println("Звонкие согласные буквы (в алфавитном порядке):");
                            for (char c : result) {
                                System.out.print(c + " ");
                            }
                            System.out.println();
                        }

                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }

                    break;

                case "6":

                    System.out.println("\n=== Очередь наоборот ===");

                    // Ввод исходной очереди L1
                    int queueSize1 = InputHelper.ReadInt(sc, "Введите размер очереди L1: ");
                    while (queueSize1 <= 0) {
                        System.out.println("Ошибка: размер очереди должен быть больше нуля");
                        queueSize1 = InputHelper.ReadInt(sc, "Введите размер очереди L1: ");
                    }

                    Queue<Integer> L1 = new LinkedList<>();
                    for (int i = 0; i < queueSize1; i++) {
                        int value = InputHelper.ReadInt(sc, "Введите элемент L1[" + i + "]: ");
                        L1.offer(value);
                    }

                    int queueSize2 = InputHelper.ReadInt(sc, "Введите размер очереди L2 (0, если пустая): ");
                    while (queueSize2 < 0) {
                        System.out.println("Ошибка: размер очереди не может быть отрицательным");
                        queueSize2 = InputHelper.ReadInt(sc, "Введите размер очереди L2 (0, если пустая): ");
                    }

                    Queue<Integer> L2 = new LinkedList<>();
                    for (int i = 0; i < queueSize2; i++) {
                        int value = InputHelper.ReadInt(sc, "Введите элемент L2[" + i + "]: ");
                        L2.offer(value);
                    }

                    System.out.println("\nИсходная очередь L1: " + L1);
                    System.out.println("Очередь L2 до добавления перевернутой L1: " + L2);

                    QueueReverser.reverseQueueToAnother(L1, L2);

                    System.out.println("Очередь L2 после добавления элементов из L1 в обратном порядке: " + L2);

                    break;

                case "7":

                    System.out.println("\n=== Stream. Point -> Polyline ===");

                    int n = InputHelper.ReadInt(sc, "Введите количество точек: ");
                    while (n <= 0) {
                        System.out.println("Ошибка: количество должно быть > 0");
                        n = InputHelper.ReadInt(sc, "Введите количество точек: ");
                    }

                    List<Point> points = new ArrayList<>();

                    for (int i = 0; i < n; i++) {
                        double x = InputHelper.ReadDouble(sc, "Введите X для точки " + (i + 1) + ": ");
                        double y = InputHelper.ReadDouble(sc, "Введите Y для точки " + (i + 1) + ": ");
                        points.add(new Point(x, y));
                    }

                    System.out.println("\nИсходные точки:");
                    points.forEach(System.out::println);

                    Polyline polyline = new Polyline();

                    points.stream().distinct().sorted(Comparator.comparing(Point::getX))
                            .map(p -> new Point(p.getX(), Math.abs(p.getY()))).forEach(polyline::addPoint);

                    System.out.println("\nРезультат:");
                    System.out.println(polyline);

                    break;

                case "8":

                    System.out.println("\n=== Работа с текстовым файлом. Имя и номер человека ===");

                    String peopleFilePath = InputHelper.ReadString(
                            sc, "Введите путь к файлу с данными людей: "
                    );

                    try {
                        Map<Integer, List<String>> result =
                                PeopleFileProcessor.processFile(peopleFilePath);

                        if (result.isEmpty()) {
                            System.out.println("Данные не найдены или все строки без номеров.");
                        } else {
                            System.out.println("\nРезультат группировки:");
                            for (Map.Entry<Integer, List<String>> entry : result.entrySet()) {
                                System.out.println(entry.getKey() + " : " + entry.getValue());
                            }
                        }

                    } catch (Exception e) {
                        System.out.println("Ошибка при обработке файла: " + e.getMessage());
                    }

                    break;

                case "0":
                    System.out.println("Выход из программы");
                    sc.close();
                    return;

                default:
                    System.out.println("Ошибка: выберите пункт из меню (0-8) ");
            }
        }
    }
}