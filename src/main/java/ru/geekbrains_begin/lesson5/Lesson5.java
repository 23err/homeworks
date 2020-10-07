package ru.geekbrains.lesson5;

import java.util.Random;

public class Lesson5 {
    public static void main(String[] args) {
        Animal cat = new Cat();
        Animal dog = new Dog();

        System.out.println(cat.jumpOverObstacle(1));
        System.out.println(cat.jumpOverObstacle(4));
        System.out.println(cat.run(250));
        System.out.println(cat.run(200));
        System.out.println(cat.swim(1));

        System.out.println(dog.jumpOverObstacle(10));
        System.out.println(dog.jumpOverObstacle(0.3f));
        System.out.println(dog.run(700));
        System.out.println(dog.run(100));
        System.out.println(dog.swim(500));
        System.out.println(dog.swim(1));

    }
}
