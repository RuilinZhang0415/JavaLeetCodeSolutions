package main;

import java.util.Arrays;

public class MovingAverage {
    private int data[], curr = 0, sum = 0, size = 0;

    public MovingAverage(int size) {
        data = new int[size];
    }

    public double next(int val) {
        int prev = data[curr];
        data[curr] = val;
        sum += val - prev;
        curr = (curr + 1) % data.length;
        size++;

        return sum * 1.0 / Math.min(size, data.length);
    }

    public static void main(String[] args) {
        MovingAverage test = new MovingAverage(4);

        System.out.println(test.next(1));
        for (int i: test.data) System.out.print(i + ", ");
        System.out.println();

        System.out.println(test.next(1));
        for (int i: test.data) System.out.print(i + ", ");
        System.out.println();
        System.out.println(test.curr);

        System.out.println(test.next(2));
        for (int i: test.data) System.out.print(i + ", ");
        System.out.println();

        System.out.println(test.next(2));
        for (int i: test.data) System.out.print(i + ", ");
        System.out.println();
    }
}
