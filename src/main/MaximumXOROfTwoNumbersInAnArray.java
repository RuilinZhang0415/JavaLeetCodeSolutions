package main;

import java.util.*;

public class MaximumXOROfTwoNumbersInAnArray {
    public int findMaximumXOR(int[] nums) {
        int maxNum = nums[0];
        for(int num : nums) maxNum = Math.max(maxNum, num);
        int len = (Integer.toBinaryString(maxNum)).length();

        int maxXor = 0, currXor;
        for(int i = len - 1; i >= 0; i--) {
            maxXor <<= 1;
            currXor = maxXor | 1;
            Set<Integer> prefixes = new HashSet<>();
            for(int num: nums) prefixes.add(num >> i);

            for(int p: prefixes) {
                if (prefixes.contains(currXor ^ p)) {
                    maxXor = currXor;
                    break;
                }
            }
        }
        return maxXor;
    }
}
