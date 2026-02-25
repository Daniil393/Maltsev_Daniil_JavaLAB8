package ru.maltsev.geometry;

/**
 * Класс {@code Point} представляет точку на двумерной плоскости
 * с координатами X и Y.
 */
public class Point {
    /** Координата по оси X. */
    private double x;

    /** Координата по оси Y. */
    private double y;

    /**
     * Создаёт точку с заданными координатами.
     *
     * @param x координата по оси X
     * @param y координата по оси Y
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Возвращает координату по оси X.
     *
     * @return значение X
     */
    public double getX() {
        return x;
    }

    /**
     * Возвращает координату по оси Y.
     *
     * @return значение Y
     */
    public double getY() {
        return y;
    }

    /**
     * Возвращает строковое представление точки
     * в формате {x;y}.
     *
     * @return строка с координатами точки
     */
    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }

    /**
     * Сравнивает текущую точку с другим объектом.
     * Точки считаются равными, если их координаты X и Y совпадают.
     *
     * @param obj объект для сравнения
     * @return true, если объект является точкой с теми же координатами,
     *         иначе false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Point)) return false;
        Point p = (Point) obj;
        return Double.compare(x, p.x) == 0 && Double.compare(y, p.y) == 0;
    }
}
