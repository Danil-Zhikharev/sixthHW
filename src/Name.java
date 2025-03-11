/**
 * Класс для представления полного имени человека с возможностью указания порядка:
 * фамилия-имя-отчество или имя-отчество-фамилия.
 */
public class Name {

    /** Фамилия человека. */
    private String surname;

    /** Имя человека. */
    private String name;

    /** Отчество человека. */
    private String patronymic;

    /** Флаг, указывающий, используется ли строгий порядок (Имя, Отчество, Фамилия). */
    private boolean strictOrder = false;

    /**
     * Конструктор без флага, для стандартного порядка (Фамилия, Имя, Отчество).
     *
     * @param nameParts Части имени. Может быть 1, 2 или 3 части (Имя, Отчество, Фамилия).
     */
    public Name(String... nameParts) {
        if (nameParts.length == 1) {
            this.name = nameParts[0];  // Присваиваем только имя
        } else if (nameParts.length == 2) {
            if (isLikelySurname(nameParts[1])) {
                this.name = nameParts[0];  // Имя
                this.surname = nameParts[1];  // Фамилия
            } else {
                this.name = nameParts[0];  // Имя
                this.patronymic = nameParts[1];  // Отчество
            }
        } else if (nameParts.length == 3) {
            this.name = nameParts[0];
            this.patronymic = nameParts[1];
            this.surname = nameParts[2];
        }
    }

    /**
     * Конструктор с флагом strictOrder, который указывает порядок (Имя, Отчество, Фамилия).
     *
     * @param strictOrder Флаг, указывающий на порядок.
     * @param nameParts Части имени. Может быть 1, 2 или 3 части (Имя, Отчество, Фамилия).
     */
    public Name(boolean strictOrder, String... nameParts) {
        this.strictOrder = strictOrder;

        if (strictOrder) {
            // Если strictOrder == true, то порядок: Имя, Отчество, Фамилия
            if (nameParts.length == 3) {
                this.name = nameParts[0];  // Имя
                this.patronymic = nameParts[1];  // Отчество
                this.surname = nameParts[2];  // Фамилия
            } else if (nameParts.length == 2) {
                this.name = nameParts[0];  // Имя
                this.patronymic = nameParts[1];  // Отчество
            } else if (nameParts.length == 1) {
                this.name = nameParts[0];  // Имя
            }
        } else {
            // Если strictOrder == false, используем эвристику для определения порядка
            if (nameParts.length == 1) {
                this.name = nameParts[0];  // Имя или фамилия
            } else if (nameParts.length == 2) {
                if (isLikelySurname(nameParts[1])) {
                    this.name = nameParts[0];  // Имя
                    this.surname = nameParts[1];  // Фамилия
                } else {
                    this.name = nameParts[0];  // Имя
                    this.patronymic = nameParts[1];  // Отчество
                }
            } else if (nameParts.length == 3) {
                this.name = nameParts[0];
                this.patronymic = nameParts[1];
                this.surname = nameParts[2];
            }
        }
    }

    /**
     * Проверяет, является ли переданное слово вероятной фамилией.
     *
     * @param word Слово для проверки.
     * @return true, если слово похоже на фамилию (имеет типичные окончания фамилий).
     */
    private boolean isLikelySurname(String word) {
        return word != null && word.matches(".*(ов|ев|ин|ская|ский|их|ко|цкий|дзе|швили|ян)$");
    }

    /**
     * Устанавливает фамилию.
     *
     * @param surname Фамилия.
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Устанавливает имя.
     *
     * @param name Имя.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Устанавливает отчество.
     *
     * @param patronymic Отчество.
     */
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    /**
     * Получает фамилию.
     *
     * @return Фамилия.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Получает имя.
     *
     * @return Имя.
     */
    public String getName() {
        return name;
    }

    /**
     * Получает отчество.
     *
     * @return Отчество.
     */
    public String getPatronymic() {
        return patronymic;
    }

    /**
     * Форматирует полное имя в строку в зависимости от порядка.
     * Если strictOrder == true, формат: Имя Отчество Фамилия.
     * Если strictOrder == false, формат: Фамилия Имя Отчество.
     *
     * @return Форматированное полное имя.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        if (strictOrder) {
            // Вывод в порядке Имя Отчество Фамилия
            appendPart(result, name);
            appendPart(result, patronymic);
            appendPart(result, surname);
        } else {
            // Вывод в порядке Фамилия Имя Отчество
            appendPart(result, surname);
            appendPart(result, name);
            appendPart(result, patronymic);
        }

        return result.toString();
    }

    /**
     * Добавляет часть имени в строку, если она не null.
     *
     * @param result Строка, к которой добавляется часть.
     * @param part Часть имени (Фамилия, Имя, Отчество).
     */
    private void appendPart(StringBuilder result, String part) {
        if (part != null) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(part);
        }
    }
}