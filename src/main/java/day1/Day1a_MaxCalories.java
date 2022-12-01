package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Day1a_MaxCalories {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/java/day1/input/1a_input.txt");
        List<String> lines = Files.readAllLines(path);
        long maxCalories = 0;
        long caloriesSoFar = 0;

        for (String line : lines) {
            if (line.isEmpty()) {
                maxCalories = Math.max(maxCalories, caloriesSoFar);
                caloriesSoFar = 0;
                continue;
            }
            long calories = Long.parseLong(line);
            caloriesSoFar += calories;
        }
        System.out.println("maxCalories :" + maxCalories);
    }
}
