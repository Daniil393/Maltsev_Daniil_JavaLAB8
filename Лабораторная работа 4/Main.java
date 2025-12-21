import zadanie_1_1.*;
import zadanie_1_3.*;
import zadanie_2_2.*;
import zadanie_3.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InputHelper inputHelper = new InputHelper();

        while (true) {
            System.out.println("\n=== Лабораторная работа 4 ===");
            System.out.println("1 - Обобщенная коробка");
            System.out.println("2 - Сравнимое");
            System.out.println("3 - Поиск максимума из коробок");
            System.out.println("4 - Обобщенные методы, автовывод типа. Функция");
            System.out.println("5 - Обобщенные методы, автовывод типа. Фильтр");
            System.out.println("6 - Обобщенные методы, автовывод типа. Сокращение");
            System.out.println("7 - Обобщенные методы, автовывод типа. Коллекционирование");
            System.out.println("0 - Выход");
            System.out.print("Ваш выбор: ");

            String choice = sc.nextLine();

            switch (choice) {

                case "1":
                    Box<Integer> intBox = new Box<>();

                    while (true) {

                        System.out.println("\nВыберите действие: ");
                        System.out.println("1 - Поместить число в коробку");
                        System.out.println("2 - Извлечь число из коробки");
                        System.out.println("3 - Посмотреть содержимое коробки без извлечения");
                        System.out.println("4 - Проверить, полна ли коробка");
                        System.out.println("5 - Очистить коробку");
                        System.out.println("6 - Использовать processBox");
                        System.out.println("0 - Вернуться назад");
                        System.out.print("Ваш выбор: ");

                        String subChoice1 = sc.nextLine();

                        try {
                            switch (subChoice1) {

                                case "1":
                                    int number = InputHelper.ReadInt(sc, "Введите число: ");
                                    intBox.put(number);
                                    System.out.println("Число помещено в коробку");
                                    break;

                                case "2":
                                    System.out.println("Извлечено значение: " + intBox.get());
                                    break;

                                case "3":
                                    System.out.println("Содержимое коробки: " + intBox.peek());
                                    break;

                                case "4":
                                    System.out.println(intBox.isFull() ? "Коробка полна" : "Коробка пуста");
                                    break;

                                case "5":
                                    intBox.clear();
                                    System.out.println("Коробка очищена");
                                    break;

                                case "6":
                                    intBox.processBox();
                                    break;

                                case "0":
                                    System.out.println("Выход из задания");
                                    break;

                                default:
                                    System.out.println("Ошибка: выберите пункт из меню (0-6) ");
                            }
                        } catch (IllegalStateException e) {
                            System.out.println("Ошибка: " + e.getMessage());
                        }
                        if (subChoice1.equals("0")) break;
                    }
                    break;

                case "2":

                    while (true) {

                        System.out.println("\n--- Сравнимое ---");
                        System.out.println("1 - Сравнить людей (класс Person)");
                        System.out.println("2 - Сравнить книги (класс Book)");
                        System.out.println("0 - Выход из задания");
                        System.out.println("Ваш выбор: ");

                        String subChoice = sc.nextLine();

                        switch (subChoice) {

                            case "1":
                                System.out.println("\nВведите данные для первого человека: ");
                                String name1 = InputHelper.ReadString(sc, "Имя: ");
                                int age1 = InputHelper.ReadInt(sc, "Возраст: ");
                                String city1 = InputHelper.ReadString(sc, "Город: ");
                                Person p1 = new Person(name1, age1, city1);

                                System.out.println("\nВведите данные для второго человека: ");
                                String name2 = InputHelper.ReadString(sc, "Имя: ");
                                int age2 = InputHelper.ReadInt(sc, "Возраст: ");
                                String city2 = InputHelper.ReadString(sc, "Город: ");
                                Person p2 = new Person(name2, age2, city2);

                                System.out.println("\nПервый человек: " + p1);
                                System.out.println("Второй человек: " + p2);

                                int result1 = p1.сравнить(p2);

                                if (result1 == -1) {
                                    System.out.println(p1.getName() + " младше, чем " + p2.getName());
                                } else if (result1 == 1) {
                                    System.out.println(p1.getName() + " старше, чем " + p2.getName());
                                } else {
                                    System.out.println(p1.getName() + " и " + p2.getName() + " - ровесники");
                                }

                                break;

                            case "2":
                                System.out.println("\nВведите данные для первой книги: ");
                                String title1 = InputHelper.ReadString(sc, "Название: ");
                                int year1 = InputHelper.ReadInt(sc, "Год издания: ");
                                String author1 = InputHelper.ReadString(sc, "Автор: ");
                                double price1 = InputHelper.ReadDouble(sc, "Цена: ");
                                Book b1 = new Book(title1, year1, author1, price1);

                                System.out.println("\nВведите данные для второй книги: ");
                                String title2 = InputHelper.ReadString(sc, "Название: ");
                                int year2 = InputHelper.ReadInt(sc, "Год издания: ");
                                String author2 = InputHelper.ReadString(sc, "Автор: ");
                                double price2 = InputHelper.ReadDouble(sc, "Цена: ");
                                Book b2 = new Book(title2, year2, author2, price2);

                                System.out.println("\nПервая книга: " + b1);
                                System.out.println("Вторая книга: " + b2);

                                int result2 = b1.сравнить(b2);

                                if (result2 == -1) {
                                    System.out.println(b1.getTitle() + " дешевле, чем " + b2.getTitle());
                                } else if (result2 == 1) {
                                    System.out.println(b1.getTitle() + " дороже, чем " + b2.getTitle());
                                } else {
                                    System.out.println(b1.getTitle() + " и " + b2.getTitle() + " - стоят одинаково");
                                }

                                break;

                            case "0":
                                System.out.println("Выход из задания");
                                break;

                            default:
                                System.out.println("Ошибка: выберите пункт из меню (0-2) ");
                        }
                        if (subChoice.equals("0")) break;
                    }
                    break;

                case "3":

                    System.out.println("\n--- Поиск максимума ---");

                    List<Box<? extends Number>> boxes = new ArrayList<>();

                    while (true) {
                        System.out.println("\nВыберите действие:");
                        System.out.println("1 - Добавить коробку с Integer");
                        System.out.println("2 - Добавить коробку с Double");
                        System.out.println("3 - Найти максимум");
                        System.out.println("0 - Выход из задания");
                        System.out.print("Ваш выбор: ");

                        String subChoice = sc.nextLine();

                        try {
                            switch (subChoice) {

                                case "1":
                                    int intValue = InputHelper.ReadInt(sc, "Введите целое число: ");
                                    boxes.add(new Box<>(intValue));
                                    System.out.println("Коробка с Integer добавлена");
                                    break;

                                case "2":
                                    double doubleValue = InputHelper.ReadDouble(sc, "Введите вещественное число: ");
                                    boxes.add(new Box<>(doubleValue));
                                    System.out.println("Коробка с Double добавлена");
                                    break;

                                case "3":
                                    double max = BoxUtils.findMax(boxes);
                                    System.out.println("Максимальное значение: " + max);
                                    break;

                                case "0":
                                    System.out.println("Выход из задания");
                                    break;

                                default:
                                    System.out.println("Ошибка: выберите пункт из меню (0-3)");
                            }
                        } catch (Exception e) {
                            System.out.println("Ошибка: " + e.getMessage());
                        }

                        if (subChoice.equals("0")) break;
                    }
                    break;

                case "4":

                    while (true) {
                        System.out.println("\n--- Обобщенные методы, автовывод типа. Функция ---");
                        System.out.println("1 - StringWrapper");
                        System.out.println("2 - IntegerWrapper");
                        System.out.println("3 - IntArrayWrapper");
                        System.out.println("0 - Выход из задания");
                        System.out.println("Ваш выбор: ");
                        String subChoice1 = sc.nextLine();

                        switch (subChoice1) {

                            case "1":

                                // Список строк -> длины строк
                                List<StringWrapper> strings = InputReaders.readStringList(sc);
                                List<IntegerWrapper> lengths = Transformer.transform(strings, (StringWrapper s) -> new IntegerWrapper(s.getValue().length()));
                                System.out.println("Результат (длины строк): ");
                                System.out.println(lengths);

                                break;

                            case "2":

                                // Список целых чисел -> все отрицательные значения заменяются на положительные
                                List<IntegerWrapper> ints = InputReaders.readIntegerList(sc);
                                List<IntegerWrapper> absInts = Transformer.transform(ints, (IntegerWrapper iw) -> new IntegerWrapper(Math.abs(iw.getValue())));
                                System.out.println("Результат (модули чисел): ");
                                System.out.println(absInts);

                                break;

                            case "3":

                                // Список массивов int - формата -> список максимумов каждого массива
                                List<IntArrayWrapper> arrays = InputReaders.readIntArrayList(sc);
                                List<IntegerWrapper> max_ints = Transformer.transform(arrays, (IntArrayWrapper aw) -> new IntegerWrapper(aw.max()));
                                System.out.println("Результат (максимумы массивов): ");
                                System.out.println(max_ints);

                                break;

                            case "0":
                                System.out.println("Выход из задания");
                                break;

                            default:
                                System.out.println("Ошибка: выберите пункт из меню (0-3) ");
                        }
                        if (subChoice1.equals("0")) break;
                    }
                    break;

                case "5":

                    while (true) {

                        System.out.println("\n--- Обобщенные методы, автовывод типа. Фильтр ---");
                        System.out.println("1 - фильтрация по длине");
                        System.out.println("2 - фильтрация по элементам");
                        System.out.println("3 - фильтрация массивов (без положительных элементов)");
                        System.out.println("0 - Выход из задания");
                        System.out.println("Ваш выбор: ");
                        String subChoice2 = sc.nextLine();

                        switch (subChoice2) {

                            case "1":

                                // строки с длинной менее 3 символов
                                List<StringWrapper> strings = InputReaders.readStringList(sc);
                                List<StringWrapper> filteredStrings = Filter.filter(strings, (StringWrapper s) -> s.getValue().length() < 3);
                                System.out.println("Строки длиной менее 3 символов: " + filteredStrings);

                                break;

                            case "2":

                                // список с положительными элементами
                                List<IntegerWrapper> ints = InputReaders.readIntegerList(sc);
                                List<IntegerWrapper> positiveOnly = Filter.filter(ints, (IntegerWrapper iw) -> iw.getValue() > 0);
                                System.out.println("Положительные числа: " + positiveOnly);

                                break;

                            case "3":

                                // Список массивов без положительных элементов
                                List<IntArrayWrapper> arrays = InputReaders.readIntArrayList(sc);
                                List<IntArrayWrapper> noPositives = Filter.filter(arrays, (IntArrayWrapper a) -> !a.hasPositive());
                                System.out.println("Массивы без положительных элементов: " + noPositives);

                                break;

                            case "0":
                                System.out.println("Выход из задания");
                                break;

                            default:
                                System.out.println("Ошибка: выберите пункт из меню (0-3) ");
                        }
                        if (subChoice2.equals("0")) break;
                    }
                    break;

                case "6":

                    while (true) {

                        System.out.println("\n--- Обобщенные методы, автовывод типа. Сокращение ---");
                        System.out.println("1 - слияние строк");
                        System.out.println("2 - сумма значений");
                        System.out.println("3 - общеe количество элементов во всех списках");
                        System.out.println("0 - Выход из задания");
                        System.out.println("Ваш выбор: ");
                        String subChoice3 = sc.nextLine();

                        switch (subChoice3) {

                            case "1":

                                List<StringWrapper> strings = InputReaders.readStringList(sc);
                                StringWrapper merged = ReducerUtil.reduce(strings, (StringWrapper a, StringWrapper b) ->
                                        new StringWrapper(a.getValue() + b.getValue()), new StringWrapper(""));
                                System.out.println("Результат объединения строк: " + merged);

                                break;

                            case "2":
                                List<IntegerWrapper> ints = InputReaders.readIntegerList(sc);
                                IntegerWrapper sum_ints = ReducerUtil.reduce(ints, (IntegerWrapper a, IntegerWrapper b) ->
                                        new IntegerWrapper(a.getValue() + b.getValue()), new IntegerWrapper(0));
                                System.out.println("Сумма элементов в списке: " + sum_ints);

                                break;

                            case "3":
                                List<IntArrayWrapper> arrays = InputReaders.readIntArrayList(sc);

                                List<IntegerWrapper> sizes = Transformer.transform(arrays, arr -> new IntegerWrapper(arr.getArray().length));

                                IntegerWrapper total = ReducerUtil.reduce(sizes, (IntegerWrapper a, IntegerWrapper b) ->
                                        new IntegerWrapper(a.getValue() + b.getValue()), new IntegerWrapper(0));

                                System.out.println("Общее количество элементов во всех массивах: " + total);

                                break;

                            case "0":
                                System.out.println("Выход из задания");
                                break;

                            default:
                                System.out.println("Ошибка: выберите пункт из меню (0-3) ");
                        }
                        if (subChoice3.equals("0")) break;
                    }
                    break;

                case "7":

                    while (true) {

                        System.out.println("\n--- Обобщенные методы, автовывод типа. Коллекционирование ---");
                        System.out.println("1 - разбиение списка чисел на положительные и отрицательные");
                        System.out.println("2 - разбиение списка строк на подсписки строк с одинаковой длиной");
                        System.out.println("3 - разбиение списка строк на подсписки с уникальными строками");
                        System.out.println("0 - Выход из задания");
                        System.out.println("Ваш выбор: ");
                        String subChoice4 = sc.nextLine();

                        switch (subChoice4) {

                            case "1":

                                List<IntegerWrapper> ints = InputReaders.readIntegerList(sc);

                                List<List<IntegerWrapper>> result = CollectUtil.collect(ints,
                                        // Создание результирующей коллекции - это список подсписков
                                        () -> {
                                            List<List<IntegerWrapper>> list = new ArrayList<>();
                                            list.add(new ArrayList<>()); // positives
                                            list.add(new ArrayList<>()); // negatives
                                            list.add(new ArrayList<>()); // nulls
                                            return list;
                                        },
                                        // Условие добавления элементов
                                        (list, value) -> {
                                            if (value.getValue() > 0)
                                                list.get(0).add(value);
                                            else if (value.getValue() < 0)
                                                list.get(1).add(value);
                                            else
                                                list.get(2).add(value);
                                        }
                                );

                                System.out.println("Подсписки: " + result);
                                break;

                            case "2":

                                List<StringWrapper> strings = InputReaders.readStringList(sc);
                                Map<Integer, List<StringWrapper>> groups = CollectUtil.collect(strings, HashMap::new,
                                        (map, s) -> {
                                            int length = s.getValue().length();
                                            map.computeIfAbsent(length, k -> new ArrayList<>()).add(s);
                                        }
                                );

                                System.out.println("Группировка по длине: " + groups);
                                break;

                            case "3":

                                // Оператор :: сокращенная запись для доступа(ссылки) на метод из функционального интерфейса при использовании лямбда выражения
                                // То есть вместо того, чтобы писать лямбду: () -> new HashSet<T>(), мы можем записать: HashSet::new
                                List<StringWrapper> strings1 = InputReaders.readStringList(sc);
                                Set<StringWrapper> unique = CollectUtil.collect(strings1, HashSet::new, Set::add);

                                System.out.println("Уникальные элементы: " + unique);
                                break;

                            case "0":
                                System.out.println("Выход из задания");
                                break;

                            default:
                                System.out.println("Ошибка: выберите пункт из меню (0-3) ");
                        }
                        if (subChoice4.equals("0")) break;
                    }
                    break;

                case "0":
                    System.out.println("Выход из программы");
                    sc.close();
                    return;

                default:
                    System.out.println("Ошибка: выберите пункт из меню (0-7) ");
            }
        }
    }
}
