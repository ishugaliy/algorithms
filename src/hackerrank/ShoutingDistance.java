package hackerrank;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

//https://www.hackerrank.com/contests/projector-algo-base-8-hw-5-zpun0n6c/challenges/shouting
@SuppressWarnings("all")
public class ShoutingDistance {

    public static void main(String[] args) {
        System.out.print("CASE #1: [4] : ");
        System.out.println(minShoutDistance(new HashSet<>(Arrays.asList(
                new Point(3, 2), new Point(3, 3), new Point(3, 4),
                new Point(3, 3), new Point(3, 9), new Point(3, 8),
                new Point(3, 1)
        ))));

        System.out.print("CASE #2: [7.0710678118654755] : ");
        System.out.println(minShoutDistance(new HashSet<>(Arrays.asList(
                new Point(5, 0), new Point(0, 5),
                new Point(-5, 0), new Point(0, -5)
        ))));

        System.out.print("CASE #3: [0.0] : ");
        System.out.println(minShoutDistance(new HashSet<>(Arrays.asList(new Point(123, 342)))));

        System.out.print("CASE #4: [3.162277] : ");
        System.out.println(minShoutDistance(new HashSet<>(Arrays.asList(
                new Point(1, 5), new Point(1, 4),
                new Point(2, 1), new Point(3, 1)
        ))));

        System.out.print("CASE #5: [4.12310] : ");
        System.out.println(minShoutDistance(new HashSet<>(Arrays.asList(
                new Point(3, 1), new Point(3, 6),
                new Point(4, 5), new Point(5, 6)
        ))));

        System.out.print("CASE #6: [3] : ");
        System.out.println(minShoutDistance(new HashSet<>(Arrays.asList(
                new Point(1, 1), new Point(2, 2), new Point(3, 1),
                new Point(1, 6), new Point(2, 5), new Point(3, 6)
        ))));

        System.out.print("CASE #7: [28284.27124] : ");
        System.out.println(minShoutDistance(new HashSet<>(Arrays.asList(
                new Point(-10_000, -10_000), new Point(10_000, 10_000)))));

        System.out.print("CASE #8: [0.0] : ");
        System.out.println(minShoutDistance(new HashSet<>(Arrays.asList(new Point(123, 342), new Point(123, 342)))));


        System.exit(0);

        // read from input
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            Set<Point> people = new HashSet<>();
            for (int i = 0; i < n; i++) {
                String[] raw = reader.readLine().split(" ");
                people.add(new Point(Integer.parseInt(raw[0]), Integer.parseInt(raw[1])));
            }

            // solution
            System.out.println(minShoutDistance(people));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double minShoutDistance(Set<Point> people) {
        if (people.size() == 1) return 0.0;
        double bad = -1;
        double good =  28285; // ~ distance between pq p1{x: -10000; y: -10000} and p2{x:  10000;  y: 10000}
        while (good - bad > 0.000001) {
            double m = (bad + good) / 2;
            if(isShoutDistanceValid(people, m)) {
                good = m;
            } else {
                bad = m;
            }
        }
        return good;
    }

    private static boolean isShoutDistanceValid(Set<Point> people, double distance) {
        Set<Point> visited = new HashSet<>();
        LinkedList<Point> queue = new LinkedList<>();

        Point first = people.stream().findFirst().get();
        queue.add(first);
        visited.add(first);

        while (!queue.isEmpty()) {
            Point screamer = queue.poll();
            for (Point receiver : people) {
                if (!visited.contains(receiver) && screamer.distance(receiver) <= distance) {
                    queue.add(receiver);
                    visited.add(receiver);
                }
            }
        }
        return visited.size() == people.size();
    }
}