package ru.geekbrains.lesson5;

import java.util.Random;

public class Dog extends Animal {
    public Dog() {
        super(0.5f + RANDOM.nextInt(10)/10f, 400 + RANDOM.nextInt(200), 10 + RANDOM.nextInt(5));
    }


    @Override
    public String run(float distance) {

        if (distance > maxDistanceRun)
            return "Песик недобежал...(((";
        else
            return "Песик пробежал!";
    }

    @Override
    public String swim(float distance) {
        if (distance > maxDistanceSwim)
            return "Песика жалко...";
        else
            return "ПЕС проплыл!";
    }

    @Override
    public String jumpOverObstacle(float height) {
        if (height>maxJumpHeight)
            return "Пес споткнулся и упал мордой вниз... За что вы так с ним?";
        else
            return "Пес молодец! Перепрыгнул такую высоту!";
    }
}
