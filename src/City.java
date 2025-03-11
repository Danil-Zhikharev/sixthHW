import java.util.ArrayList;
import java.util.List;

/**
 * Класс, представляющий город.
 * Город имеет название и список путей к другим городам.
 */
public class City {
    /** Название города. */
    String cityName;

    /** Список путей к другим городам. */
    List<Path> directions;

    /**
     * Конструктор для создания города с указанием только названия.
     *
     * @param cityName Название города.
     */
    public City(String cityName) {
        this.cityName = cityName;
        this.directions = new ArrayList<>();
    }

    /**
     * Конструктор для создания города с указанием названия и набора путей.
     *
     * @param cityName Название города.
     * @param paths Список путей, соединяющих этот город с другими.
     */
    public City(String cityName, List<Path> paths) {
        this.cityName = cityName;
        // Если paths не равен null, используем его, иначе создаем новый пустой список путей
        this.directions = paths != null ? paths : new ArrayList<>();
    }

    /**
     * Добавляет путь к следующему городу.
     *
     * @param destinationCity Соседний город.
     * @param cost Стоимость поездки в соседний город.
     */
    public void addPath(City destinationCity, int cost) {
        Path path = new Path(destinationCity, cost);
        directions.add(path);
    }

    /**
     * Переопределенный метод toString для представления города в виде строки.
     * Возвращает строку с названием города и списком связанных с ним городов.
     *
     * @return Строковое представление города.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(cityName + " [");

        for (int i = 0; i < directions.size(); i++) {
            sb.append(directions.get(i));
            if (i < directions.size() - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }
}
