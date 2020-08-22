package main;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] M, int[] N) {
        int m = M.length, n = N.length;

        if (m > n) return findMedianSortedArrays(N, M);

        int iMin = 0, iMax = m, half = (m + n + 1) / 2;
        while (iMin <= iMax) {
            //     left         right      (left == right) or (left == right + 1) == half
            //  M[0 .. i-1]    M[i ..]
            //             \  /
            //              \/  Needs to ensure that:
            //              /\  M[i] > N[j - 1] && M[i - 1] < N[j]
            //             /  \
            // N[0 .. j-1]     N[j ..]
            int i = (iMin + iMax) / 2, j = half - i;
            System.out.println("iMin: " + iMin + ", iMax: " + iMax + ", i: " + i + ", j: " + j);
            if (i < iMax && M[i] < N[j - 1]) { // Right M is smaller than left N
                iMin = i + 1; // Increase i by increasing the lower bound, decrease j
            } else if (i > iMin && M[i - 1] > N[j]) { // Left M is larger than right N
                iMax = i - 1; // Decrease i by decreasing the upper bound, increase j
            } else { // Found a good i
                int leftMax = 0;
                if (i == 0) leftMax = N[j - 1]; // No element in M is in the new left side
                else if (j == 0) leftMax = M[i - 1]; // No element in N is in the new left side, i.e. {1,2}, {3,4}
                else leftMax = Math.max(N[j - 1], M[i - 1]);
                if ((m + n) % 2 == 1) return leftMax;

                int rightMin = 0;
                if (i == m) rightMin = N[j];
                else if (j == n) rightMin = M[i];
                else rightMin = Math.min(N[j], M[i]);
                System.out.println(N[j] + " " + M[i]);
                return (leftMax + rightMin) / 2.0;
            }
        }

        return 0;
    }
}
