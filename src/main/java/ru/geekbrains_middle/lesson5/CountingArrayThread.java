package ru.geekbrains_middle.lesson5;

public class CountingArrayThread extends Thread {

    private float arr[];
    @Override
    public void run() {
        if (arr == null){
            try {
                throw new NullArrayPassExeption("must pass array to this class");
            } catch (NullArrayPassExeption nullArrayPassExeption) {
                nullArrayPassExeption.printStackTrace();
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i]*Math.sin(0.2f+i/5)* Math.cos(0.2f + i/5) * Math.cos(0.4f + i/2));
        }

    }

    public void setArr(float[] arr) {
        this.arr = arr;
    }
    public float[] getArr(){
        return arr;
    }
}
