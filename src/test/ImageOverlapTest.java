package test;

import main.ImageOverlap;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImageOverlapTest {
    @Test
    public void test() {
        ImageOverlap test = new ImageOverlap();
        int[][] A = {{1,1,0},{1,1,0},{0,0,0}};
        int[][] B = {{0,0,0},{0,1,1},{0,1,1}};
        int expected = 4;
        assertEquals(expected, test.largestOverlap(A, B));

        System.out.println();
        A = new int[][] {{0,0,0,0,0},{0,1,0,0,0},{0,0,1,0,0},{0,0,0,0,1},{0,1,0,0,1}};
        B = new int[][] {{1,0,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{0,1,1,1,1},{1,0,1,1,1}};
        expected = 5;
        assertEquals(expected, test.currOverlap(A, B, 0, -1));
    }
}
