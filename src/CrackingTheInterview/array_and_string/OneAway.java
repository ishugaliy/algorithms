package CrackingTheInterview.array_and_string;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * One Away: There are three types of edits that can be performed on strings:
 * insert a character, remove a character, or replace a character.
 * Given two strings, write a function to check if they are one edit (or zero edits) away.
 */
public class OneAway {

    public static void main(String[] args) {
        System.out.println(isOneWayEdit("pale", "ple"));    // true
        System.out.println(isOneWayEdit("pales", "pale"));  // true
        System.out.println(isOneWayEdit("pale", "bale"));   // true
        System.out.println(isOneWayEdit("pale", "bake"));   // false
        System.out.println(isOneWayEdit("pale", "pa"));     // false
    }

    public static boolean isOneWayEdit(String s1, String s2) {
        if (Math.abs(s1.length() - s2.length()) > 1) return false;

        Map<Integer, Long> s1_chars = s1.chars().boxed()
                .collect(Collectors.groupingBy(v -> v, Collectors.counting()));

        int editCnt = 0;
        for (int i = 0; i < s2.length(); i++) {
            if (editCnt > 1) break;

            int c = s2.charAt(i);
            if (s1_chars.containsKey(c)) {
                long cnt = s1_chars.get(c) - 1;
                if (cnt == 0) {
                    s1_chars.remove(c);
                } else {
                    s1_chars.put(c, cnt);
                }

            } else {
                editCnt++;
            }
        }
        return editCnt <= 1;
    }
}
