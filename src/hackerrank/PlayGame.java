package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PlayGame {

    public static void main(String[] args) {
        // 105
        System.out.println(play(new int[]{2, 5, 100}, new int[]{1, 3, 101}));
        // 120
        System.out.println(play(new int[]{5, 15, 100, 1, 5}, new int[]{5, 15, 100, 1, 5}));
        // 99
        System.out.println(play(new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19}, new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20}));
        // 65
        System.out.println(play(new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}));
        // 25084
        System.out.println(play(
                new int[]{651, 321, 106, 503, 227, 290, 915, 549, 660, 115, 491, 378, 495, 789, 507, 381, 685, 530, 603,
                        394, 7, 704, 101, 620, 859, 490, 744, 495, 379, 781, 550, 356, 950, 628, 177, 373, 132, 740, 946,
                        609, 29, 329, 57, 636, 132, 843, 860, 594, 718, 849},
                new int[]{16, 127, 704, 614, 218, 67, 169, 621, 340, 319, 366, 658, 798, 803, 524, 608, 794, 896, 145,
                        627, 401, 253, 137, 851, 67, 426, 571, 302, 546, 225, 311, 111, 804, 135, 284, 784, 890, 786,
                        740, 612, 360, 852, 228, 859, 229, 249, 540, 979, 55, 82}));

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int armySize = Integer.parseInt(reader.readLine());
            int[] army = Arrays
                    .stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] enemy = Arrays
                    .stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            // algorithm
            System.out.println(play(army, enemy));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int play(int[] player, int[] computer) {
        if (player.length == 0 || player.length != computer.length) return 0;

        Arrays.sort(player);
        Arrays.sort(computer);

        int strength = 0;
        int playerIdx = player.length - 1;
        for (int i = computer.length - 1; i >= 0; i--) {
            if (player[playerIdx] > computer[i]) {
                strength += player[playerIdx--];
            }
        }
        return strength;
    }
}
