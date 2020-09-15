package ru.geekbrains.lesson4;

/*
Создать класс "Сотрудник" с полями: ФИО, зарплата, возраст;
Конструктор класса должен заполнять эти поля при создании объекта;
Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого поля;
Вывести при помощи методов из пункта 3 ФИО и возраст.
Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
* Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000.
* Подсчитать средние арифметические зарплаты и возраста
*** Продумать конструктор таким образом, чтобы при создании каждому сотруднику присваивался личный уникальный идентификационный порядковый номер
 */
public class Employeе {
    private static int lastUid = 0;

    private String name;
    private int salary, age, uid;

    public Employeе(String name, int salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        uid = ++lastUid;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getUid() {
        return uid;
    }
}
