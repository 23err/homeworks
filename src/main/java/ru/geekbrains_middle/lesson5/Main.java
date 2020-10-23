package ru.geekbrains_middle.lesson5;

import java.util.Arrays;

public class Main {
    static final int SIZE = 10_000_000;
    static final int H = SIZE / 2;


    public static void main(String[] args) {
        method1();
        method2();

    }

    private static void method2() {
        float[] arr = new float[SIZE];
        float[] arr1 = new float[H], arr2 = new float[H];
        Arrays.fill(arr, 1);
        long startTime = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, H);
        CountingArrayThread thread1 = new CountingArrayThread();
        thread1.setArr(arr1);
        thread1.start();

        System.arraycopy(arr, H, arr2, 0, H);
        CountingArrayThread thread2 = new CountingArrayThread();
        thread2.setArr(arr2);
        thread2.start();

        try {
            thread1.join();
            thread2.join();
            System.arraycopy(arr1, 0, arr, 0, H);
            System.arraycopy(arr2, 0, arr, H, H);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        long runTime = endTime - startTime;
        System.out.println("runTime method 2 = " + runTime);

    }

    private static void method1() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
                arr[i] = (float)(arr[i]*Math.sin(0.2f+i/5)* Math.cos(0.2f + i/5) * Math.cos(0.4f + i/2));
        }
        long endTime = System.currentTimeMillis();
        long runTime = endTime - startTime;
        System.out.println("runTime method 1 = " + runTime);
    }
}
