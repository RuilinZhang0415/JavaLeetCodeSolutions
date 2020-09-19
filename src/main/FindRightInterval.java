package main;

import java.util.Arrays;
import java.util.Comparator;

public class FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        int size = intervals.length;

        if (size == 1) return new int[] {-1};

        int[][] startPts = new int[size][2];
        for (int i = 0; i < size; i++) startPts[i] = new int[] {intervals[i][0], i};

        Arrays.sort(startPts, Comparator.comparingInt(o -> o[0]));

        int[] result = new int[size];
        for (int i = 0; i < size; i++) result[i] = findIndex(intervals[i][1], startPts);

        return result;
    }

    // Returns the smallest i such that arr[i][0] >= val, if no such i exists, return -1;
    public int findIndex(int val, int[][] arr) {
        int l = 0, h = arr.length - 1;

        while (l + 1 != h) {
            int m = (l + h) / 2;

            if (val <= arr[m][0]) h = m;
            else l = m;
        }

        if (val > arr[h][0]) return -1;
        else if (val > arr[l][0]) return arr[h][1];
        else return arr[l][1];
    }
}
