package test;

import main.MinimumPossibleIntegerAfterAtMostKAdjacentSwapsOnDigits;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumPossibleIntegerAfterAtMostKAdjacentSwapsOnDigitsTest {
    MinimumPossibleIntegerAfterAtMostKAdjacentSwapsOnDigits obj =
            new MinimumPossibleIntegerAfterAtMostKAdjacentSwapsOnDigits();

    @Test
    public void testminInteger0() {
        String s = "4321";
        int k = 3;
        assertEquals("1432", obj.minInteger(s, k));
        k = 4;
        assertEquals("1342", obj.minInteger(s, k));
        k = 5;
        assertEquals("1243", obj.minInteger(s, k));
        k = 6;
        assertEquals("1234", obj.minInteger(s, k));
        k = 7;
        assertEquals("1234", obj.minInteger(s, k));
    }

    @Test
    public void testminInteger1() {
        String s = "9438957234785635408";
        int k = 23;
        assertEquals("0345989723478563548", obj.minInteger(s, k));
    }
}
