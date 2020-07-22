package main;

import java.util.Arrays;

public class CanMakeArithmeticProgressionFromSequence {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length < 2) return false;

        Arrays.sort(arr);
        int delta = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) if (arr[i] - arr[i - 1] != delta) return false;

        return true;
    }

    public static void main(String[] args) {
        CanMakeArithmeticProgressionFromSequence test = new CanMakeArithmeticProgressionFromSequence();
        int[] arr = new int[] {3,5,1};
        System.out.println(test.canMakeArithmeticProgression(arr));
        arr = new int[] {1,2,4};
        System.out.println(test.canMakeArithmeticProgression(arr));
    }
}
