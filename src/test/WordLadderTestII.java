package test;

import main.WordLadderII;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class WordLadderTestII {


    @Test
    public void testBuildAdjacencyMap() {
        WordLadderTestII test = new WordLadderTestII();

        WordLadderII obj = new WordLadderII();

        String mapAsString = "Key: fbcd, values: abcd " + "\n" +
                "Key: aqlk, values: aqld ablk " + "\n" +
                "Key: abld, values: abcd " + "\n" +
                "Key: aqld, values: aqcd abld " + "\n" +
                "Key: fbld, values: fbcd abld " + "\n" +
                "Key: aqcd, values: abcd " + "\n" +
                "Key: ablk, values: abld " + "\n";

        String beginWord = "abcd";
        String endWord = "aqlk";
        List<String> wordList = Arrays.asList("aqcd", "abld","fbcd","aqld","ablk","fbld", "aqlk");
        Map<String, List<String>> adjacencyMap = obj.buildAdjacencyMap(beginWord, endWord, new HashSet<>(wordList));

        String result = new String();
        for (String key: adjacencyMap.keySet()) {
            result += "Key: " + key + ", values: ";
            for (String value: adjacencyMap.getOrDefault(key, new LinkedList<>())) {
                result += value + " ";
            }
            result += "\n";
        }

        assertTrue(result.equals(mapAsString));
    }
}

