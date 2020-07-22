package main;

public class MaximumAverageSubarrayI {
//    Given an array consisting of n integers, find the contiguous subarray of given length k that
//    has the maximum average value. And you need to output the maximum average value.
    public double findMaxAverage(int[] nums, int k) {
        int len = nums.length, max_sum = Integer.MIN_VALUE;
        int curr_sum = 0, prev_sum = 0;
        if (len == 1) return nums[0] * 1.0;

        for (int i = 0; i < len; i++) {
            curr_sum += nums[i];

            if (i - k + 1 >= 0) {
                prev_sum += nums[i - k + 1];
                max_sum = Math.max(max_sum, curr_sum - prev_sum + nums[i - k + 1]);
            }
        }

        return max_sum * 1.0 / k;
    }



//    public double findMaxAverage(int[] nums, int k) {
//        int len = nums.length, max_sum = Integer.MIN_VALUE;
//        int[] sums = new int[len];
//        if (len == 1) return nums[0] * 1.0;
//
//        for (int i = 0; i < len; i++) {
//            if (i == 0) {
//                sums[0] = nums[0];
//            } else {
//                sums[i] = sums[i - 1] + nums[i];
//            }
//
//            if (i - k + 1 >= 0) {
//                max_sum = Math.max(max_sum, sums[i] - sums[i - k + 1] + nums[i - k + 1]);
//            }
//        }
//
//        return max_sum * 1.0 / k;
//    }

    public static void main(String[] args) {
        MaximumAverageSubarrayI test = new MaximumAverageSubarrayI();
        int[] arr = new int[] {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(test.findMaxAverage(arr, k));
    }
}
