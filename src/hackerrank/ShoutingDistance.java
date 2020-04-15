package hackerrank;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://www.hackerrank.com/contests/projector-algo-base-8-hw-5-zpun0n6c/challenges/shouting
@SuppressWarnings("all")
public class ShoutingDistance {

    public static void main(String[] args) {
        // CASE #1: 4
        System.out.println(minShoutDistance(new HashSet<>(Arrays.asList(
                new Point(3, 2), new Point(3, 3), new Point(3, 4),
                new Point(3, 3), new Point(3, 9), new Point(3, 8),
                new Point(3, 1)
        ))));

        // CASE #2: 7.0710678118654755
        System.out.println(minShoutDistance(new HashSet<>(Arrays.asList(
                new Point(5, 0), new Point(0, 5),
                new Point(-5, 0), new Point(0, -5)
        ))));

        // CASE #3: 0.0
        System.out.println(minShoutDistance(new HashSet<>(Arrays.asList(new Point(123, 342)))));

        // CASE #4: 3.162277
        System.out.println(minShoutDistance(new HashSet<>(Arrays.asList(
                new Point(1, 5), new Point(1, 4),
                new Point(2, 1), new Point(3, 1)
        ))));

        // CASE #5: 4.12310
        System.out.println(minShoutDistance(new HashSet<>(Arrays.asList(
                new Point(3, 1), new Point(3, 6),
                new Point(4, 5), new Point(5, 6)
        ))));


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
        double minDistance = Double.MAX_VALUE;
        for (Point screamer : people) {
            minDistance = Math.min(_minShoutDistance(new HashSet<>(people), screamer), minDistance);
        }
        return minDistance;
    }

    private static double _minShoutDistance(Set<Point> people, Point screamer) {
        if (!people.remove(screamer)) return 0;

        double minDistance = Double.MAX_VALUE;
        Point closestReceiver = null;
        for (Point receiver : people) {
            double distance = screamer.distance(receiver);
            if (distance < minDistance) {
                minDistance = distance;
                closestReceiver = receiver;
            }
        }
        minDistance = minDistance != Double.MAX_VALUE ? minDistance : 0;
        return Math.max(minDistance, _minShoutDistance(people, closestReceiver));
    }
}