package day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Day2b_ {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/java/day2/input/2a_input.txt");
        List<String> lines = Files.readAllLines(path);

        Map<String, Long> chooseToAchieveGoal = new HashMap<>();
        chooseToAchieveGoal.put("A X", 3L);
        chooseToAchieveGoal.put("A Y", 1L);
        chooseToAchieveGoal.put("A Z", 2L);
        chooseToAchieveGoal.put("B X", 1L);
        chooseToAchieveGoal.put("B Y", 2L);
        chooseToAchieveGoal.put("B Z", 3L);
        chooseToAchieveGoal.put("C X", 2L);
        chooseToAchieveGoal.put("C Y", 3L);
        chooseToAchieveGoal.put("C Z", 1L);

        Map<String, Long> goalPoints = new HashMap<>();
        goalPoints.put("X", 0L);
        goalPoints.put("Y", 3L);
        goalPoints.put("Z", 6L);


        long totalScore = 0;
        for (String line : lines) {
            long currentScore = 0;
            String[] split = line.split(" ");
            long goal = goalPoints.get(split[1]);

            currentScore += goal;
            Long rockChosen = chooseToAchieveGoal.get(line);
            currentScore += rockChosen;

            System.out.println("line :" + line);
            System.out.println("goal :" + goal);
            System.out.println("rockChosen :" + rockChosen);
            System.out.println("currentScore :" + currentScore);
            System.out.println("=========");
            totalScore += currentScore;
        }
        System.out.println("totalScore :" + totalScore);
    }
}
