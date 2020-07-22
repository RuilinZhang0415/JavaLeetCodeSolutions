package main;

public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] result = new long[n];
        result[0] = 1;
        int[] ptrs = new int[primes.length];

        for (int i = 1; i < n; i++) {
            long[] allUglys = new long[primes.length];
            for (int j = 0; j < primes.length; j++) {
                allUglys[j] = primes[j] * result[ptrs[j]];
            }

            result[i] = minOfArray(allUglys);

            for (int j = 0; j < primes.length; j++) {
                if (allUglys[j]  == result[i]) ptrs[j]++;
            }
        }

//        for (int i = 0; i < n; i++) {
//            System.out.println(result[i]);
//        }

        return (int)result[n - 1];
    }

    private long minOfArray(long[] arr) {
        long min = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
        }

        return min;
    }


//    public int nthSuperUglyNumber(int n, int[] primes) {
//        SortedSet<Long> next = new TreeSet<>();
//        next.add(1L);
//        long curr = next.first();
//        int size = primes.length;
//
//        for (int i = 0; i < n; i++) {
//            curr = next.first();
//
//            for (int j = 0; j < size; j++) {
//                next.add(curr * primes[j]);
//            }
//
//            next.remove(curr);
//        }
//
//        return (int)curr;
//    }

    public static void main(String[] args) {
        SuperUglyNumber test = new SuperUglyNumber();
        int[] arr = new int[] {2, 7, 13, 9};
        test.nthSuperUglyNumber(12, arr);
    }
}
