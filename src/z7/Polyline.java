package z7;

import java.util.*;

public class Polyline {
    private List<Point> points;

    public Polyline(List<Point> points) {
        this.points = points;
    }

    public String toString() {
        return "Линия " + points.toString();
    }
}
