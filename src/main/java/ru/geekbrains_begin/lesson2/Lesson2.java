package ru.geekbrains.lesson3;

import java.util.Arrays;

public class Lesson2 {
    public static void main(String[] args) {
        //task 1
        System.out.println("task 1");
        int[] arrTask1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(getOppositeValueArray(arrTask1)));

        //task 2
        System.out.println("-----------\ntask 2");
        int[] arrTask2 = new int[8];

        System.out.println(Arrays.toString(fillArrayWithStep3(arrTask2)));

        //task 3
        System.out.println("-----------\ntask 3");
        int[] arrTask3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(changeArrValue(arrTask3)));

        //task 4
        System.out.println("-----------\ntask 4");
        int[] arrTask4 = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("getMaxValueInArray(arrTask4) = " + getMaxValueInArray(arrTask4));
        System.out.println("getMinValueInArray(arrTask4) = " + getMinValueInArray(arrTask4));

        //task 5
        System.out.println("-----------\ntask 5");

        int[][] arrTask5 = getArrWithFilledDiagonal(7);

        for (int i = 0; i < arrTask5.length; i++) {
            for (int j = 0; j < arrTask5[i].length; j++) {
                System.out.printf("%3d", arrTask5[i][j]);
            }
            System.out.println();
        }

        //task 6
        System.out.println("-----------\ntask 6");
        int[] arrTask6 = {1, 2, 1, 2, 1, 1};
        System.out.println(Arrays.toString(arrTask6));
        System.out.println(isEquilateralArray(arrTask6));

        //task 7
        System.out.println("-----------\ntask 7");
        int[] arrTask7 = {1, 2, 3, 4, 5, 6, 7, 8};
        int count = -3;
        System.out.println(Arrays.toString(moveElementsInArray(arrTask7, count)));

        //task 8
        System.out.println("-----------\ntask 8");
        System.out.println(Arrays.toString(moveElementsInArrayWithoutSecArr(arrTask7, count)));

    }

    /*1 Задать целочисленный массив, состоящий из элементов 0 и 1.
    Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0;
     */
    private static int[] getOppositeValueArray(int[] arrTask1) {
        for (int i = 0; i < arrTask1.length; i++) {
            arrTask1[i] = arrTask1[i] == 1 ? 0 : 1;
        }
        return arrTask1;
    }

    /*2 Задать пустой целочисленный массив размером 8.
    Написать метод, который помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22;
     */
    private static int[] fillArrayWithStep3(int[] arrTask2) {
        arrTask2[0] = 1;
        for (int i = 1; i < arrTask2.length; i++) {
            arrTask2[i] = arrTask2[i-1] + 3;
        }
        return arrTask2;
    }

    /*3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], написать метод,
    принимающий на вход массив и умножающий числа меньше 6 на 2;
     */
    private static int[] changeArrValue(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6)
                arr[i] *= 2;
        }
        return arr;
    }

    /*4 Задать одномерный массив. Написать методы поиска в нём минимального
    и максимального элемента;
     */
    private static int getMaxValueInArray(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    /*4 Задать одномерный массив. Написать методы поиска в нём минимального
    и максимального элемента;
     */
    private static int getMinValueInArray(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
        }
        return min;
    }

    /*5 Создать квадратный целочисленный массив (количество строк и столбцов одинаковое),
    заполнить его диагональные элементы единицами, используя цикл(ы);
     */
    private static int[][] getArrWithFilledDiagonal(int size) {
        int[][] arrTask5 = new int[size][size];
        for (int i = 0; i < arrTask5.length; i++) {
            arrTask5[i][i] = 1;
            arrTask5[i][arrTask5.length-1-i] = 1;
        }
        return arrTask5;
    }

    /*6 ** Написать метод, в который передается не пустой одномерный целочисленный массив,
    метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части
    массива равны. Примеры: checkBalance([1, 1, 1, || 2, 1]) → true,
    checkBalance ([2, 1, 1, 2, 1]) → false, checkBalance ([10, || 1, 2, 3, 4]) → true.
    Абстрактная граница показана символами ||, эти символы в массив не входят.
     */
    private static boolean isEquilateralArray (int[] arr) {
        int leftSum = 0, rightSum = 0;
        for (int i = 0; i < arr.length; i++) {
            rightSum += arr[i];
        }
        for (int i = 0; i < arr.length - 1; i++) {
            leftSum += arr[i];
            rightSum -= arr[i];
            if (leftSum == rightSum) {
                return true;
            }
        }
        return false;
    }

    /*
    7 *** Написать метод, которому на вход подаётся одномерный массив и число n
    (может быть положительным, или отрицательным), при этом метод должен циклически
    сместить все элементы массива на n позиций.
     */
    private static int[] moveElementsInArray(int[] arr, int count) {
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int index = (arr.length + count + i) % arr.length;
            result[index] = arr[i];
        }

        return result;
    }

    /*
    8 **** Не пользоваться вспомогательным массивом при решении задачи 7.
     */
    private static int[] moveElementsInArrayWithoutSecArr(int[] arr, int count) {

        if (arr.length <= 1) return arr;

        int countOne = count >= 0 ? 1 : -1;

        for (int i = 0; i < Math.abs(count); i++) {
            int currentIndex = 0, nextIndex = 1, temp = arr[currentIndex];
            while (nextIndex != 0) {
                nextIndex = (arr.length + countOne + currentIndex) % arr.length;
                int currentTemp = arr[nextIndex];
                arr[nextIndex] = temp;
                temp = currentTemp;
                currentIndex = nextIndex;
            }
        }

        return arr;
    }
}

