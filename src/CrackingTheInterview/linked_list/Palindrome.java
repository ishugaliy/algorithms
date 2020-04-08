package CrackingTheInterview.linked_list;

/**
 * Defined if the list is palindrome.
 * Solution should have O(1) memory usage.
 * <p>
 * List represented with interface below:
 * Singly-linked lists are already defined with this interface:
 * class ListNode<T> {
 * ListNode(T x) {
 * value = x;
 * }
 * T value;
 * ListNode<T> next;
 * }
 * <p>
 * boolean isListPalindrome(ListNode<Integer> l) {
 * //Write code here
 * }
 */
public class Palindrome {

    public static void main(String[] args) {
        // Case 1
        ListNode<Integer> head = new ListNode<>(1);
        System.out.println(isListPalindrome(head)); // true

        // Case 2
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        System.out.println(isListPalindrome_2(head)); // false

        // Case 3
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(2);
        head.next.next.next = new ListNode<>(1);
        System.out.println(isListPalindrome_2(head));// true

        // Case 3
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(1);
        head.next.next.next = new ListNode<>(1);
        System.out.println(isListPalindrome(head));// false
    }

    public static boolean isListPalindrome(ListNode<Integer> l) {
        ListNode<Integer> mid = l; // mid pointer
        ListNode<Integer> end = l; // end pointer

        // in the end of this loop, mid pointer will be in the middle of the list
        while (mid.next != null && end.next != null && end.next.next != null) {
            end = end.next.next;
            mid = mid.next;
        }
        if (end.next != null && mid.next != null) {
            mid = mid.next;
            end = end.next;
        }

        ListNode<Integer> left = l;    // left pointer
        ListNode<Integer> right = end; // right pointer
        while (left != right) {
            if (!left.value.equals(right.value)) {
                return false;
            }
            left = left.next;
            right = mid;
            while (right.next != null && right.next.next != null) {
                right = right.next;
            }
            right.next = null;
        }
        return true;
    }

    // Solution O(n) with polynomial hash calculation
    public static boolean isListPalindrome_2(ListNode<Integer> l) {
        ListNode<Integer> slow = l;
        ListNode<Integer> fast = l;

        int idx = 0;
        long hash = 0;
        while (fast.next != null) {
            hash += calcHash(idx++, slow.value);
            fast = fast.next;
            slow = slow.next;
            if (fast.next != null) fast = fast.next;
        }
        if (idx % 2 != 0 && slow.next != null) slow = slow.next;

        while (slow != null) {
            hash -= calcHash(--idx, slow.value);
            slow = slow.next;
        }
        return hash == 0;
    }

    private static long calcHash(int idx, int v) {
        return Math.abs(v * (long) Math.pow(31, idx));
    }

    private static class ListNode<T> {
        T value;
        ListNode<T> next;
        ListNode(T x) {
            value = x;
        }
    }
}
