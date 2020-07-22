package main;

public class RotateArray {
    /******************** O(1) Space ********************/
//    public void rotate(int[] nums, int k) {
//        int len = nums.length, count = 0;
//        k = k % len;
//
//        for (int i = 0; count < len; i++) {
//            int curr = i, next_val = nums[curr];
//            do {
//                int next = (curr + k) % len;
//                int temp = nums[next];
//                nums[next] = next_val;
//                next_val = temp;
//                curr = next;
//
//                count++;
//            } while (curr != i);
//        }
//    }

    /******************** O(1) Space ********************/
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k= k % len;

        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    private void reverse(int[] nums, int low, int high) {
        while(low < high) {
            swap(nums, low++, high--);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    /******************** O(n) Space ********************/
//    public void rotate(int[] nums, int k) {
//        int len = nums.length;
//        k = k % len;
//
//        if (k == 0) return;
//
//        int[] temp = new int[k];
//        for (int i = 0; i < k; i++) {
//            temp[i] = nums[len - k + i];
//        }
//        System.out.println();
//        for (int i = len - k - 1; i >= 0; i--) {
//            nums[i + k] = nums[i];
//        }
//
//        for (int i = 0; i < k; i++) {
//            nums[i] = temp[i];
//        }
//    }

    public static void main(String[] args) {
        RotateArray test = new RotateArray();

        int[] nums = new int[] {1,2,3,4,5,6,7};
        int k = 3, len = nums.length;

        test.rotate(nums, k);

        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
