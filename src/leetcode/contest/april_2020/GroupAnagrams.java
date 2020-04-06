package leetcode.contest.april_2020;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(groupAnagrams(new String[]{"cab","tin","pew","duh","may","ill","buy","bar","max","doc"}));
        System.out.println(groupAnagrams(new String[]{"mod","mop","pip","tug","hop","dog","met","zoe","axe","mug","fdr",
                "for","fro","fdr","pap","ray","lop","nth","old","eva","ell","mci","wee","ind","but","all","her","lew",
                "ken","awl","law","rim","zit","did","yam","not","ref","lao","gab","sax","cup","new","job","new","del",
                "gap","win","pot","lam","mgm","yup","hon","khz","sop","has","era","ark"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> anagrams = new HashMap<>();
        for (String s : strs) {
            // count search
            int[] chars = new int[26];
            for (int i = 0; i < s.length(); i++) {
                chars[s.charAt(i) - 97]++;
            }

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                while (chars[i]-- > 0) {
                    builder.append((char) (i + 97));
                }
            }
            anagrams
                    .computeIfAbsent(builder.toString(), k -> new ArrayList<>())
                    .add(s);
        }
        return new ArrayList<>(anagrams.values());
    }
}
