package zadanie_7_1;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, представляющий ломаную линию в двумерном пространстве.
 * <p>
 * Ломаная линия состоит из упорядоченного списка точек {@link Point}.
 * Поддерживаются добавление точек и получение полного списка точек.
 */
public class Polyline {

    /** Список точек, образующих ломаную линию */
    private List<Point> points;

    /**
     * Создает пустую ломаную линию.
     */
    public Polyline() {
        points = new ArrayList<>();
    }

    /**
     * Добавляет точку в конец ломаной линии.
     *
     * @param p точка для добавления
     */
    public void addPoint(Point p) {
        points.add(p);
    }

    /**
     * Возвращает список всех точек ломаной линии.
     *
     * @return список точек
     */
    public List<Point> getPoints() { return points; }

    /**
     * Возвращает строковое представление ломаной линии.
     * <p>
     * Формат: "Линия [T1{x1;y1}, T2{x2;y2}, ...]".
     *
     * @return строковое представление ломаной линии
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Линия [");
        for (int i = 0; i < points.size(); i++) {
            sb.append("T").append(i + 1).append(points.get(i));
            if (i != points.size() - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}