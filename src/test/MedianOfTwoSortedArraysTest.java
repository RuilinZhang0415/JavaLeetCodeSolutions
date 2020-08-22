package test;

import main.MedianOfTwoSortedArrays;
import org.junit.Test;

import static org.junit.Assert.*;

public class MedianOfTwoSortedArraysTest {
    @Test
    public void test() {
        MedianOfTwoSortedArrays test = new MedianOfTwoSortedArrays();
        double delta = 0.00001;
        int[] a = {1, 2}, b = {3, 4, 5};
        assertEquals(3.0, test.findMedianSortedArrays(a, b), delta);
        assertEquals(3.0, test.findMedianSortedArrays(b, a), delta);

        a = new int[] {1, 7, 8}; b = new int[] {2, 3, 4};
        assertEquals(3.5, test.findMedianSortedArrays(a, b), delta);

        a = new int[] {1, 3, 5, 7, 9}; b = new int[] {2, 4, 6, 8, 10};
        assertEquals(5.5, test.findMedianSortedArrays(a, b), delta);
    }
}
