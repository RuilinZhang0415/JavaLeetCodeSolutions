package test;

import main.ContiguousArray;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContiguousArrayTest {
    @Test
    public void test() {
        ContiguousArray test = new ContiguousArray();

        int[] arr = {};
        assertEquals(0, test.findMaxLength(arr));

        arr = new int[] {1, 1, 1, 0, 0, 0};
        assertEquals(6, test.findMaxLength(arr));
    }
}
