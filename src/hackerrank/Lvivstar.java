package hackerrank;

import datatype.IRSQ;
import datatype.SRSQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.hackerrank.com/challenges/java-stdin-and-stdout-1/problem
public class Lvivstar {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] stations = readStations(reader);
            String[] cmds = readCommands(reader);

            // algorithm
            new Lvivstar().execute(stations, cmds);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[] readStations(BufferedReader reader) throws IOException {
        int numOfStations = Integer.parseInt(reader.readLine());
        int[] stations = new int[numOfStations];
        String[] args = reader.readLine().split(" ");
        for (int i = 0; i < numOfStations; i++) {
            stations[i] = Integer.parseInt(args[i]);
        }
        return stations;
    }

    private static String[] readCommands(BufferedReader reader) throws IOException {
        int numOfCmd = Integer.parseInt(reader.readLine());
        String[] cmds = new String[numOfCmd];
        for (int i = 0; i < numOfCmd; i++) {
            cmds[i] = reader.readLine();
        }
        return cmds;
    }

    private void execute(int[] stations, String[] cmds) {
        IRSQ rsq = new SRSQ(stations);
        for (String cmd : cmds) {
            String[] args = cmd.split(" ");
            int startIdx = Integer.parseInt(args[1]) - 1;
            switch (args[0]) {
                case "ENTER":
                    rsq.increment(startIdx);
                    break;
                case "LEAVE":
                    rsq.decrement(startIdx);
                    break;
                case "COUNT":
                    int endIdx = Integer.parseInt(args[2]) - 1;
                    System.out.println(rsq.sum(startIdx, endIdx));
                    break;
            }
        }
    }
}
