/**
 * Класс, представляющий человека с именем, ростом и информацией о его отце.
 * Позволяет создавать человека с разными вариантами данных, такими как имя, рост и фамилия.
 * Также поддерживает наследование фамилии и отчества от отца.
 */
public class Human {

    private Human father; // Отец человека
    private Name nameFromClass;  // Имя человека в виде объекта Name
    private String name;  // Имя человека в виде строки
    private int height;  // Рост человека

    /**
     * Конструктор для создания объекта человека с именем в виде строки.
     *
     * @param name Имя человека.
     */
    public Human(String name) {
        this.name = name;
        this.nameFromClass = new Name(name); // Создаем объект Name из строки
    }

    /**
     * Конструктор для создания объекта человека с именем и ростом.
     *
     * @param name Имя человека.
     * @param height Рост человека.
     */
    public Human(String name, int height) {
        this.name = name;
        this.height = height;
        this.nameFromClass = new Name(name); // Создаем объект Name из строки
    }

    /**
     * Конструктор для создания объекта человека с объектами Name для имени и отца.
     * Если имя отца указано, наследуется фамилия и отчество.
     *
     * @param nameFromClass Объект Name, представляющий имя человека.
     * @param nameOfFatherFromClass Объект Name, представляющий имя отца человека.
     */
    public Human(Name nameFromClass, Name nameOfFatherFromClass) {
        this.nameFromClass = nameFromClass;

        // Если имя отца указано, наследуем фамилию и отчество
        if (nameOfFatherFromClass != null) {
            this.nameFromClass.setSurname(nameOfFatherFromClass.getSurname());
            if (nameFromClass.getPatronymic() == null) {
                this.nameFromClass.setPatronymic(generatePatronymicFromFather(nameOfFatherFromClass));
            }
        }
    }

    /**
     * Конструктор для создания объекта человека с объектом Name и отцом.
     * Наследуются фамилия и отчество от отца.
     *
     * @param nameFromClass Объект Name, представляющий имя человека.
     * @param father Объект Human, представляющий отца человека.
     */
    public Human(Name nameFromClass, Human father) {
        this.nameFromClass = nameFromClass;
        this.father = father;
        inheritFatherData(); // Наследуем фамилию и отчество
    }

    /**
     * Конструктор для создания объекта человека с именем и отцом.
     * Наследуются фамилия и отчество от отца.
     *
     * @param name Имя человека.
     * @param father Объект Human, представляющий отца человека.
     */
    public Human(String name, Human father) {
        this.name = name;
        this.father = father;
        this.nameFromClass = new Name(name);
        inheritFatherData(); // Наследуем фамилию и отчество
    }

    /**
     * Конструктор для создания объекта человека с объектом Name и ростом.
     *
     * @param nameFromClass Объект Name, представляющий имя человека.
     * @param height Рост человека.
     */
    public Human(Name nameFromClass, int height) {
        this.nameFromClass = nameFromClass;
        this.height = height;
    }

    /**
     * Конструктор для создания объекта человека с объектом Name.
     *
     * @param nameFromClass Объект Name, представляющий имя человека.
     */
    public Human(Name nameFromClass) {
        this.nameFromClass = nameFromClass;
    }

    /**
     * Переопределенный метод toString для вывода информации о человеке.
     * Возвращает строковое представление человека с указанием фамилии, имени, отчества и роста.
     *
     * @return Строковое представление человека.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        if (nameFromClass != null) {
            if (nameFromClass.getSurname() != null) {
                result.append(nameFromClass.getSurname()).append(" ");
            }
            if (nameFromClass.getName() != null) {
                result.append(nameFromClass.getName());
            }
            if (nameFromClass.getPatronymic() != null) {
                result.append(" ").append(nameFromClass.getPatronymic());
            }
        } else if (name != null) {
            result.append(name);
        }

        if (height > 0) {
            result.append(", рост: ").append(height);
        }

        return result.toString().trim();
    }

    /**
     * Генерация отчества из имени отца.
     * Если имя отца указано, генерируется отчество на основе его имени.
     *
     * @param fatherName Объект Name, представляющий имя отца.
     * @return Отчество, сгенерированное на основе имени отца.
     */
    private String generatePatronymicFromFather(Name fatherName) {
        if (fatherName != null && fatherName.getName() != null) {
            return generatePatronymic(fatherName.getName());
        }
        return null;
    }

    /**
     * Генерация отчества на основе имени отца.
     * Если имя отца соответствует определенным условиям, генерируется соответствующее отчество.
     *
     * @param fatherName Имя отца.
     * @return Отчество, сгенерированное на основе имени отца.
     */
    private String generatePatronymic(String fatherName) {
        if (fatherName == null) return null;

        if (fatherName.equals("Лев")) {
            return "Львович";
        }
        if (fatherName.endsWith("а") || fatherName.endsWith("я")) {
            return fatherName.substring(0, fatherName.length() - 1) + "вна";
        }
        if (fatherName.endsWith("й") || fatherName.endsWith("ь")) {
            return fatherName.substring(0, fatherName.length() - 1) + "евич";
        }
        return fatherName + "ович";
    }

    /**
     * Наследование фамилии и отчества от отца.
     * Если имя отца не указано, фамилия и отчество наследуются от объекта father.
     */
    private void inheritFatherData() {
        if (this.father != null && this.nameFromClass != null) {
            // Наследуем фамилию от отца, если у сына она не указана
            if (this.nameFromClass.getSurname() == null && this.father.nameFromClass != null) {
                this.nameFromClass.setSurname(this.father.nameFromClass.getSurname());
            }

            // Генерируем отчество, если его нет
            if (this.nameFromClass.getPatronymic() == null) {
                String patronymic = generatePatronymicFromFather(this.father.nameFromClass);
                this.nameFromClass.setPatronymic(patronymic);
            }
        }
    }
}