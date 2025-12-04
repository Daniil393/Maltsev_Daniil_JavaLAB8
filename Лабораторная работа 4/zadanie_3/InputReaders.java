package zadanie_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReaders {

// Методы ввода с проверкой

    // Ввод списка строк - запрос строки с элементами через запятую
    public static List<StringWrapper> readStringList(Scanner sc) {
        List<StringWrapper> list = new ArrayList<>();

        while (true) {
            System.out.println("Введите список строк через запятую (пример: qwerty, asdfg, zx");
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                System.out.println("Ввод пуст. Введите список строк");
                continue;
            }

            String[] parts = line.split(",");
            boolean ok = true;
            for (String p : parts) {
                String t = p.trim();
                if (t.isEmpty()) {
                    ok = false;
                    break;
                }
                list.add(new StringWrapper(t));
            }
            if (!ok) {
                System.out.println("Некорректный ввод (пустая строка между запятыми). Попробуйте ещё раз");
                list.clear();
                continue;
            }
            break;
        }
        return list;
    }

    // Ввод списка целых чисел - через запятую
    public static List<IntegerWrapper> readIntegerList(Scanner sc) {
        List<IntegerWrapper> list = new ArrayList<>();

        while (true) {
            System.out.println("Введите список целых чисел через запятую (пример: 1, -3, 7):");
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                System.out.println("Ввод пуст. Введите список целых чисел");
                continue;
            }

            String[] parts = line.split(",");
            boolean ok = true;
            for (String p : parts) {
                String t = p.trim();
                if (t.isEmpty()) {
                    ok = false;
                    break;
                }
                try {
                    int v = Integer.parseInt(t);
                    list.add(new IntegerWrapper(v));
                }
                catch (NumberFormatException e) {
                    System.out.println("Неправильный формат числа: " + t);
                    ok = false;
                    break;
                }
            }
            if (!ok) {
                System.out.println("Попробуйте ввести список чисел снова");
                list.clear();
                continue;
            }
            break;
        }
        return list;
    }

    // Ввод списка массивов int - формата: каждый массив должен быть разделен ";" и элементы массива записаны через пробел
    // Пример: "1 2 3; 5 7; -1;

    public static List<IntArrayWrapper> readIntArrayList(Scanner sc) {
        List<IntArrayWrapper> list = new ArrayList<>();

        while (true) {
            System.out.println("Введите список массивов (каждый массив разделен ';')");
            System.out.println("Внутри массива числа разделяйте пробелом. Пример: 1 2 3; 5 7; -1;");
            String line = sc.nextLine().trim();

            if (line.isEmpty()) {
                System.out.println("Ввод пуст. Введите список целочисленных массивов");
                continue;
            }

            String[] arrays = line.split(";");
            boolean ok = true;
            for (String arrStr : arrays) {
                String s = arrStr.trim();
                if (s.isEmpty()) {
                    ok = false;
                    break;
                }

                // Разбивка по пробелам
                String[] nums = s.split("\\s+");
                try {
                    int[] arr = new int[nums.length];
                    for (int i = 0; i < nums.length; i++)
                        arr[i] = Integer.parseInt(nums[i]);
                    list.add(new IntArrayWrapper(arr));
                } catch (NumberFormatException e) {
                    System.out.println("Неправильный формат числа в массиве: " + s);
                    ok = false;
                    break;
                }
            }
            if (!ok) {
                System.out.println("Попробуйте ввести массивы снова");
                list.clear();
                continue;
            }
            break;
        }
        return list;
    }
}