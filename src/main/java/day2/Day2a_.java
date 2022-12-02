package day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Day2a_ {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/java/day2/input/2a_input.txt");
        List<String> lines = Files.readAllLines(path);

        Map<Set<Long>, Long> rules = new HashMap<>();
        rules.put(new HashSet<>(Arrays.asList(1L, 3L)), 1L);
        rules.put(new HashSet<>(Arrays.asList(2L, 3L)), 3L);
        rules.put(new HashSet<>(Arrays.asList(1L, 2L)), 2L);

        Map<String, Long> points = new HashMap<>();
        points.put("A", 1L);
        points.put("B", 2L);
        points.put("C", 3L);
        points.put("X", 1L);
        points.put("Y", 2L);
        points.put("Z", 3L);

        long totalScore = 0;
        for (String line : lines) {
            long currentScore = 0;
            String[] split = line.split(" ");
            long opponentMove = points.get(split[0]);
            long yourMove = points.get(split[1]);

            currentScore += yourMove;

            if (opponentMove == yourMove) {
                currentScore += 3;
            } else if (rules.get(new HashSet<>(Arrays.asList(opponentMove, yourMove))) == yourMove) {
                currentScore += 6;
            }

            totalScore += currentScore;
        }
        System.out.println("totalScore :" + totalScore);
    }
}
