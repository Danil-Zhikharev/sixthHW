/**
 * Класс, представляющий путь от одного города к другому.
 * Содержит информацию о соседнем городе и стоимости поездки.
 */
public class Path {
    /** Соседний город. */
    City destinationCity;

    /** Стоимость поездки в соседний город. */
    int cost;

    /**
     * Конструктор для создания пути.
     *
     * @param destinationCity Соседний город.
     * @param cost Стоимость поездки.
     */
    public Path(City destinationCity, int cost) {
        this.destinationCity = destinationCity;
        this.cost = cost;
    }

    /**
     * Переопределенный метод toString для представления пути в виде строки.
     *
     * @return Строковое представление пути в формате "название города: стоимость".
     */
    @Override
    public String toString() {
        return destinationCity.cityName + ": " + cost;
    }
}
