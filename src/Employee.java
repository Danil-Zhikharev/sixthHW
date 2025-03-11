import java.util.ArrayList;
import java.util.List;

/**
 * Класс, представляющий сотрудника в организации.
 * Содержит имя сотрудника и информацию о его отделе.
 */
class Employee {
    /** Имя сотрудника. */
    Name name;

    /** Отдел, в котором работает сотрудник. */
    Department department;

    /**
     * Конструктор для создания сотрудника с именем и отделом.
     *
     * @param name Имя сотрудника, представленный объектом {@link Name}.
     * @param department Отдел, в котором работает сотрудник, представленный объектом {@link Department}.
     */
    public Employee(Name name, Department department) {
        this.name = name;
        this.department = department;
        // Добавляем сотрудника в отдел
        if (department != null) {
            department.addEmployee(this);
        }
    }

    /**
     * Конструктор для создания сотрудника с именем и названием отдела.
     * Если название отдела передано в виде строки, создается новый объект {@link Department}.
     *
     * @param name Имя сотрудника, представленный объектом {@link Name}.
     * @param departmentName Название отдела, в котором работает сотрудник. Может быть null или пустым.
     */
    public Employee(Name name, String departmentName) {
        this.name = name;
        // Если имя отдела передано как строка, создаем новый объект Department с этим именем
        if (departmentName != null && !departmentName.trim().isEmpty()) {
            this.department = new Department(departmentName, null); // Пока без начальника
            department.addEmployee(this); // Добавляем сотрудника в только что созданный отдел
        }
    }

    /**
     * Переопределение метода toString для представления сотрудника в виде строки.
     * Строка будет содержать имя сотрудника, название отдела и имя начальника.
     * Если сотрудник является начальником отдела, это также будет отражено в строке.
     *
     * @return Строковое представление сотрудника, включая его имя, отдел и имя начальника.
     *         Если сотрудник не работает в отделе, возвращается строка "Имя не работает в отделе."
     */
    @Override
    public String toString() {
        // Если сотрудник является начальником отдела
        if (department != null && department.manager == this) {
            return name + " начальник отдела " + department.name;
        } else if (department != null) {
            // Если сотрудник работает в отделе
            return name + " работает в отделе " + department.name + ", начальник которого " + (department.manager != null ? department.manager.name : "неизвестен");
        }
        return name + " не работает в отделе.";
    }

    /**
     * Метод для получения списка всех сотрудников отдела, в котором работает этот сотрудник.
     *
     * @return Список сотрудников отдела.
     */
    public List<Employee> getDepartmentEmployees() {
        if (department != null) {
            return department.getEmployees();
        }
        return new ArrayList<>(); // Возвращаем пустой список, если сотрудник не в отделе
    }
}
