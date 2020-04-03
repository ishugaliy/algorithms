package CrackingTheInterview.array_and_string;

/**
 * URLify: Write a method to replace all spaces in a string with '%20'.
 * You may assume that the string has sufficient space at the end to hold the additional characters,
 * and that you are given the "true" length of the string.
 * (Note: If implementing in Java,please use a character array so that you can perform this operation in place.)
 */
public class URLify {

    public static void main(String[] args) {
        System.out.println(urlify("Mr John Smith   "));
    }

    public static String urlify(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char next = i + 1 < s.length() ? s.charAt(i+1) : ' ';
            if (c != ' ') {
                builder.append(c);
            } else if (next != ' ') {
                builder.append("%20");
            }

        }
        return builder.toString();
    }
}
