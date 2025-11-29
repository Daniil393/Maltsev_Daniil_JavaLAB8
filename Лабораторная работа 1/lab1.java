import java.util.Random;
import java.util.Scanner;

public class lab1 {

    /**
     * Метод вычисления суммы двух последних цифр числа
     * @param x целочисленное значение
     * @return сумма двух последних цифр
     */

    public int sumLastNums(int x) {
        int LastDigit = Math.abs(x % 10);
        int SecondLastDigit = Math.abs((x / 10) % 10);
        return LastDigit + SecondLastDigit;
    }

    /**
     * Метод проверки числа на положительность
     * @param x число для проверки
     * @return true, если число положительное, иначе false
     */

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

    /**
     * Метод определения, является ли символ заглавной или строчной английской буквой
     * @param x символ для проверки
     * @return true, если символ заглавный, иначе false
     */

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

    /**
     * Метод определения делимости чисел
     * @param a первое число
     * @param b второе число
     * @return true, если одно из чисел делится на другое, иначе false
     */

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

    /**
     * Метод вычисления суммы последних цифр двух чисел
     * @param a первое число
     * @param b второе число
     * @return сумма последних цифр
     */

    public int LastNumSum(int a, int b) {
        return Math.abs(a % 10) + Math.abs(b % 10);
    }

    /**
     * Метод безопасного деления двух чисел
     * @param x делимое
     * @param y делитель
     * @return результат деления, либо 0 при делении на ноль
     */

    public double safeDiv(int x, int y) {
        if (y == 0)
            return 0;
        double resultDiv = (double) x / y;

        if (resultDiv == (int) resultDiv)
            return (int) resultDiv;
        else
            return resultDiv;
    }

    /**
     * Метод формирования строки сравнения двух чисел
     * @param x первое число
     * @param y второе число
     * @return строка сравнения вида "x>y", "x<y" или "x==y"
     */

    public String makeDecision(int x, int y) {
        if (x > y)
            return x + ">" + y;
        else if (x < y)
            return x + "<" + y;
        else
            return x + "==" + y;
    }

    /**
     * Метод проверки, можно ли получить одно число суммой двух других
     * @param x первое число
     * @param y второе число
     * @param z третье число
     * @return true, если одно число является суммой двух других
     */

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

    /**
     * Метод формирования строки возраста в правильной форме
     * @param x возраст
     * @return строка с корректным окончанием
     */

    public String age(int x) {
        if (x % 10 == 1 && x != 11)
            return x + " год";
        else if ((x % 10 >= 2 && x % 10 <= 4) && !(x >= 12 && x <= 14))
            return x + " года";
        else
            return x + " лет";
    }

    /**
     * Метод вывода дней недели, начиная с указанного
     * @param x строка с названием дня
     */

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

    /**
     * Метод формирования строки чисел от X до 0 (включительно)
     * @param x исходное число
     * @return строка перечисленных чисел
     */

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

    /**
     * Метод возведения числа X в степень Y
     * @param x основание
     * @param y показатель степени
     * @return результат возведения в степень
     */

    public int pow(int x, int y) {
        int result = 1;
        for (int i = 1; i <= y; i++)
            result *= x;
        return result;
    }

    /**
     * Метод проверки, что все цифры числа одинаковые
     * @param x число для проверки
     * @return true, если все цифры совпадают
     */

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

    /**
     * Метод вывода левого треугольника из символов '*'
     * @param x высота треугольника
     */

    public void leftTriangle(int x) {
        for (int i = 1; i <= Math.abs(x); i++) {
            for (int j = 1; j <= i; j++)
                System.out.print("*");
            System.out.println();
        }
    }

    /**
     * Метод игры "Угадай число"
     */

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

    /**
     * Метод поиска последнего вхождения числа в массиве
     * @param arr массив чисел
     * @param x искомое число
     * @return индекс последнего вхождения или -1 если не найден
     */

    public int findLast(int[] arr, int x) {
        for (int i = arr.length - 1; i >= 0; i--)
            if (arr[i] == x)
                return i;
        return -1;
    }

    /**
     * Метод добавления элемента в массив по указанной позиции
     * @param arr исходный массив
     * @param x элемент для вставки
     * @param pos позиция вставки
     * @return новый массив с добавленным элементом
     */

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

    /**
     * Метод реверса массива
     * @param arr массив для реверса
     */

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

    /**
     * Метод объединения двух массивов
     * @param arr1 первый массив
     * @param arr2 второй массив
     * @return объединённый массив (сначала элементы arr1, потом - arr2)
     */

    public int[] concat(int[] arr1, int[] arr2) {
        int[] concatArr = new int[arr1.length + arr2.length];

        for (int i = 0; i < arr1.length; i++)
            concatArr[i] = arr1[i];

        for (int i = 0; i < arr2.length; i++)
            concatArr[arr1.length + i] = arr2[i];

        return concatArr;
    }

    /**
     * Метод удаления всех отрицательных элементов массива
     * @param arr исходный массив
     * @return новый массив без отрицательных значений
     */

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

    /**
     * Метод проверки ввода целого числа
     * @param sc сканер
     * @param prompt строка-интерфейс
     * @return введённое целое число
     */

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

    /**
     * Метод проверки ввода символа
     * @param sc сканер
     * @param prompt строка-интерфейс
     * @return введённый символ
     */

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