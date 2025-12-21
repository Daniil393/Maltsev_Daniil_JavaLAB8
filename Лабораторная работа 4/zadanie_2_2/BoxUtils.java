package zadanie_2_2;

import zadanie_1_1.Box;
import java.util.Collection;

public class BoxUtils {

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