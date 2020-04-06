package CrackingTheInterview.array_and_string;

import java.util.*;

public class ZeroMatrix {

    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3},
                {4,5,0},
                {7,8,9}
        };
        zerofy(arr);

        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void zerofy(int[][] arr) {
        // find position of all zeroes
        ArrayList<Integer> rowZeroes = new ArrayList<>();
        ArrayList<Integer> colZeroes = new ArrayList<>();
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col] == 0) {
                    rowZeroes.add(row);
                    colZeroes.add(col);
                }
            }
        }
        for (Integer row : rowZeroes) {
            Arrays.fill(arr[row], 0);
        }
        for (Integer col : colZeroes) {
            for (int row = 0; row < arr.length; row++) {
                arr[row][col] = 0;
            }
        }
    }
}
