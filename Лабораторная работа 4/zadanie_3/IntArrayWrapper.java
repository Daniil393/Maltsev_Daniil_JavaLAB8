package zadanie_3;

import java.util.Arrays;

public class IntArrayWrapper {
    private int[] array;

    public IntArrayWrapper() {
        this.array = new int[0];
    }

    public IntArrayWrapper(int[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    public int[] getArray() {
        return Arrays.copyOf(array, array.length);
    }

    public void setArray(int[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

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

    public boolean hasPositive() {
        for (int x : array)
            if (x > 0) return true;
        return false;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}