package CrackingTheInterview.array_and_string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Check Permutation: Given two strings,write a method to decide if one is a permutation of the
 * other.
 */
public class CheckPermutation {

    public static void main(String[] args) {
        System.out.println(isPermutation("qweerty", "reewqty")); // true
        System.out.println(isPermutation("qweerty", "reewzty")); // false
        System.out.println(isPermutation("qweerty", "rewqty")); // false
    }

    public static boolean isPermutation(String s1, String s2) {
        Map<Integer, Long> s1_chars = s1.chars()
                .boxed()
                .collect(Collectors.groupingBy(v -> v, Collectors.counting()));

        for (int i = 0; i < s2.length(); i++) {
            int c = s2.charAt(i);
            if (!s1_chars.containsKey(c)) return false;

            long cnt = s1_chars.get(c) - 1;

            if (cnt == 0) {
                s1_chars.remove(c);
            } else{
                s1_chars.put(c, cnt);
            }
        }
        return s1_chars.size() == 0;
    }
}
