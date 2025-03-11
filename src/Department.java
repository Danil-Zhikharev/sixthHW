import java.util.ArrayList;
import java.util.List;

/**
 * Класс, представляющий отдел в организации.
 * Содержит название отдела и руководителя.
 */
class Department {
    /** Название отдела. */
    String name;

    /** Руководитель отдела (сотрудник). */
    Employee manager;

    /** Список сотрудников отдела. */
    List<Employee> employees;

    /**
     * Конструктор для создания отдела с заданным названием и начальником.
     * Также создаётся пустой список сотрудников.
     *
     * @param name Название отдела. Не может быть null.
     * @param manager Руководитель отдела, представленный объектом {@link Employee}. Может быть null, если начальник не задан.
     */
    public Department(String name, Employee manager) {
        this.name = name;
        this.manager = manager;
        this.employees = new ArrayList<>();
        if (manager != null) {
            employees.add(manager); // Добавляем начальника в список сотрудников
        }
    }

    /**
     * Метод для добавления сотрудника в отдел.
     *
     * @param employee Сотрудник, которого нужно добавить в отдел.
     */
    public void addEmployee(Employee employee) {
        if (!employees.contains(employee)) {
            employees.add(employee);
        }
    }

    /**
     * Получение списка всех сотрудников отдела.
     *
     * @return Список всех сотрудников отдела.
     */
    public List<Employee> getEmployees() {
        return employees;
    }
}
