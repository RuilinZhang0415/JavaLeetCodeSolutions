package main;

import java.util.Arrays;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;

        // Use count to record the diff between num of 1s and num of 0s
        // -n means num of 0 is n and n means num of 1 is n
        //
        // Use sum[] to record the first occurrence of each unique diff,
        // which can range from -n to n, for a total of 2n + 1
        // NOTE: one can use map as well, same idea
        //
        // Use maxLen to record the current max distance between any two diff with the same value
        int len = nums.length, sum[] = new int[2 * len + 1], count = 0, maxLen = 0;
        // Mark unseen indexes as -Inf
        Arrays.fill(sum, Integer.MIN_VALUE);
        // First occurrence of 0 is at index -1
        sum[len] = -1;

        for (int i = 0; i < nums.length; i++) {
            count += nums[i] == 1 ? 1 : -1;
            System.out.println("i: " + i + ", count: " + count);
            if (sum[len + count] < -1) {
                sum[len + count] = i;
            } else {
                maxLen = Math.max(maxLen, i - sum[len + count]);
            }
        }

        return maxLen;
    }
}
