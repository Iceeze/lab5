package z7;

import java.util.*;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return "{" + x + ";" + y + "}";
    }

    // Метод для сравнения точек по координатам
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point point = (Point) obj;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
    }

    // Хеш-код на основе координат
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
