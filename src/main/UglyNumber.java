package main;

public class UglyNumber {
    public int[] results = new int[1690];
    int curr = 0, i1 = 0, i2 = 0, i3 = 0;

    UglyNumber() {
        results[0] = 1;
    }

    public int nthUglyNumber(int n) {
        if (n - 1 <= curr) return results[n - 1];

        for (int i = curr + 1; i < n; ++i) {
            results[i] = Math.min(results[i3] * 5, Math.min(results[i1] * 2, results[i2] * 3));

            if (results[i1] * 2 == results[i]) ++i1;
            if (results[i2] * 3 == results[i]) ++i2;
            if (results[i3] * 5 == results[i]) ++i3;
        }

        return results[n - 1];
    }

//    public int nthUglyNumber(int n) {
//        SortedSet<Integer> next = new TreeSet<Integer>();
//        int curr = 1;
//        next.add(1);
//
//        for (int i = 0; i < n; i++) {
//            curr = next.first();
//            System.out.print(curr + " ");
//
//            next.add(curr * 2);
//            next.add(curr * 3);
//            next.add(curr * 5);
//
//            next.remove(curr);
//            }
//        }
//
//        return curr;
//    }

    public static void main(String[] args) {
        UglyNumber test = new UglyNumber();
        System.out.println(test.nthUglyNumber(1690));
        for (int i = 0; i < 1690; i++) {
            System.out.println(test.results[i]);
        }
        System.out.println(test.results[999]);
    }
}

