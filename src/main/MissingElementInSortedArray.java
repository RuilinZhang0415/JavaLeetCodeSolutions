package main;

public class MissingElementInSortedArray {
/*************** Simple Binary Search ***************/
    public int missingElement(int[] nums, int k) {
        int len = nums.length;
        if (len == 1) {
            return nums[0] + k;
        }
        // Count of missing element between first and last number
        int num_missing = (nums[len - 1] - nums[0] - 1) - (len - 2);
        if (k > num_missing) {
            return nums[len - 1] + k - num_missing;
        }
        // The missing element is now guaranteed to appear between first and last number
        int low = 0, high = len - 1;

        while (true) {
            if (high - low == 1) {
                return nums[low] + k;
            } else {
                int mid = (low + high) / 2;
                // Count of missing elements in left part
                int num_missing_left = (nums[mid] - nums[low] - 1) - (mid - low - 1);
                if (k <= num_missing_left) {
                    high = mid;
                } else {
                    k = k - num_missing_left;
                    low = mid;
                }
            }
        }
    }

/*************** Recursive Binary Search ***************/
//    public int missingElement(int[] nums, int k) {
//        int len = nums.length;
//        if (len == 1) {
//            return nums[0] + k;
//        }
//        // Count of missing element between first and last number
//        int num_missing = (nums[len - 1] - nums[0] - 1) - (len - 2);
//        if (k > num_missing) {
//            return nums[len - 1] + k - num_missing;
//        }
//        // The missing element is now guaranteed to appear between first and last number
//        return missingElementAux(nums, k, 0 , len - 1);
//    }
//
//    private int missingElementAux(int[] nums, int k, int low, int high) {
//        if (high - low == 1) {
//            return nums[low] + k;
//        } else {
//            int mid = (low + high) / 2;
//            // Count of missing elements in left part
//            int num_missing_left = (nums[mid] - nums[low] - 1) - (mid - low - 1);
//            if (k <= num_missing_left) {
//                return missingElementAux(nums, k, low, mid);
//            } else {
//                return missingElementAux(nums, k - num_missing_left, mid, high);
//            }
//        }
//    }

/*************** Linear Search ***************/
//    public int missingElement(int[] nums, int k) {
//        int index = 1, len = nums.length;
//
//        while (index < len) {
//            if (nums[index] - nums[index - 1] > k) {
//                return nums[index - 1] + k;
//            }
//            k = k - (nums[index] - nums[index - 1]) + 1;
//            index++;
//        }
//
//        return nums[index - 1] + k;
//    }

    public static void main(String[] args) {
        MissingElementInSortedArray test = new MissingElementInSortedArray();
        int[] arr = new int[] {2,5,6,8,10};
        System.out.println(test.missingElement(arr, 1));
    }
}
