package ru.geekbrains.lesson4;

public class Lesson4 {


    public static void main(String[] args) {
        Employeе employeе1 = new Employeе("Phil", 200000, 29);
        System.out.println("имя сотрудника: " + employeе1.getName());
        System.out.println("возраст сотрудника: " + employeе1.getAge());


        //Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
        Employeе[] employeеs = {
                new Employeе("Филипп", 250000, 29),
                new Employeе("Максим", 300000, 31),
                new Employeе("Kистаман", 300000, 31),
                new Employeе("Андрей", 70000, 42),
                new Employeе("Илья", 50000, 49),
        };

        //С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
        for (int i = 0; i < employeеs.length; i++) {
            Employeе employeе = employeеs[i];
            if (employeе.getAge() > 40)
                System.out.printf("---------------%nФИО:%s%nВозраст:%d%nЗарплата:%d%n",
                        employeе.getName(), employeе.getAge(), employeе.getSalary());

        }

        upSalary(employeеs);

        System.out.println();
        System.out.println("============================");


        //Подсчитать средние арифметические зарплаты и возраста
        int sumSalaries = 0, sumAges = 0;
        for (int i = 0; i < employeеs.length; i++) {
            sumSalaries += employeеs[i].getSalary();
            sumAges += employeеs[i].getAge();

        }
        System.out.println("Средняя зарплата сотрудника: " + sumSalaries / employeеs.length);
        System.out.println("Средний возраст сотрудника: " + sumAges / employeеs.length);

    }

    //Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000.
    //повышение зарплаты всем сотрудникам старше 45 лет
    public static void upSalary(Employeе[] employeеs) {
        for (int i = 0; i < employeеs.length; i++) {
            Employeе employeе = employeеs[i];
            if (employeе.getAge() > 45) {
                employeе.setSalary(employeе.getSalary() + 5000);
            }

        }
    }
}
