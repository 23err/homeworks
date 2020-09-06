package ru.geekbrains.lesson1;

//lesson 1
public class Lesson1 {
    public static void main(String[] args) {
        System.out.println("task 1");
        System.out.println(calculateUseFormula(2, 2, 3, 4));
        System.out.println("---------------------------");
        System.out.println("task 2");
        System.out.println(numberBetween(5, 10));
        System.out.println("---------------------------");
        System.out.println("task 3");
        System.out.println(isPositiveNumber(-2) ? "Postiive" : "Negative");
        System.out.println("---------------------------");
        System.out.println("task 4");
        System.out.println(getHelloName("Philipp"));
        System.out.println("---------------------------");
        System.out.println("task 5");
        System.out.println(isLeapYear(2004));


    }

    //task 1
    private static float calculateUseFormula(int a, int b, int c, int d) {
        return a * (b + ((float) c / d));
    }

    //task 2
    private static boolean numberBetween(int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <= 20) return true;
        return false;
    }

    //task 3
    private static boolean isPositiveNumber(int number) {
        if (number >= 0) return true;
        return false;
    }

    //task 4
    private static String getHelloName(String name) {
        return "Привет, " + name + "!";
    }

    //task 5
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && !(year % 100 == 0) || year % 400 == 0);
    }

}
