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
        System.out.println(isListPalindrome(head)); // false

        // Case 3
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(2);
        head.next.next.next = new ListNode<>(1);
        System.out.println(isListPalindrome(head));// true

        // Case 3
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(1);
        head.next.next.next = new ListNode<>(1);
        System.out.println(isListPalindrome(head));// false
    }

    // TODO: implement another solution
    // not rally good solution, it can be done without sum variable, with has drawbacks
    // go to the middle with two pointer and then just compare first and last element,
    // each time go to the last element, and after comparison cut it (next = null)
    public static boolean isListPalindrome(ListNode<Integer> l) {
        ListNode<Integer> p1 = l;
        ListNode<Integer> p2 = l;

        int sum = 0;
        while (p2.next != null && p2.next.next != null) {
            sum += p1.value;
            p2 = p2.next.next;
            p1 = p1.next;

        }
        if (p2.next != null) sum += p1.value;

        p1 = p1.next;
        while (p1 != null) {
            sum -= p1.value;
            p1 = p1.next;

        }
        return sum == 0;
    }

    private static class ListNode<T> {
        T value;
        ListNode<T> next;
        ListNode(T x) {
            value = x;
        }
    }
}
