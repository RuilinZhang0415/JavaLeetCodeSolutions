package main;

import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 0) return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i: stones) pq.offer(i);
        while (pq.size() > 1) {
            int delta = pq.poll() - pq.poll();
            if (delta != 0) pq.offer(delta);
        }

        return pq.size() == 0 ? 0 : pq.poll();
    }

//    public int lastStoneWeight(int[] stones) {
//        if (stones.length == 0) return 0;
//        if (stones.length == 1) return stones[0];
//
//        int max = 0;
//        for (int i: stones) {
//            max = Math.max(max, i);
//        }
//        int bucket[] = new int[max + 1];
//        for (int i: stones) {
//            bucket[i]++;
//        }
//
//        int curr = max, carry = 0;
//        while (curr >= 0) {
//            System.out.println("carry: " + carry + ", curr:" + curr);
//
//            if (carry != 0 && bucket[curr] != 0) {
//                while (carry - curr >= 0 && bucket[curr] > 0) {
//                    carry -= curr;
//                    bucket[curr]--;
//                }
//                if (carry < curr) {
//                    bucket[carry]++;
//                    carry = 0;
//                }
//            }
//
//            if (bucket[curr] % 2 != 0) carry = curr;
//            curr--;
//        }
//
//        return carry;
//    }
}
