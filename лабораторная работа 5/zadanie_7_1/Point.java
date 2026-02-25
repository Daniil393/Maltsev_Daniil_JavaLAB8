package zadanie_7_1;

/**
 * Класс, представляющий точку в двумерной системе координат.
 * <p>
 * Содержит координаты {@code x} и {@code y}, а также методы для получения
 * этих координат, строковое представление и корректное сравнение точек.
 */
public class Point {

    /** Координата X точки */
    private double x;

    /** Координата Y точки */
    private double y;

    /**
     * Создает точку с указанными координатами.
     *
     * @param x координата X
     * @param y координата Y
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Возвращает координату X точки.
     *
     * @return координата X
     */
    public double getX() { return x; }

    /**
     * Возвращает координату Y точки.
     *
     * @return координата Y
     */
    public double getY() { return y; }

    /**
     * Возвращает строковое представление точки.
     * <p>
     * Формат: "{x;y}".
     *
     * @return строковое представление точки
     */
    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }

    /**
     * Проверяет, равна ли текущая точка другой точке.
     * <p>
     * Сравнение осуществляется по координатам {@code x} и {@code y}.
     *
     * @param obj объект для сравнения
     * @return {@code true}, если точки совпадают, иначе {@code false}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Point)) return false;
        Point p = (Point) obj;
        return Double.compare(x, p.x) == 0 && Double.compare(y, p.y) == 0;
    }

    /**
     * Вычисляет хеш-код точки на основе координат.
     *
     * @return хеш-код точки
     */
    @Override
    public int hashCode() {
        return Double.hashCode(x) * 31 + Double.hashCode(y);
    }
}