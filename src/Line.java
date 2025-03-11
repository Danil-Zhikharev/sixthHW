/**
 * Класс, представляющий линию, определяемую двумя точками (начальной и конечной).
 * Объект линии может быть обновлен с помощью методов для изменения координат точек.
 */
class Line {
    /** Координата X начальной точки линии */
    private int x1;

    /** Координата Y начальной точки линии */
    private int y1;

    /** Координата X конечной точки линии */
    private int x2;

    /** Координата Y конечной точки линии */
    private int y2;

    /** Начальная точка линии */
    Point startPoint;

    /** Конечная точка линии */
    Point endPoint;

    /**
     * Создает линию между двумя точками.
     *
     * @param x1 координата X начальной точки
     * @param y1 координата Y начальной точки (может быть null)
     * @param x2 координата X конечной точки
     * @param y2 координата Y конечной точки (может быть null)
     * @throws IllegalArgumentException если оба значения y1 и y2 равны null
     */
    public Line(int x1, Integer y1, int x2, Integer y2) {
        // Проверка, если оба y равны null
        if (y1 == null && y2 == null) {
            throw new IllegalArgumentException("Оба значения 'y' не могут быть null. Пожалуйста, введите значение для 'y'");
        }

        // Если только y1 == null, присваиваем значение y2
        if (y1 == null) {
            y1 = y2;
        }

        // Если только y2 == null, присваиваем значение y1
        if (y2 == null) {
            y2 = y1;
        }

        this.startPoint = new Point(x1, y1);
        this.endPoint = new Point(x2, y2);
    }

    /**
     * Конструктор для создания линии с заданными точками начала и конца.
     *
     * @param startPoint начальная точка линии
     * @param endPoint конечная точка линии
     */
    public Line(Point startPoint, Point endPoint) {
        this.startPoint = new Point(startPoint.x, startPoint.y);
        this.endPoint = new Point(endPoint.x, endPoint.y);
    }

    /**
     * Метод для обновления координат начальной точки линии.
     *
     * @param x новая координата X начальной точки
     * @param y новая координата Y начальной точки
     */
    public void updateStartPoint(int x, int y) {
        this.startPoint.x = x;
        this.startPoint.y = y;
    }

    /**
     * Метод для обновления координат конечной точки линии.
     *
     * @param x новая координата X конечной точки
     * @param y новая координата Y конечной точки
     */
    public void updateEndPoint(int x, int y) {
        this.endPoint.x = x;
        this.endPoint.y = y;
    }

    /**
     * Переопределенный метод toString, возвращающий строковое представление линии.
     *
     * @return строковое представление линии в формате "Линия от {startPoint} до {endPoint}"
     */
    @Override
    public String toString() {
        return "Линия от " + startPoint + " до " + endPoint;
    }
}
