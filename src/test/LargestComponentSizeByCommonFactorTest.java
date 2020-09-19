package test;

import main.LargestComponentSizeByCommonFactor;
import org.junit.Test;

import static org.junit.Assert.*;

public class LargestComponentSizeByCommonFactorTest {
    @Test
    public void test() {
        LargestComponentSizeByCommonFactor test = new LargestComponentSizeByCommonFactor();

        int[] A = {4, 6, 15, 35};
        assertEquals(4, test.largestComponentSize(A));

        A = new int[] {20, 50, 9, 63};
        assertEquals(2, test.largestComponentSize(A));

        A = new int[] {2, 3, 6, 7, 4, 12, 21, 39};
        assertEquals(8, test.largestComponentSize(A));

        A = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertEquals(8, test.largestComponentSize(A));
    }
}
