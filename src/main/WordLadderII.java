package main;

import java.util.*;

public class WordLadderII {
    List<List<String>> allPaths = new LinkedList<>();
    List<String> currPath = new LinkedList<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int len = beginWord.length();

        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) return allPaths;

        words.remove(beginWord);

        Map<String, List<String>> adjacencyMap = buildAdjacencyMap(beginWord, endWord, words);

        if (!adjacencyMap.isEmpty()) buildPaths(beginWord, endWord, adjacencyMap);

        return allPaths;
    }

    private void buildPaths(String beginWord, String currWord, Map<String, List<String>> adjacencyMap) {
        currPath.add(0, currWord);

        if (currWord.equals(beginWord)) {
            allPaths.add(new LinkedList<>(currPath));
            return;
        }

        for (String transform: adjacencyMap.get(currWord)) {
            buildPaths(beginWord, transform, adjacencyMap);
            currPath.remove(0);
        }
    }

    // Build the map backwards
    public Map<String, List<String>> buildAdjacencyMap(String beginWord, String endWord, Set<String> words) {
        Map<String, List<String>> adjacencyMap = new HashMap<>();

        int len = beginWord.length();
        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();
        Set<String> unvisited = words;

        // Early termination
        boolean found = false;
        // Use queue to perform BFS
        while (!queue.isEmpty()) {
            // Iterate through all words in current layer
            int size = queue.size();
            while (size-- > 0) {
                String word = queue.poll();
                // Search for all possible transformations of the current word
                for (int i = 0; i < len; i++) {
                    char[] toTranform = word.toCharArray();
                    // Search for all possible transformations at index i
                    for (char c = 'a'; c <= 'z'; c++) {
                        toTranform[i] = c;
                        String transform = new String(toTranform);
                        // Avoid duplicates in the current layer and layers before current one
                        if (unvisited.contains(transform)) {
                            if (!visited.contains(transform)) {
                                queue.add(transform); // Build the next layer
                                visited.add(transform);
                            }
                            // Build adjacency map
                            List<String> adjacencies = adjacencyMap.getOrDefault(transform, new ArrayList<String>());
                            adjacencies.add(word);
                            adjacencyMap.put(transform, adjacencies);
                            if (transform.equals(endWord)) found = true;
                        } // if transform is in the word list
                    } // char a to z
                } // index from 0 to beginWord.length() - 1
            } // count from queue.size to 1
            // After processing current layer, check if endWord found and update visited and unvisited
            if (found) break;
            unvisited.removeAll(visited);
            visited.clear();
        }

        return adjacencyMap;
    }

    public static void main(String[] args) {
//        List<List<String>> result = new ArrayList<>();
//        List<String> list = new ArrayList<>();
//        list.add("list1");
//        result.add(list);
//        list = new ArrayList<>();
//        list.add("list2");
//        result.add(list);

        WordLadderII test = new WordLadderII();
        String beginWord = "abcd";
        String endWord = "aqlk";
        List<String> wordList = Arrays.asList("aqcd", "abld","fbcd","aqld","ablk","fbld", "aqlk");
        Map<String, List<String>> adjacencyMap = test.buildAdjacencyMap(beginWord, endWord, new HashSet<>(wordList));
        test.buildPaths(beginWord, endWord, adjacencyMap);
        for (List<String> list: test.allPaths) {
            for (String string: list) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }
}
