package leetcode;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        System.out.println("CASE #1");
        int[][] arr = {{1, 3}, {-2, 2}};
        print(kClosest_heap(arr, 1));
        print(kClosest_arr(arr, 1));
        print(kClosest_quickSelect(arr, 1));

        System.out.println("CASE #2");
        arr = new int[][]{{3, 3}, {5, -1}, {-2, 4}};
        print(kClosest_heap(arr, 2));
        print(kClosest_arr(arr, 2));
        print(kClosest_quickSelect(arr, 2));
    }

    public static int[][] kClosest_heap(int[][] points, int k) {
        Point source = new Point(0,0);
        PriorityQueue<Point> heap =
                new PriorityQueue<>(Comparator.comparingDouble(p -> p.distance(source)));
        for (int[] point : points) {
            heap.add(new Point(point[0], point[1]));
        }
        int[][] closest = new int[k][2];
        int idx = 0;
        while (idx < k) {
            Point p = heap.poll();
            closest[idx][0] = p.x;
            closest[idx][1] = p.y;
            idx++;
        }
        return closest;
    }

    public static int[][] kClosest_arr(int[][] points, int k) {
        Point point = new Point(0,0);
        Arrays.sort(points, Comparator.comparingDouble(a -> point.distance(a[0], a[1])));
        return Arrays.copyOfRange(points, 0, k);
    }

    public static int[][] kClosest_quickSelect(int[][] points, int k) {
        Point point = new Point(0,0);
        Arrays.sort(points, Comparator.comparingDouble(a -> point.distance(a[0], a[1])));
        return Arrays.copyOfRange(points, 0, k);
    }

    private static void print(int[][] arr) {
        for (int[] p : arr) {
            System.out.println("[" + p[0] + ", " + p[1] + "]");
        }
        System.out.println("-----");
    }
}
