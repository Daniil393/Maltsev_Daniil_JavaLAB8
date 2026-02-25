package zadanie_7_1;

/**
 * Класс, представляющий отрезок линии в двумерном пространстве.
 * <p>
 * Отрезок определяется начальной и конечной точкой {@link Point}.
 */
public class Line {

    /** Начальная точка линии */
    private Point start;

    /** Конечная точка линии */
    private Point end;

    /**
     * Создает линию с указанными начальной и конечной точками.
     *
     * @param start начальная точка линии
     * @param end конечная точка линии
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Возвращает начальную точку линии.
     *
     * @return объект {@link Point}, представляющий начальную точку
     */
    public Point getStart() { return start; }

    /**
     * Возвращает конечную точку линии.
     *
     * @return объект {@link Point}, представляющий конечную точку
     */
    public Point getEnd() { return end; }

    /**
     * Возвращает строковое представление линии.
     * <p>
     * Формат: "Линия от {start} до {end}".
     *
     * @return строковое представление линии
     */
    @Override
    public String toString() {
        return "Линия от " + start + " до " + end;
    }
}