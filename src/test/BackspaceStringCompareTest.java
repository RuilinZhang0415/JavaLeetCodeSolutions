package test;

import main.BackspaceStringCompare;
import org.junit.Test;
import static org.junit.Assert.*;

public class BackspaceStringCompareTest {
    BackspaceStringCompare test = new BackspaceStringCompare();

    @Test
    public void testPrevCharIndex() {
        char[] arr = {'#', 'a', 'b', '#', 'c', '#', '#'};
        assertEquals(-1, test.prevCharIndex(arr, arr.length));
    }

    @Test
    public void testBackspaceCompare() {
        String a = "###";
        String b = "";
        assertTrue(test.backspaceCompare(a, b));

        a = "ba#aa###";
        b = "bb#";
        assertFalse(test.backspaceCompare(a, b));

        a = "ca#aa###";
        b = "bb#";
        assertFalse(test.backspaceCompare(a, b));

        a = "ba#aa###aa";
        b = "b#aa";
        assertTrue(test.backspaceCompare(a, b));

        a = "bxj##tw";
        b = "bxo#j##tw";
        assertTrue(test.backspaceCompare(a, b));
    }
}
