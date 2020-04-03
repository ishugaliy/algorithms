package CrackingTheInterview.array_and_string;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * String Compression: Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string aabcccccaaa would become a2blc5a3.
 * If the "compressed" string would not become smaller than the original string, your method should return
 * the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 */
public class StringCompression {

    public static void main(String[] args) {
        System.out.println(compress("aabcccccaaa")); // a2b1c5a3
        System.out.println(compress("abc"));        // abc
    }

    public static String compress(String s) {
        Map<Integer, Long> chars = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            long cnt = chars.getOrDefault(c, 0L);
            chars.put(c, cnt + 1);
        }
        StringBuilder builder = new StringBuilder();
        for (int c : chars.keySet()) {
            if (builder.length() > s.length()) return s;

            builder.append((char) c);
            builder.append(chars.get(c));
        }
        return builder.toString();
    }
}
