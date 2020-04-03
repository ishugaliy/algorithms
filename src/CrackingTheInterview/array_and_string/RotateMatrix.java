package CrackingTheInterview.array_and_string;

/**
 * Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees. Can you do this in place?
 */
public class RotateMatrix {

    public static void main(String[] args) {
        int[][] a = new int[][] {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int[][] r = rotate(a);

        // Print result
        for (int i = 0; i < r.length; i++) {
            for (int j = 0; j < r[i].length; j++) {
                System.out.print(r[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int[][] rotate(int[][] a) {
        int[][] r = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            int[] row = a[i];
            for (int j = row.length - 1; j >= 0; j--) {
                r[row.length - j - 1][i] = row[j];
            }
        }
        return r;
    }
}
