package main;

import java.util.*;

public class StickerToSpellWord {
    public int minStickers(String[] stickers, String target) {
//        char t[] = target.toCharArray();
//        Arrays.sort(t);
//        StringBuilder sb = new StringBuilder();
//        sb.append(t);
//        target = sb.toString();

        Set<Character> alphabet = new HashSet<>();
        for (char c: target.toCharArray()) alphabet.add(c);

        List<String> list = new LinkedList<>();
        for (String s: stickers) {
            StringBuilder sb = new StringBuilder();
            for (char c: s.toCharArray()) {
                if (alphabet.contains(c)) {
                    sb.append(c);
                }
            }
            if (sb.length() != 0) list.add(sb.toString());
        }

        int len = target.length(),size = 1 << len, subsets[] = new int[size];
        for (int i = 1; i < size; i++) subsets[i] = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            if (subsets[i] == Integer.MAX_VALUE) continue;
            for (String s: list) {
                int curr_subset = i;
                for (char c: s.toCharArray()) {
                    for (int index_of_char = 0; index_of_char < len; index_of_char++) {
                        if (c == target.charAt(index_of_char) && ((curr_subset >> index_of_char) & 1) == 0) {
                            curr_subset |= 1 << index_of_char;
                            break;
                        }
                    }
                }
                subsets[curr_subset] = Math.min(subsets[i] + 1, subsets[curr_subset]);
            }
        }
        return subsets[size - 1] == Integer.MAX_VALUE ? -1 : subsets[size - 1];
    }

    public List<int[]> stringToCharArray(String[] stickers, int[] alphabet, int[] t) {
        List<int[]> result = new LinkedList<>();
        int len = t.length;
        for (String s: stickers) {
            int arr[] = new int[len];
            for (char c: s.toCharArray()) {
                int index = alphabet[c - 'a'];
                if (index >= 0) arr[index]++;
            }
            for (int i = 0; i < len; i++) {
                if (arr[i] > t[i]) arr[i] = t[i];
            }
            result.add(arr);
        }

        return result;
    }

    public static void main(String[] args) {
//        StickerToSpellWord test = new StickerToSpellWord();
//
//        String[] stickers = {"abbcc", "abbbc", "ccc", "ccd"};
//        String target = "abbbcccd";
//        System.out.println("output: " + test.minStickers(stickers, target));
    }
}
