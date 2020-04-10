package leetcode.contest.april_2020.week_2;

import java.util.HashSet;
import java.util.LinkedList;

// https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3291/
public class BackspaceStringCompare {

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c"));   // true
        System.out.println(backspaceCompare("ab##", "c#d#"));   // true
        System.out.println(backspaceCompare("a##c", "#a#c"));   // true
        System.out.println(backspaceCompare("a#c", "b"));       // false
    }

    public static boolean backspaceCompare(String S, String T) {
        LinkedList<Integer> s_chars = new LinkedList<>();
        LinkedList<Integer> t_chars = new LinkedList<>();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != '#') {
                s_chars.add((int) S.charAt(i));
            } else if(!s_chars.isEmpty()) {
                s_chars.pollLast();
            }
        }
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) != '#') {
                t_chars.add((int) T.charAt(i));
            } else if(!t_chars.isEmpty()){
                t_chars.pollLast();
            }
        }
        return s_chars.size() == t_chars.size()
                && new HashSet<>(s_chars).containsAll(t_chars);
    }
}
