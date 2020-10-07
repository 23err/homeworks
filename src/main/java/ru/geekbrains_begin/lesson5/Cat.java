package ru.geekbrains.lesson5;

public class Cat extends Animal {
    public Cat() {
        super(2 + RANDOM.nextInt(10)/10f, 200 + RANDOM.nextInt(100),0);
    }
    @Override
    public String run(float distance) {
        if (distance > maxDistanceRun)
            return "Котик недобежал...(((";
        else
            return "Котик пробежал!";
    }

    @Override
    public String swim(float distance) {
        return "Котики не умеют плавать! Не надо было проверять!";
    }

    @Override
    public String jumpOverObstacle(float height) {
        if (height>maxJumpHeight)
            return "Котик недопрыгнул...";
        else
            return "Кот молодец! Перепрыгнул такую высоту!";
    }
}
