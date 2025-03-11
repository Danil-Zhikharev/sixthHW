/**
 * Класс, представляющий студента с именем и возможными оценками.
 * Если оценки не указаны, они будут автоматически установлены как пустой массив.
 */
public class Student {
    /** Имя студента */
    String name;

    /** Оценки студента */
    int[] marks;

    /**
     * Конструктор для создания студента с именем и оценками.
     * Если оценки не указаны, они будут пустым массивом.
     *
     * @param name  Имя студента
     * @param marks Массив оценок студента, может быть null или пустым.
     *              Если оценки не переданы, будет создан пустой массив.
     */
    public Student(String name, int... marks) {
        this.name = name;
        // Если оценки не указаны, marks будет пустым массивом
        this.marks = marks.length > 0 ? marks : new int[0];
    }

    /**
     * Метод возвращает строковое представление студента.
     * Если у студента есть оценки, они выводятся. Если оценок нет, выводится информация о том, что оценок нет.
     *
     * @return Строковое представление студента, включая имя и оценки (или информацию о их отсутствии).
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(name);
        if (marks.length > 0) {
            result.append(", оценки: ");
            for (int mark : marks) {
                result.append(mark).append(" ");
            }
        } else {
            result.append(", без оценок");
        }
        return result.toString().trim();
    }
}
