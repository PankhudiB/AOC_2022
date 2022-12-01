package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//top 3
// using min heap
public class Day1b_Top3MaxCalories {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/java/day1/input/1a_input.txt");
        List<String> lines = Files.readAllLines(path);

        PriorityQueue<Long> minHeap = new PriorityQueue<>(Comparator.naturalOrder());

        long caloriesSoFar = 0;

        for (String line : lines) {
            if (line.isEmpty()) {
                caloriesSoFar = 0;
                continue;
            }
            long calories = Long.parseLong(line);
            caloriesSoFar += calories;

            if (minHeap.size() < 3) {
                minHeap.add(caloriesSoFar);
            } else if (caloriesSoFar > minHeap.peek()) {
                minHeap.remove();
                minHeap.add(caloriesSoFar);
            }
        }

        long sumOfTop3MaxCalories = minHeap.poll() + minHeap.poll() + minHeap.poll();
        System.out.println("sumOfTop3MaxCalories: " + sumOfTop3MaxCalories);
    }
}
