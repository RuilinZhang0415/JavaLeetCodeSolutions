package main;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s: strs) {
            String hash_value = s.length() <= 1 ? s : hash(s);

            map.computeIfAbsent(hash_value, v -> new LinkedList<>()).add(s);
        }

        return new LinkedList<>(map.values());
    }

    private static String hash(String key) {
        int[] count = new int[26];
        for (char c: key.toCharArray()) count[c - 'a']++;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) sb.append((char)('a'+ i)).append(count[i]);
        }

        return sb.toString();
    }

//    private static String hash(String key) {
//        SortedMap<Character, Integer> map = new TreeMap<>();
//        for (char c: key.toCharArray()) {
//            int count = map.getOrDefault(c, 0);
//            map.put(c, count + 1);
//        }
//        StringBuilder sb = new StringBuilder();
//        for (Character c: map.keySet()) sb.append(c).append(map.get(c));
//
//        return sb.toString();
//    }

//    private static String hash(String key) {
//        char[] arr = key.toCharArray();
//        Arrays.sort(arr);
//
//        return String.valueOf(arr);
//    }

    public static void main(String[] args) {
        GroupAnagrams test = new GroupAnagrams();

//        String[] arr = new String[] {
//                "chi","nip","lab","mud","fan","yak","kid","lox","joy","rob","cad","hug","ken","oaf","pus","hos","ton","any","sac","mid","nip","ron","tux","set","jug","axe","ago","sob","ode","dot","nit","pug","sue","new","rub","sup","ohs","ski","oaf","don","cob","kin","ark","gay","jay","bur","dot","eat","rca","wad","maj","luz","gad","dam","eon","ark","del","sin","tat"
//        };
//        for (List<String> list: test.groupAnagrams(arr)) {
//            for (String s: list) {
//                System.out.print(s + " ");
//            }
//            System.out.println();
//        }

        System.out.println(hash("bur"));
        System.out.println(hash("rub"));
    }
}
