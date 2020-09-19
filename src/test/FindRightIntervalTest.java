package test;

import main.FindRightInterval;
import org.junit.Test;

import static org.junit.Assert.*;

public class FindRightIntervalTest {
    @Test
    public void test() {
        FindRightInterval test = new FindRightInterval();

        int[][] intervals = {{1,4}};
        int[] expected = {-1};
        assertArrayEquals(expected, test.findRightInterval(intervals));

        intervals = new int[][] {{3,4}, {2,3}, {1,2}};
        expected = new int[] {-1, 0, 1};
        assertArrayEquals(expected, test.findRightInterval(intervals));

        intervals = new int[][] {{1,4}, {2,3}, {3,4}};
        expected = new int[] {-1, 2, -1};
        assertArrayEquals(expected, test.findRightInterval(intervals));

//        for (int[] row: matrix) {
//            for (int i: row) System.out.print(i + ", ");
//            System.out.println();
//        }
    }
}
