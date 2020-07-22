package main;

public class RLEIterator {
    private int[] arr;
    private int curr = 0, len;

    public RLEIterator(int[] A) {
        len = A.length;
        arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = A[i];
        }
    }

    public int next(int n) {
        while (n > 0) {
            if (curr >= len) {
                return -1;
            } else if (arr[curr] >= n) {
                arr[curr] -= n;
                return arr[curr + 1];
            } else {
                n -= arr[curr];
                arr[curr] = 0;
                curr += 2;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int [] arr = new int[] {3,8,0,9,2,5};
        RLEIterator test = new RLEIterator(arr);
        System.out.println(test.next(2));
        System.out.println(test.next(1));
        System.out.println(test.next(1));
        System.out.println(test.next(2));
    }
}
