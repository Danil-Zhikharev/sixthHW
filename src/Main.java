import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // 1.1.1
        System.out.println("Задача 1.1.1");
        Point test1 = new Point(5, 7);
        System.out.println(test1);

        Point test2 = new Point(7,7);
        System.out.println(test2);

        Point test3 = new Point(10, 1);
        System.out.println(test3);

        // 1.1.2
        System.out.println("\nЗадача 1.1.2");
        Human test01 = new Human ("Клеопатра", 152);
        System.out.println( test01);

        Human test02 = new Human("Пушкин", 167);
        System.out.println(test02);

        Human test03 = new Human("Александр", 189);
        System.out.println(test03);

        // 1.1.3
        System.out.println("\nЗадача 1.1.3");
        Name test001 = new Name("Клеопатра", null, null);
        System.out.println(test001);

        Name test002 = new Name("Александр","Сергеевич", "Пушкин");
        System.out.println(test002);

        Name test003 = new Name("Владимир", null, "Маяковский");
        System.out.println(test003);

        // 1.1.4
        System.out.println("\nЗадача 1.1.4");
        Time time1 = new Time(12000);
        System.out.println(time1);     // 3:20:00

        Time time2 = new Time(91800);  // 25 часов
        System.out.println(time2);     // 1:30:00

        Time time3 = new Time(3661);
        System.out.println(time3);     // 1:01:01

        Time time4 = new Time(86461);  // 1 секунда после 24 часов
        System.out.println(time4);     // 0:00:01

        // 1.1.5
        System.out.println("\nЗадача 1.1.5");
        House t1 = new House(1);
        System.out.println(t1);

        House t2 = new House(5);
        System.out.println(t2);

        House t3 = new House(23);
        System.out.println(t3);

        // 1.2.1.
        System.out.println("\nЗадача 1.2.1.");
        // 1. Линия 1: начало в т. {1;3}, конец в т. {23;8}
        Point p1L1 = new Point(1, 3);
        Point p2L1 = new Point(23, 8);
        Line firstLine = new Line(p1L1, p2L1);
        System.out.println("Линия 1: " + firstLine);

        // 2. Линия 2: горизонтальная, высота 10, от точки 5 до точки 25
        Point p1L2 = new Point(5, 10);
        Point p2L2 = new Point(25, 10);
        Line secondLine = new Line(p1L2, p2L2);
        System.out.println("Линия 2: " + secondLine);

        // 3. Линия 3: начинается в точке, где начинается линия 1, и заканчивается в точке, где заканчивается линия 2
        Line thirdLine = new Line(firstLine.startPoint, secondLine.endPoint);
        System.out.println("Линия 3: " + thirdLine);

        // 4. Изменение координат первой и второй линии
        // Линия 3 также изменяется, так как она зависит от первой и второй линии
        firstLine.updateStartPoint(10, 5);
        secondLine.updateEndPoint(30, 12);
        thirdLine = new Line(firstLine.startPoint, secondLine.endPoint);

        System.out.println("\nПосле изменения первой и второй линии:");
        System.out.println("Линия 1: " + firstLine);
        System.out.println("Линия 2: " + secondLine);
        System.out.println("Линия 3: " + thirdLine);

        // 5. Изменяем координаты первой линии так, чтобы не изменились координаты третьей линии
        // Линия 3 должна остаться неизменной, так как мы не пересоздаем 3-ю линию заново
        firstLine.updateStartPoint(50, 50);
        firstLine.updateEndPoint(70, 70);

        System.out.println("\nПосле изменения первой линии:");
        System.out.println("Линия 1: " + firstLine);
        System.out.println("Линия 2: " + secondLine);
        System.out.println("Линия 3: " + thirdLine);

        // 1.2.2.
        System.out.println("\nЗадача 1.2.2.");
        Human person1 = new Human(test001, 152);
        System.out.println(person1);

        Human person2 = new Human(test002, 167);
        System.out.println(person2);

        Human person3 = new Human(test003, 189);
        System.out.println(person3);

        // 1.2.3.
        System.out.println("\nЗадача 1.2.3.");

        Name fatherIvan = new Name("Иван",null, "Чудов");
        Name sonPetr = new Name("Петр", null, "Чудов");
        Name sonBoris = new Name("Борис", null, null);

        Human personWithFatherOnly = new Human(fatherIvan);
        System.out.println(personWithFatherOnly); // Должно корректно вывести "Чудов Иван"

        Human personWithFatherAndSon = new Human(sonPetr, fatherIvan);
        System.out.println(personWithFatherAndSon); // Должно корректно вывести "Чудов Петр Иванович"

        Human personWithFatherAndSonName = new Human(sonBoris, sonPetr);
        System.out.println(personWithFatherAndSonName); // Должно вывести "Чудов Борис Петрович"


        // 1.2.4.
        System.out.println("\nЗадача 1.2.4.");

        Name petrovName = new Name("Петров", null, null);
        Name kozlovName = new Name("Козлов", null, null);
        Name sidorovName = new Name("Сидоров", null, null);


        Employee kozlov = new Employee(kozlovName, "IT");
        Department itDepartment = new Department("IT", kozlov);
        kozlov.department = itDepartment;

        Employee petrov = new Employee(petrovName, itDepartment);
        Department accountDepartment = new Department("Бухгалтерия", null);
        Employee sidorov = new Employee(sidorovName, accountDepartment);

        System.out.println(petrov);
        System.out.println(kozlov);
        System.out.println(sidorov);


        // 1.3.1.
        System.out.println("\nЗадача 1.3.1.");
        Student vasya = new Student("Вася", new int [] {3, 4, 5});
        System.out.println(vasya);

        int[] petyaMarks = vasya.marks.clone();
        petyaMarks[0] = 5;
        Student petya = new Student("Петя", petyaMarks);
        System.out.println(petya);

        int [] andreiMarks = vasya.marks.clone();
        vasya.marks[1] = 7;
        System.out.println("После изменения: " + vasya);
        Student andrei = new Student("Андрей", andreiMarks);
        System.out.println(andrei);

        // 1.3.2.
        System.out.println("\nЗадача 1.3.2.");

        Point[] points = {
                new Point(0, 5),
                new Point(2, 8),
                new Point(5, 3)
        };

        Polyline polylineFirst = new Polyline();
        polylineFirst.points = points;
        System.out.println(polylineFirst);

        Point[] pointsNew = {
                polylineFirst.points[0],
                new Point(2, -5),
                new Point(4, -8),
                polylineFirst.points[2]
        };

        Polyline polylineSecond = new Polyline();
        polylineSecond.points = pointsNew;
        System.out.println(polylineSecond);

        // 1.3.3.
        System.out.println("\nЗадача 1.3.3.");
        // Создание городов
        City city1 = new City("A");
        City city2 = new City("B");
        City city3 = new City("C");
        City city4 = new City("D");
        City city5 = new City("E");
        City city6 = new City("F");

        // Добавление путей
        city1.addPath(city2, 5);
        city1.addPath(city4, 6);
        city1.addPath(city6, 1);

        city2.addPath(city3, 3);
        city2.addPath(city1, 5);

        city3.addPath(city2, 3);
        city3.addPath(city4, 4);

        city4.addPath(city1, 6);
        city4.addPath(city5, 2);

        city5.addPath(city6, 2);
        city6.addPath(city2, 1);

        // Вывод информации о городах
        System.out.println(city1);
        System.out.println(city2);
        System.out.println(city3);
        System.out.println(city4);
        System.out.println(city5);
        System.out.println(city6);

        // 1.3.4.
        System.out.println("\nЗадача 1.3.4.");
        // Выводим всех сотрудников отдела IT
        System.out.println("Сотрудники отдела IT:");
        List<Employee> itEmployees = kozlov.getDepartmentEmployees();
        for (Employee emp : itEmployees) {
            System.out.println(emp);
        }

        // Выводим всех сотрудников отдела Бухгалтерия
        System.out.println("\nСотрудники отдела Бухгалтерия:");
        List<Employee> accountEmployees = sidorov.getDepartmentEmployees();
        for (Employee emp : accountEmployees) {
            System.out.println(emp);
        }

        // 1.4.1.
        System.out.println("\nЗадача 1.4.1.");
        Point point1 = new Point(3, 5);
        System.out.println(point1);

        Point point2 = new Point(25,6);
        System.out.println(point2);

        Point point3 = new Point(7, 8);
        System.out.println(point3);

        // 1.4.2.
        System.out.println("\nЗадача 1.4.2.");
        Line lineFourPoints = new Line (5, 3, -1, 2);
        System.out.println(lineFourPoints);

        // Линия 1 с началом в т. {1;3} и концом в {23;8}.
        Point firstPoint1 = new Point(1, 3);
        Point secondPoint1 = new Point(23, 8);
        Line lineFirst = new Line(firstPoint1, secondPoint1);
        System.out.println("Линия 1: " + lineFirst);

        // Линия 2, горизонтальная, на высоте 10, от точки 5 до точки 25.
        Line lineSecond = new Line(5, 10, 25, null);
        System.out.println("Линия 2: " + lineSecond);

        // Линия 3 которая начинается всегда там же где начинается линия 1, и заканчивается всегда там же, где заканчивается линия 2.
        Line lineThird = new Line (lineFirst.startPoint, lineSecond.endPoint);
        System.out.println("Линия 2: " + lineThird);


        // 1.4.3.
        System.out.println("\nЗадача 1.4.3.");
        Point p1 = new Point(3, 5);
        Point p2 = new Point(25, 6);
        Point p3 = new Point(7, 8);
        Polyline polylineNew = new Polyline(p1, p2, p3);
        System.out.println(polylineNew);

        Polyline emptyPolyline = new Polyline();
        System.out.println(emptyPolyline);

        // 1.4.4.
        System.out.println("\nЗадача 1.4.4.");
        House house2 = new House(2);
        House house35 = new House(35);
        House house91 = new House(91);

        System.out.println(house2);
        System.out.println(house35);
        System.out.println(house91);

        // cannot assign a value to final variable qteFloor
        // System.out.println(house91.qteFloor = 95);

        // 1.4.5.
        System.out.println("\nЗадача 1.4.5.");
        // 1. Только имя
        Name nameOne = new Name(false, "Клеопатра");
        System.out.println(nameOne);

        // 2. Имя + Отчество + Фамилия (правильный порядок)
        Name nameTwo = new Name(true, "Александр", "Сергеевич", "Пушкин");
        System.out.println(nameTwo);

        // 3. Имя + Фамилия
        Name name3 = new Name(true, "Владимир", "Маяковский");
        System.out.println(name3);

        // 4. Имя + Фамилия (Бонифатьевич - фамилия)
        Name name4 = new Name(true, "Христофор", "Бонифатьевич");
        System.out.println(name4);


        // 1.4.6.
        System.out.println("\nЗадача 1.4.6.");
        Name sergey = new Name("Сергей", null, "Пушкин");

        Human pers1 = new Human("Лев");
        System.out.println(pers1); // Должно корректно вывести "Лев"

        Human pers2 = new Human(sergey, pers1);
        System.out.println(pers2); // Должно корректно вывести "Пушкин Сергей Львович"

        Human pers3 = new Human("Александр", pers2);
        System.out.println(pers3); // Должно вывести "Пушкин Александр Сергеевич"

        // 1.4.7.
        System.out.println("\nЗадача 1.4.7.");
        Student studentVasya = new Student("Вася", new int [] {3, 4, 5});
        System.out.println(studentVasya);

        Student studentMax = new Student("Максим");
        System.out.println(studentMax);

        // 1.4.8.
        System.out.println("\nЗадача 1.4.8.");
        // Создание города только с названием
        City cityOne = new City("Москва");

        // Создание города с названием и набором путей
        List<Path> paths = new ArrayList<>();
        paths.add(new Path(new City("Санкт-Петербург"), 100));
        paths.add(new Path(new City("Казань"), 200));
        City cityTwo = new City("Москва", paths);

        // Добавление нового пути в город
        cityTwo.addPath(new City("Тверь"), 50);

        System.out.println(cityOne);
        System.out.println(cityTwo);
    }
}
