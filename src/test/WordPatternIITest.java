package test;

import main.WordPatternII;
import org.junit.Test;

import static org.junit.Assert.*;

public class WordPatternIITest {
    @Test
    public void test() {
        WordPatternII test = new WordPatternII();

        String p = "abab";
        String s = "redblueredblue";
        assertTrue(test.wordPatternMatch(p, s));

        p = "aaaa";
        s = "redredredred";
        assertTrue(test.wordPatternMatch(p, s));

        p = "aabb";
        s = "xyzabcxzyabc";
        assertFalse(test.wordPatternMatch(p, s));
    }
}
