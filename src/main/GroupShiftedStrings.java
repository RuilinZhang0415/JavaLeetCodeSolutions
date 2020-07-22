package main;

import java.util.*;

public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s: strings) {
            map.computeIfAbsent(hash(s), k -> new LinkedList<>()).add(s);
        }

        return new LinkedList<>(map.values());
    }

    private static String hash(String s) {
        int shift = s.charAt(0) - 'a';
        StringBuilder pattern = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            pattern.append((char)(curr - shift < 'a' ? curr - shift + 26 : curr - shift));
        }

        return pattern.toString();
    }

    public static void main(String[] args) {
        GroupShiftedStrings test = new GroupShiftedStrings();
        String[] input = new String[]{"qzq","zkddvitlk","xbogegswmad","mkndeyrh","llofdjckor","lebzshcb","firomjjlidqpsdeqyn","dclpiqbypjpfafukqmjnjg","lbpabjpcmkyivbtgdwhzlxa","wmalmuanxvjtgmerohskwil","yxgkdlwtkekavapflheieb","oraxvssurmzybmnzhw","ohecvkfe","kknecibjnq","wuxnoibr","gkxpnpbfvjm","lwpphufxw","sbs","txb","ilbqahdzgij","i","zvuur","yfglchzpledkq","eqdf","nw","aiplrzejplumda","d","huoybvhibgqibbwwdzhqhslb","rbnzendwnoklpyyyauemm"};
        List<List<String>> result = test.groupStrings(input);
        System.out.println(result.size());
        for (List<String> list : result) {
            for (String s: list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
        // qzq sbs
//        System.out.println((char)(('z' - 'a' + 1) % 26 + 'a'));
//        System.out.println(('b' - 's' + 26) % 26);
    }
}
