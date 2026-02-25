package zadanie_3;

import java.util.Arrays;

/**
 * Класс-обёртка для массива целых чисел.
 * <p>
 * Позволяет безопасно хранить и обрабатывать массив целых чисел, предоставляя методы доступа и анализа данных.
 */
public class IntArrayWrapper {

    /** Хранимый массив целых чисел */
    private int[] array;

    /**
     * Создаёт пустой массив.
     */
    public IntArrayWrapper() {
        this.array = new int[0];
    }

    /**
     * Создаёт обёртку с копией переданного массива.
     *
     * @param array массив целых чисел
     */
    public IntArrayWrapper(int[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    /**
     * Возвращает копию массива.
     *
     * @return копия массива целых чисел
     */
    public int[] getArray() {
        return Arrays.copyOf(array, array.length);
    }

    /**
     * Устанавливает массив, копируя переданный массив.
     *
     * @param array массив целых чисел
     */
    public void setArray(int[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    /**
     * Находит максимальное значение в массиве.
     *
     * @return максимальное значение массива
     * @throws IllegalStateException если массив пустой
     */
    public int max() {
        if (array.length == 0) {
            throw new IllegalStateException("Массив пустой, максимум не определен");
        }

        int m = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > m) m = array[i];
        }
        return m;
    }

    /**
     * Проверяет, содержит ли массив хотя бы одно положительное число.
     *
     * @return {@code true}, если есть хотя бы одно положительное число, иначе {@code false}
     */
    public boolean hasPositive() {
        for (int x : array)
            if (x > 0) return true;
        return false;
    }

    /**
     * Возвращает строковое представление массива.
     *
     * @return строковое представление массива
     */
    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}