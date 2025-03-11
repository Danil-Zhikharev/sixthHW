/**
 * Класс, описывающий дом с определенным количеством этажей.
 */
class House {
    final int qteFloor;

    /**
     * Конструктор для создания объекта дома с указанным количеством этажей.
     *
     * @param qteFloor Количество этажей в доме.
     */
    public House(int qteFloor) {
        this.qteFloor = qteFloor;
    }

    /**
     * Переопределение метода toString для представления дома в виде строки.
     * В строке будет указано количество этажей и правильная форма слова "этаж" в зависимости от числа этажей.
     *
     * @return Строковое представление дома с правильным окончанием слова "этаж".
     */
    @Override
    public String toString() {
        String suffix = getFloorSuffix(qteFloor);
        return "Дом с " + qteFloor + " " + suffix;
    }

    /**
     * Метод для определения правильной формы слова "этаж" в зависимости от количества этажей.
     *
     * @param qteFloor Количество этажей.
     * @return Строка с правильной формой слова "этаж".
     */
    private String getFloorSuffix(int qteFloor) {
        int lastDigit = qteFloor % 10;  // Последняя цифра
        int lastTwoDigits = qteFloor % 100;  // Последние две цифры

        // Исключения для чисел 11-14
        if (lastTwoDigits >= 11 && lastTwoDigits <= 14) {
            return "этажами";  // Исключения: 11, 12, 13, 14
        }

        // Проверка для чисел, заканчивающихся на 1, 2, 3, 4
        if (lastDigit == 1) {
            return "этажом";
        } else if (lastDigit >= 2 && lastDigit <= 4) {
            return "этажами";
        }

        return "этажами";  // Для всех остальных случаев
    }
}
