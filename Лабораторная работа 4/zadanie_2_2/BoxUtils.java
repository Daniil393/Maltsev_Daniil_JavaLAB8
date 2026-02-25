package zadanie_2_2;

import zadanie_1_1.Box;
import java.util.Collection;

/**
 * Утилитный класс для работы с коллекциями {@link Box} объектов.
 * <p>
 * Предоставляет методы для поиска максимальных значений в наборах коробок.
 */
public class BoxUtils {

    /**
     * Находит максимальное числовое значение среди всех непустых коробок в коллекции.
     * <p>
     * Игнорирует пустые коробки. Если все коробки пустые, выбрасывает {@link IllegalArgumentException}.
     *
     * @param boxes коллекция коробок, содержащих объекты, расширяющие {@link Number}
     * @return максимальное значение среди содержимого всех непустых коробок
     * @throws IllegalArgumentException если ни одна коробка не содержит значения
     */
    public static double findMax(Collection<? extends Box<? extends Number>> boxes) {
        double max = Double.NEGATIVE_INFINITY;
        boolean found = false;

        for (Box<? extends Number> box : boxes) {
            if (box.isFull()) {
                double value = box.getContent().doubleValue();
                if (!found || value > max) {
                    max = value;
                    found = true;
                }
            }
        }

        if (!found) {
            throw new IllegalArgumentException("Нет ни одной непустой коробки");
        }

        return max;
    }
}
