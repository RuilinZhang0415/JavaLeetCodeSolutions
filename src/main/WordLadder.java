package main;

import java.util.*;

public class WordLadder {

    private static class Tuple {
        String str; int num;
        public Tuple(String str, int num) {
            this.str = str; this.num = num;
        }
    }


    /******************** Two Direction BFS with Map solution (without comparison method) ********************/
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;

        int len = beginWord.length();

        // Map that stores words that can be transformed with each other together
        Map<String, List<String>> intermediateStates = new HashMap<>();
        wordList.forEach(
                word -> {
                    for (int i = 0; i < len; i++) {
                        String intermediate = word.substring(0, i) + "*" + word.substring(i + 1, len);
                        List<String> words = intermediateStates.getOrDefault(intermediate, new LinkedList<>());
                        words.add(word);
                        intermediateStates.put(intermediate, words);
                    }
                }
        );
        // BFS from begin
        Map<String, Integer> begin_visited = new HashMap<>();
        Queue<Tuple> begin_queue = new LinkedList<>();
        begin_visited.put(beginWord, 1);
        begin_queue.add(new Tuple(beginWord, 1));
        // BFS from end
        Map<String, Integer> end_visited = new HashMap<>();
        Queue<Tuple> end_queue = new LinkedList<>();
        end_visited.put(endWord, 1);
        end_queue.add(new Tuple(endWord, 1));

        while (!begin_queue.isEmpty() && !end_queue.isEmpty()) {
            Tuple currBeginTuple = begin_queue.poll();
            Tuple currEndTuple = end_queue.poll();
            // Process begin queue
            for (int i = 0; i < len; i++) {
                String intermediate = currBeginTuple.str.substring(0, i) + "*" + currBeginTuple.str.substring(i + 1, len);

                for (String word: intermediateStates.getOrDefault(intermediate, new LinkedList<>())) {
                    if (end_visited.keySet().contains(word)) {
                        return currBeginTuple.num + end_visited.get(word);
                    }
                    if (!begin_visited.keySet().contains(word)) {
                        begin_queue.add(new Tuple(word, currBeginTuple.num + 1));
                        begin_visited.put(word, currBeginTuple.num + 1);
                    }
                }
            }
            // Process end queue
            for (int i = 0; i < len; i++) {
                String intermediate = currEndTuple.str.substring(0, i) + "*" + currEndTuple.str.substring(i + 1, len);

                for (String word: intermediateStates.getOrDefault(intermediate, new LinkedList<>())) {
                    if (begin_visited.keySet().contains(word)) {
                        return currEndTuple.num + begin_visited.get(word);
                    }
                    if (!end_visited.keySet().contains(word)) {
                        end_queue.add(new Tuple(word, currEndTuple.num + 1));
                        end_visited.put(word, currEndTuple.num + 1);
                    }
                }
            }
        }


        return 0;
    }



/******************** BFS with Map solution (without comparison method) ********************/
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        int len = beginWord.length();
//        // Map that stores words that can be transformed with each other together
//        Map<String, List<String>> intermediateStates = new HashMap<>();
//        wordList.forEach(
//                word -> {
//                    for (int i = 0; i < len; i++) {
//                        String intermediate = word.substring(0, i) + "*" + word.substring(i + 1, len);
//                        List<String> words = intermediateStates.getOrDefault(intermediate, new LinkedList<>());
//                        words.add(word);
//                        intermediateStates.put(intermediate, words);
//                    }
//                }
//        );
//
//        HashSet<String> visited = new HashSet<>();
//        Queue<Tuple> queue = new LinkedList<>();
//        visited.add(beginWord);
//        queue.add(new Tuple(beginWord, 1));
//
//        while (!queue.isEmpty()) {
//            Tuple curr = queue.poll();
//            String currWord = curr.str;
//            int currDepth = curr.num;
//
//            for (int i = 0; i < len; i++) {
//                String intermediate = currWord.substring(0, i) + "*" + currWord.substring(i + 1, len);
//
//                for (String word: intermediateStates.getOrDefault(intermediate, new LinkedList<>())) {
//                    if (word.equals(endWord)) return currDepth + 1;
//                    if (!visited.contains(word)) {
//                        queue.add(new Tuple(word, currDepth + 1));
//                        visited.add(word);
//                    }
//                }
//            }
//        }
//
//
//        return 0;
//    }



/******************** BFS Solution ********************/
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        HashSet<String> visited = new HashSet<>();
//        Queue<Tuple> queue = new LinkedList<>();
//        queue.add(new Tuple(beginWord, 1));
//        while (!queue.isEmpty()) {
//            Tuple currTuple = queue.poll();
//            if (currTuple.str.equals(endWord)) return currTuple.num;
//
//            for (int i = 0; i < wordList.size(); i++) {
//                String word = wordList.get(i);
//                if (canTransform(currTuple.str, word) && !visited.contains(word)) {
//                    queue.add(new Tuple(word, currTuple.num + 1));
//                    visited.add(word);
//                    wordList.remove(i--);
//                }
//            }
//        }
//
//        return 0;
//    }
//
//    private boolean canTransform(String a, String b) {
//        // Assume a and b are different, and they have equal length
//        int count = 0;
//        for (int i = 0; i < a.length(); i++) {
//            if (a.charAt(i) != b.charAt(i)) count++;
//            if (count >= 2) return false;
//        }
//        return true;
//    }

//    private int numOfDifferentLetters(String a, String b) {
//        // Assume a and b are different, and they have equal length
//        int count = 0;
//        for (int i = 0; i < a.length(); i++) {
//            if (a.charAt(i) != b.charAt(i)) count++;
//        }
//        return count;
//    }

    public static void main(String[] args) {
        WordLadder test = new WordLadder();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new LinkedList<>();
        wordList.add("hot");wordList.add("dot");wordList.add("dog");wordList.add("lot");wordList.add("log");
        wordList.add("cog");
        System.out.println(test.ladderLength(beginWord, endWord, wordList));
    }
}
