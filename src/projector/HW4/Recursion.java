package projector.HW4;

import datatype.Node;

import java.util.Arrays;
import java.util.LinkedList;

public class Recursion {

    public static void main(String[] args) {
        System.out.println("-----[count_multiples]------");
        System.out.println(count_multiples(2, 6));                        // 1
        System.out.println(count_multiples(2, 12));                       // 2
        System.out.println(count_multiples(3, 11664));                    // 6
        System.out.println();

        System.out.println("-----[max_val]------");
        System.out.println(max_val(new int[]{1, 9, -3, 7, 13, 2, 3}, 0)); // 13
        System.out.println();

        System.out.println("-----[merge]------");
        System.out.println(Arrays.toString(merge(new int[]{1, 8, 9, 14, 15}, new int[]{2, 10, 23})));
        System.out.println();

        System.out.println("-----[reverse]------");
        System.out.println(reverse(new LinkedList<>(Arrays.asList(1, 2, 3, 4, null))));
        System.out.println();

        System.out.println("------[ast_build]-------");
        Node<String> node = buildTree("2+3*4");
        System.out.println(compute_expr(node));         // 14
        System.out.println();
    }

    /**
     * A. Write a recursive function count_multiples(a, b) that counts how many multiples of a are part of the factorization of the number b. For example:
     * >>> count_multiples(2, 6)     # 2 * 3 = 6
     * 1
     * >>> count_multiples(2, 12)    # 2 * 2 * 3 = 12
     * 2
     * >>> count_multiples(3, 11664)
     * 6
     */
    public static int count_multiples(int a, int b) {
        if (b % a != 0) return 0;
        return count_multiples(a, b / a) + 1;
    }

    /**
     * B. Write a recursive function that finds the maximum value in a Python list without using any kind of
     * looping construct such as "for" or "while."
     * For example:
     * >>> maxval([1, 9, -3, 7, 13, 2, 3])
     * 13
     */
    public static int max_val(int[] arr, int idx) {
        if (idx >= arr.length) {
            return arr[arr.length - 1];
        }
        return Math.max(arr[idx], max_val(arr, idx + 1));
    }

    /**
     * D. Write a recursive function that merges two sorted lists of numbers into a single sorted list. For example:
     * >>> merge([1, 8, 9, 14, 15], [2, 10, 23])
     * [1, 2, 8, 9, 10, 14, 15, 23]
     */
    public static int[] merge(int[] a1, int[] a2) {
        if (a1.length == 0) return a2;
        if (a2.length == 0) return a1;

        int[] a = new int[a1.length + a2.length];
        a[0] = Math.min(a1[0], a2[0]);
        int[] tmp = a1[0] < a2[0]
                ? merge(Arrays.copyOfRange(a1, 1, a1.length), a2)
                : merge(a1, Arrays.copyOfRange(a2, 1, a2.length));

        System.arraycopy(tmp, 0, a, 1, a.length - 1);
        return a;
    }

    /**
     * E. Write a recursive function that reverses a linked-list. For example:
     * >>> reverse((1, (2, (3, (4, None)))))
     * (4, (3, (2, (1, None))))
     */
    public static LinkedList<Integer> reverse(LinkedList<Integer> list) {
        if (list.size() == 0) return list;

        Integer first = null;
        while (first == null && list.size() > 0) {
            first = list.pollFirst();
        }
        Integer last = null;
        while (last == null && list.size() > 0) {
            last = list.pollLast();
        }

        LinkedList<Integer> rev = reverse(list);
        rev.addLast(first);
        rev.addFirst(last);
        return rev;
    }

    /**
     * F. Inside a compiler, source code is usually represented by some sort of tree structure.
     * Trees are usually recursive in nature --as are the algorithms for dealing with the data.
     * Write a Python function that takes an expr and build Abstract Syntax Tree (AST) and then compute the result by
     * traversing the tree. The expression will consit only with numbers and the following operations (+, *)
     * expr = "2+3*4"
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * a) build_tree(expr) should return a tree:
     * # AST:
     * #       +
     * #    /    \
     * #   2      *
     * #        /   \
     * #       3     4
     */
    public static Node<String> buildTree(String expr) {
        int operIdx = 0;
        while (operIdx < expr.length()
                && expr.charAt(operIdx) != '+'
                && expr.charAt(operIdx) != '*') {
            operIdx++;
        }

        if (operIdx == expr.length()) return new Node<>(expr);

        Node<String> root = new Node<>(String.valueOf(expr.charAt(operIdx)));
        Node<String> prev = new Node<>(String.valueOf(expr.charAt(operIdx - 1)));
        Node<String> next = buildTree(expr.substring(operIdx + 1));

        root.setPrev(prev);
        root.setNext(next);
        return root;
    }

    /**
     * b) assert compute_expr(root: Node) == 14
     */
    public static int compute_expr(Node<String> node) {
        int result;
        switch (node.getValue()) {
            case "+":
                result = compute_expr(node.getPrev()) + compute_expr(node.getNext());
                break;
            case "*":
                result = compute_expr(node.getPrev()) * compute_expr(node.getNext());
                break;
            default:
                result = Integer.parseInt(node.getValue());
        }
        return result;
    }
}
