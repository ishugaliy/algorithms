package CrackingTheInterview.array_and_string;

import java.util.HashSet;
import java.util.Set;

/**
 * Is Unique: Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 */
public class IsUnique {

    public static void main(String[] args) {
        System.out.println(isUnique("1234"));  // true
        System.out.println(isUnique("12344")); // false
    }

    public static boolean isUnique(String str) {
        Set<Integer> chars = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i);
            if (chars.remove(c)) {
                return false;
            }
            chars.add(c);
        }
        return true;
    }
}
