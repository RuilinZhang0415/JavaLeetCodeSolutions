package test;

import main.LastStoneWeight;
import org.junit.Test;

import java.util.PriorityQueue;

import static org.junit.Assert.*;

public class LastStoneWeightTest {
    @Test
    public void test() {
        LastStoneWeight test = new LastStoneWeight();

        int[] arr = {2,7,4,1,8,1};
        assertEquals(1, test.lastStoneWeight(arr));

        System.out.println();
        arr = new int[] {3, 1};
        assertEquals(2, test.lastStoneWeight(arr));
    }
}
