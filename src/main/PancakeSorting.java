package main;

import java.util.LinkedList;
import java.util.List;

public class PancakeSorting {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> result = new LinkedList<>();
        int size = arr.length - 1;
        while (size > 0) {
            int maxIdx = 0;
            for (int i = 0; i <= size; i++) if (arr[i] > arr[maxIdx]) maxIdx = i;
            if (maxIdx != size) {
                if (maxIdx != 0) {
                    flip(arr, 0, maxIdx);
                    result.add(maxIdx + 1);
                }
                flip(arr, 0, size);
                result.add(size + 1);
            }
            size--;
        }

        return result;
    }

    private void flip(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    }

    private void swap(int[] arr, int l, int h) {
        int temp = arr[l];
        arr[l] = arr[h];
        arr[h] = temp;
    }
}
