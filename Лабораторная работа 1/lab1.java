import java.util.Random;
import java.util.Scanner;

public class lab1 {

    // 1.2) Сумма двух последних цифр числа
    public int sumLastNums(int x) {
        int LastDigit = Math.abs(x % 10);
        int SecondLastDigit = Math.abs((x / 10) % 10);
        return LastDigit + SecondLastDigit;
    }

    // 1.4) Проверка числа на положительность
    public boolean isPositive (int x) {
        if (x > 0)
            return true;
        else if (x < 0)
            return false;
        else {
            System.out.println("Ноль не является ни положительным, ни отрицательным.");
            return false;
        }
    }

    // 1.6) Большая буква
    public boolean isUpperCase(char x) {
        if (x >= 'A' && x <= 'Z') {
            System.out.println(x + " — большая буква английского алфавита.");
            return true;
        }

        else if (x >= 'a' && x <= 'z') {
            System.out.println(x + " — маленькая буква английского алфавита");
            return false;
        }
        else
            return false;
    }

    // 1.8) Делитель
    public boolean isDivisor(int a, int b) {
        if (a == 0 && b == 0) {
            System.out.println("Ошибка: деление на ноль невозможно");
            return false;
        }

        if (a % b == 0) {
            System.out.println(a + " делится на " + b + " нацело");
            return true;
        }
        if (b % a == 0) {
            System.out.println(b + " делится на " + a + " нацело");
            return true;
        }
        else {
            System.out.println("Ни одно из чисел не делится на другое нацело");
            return false;
        }
    }

    // 1.10) Многократный вызов
    public int LastNumSum(int a, int b) {
        return Math.abs(a % 10) + Math.abs(b % 10);
    }

    // 2.2) Безопасное деление
    public double safeDiv(int x, int y) {
        if (y == 0)
            return 0;
        double resultDiv = (double) x / y;

        if (resultDiv == (int) resultDiv)
            return (int) resultDiv;
        else
            return resultDiv;
    }

    // 2.4) Строка сравнения
    public String makeDecision(int x, int y) {
        if (x > y)
            return x + ">" + y;
        else if (x < y)
            return x + "<" + y;
        else
            return x + "==" + y;
    }

    // 2.6) Тройная сумма
    public boolean sum3(int x, int y, int z) {
        if ((x + y == z) || (x + z == y) || (y + z == x)) {
            System.out.println("из двух чисел можно получить третье с помощью операции сложения");
            return true;
        }
        else {
            System.out.println("из двух чисел нельзя получить третье с помощью операции сложения");
            return false;
        }
    }

    // 2.8) Возраст
    public String age(int x) {
        if (x % 10 == 1 && x != 11)
            return x + " год";
        else if ((x % 10 >= 2 && x % 10 <= 4) && !(x >= 12 && x <= 14))
            return x + " года";
        else
            return x + " лет";
    }

    // 2.10) Вывод дней недели
    public void printDays(String x) {
        switch (x.toLowerCase()) {
            case "понедельник":
                System.out.println("понедельник");
            case "вторник":
                System.out.println("вторник");
            case "среда":
                System.out.println("среда");
            case "четверг":
                System.out.println("четверг");
            case "пятница":
                System.out.println("пятница");
            case "суббота":
                System.out.println("суббота");
            case "воскресенье":
                System.out.println("воскресенье");
                break;

            default:
                System.out.println("это не день недели");
        }
    }

    // 3.2) Числа наоборот
    public String reverseListNums(int x) {
        String result = "";

        if (x >= 0) {
            for (int i = x; i >= 0; i--) {
                result += i;
                if (i != 0) result += " ";
            }
        }
        else {
            for (int i = x; i <= 0; i++) {
                result += i;
                if (i != 0) result += " ";
            }
        }
        return result;
    }

    // 3.4) Степень числа
    public int pow(int x, int y) {
        int result = 1;
        for (int i = 1; i <= y; i++)
            result *= x;
        return result;
    }

    // 3.6) Одинаковость
    public boolean equalNum(int x) {
        int lx = x % 10;
        x = x / 10;

        while (x > 0)
        {
            int Cx = x % 10;
            if (Cx != lx) {
                return false;
            }
            x = x / 10;
        }
        return true;
    }

    // 3.8) Левый треугольник
    public void leftTriangle(int x) {
        for (int i = 1; i <= Math.abs(x); i++) {
            for (int j = 1; j <= i; j++)
                System.out.print("*");
            System.out.println();
        }
    }

    // 3.10) Угадайка
    public void guessGame() {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int r = random.nextInt(10);
        int attempts = 0;
        int guess;

        System.out.println("Загадано число от 0 до 9. Попробуйте угадать");

        while (true) {
            System.out.println("Введите число: ");

            if (!sc.hasNextInt()) {
                System.out.println("Ошибка: нужно ввести целое число");
                sc.nextLine();
                continue;
            }

            guess = sc.nextInt();
            sc.nextLine();

            if (guess < 0 || guess > 9) {
                System.out.println("Ошибка: число должно быть в диапазоне от 0 до 9");
                continue;
            }

            attempts++;

            if (guess == r) {
                System.out.println("Вы угадали!");
                System.out.println("Вы отгадали число за " + attempts + " попыт" + ((attempts <= 4) ? "ки" : "ок"));
                break;
            }
            else {
                System.out.println("Вы не угадали, введите число от 0 до 9: ");
            }
        }
    }

    // 4.2) Поиск последнего значения
    public int findLast(int[] arr, int x) {
        for (int i = arr.length - 1; i >= 0; i--)
            if (arr[i] == x)
                return i;
        return -1;
    }

    // 4.4) Добавление в массив
    public int[]add (int[] arr, int x, int pos) {
        // проверка корректности позиции
        if (pos < 0 || pos > arr.length) {
            System.out.println("Ошибка: позиция для вставки находится вне размерности массива (0 - " + arr.length + ")");
            return arr; // возвращение массива без изменений
        }

        int[] newArr = new int[arr.length + 1];

        // переносим элементы старого массива в новый до позиции вставки
        for (int i = 0; i < pos; i++)
            newArr[i] = arr[i];

        // вставка нового значения
        newArr[pos] = x;

        // переносим оставшиеся элементы массива после вставки нового
        for (int i = pos; i < arr.length; i++)
            newArr[i + 1] = arr[i];

        return newArr;
    }

    // 4.6) Реверс
    public void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++; right--;
        }
    }

    // 4.8) Объединение
    public int[] concat(int[] arr1, int[] arr2) {
        int[] concatArr = new int[arr1.length + arr2.length];

        for (int i = 0; i < arr1.length; i++)
            concatArr[i] = arr1[i];

        for (int i = 0; i < arr2.length; i++)
            concatArr[arr1.length + i] = arr2[i];

        return concatArr;
    }

    // 4.10) Удалить негатив
    public int[] deleteNegative(int[] arr) {
        // Подсчет количества неотрицательных элементов
        int count = 0;
        for (int i = 0; i < arr.length; i++) { if (arr[i] >= 0) count++; }

        // Создание нового массива нужного размера
        int[] newArr = new int[count];
        int index = 0;

        //Копирование только неотрицательных элементов
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                newArr[index] = arr[i];
                index++;
            }
        }

        return newArr;
    }

    // проверка на ввод числа
    public int ReadInt(Scanner sc, String prompt) {
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

    // проверка на ввод символа
    public char ReadChar(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            if (input.length() == 1)
                return input.charAt(0);
            else
                System.out.println("Ошибка: введите символ.");
        }
    }
}