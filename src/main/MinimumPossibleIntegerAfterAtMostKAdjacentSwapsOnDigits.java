package main;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumPossibleIntegerAfterAtMostKAdjacentSwapsOnDigits {
    public String minInteger(String num, int k) {
        char[] num_arr = num.toCharArray();
        int len = num.length(), BITree[] = new int[len + 1];
        Deque<Integer> queues[] = new ArrayDeque[10];
        for (int i = 0; i < 10; i++) queues[i] = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            queues[num_arr[i] - '0'].offerLast(i); // push the index into nth queue
            update(BITree, i, 1); // update the index's position
        }

        char result[] = new char[len];
        int curr = 0;
        for (int iter = 0; iter < len; iter++) {
            for (int i = 0; i < 10; i++) {
                if (queues[i].isEmpty()) continue;
                int index = queues[i].peekFirst();
                if (query(BITree, index) - 1 > k) continue;
                k -= query(BITree, index) - 1;
                queues[i].removeFirst();
                num_arr[index] = 'a';
                update(BITree, index, -1);
                result[iter] = ((char)('0' + i));
                break;
            }
            if (k == 0) {
                curr = iter + 1;
                break;
            }
        }

        for (int i = 0; i < len; i++) {
            if (num_arr[i] <= '9') {
                result[curr++] = num_arr[i];
            }
        }

        return new String(result);
    }

    public void update(int[] BITree, int i, int val) {
        i += 1; // Convert 0-based index to 1-based
        int n = BITree.length - 1;
        for (; i <= n; i += i&-i) BITree[i] += val;
    }

    public int query(int[] BITree, int i) {
        i += 1;// Convert 0-based index to 1-based
        int sum = 0;
        for (; i > 0; i -= i&-i) sum += BITree[i];
        return sum;
    }

    /******************** Brute Force ********************/
//    public String minInteger(String num, int k) {
//        int len = num.length();
//        char arr[] = num.toCharArray();
//
//        for (int i = 0; i < len; i++) {
//            if (arr[i] == '0') continue;
//
//            int min_index = i, bound = i + k + 1 <= len ? i + k + 1 : len;
//            for (int j = i; j < bound; j++) if (arr[j] < arr[min_index]) min_index = j;
//
//            char min_char = arr[min_index];
//            for (int j = min_index - 1; j >= i; j--) arr[j + 1] = arr[j];
//            arr[i] = min_char;
//
//            k -= min_index - i;
//            if (k == 0) break;
//        }
//
//        return new String(arr);
//    }
}
