package ru.geekbrains.lesson5;

import java.util.Random;

/*
Создать классы Собака и Кот с наследованием от класса Животное.
Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие. В качестве параметра каждому методу передается величина, означающая или длину препятствия (для бега и плавания), или высоту (для прыжков).
У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; прыжок: кот 2 м., собака 0.5 м.; плавание: кот не умеет плавать, собака 10 м.).
При попытке животного выполнить одно из этих действий, оно должно сообщить результат. (Например, dog1.run(150); -> результат: 'Пёсик пробежал!')
* Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м.
 */
abstract public  class Animal {
    protected float  maxJumpHeight, maxDistanceRun, maxDistanceSwim;
    protected final static Random RANDOM = new Random();

    public Animal(float maxJumpHeight, float maxDistanceRun, float maxDistanceSwim){
        this.maxJumpHeight = maxJumpHeight;
        this.maxDistanceRun = maxDistanceRun;
        this.maxDistanceSwim = maxDistanceSwim;
    }


    abstract public String run(float distance);
    abstract public String swim(float distance);
    abstract public String jumpOverObstacle(float height);

}
