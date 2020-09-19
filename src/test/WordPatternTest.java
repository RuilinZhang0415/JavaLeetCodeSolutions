package test;

import main.WordPattern;
import org.junit.Test;

import static org.junit.Assert.*;

public class WordPatternTest {
    @Test
    public void test() {
        WordPattern test = new WordPattern();

        String pattern = "";
        String str = "";
        assertTrue(test.wordPattern(pattern, str));

        pattern = "abba";
        str = "dog cat cat dog";
        assertTrue(test.wordPattern(pattern, str));

        pattern = "abba";
        str = "dog cat cat fish";
        assertFalse(test.wordPattern(pattern, str));

        pattern = "aaaa";
        str = "dog cat cat dog";
        assertFalse(test.wordPattern(pattern, str));

        pattern = "abba";
        str = "dog dog dog dog";
        assertFalse(test.wordPattern(pattern, str));
    }
}
