package main;

public class MaximumAverageSubarrayII {
    public double findMaxAverage(int[] nums, int k) {
        double min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int n: nums) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        double prev_mean = max, mean = (max + min) / 2;
        while (Math.abs(mean - prev_mean) > 0.00001) {
            if (didFindSumNonNegative(nums, mean, k)) {
                min = mean;
            } else {
                max = mean;
            }
            prev_mean = mean;
            mean = (max + min) / 2;
        }

        return mean;
    }

    private boolean didFindSumNonNegative(int[] nums, double toSubtract, int k) {
        double sum = 0; // sum is the sum from nums[0] to nums[i]
        double prev = 0; // prev is the sum from nums[0] to nums[i - k]
        double min_prev = 0; // min_prev is the min of all prev values
        for (int i = 0; i < k; i++) {
            sum += nums[i] - toSubtract;
        }
        if (sum >= 0) return true;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - toSubtract;
            prev += nums[i - k] - toSubtract;
            min_prev = Math.min(prev, min_prev);
            if (sum - min_prev >= 0) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        MaximumAverageSubarrayII test = new MaximumAverageSubarrayII();
        int[] arr = new int[] {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(test.findMaxAverage(arr, 4));
    }
}
