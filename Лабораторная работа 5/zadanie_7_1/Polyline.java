package zadanie_7_1;

import java.util.ArrayList;
import java.util.List;

public class Polyline {
    private List<Point> points;

    public Polyline() {
        points = new ArrayList<>();
    }

    public void addPoint(Point p) {
        points.add(p);
    }

    public List<Point> getPoints() { return points; }

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