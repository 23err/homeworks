package ru.geekbrains_middle.lesson1;

import java.awt.*;
import java.util.Random;

public class Background extends Color {
    private final static Random RANDOM = new Random();
    private final static int RANDOM_STEP = 2;
    private static int red = 135;
    private static int green = 75;
    private static int blue = 85;


    public Background(Color color) {
        super(red, green, blue);
        red = getIntColor(red);
        green = getIntColor(green);
        blue = getIntColor(blue);
    }

    private int getIntColor(int color) {
        if (color == 255) return --color;
        if (color == 0 ) return ++color;
        return color + RANDOM.nextInt(RANDOM_STEP) - RANDOM.nextInt(RANDOM_STEP);

    }
}
