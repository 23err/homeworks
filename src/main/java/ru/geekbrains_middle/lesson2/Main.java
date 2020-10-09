package ru.geekbrains_middle.lesson2;

import java.util.Arrays;

public class Main {

    private static final int X_LENGTH = 4;
    private static final int Y_LENGTH = 4;

    public static void main(String[] args) {
        String text = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        try{
            String[][] result = getArray(text);
            for (int i = 0; i < result.length; i++) {
                System.out.println(Arrays.toString(result[i]));
            }
            System.out.println(getExpressionResult(result));

        } catch (ArraySizeException e) {
            e.printStackTrace();
        } catch (StringNotNumberException e) {
            e.printStackTrace();
        }

    }

    private static float getExpressionResult(String[][] result) throws ArraySizeException, StringNotNumberException {
        checkLengthGenerateException(result);

        int sum = 0;

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                checkStringForIntGenerateException(result[i][j]);
                int item = Integer.valueOf(result[i][j]);
                sum += item;
            }
        }
        return sum / 7f;

    }

    private static String[][] getArray(String text) throws StringNotNumberException, ArraySizeException {
        String[] arr = text.split("\n");
        int yLength = arr.length;

        String[][] result = new String[yLength][];
        for (int i = 0; i < yLength; i++) {
            result[i] = arr[i].split("\\s");
            for (int j = 0; j < result[i].length; j++) {
                checkStringForIntGenerateException(result[i][j]);
            }
        }
        checkLengthGenerateException(result);

        return result;
    }

    private static void checkStringForIntGenerateException(String item) throws StringNotNumberException{
        try{
            Integer.parseInt(item);
        } catch (NumberFormatException e){
            throw new StringNotNumberException("Array contains not number");
        }
    }

    private static void checkLengthGenerateException(Object[][] arr) throws ArraySizeException{
        checkLength(arr, Y_LENGTH);
        for (int i = 0; i < arr.length; i++) {
            checkLength(arr[i], X_LENGTH);
        }

    }

    private static void checkLength(Object[] arr, int length) throws ArraySizeException{
        if (arr.length != length) throw new ArraySizeException("array size != [" + Y_LENGTH + "," + X_LENGTH + "]");
    }


}
