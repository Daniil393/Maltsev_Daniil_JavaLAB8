import javax.swing.*;
import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        lab1 tasks = new lab1();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Лабораторная работа №1 ===");
            System.out.println("Выберите задание: ");
            System.out.println("1 - Сумма двух последних цифр числа");
            System.out.println("2 - Проверка числа на положительность");
            System.out.println("3 - Проверка регистра буквы");
            System.out.println("4 - Проверка делимости одного из чисел нацело на другое");
            System.out.println("5 - Многократный вызов");
            System.out.println("6 - Безопасное деление");
            System.out.println("7 - Строка сравнения");
            System.out.println("8 - Тройная сумма");
            System.out.println("9 - Возраст");
            System.out.println("10 - Вывод дней недели");
            System.out.println("11 - Числа наоборот");
            System.out.println("12 - Степень числа");
            System.out.println("13 - Одинаковость");
            System.out.println("14 - Левый треугольник");
            System.out.println("15 - Угадайка");
            System.out.println("16 - Поиск последнего значения");
            System.out.println("17 - Добавление элемента в массив");
            System.out.println("18 - Запись массив в задом-наперед");
            System.out.println("19 - Объединение массивов");
            System.out.println("20 - Копирование всех неотрицательных элементов в новый массив");
            System.out.println("0 - Выход");
            System.out.print("Ваш выбор: ");

            String choice = sc.nextLine();

            switch (choice) {

                case "1":
                    int num1 = tasks.ReadInt(sc, "Ведите целое число: ");

                    while (Math.abs(num1) < 10) {
                        num1 = tasks.ReadInt(sc, "Число должно быть хотя бы двузначным. Попробуйте ввести его снова: ");
                    }

                    int sum = tasks.sumLastNums(num1);
                    System.out.println("Сумма двух последних цифр: " + sum);
                    break;

                case "2":
                    int num2 = tasks.ReadInt(sc, "Ведите целое число: ");
                    boolean positive = tasks.isPositive(num2);
                    if (num2 != 0) {
                        if (positive)
                            System.out.println("Число" + num2 + "положительное");
                        else
                            System.out.println("Число" + num2 + "отрицательное");
                    }
                    break;

                case "3":
                    char ch;

                    while (true) {
                        ch = tasks.ReadChar(sc, "Введите символ английского алфавита: ");

                        if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
                            break;
                        }

                        System.out.println("Ошибка: допускаются только английские буквы (A–Z или a–z).");
                    }

                    boolean upper = tasks.isUpperCase(ch);
                    break;

                case "4":
                    int a = tasks.ReadInt(sc, "Введите первое целое число: ");
                    int b = tasks.ReadInt(sc, "Введите второе целое число: ");
                    tasks.isDivisor(a, b);
                    break;

                case "5":
                    System.out.println("Последовательное сложение пяти чисел по последним цифрам");
                    int result = tasks.ReadInt(sc, "Введите 1-е число: ");

                    for (int i = 2; i <= 5; i++) {
                        int next = tasks.ReadInt(sc, "Введите " + i + "-е число: ");
                        result = tasks.LastNumSum(result, next);
                        System.out.println("Промежуточная сумма: " + result);
                    }

                    System.out.println("Итоговая сумма: " + result);
                    break;

                case "6":
                    int x = tasks.ReadInt(sc, "Введите делимое (x): ");
                    int y = tasks.ReadInt(sc, "Введите делитель (y): ");
                    double resultDiv = tasks.safeDiv(x, y);
                    if (resultDiv == (int) resultDiv)
                        System.out.println("Результат деления: " + (int) resultDiv);
                    else
                        System.out.println("Результат деления: " + resultDiv);
                    break;

                case "7":
                    int x1 = tasks.ReadInt(sc, "Введите первое целое число (x): ");
                    int y1 = tasks.ReadInt(sc, "Введите второе целое число (y): ");
                    String decision = tasks.makeDecision(x1, y1);
                    System.out.println("Результат сравнения: " + decision);
                    break;

                case "8":
                    int x2 = tasks.ReadInt(sc, "Введите первое целое число (x): ");
                    int y2 = tasks.ReadInt(sc, "Введите второе целое число (y): ");
                    int z2 = tasks.ReadInt(sc, "Введите третье целое число (z): ");
                    boolean check = tasks.sum3(x2, y2, z2);
                    break;

                case "9":
                    int x3 = tasks.ReadInt(sc, "Введите целое число: ");
                    String Age = tasks.age(x3);
                    System.out.println(Age);
                    break;

                case "10":
                    System.out.println("Введите день недели: ");
                    String day = sc.nextLine().trim();
                    tasks.printDays(day);
                    break;

                case "11":
                    int x4 = tasks.ReadInt(sc, "Введите целое число: ");
                    String res = tasks.reverseListNums(x4);
                    System.out.println("Последовательность: " + res);
                    break;

                case "12":
                    int x5 = tasks.ReadInt(sc, "Введите первое целое число (x): ");
                    int y5 = tasks.ReadInt(sc, "Введите второе целое число (y): ");
                    int resultPow = tasks.pow(x5, y5);
                    System.out.println("Результат: " + resultPow);
                    break;

                case "13":
                    int number = tasks.ReadInt(sc, "Введите целое число: ");
                    boolean check1 = tasks.equalNum(number);
                    break;

                case "14":
                    int number1 = tasks.ReadInt(sc, "Введите целое число: ");
                    System.out.println("Результат: ");
                    tasks.leftTriangle(number1);
                    break;

                case "15":
                    tasks.guessGame();
                    break;

                case "16":
                    int size = tasks.ReadInt(sc, "Введите размер массива: ");
                    while (size <= 0) {
                        System.out.println("Ошибка: размер массива должен быть положительным числом");
                        size = tasks.ReadInt(sc, "Введите размер массива: ");
                    }

                    // ввод элементов массива
                    int[] arr = new int[size];
                    System.out.println("Введите элементы массива: ");
                    for (int i = 0; i < size; i++)
                        arr[i] = tasks.ReadInt(sc, "Элемент " + (i + 1) + ": ");

                    // ввод элемента для поиска
                    int target = tasks.ReadInt(sc, "Введите элемент для поиска: ");

                    int index = tasks.findLast(arr, target);
                    if (index == - 1)
                        System.out.println("Элемент " + target + " не найден в массиве");
                    else
                        System.out.println("Последние вхождение элемента " + target + " находится по индексу " + index);
                    break;

                case "17":
                    int size1 = tasks.ReadInt(sc, "Введите размер массива: ");
                    while (size1 <= 0) {
                        System.out.println("Ошибка: размер массива должен быть положительным числом");
                        size1 = tasks.ReadInt(sc, "Введите размер массива: ");
                    }

                    // ввод элементов массива
                    int[] arr1 = new int[size1];
                    System.out.println("Введите элементы массива: ");
                    for (int i = 0; i < size1; i++)
                        arr1[i] = tasks.ReadInt(sc, "Элемент " + (i + 1) + ": ");

                    int el = tasks.ReadInt(sc, "Введите число для вставки в массив (число должно быть целым): ");
                    int pos;

                    while (true) {
                        pos = tasks.ReadInt(sc, "Введите позицию для вставки числа (от 0 до " + size1 + "): ");
                        if (pos < 0 || pos > size1)
                            System.out.println("Ошибка: позиция должна быть в диапазоне от 0 до " + size1);
                        else
                            break;
                    }

                    int[] newArr = tasks.add(arr1, el, pos);

                    System.out.println("Новый массив: " + Arrays.toString(newArr));
                    break;

                case "18":
                    int size2 = tasks.ReadInt(sc, "Введите размер массива: ");
                    while (size2 <= 0) {
                        System.out.println("Ошибка: размер массива должен быть положительным числом");
                        size2 = tasks.ReadInt(sc, "Введите размер массива: ");
                    }

                    // ввод элементов массива
                    int[] arr2 = new int[size2];
                    System.out.println("Введите элементы массива: ");
                    for (int i = 0; i < size2; i++)
                        arr2[i] = tasks.ReadInt(sc, "Элемент " + (i + 1) + ": ");

                    tasks.reverse(arr2);

                    System.out.println("Измененный массив: " + Arrays.toString(arr2));
                    break;

                case "19":
                    int sizeArr1 = tasks.ReadInt(sc, "Введите размер первого массива: ");
                    while (sizeArr1 <= 0) {
                        System.out.println("Ошибка: размер массива должен быть положительным числом");
                        sizeArr1 = tasks.ReadInt(sc, "Введите размер первого массива: ");
                    }

                    // ввод элементов массива
                    int[] Arr1 = new int[sizeArr1];
                    System.out.println("Введите элементы для первого массива: ");
                    for (int i = 0; i < sizeArr1; i++)
                        Arr1[i] = tasks.ReadInt(sc, "Элемент " + (i + 1) + ": ");

                    int sizeArr2 = tasks.ReadInt(sc, "Введите размер второго массива: ");
                    while (sizeArr2 <= 0) {
                        System.out.println("Ошибка: размер массива должен быть положительным числом");
                        size = tasks.ReadInt(sc, "Введите размер второго массива: ");
                    }

                    // ввод элементов массива
                    int[] Arr2 = new int[sizeArr2];
                    System.out.println("Введите элементы для второго массива: ");
                    for (int i = 0; i < sizeArr2; i++)
                        Arr2[i] = tasks.ReadInt(sc, "Элемент " + (i + 1) + ": ");

                    System.out.println("Объединение массивов: " + Arrays.toString(tasks.concat(Arr1, Arr2)));
                    break;

                case "20":
                    int SizeArr = tasks.ReadInt(sc, "Введите размер массива: ");
                    while (SizeArr <= 0) {
                        System.out.println("Ошибка: размер массива должен быть положительным числом");
                        SizeArr = tasks.ReadInt(sc, "Введите размер массива: ");
                    }

                    // ввод элементов массива
                    int[] Arr3 = new int[SizeArr];
                    System.out.println("Введите элементы для массива: ");
                    for (int i = 0; i < SizeArr; i++)
                        Arr3[i] = tasks.ReadInt(sc, "Элемент " + (i + 1) + ": ");

                    System.out.println("Новый массив со всеми элементами, кроме отрицательных: " + Arrays.toString(tasks.deleteNegative(Arr3)));
                    break;

                case "0":
                    System.out.println("Выход из программы");
                    sc.close();
                    return;

                default:
                    System.out.println("Ошибка: выберите пункт из меню (0-20) ");
                    break;
            }
        }
    }
}