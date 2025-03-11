import java.util.Arrays;

/**
 * Класс, представляющий ломанную линию, состоящую из множества точек.
 * Ломанная линия хранит массив точек и предоставляет метод для вывода информации о полилинии в виде строки.
 */
public class Polyline {

    /** Массив точек, составляющих ломанную линию. */
    Point[] points;

    /**
     * Создает пустую полилинию без точек.
     */
    public Polyline() {
        this.points = new Point[0];
    }

    /**
     * Создает полилинию из набора переданных точек.
     *
     * @param p1 Массив точек, составляющих полилинию.
     * @throws IllegalArgumentException если переданный массив null.
     */
    public Polyline(Point... p1) {
        if (p1 == null) {
            throw new IllegalArgumentException("Полилиния не может быть null.");
        }
        this.points = Arrays.copyOf(p1, p1.length);
    }

    /**
     * Переопределяет метод toString для представления ломаной в виде строки.
     * Формат: "Линия [{x1;y1}, {x2;y2}, ..., {xN;yN}]".
     *
     * @return Строковое представление полилинии.
     */
    @Override
    public String toString() {
        if (points.length == 0) {
            return "Линия []"; // Обрабатываем случай пустой линии
        }

        StringBuilder sb = new StringBuilder("Линия [");
        for (int i = 0; i < points.length; i++) {
            sb.append(points[i]); // Вызывает toString() у Point
            if (i < points.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Возвращает массив точек, составляющих полилинию.
     *
     * @return Массив точек.
     */
    public Point[] getPoints() {
        return Arrays.copyOf(points, points.length);
    }
}
