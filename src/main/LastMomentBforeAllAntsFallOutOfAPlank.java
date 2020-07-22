package main;

public class LastMomentBforeAllAntsFallOutOfAPlank {
    public int getLastMoment(int n, int[] left, int[] right) {
        int l = left.length == 0 ? 0 : findMax(left, 0, left.length - 1);
        int r = right.length == 0 ? n : findMin(right, 0, right.length - 1);

        return Math.max(l, n - r);
    }

    public int findMax(int[] arr, int low, int high) {
        if (low == high) return arr[low];

        int mid = low + (high - low) / 2;
        return Math.max(findMax(arr, low, mid), findMax(arr, mid + 1, high));
    }

    public int findMin(int[] arr, int low, int high) {
        if (low == high) return arr[low];

        int mid = low + (high - low) / 2;
        return Math.min(findMin(arr, low, mid), findMin(arr, mid + 1, high));
    }

    public static void main(String[] args) {
        LastMomentBforeAllAntsFallOutOfAPlank test = new LastMomentBforeAllAntsFallOutOfAPlank();

        int[] arr = {1,2,3,4,3,2,1};
        System.out.println(test.findMax(arr, 0, arr.length - 1));
        System.out.println(test.findMin(arr, 0, arr.length - 1));
    }
}
