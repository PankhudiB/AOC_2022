package day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Day4b_ {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/java/day4/input/4a_input.txt");
        List<String> lines = Files.readAllLines(path);
        long result = 0;

        for (String line : lines) {
            String[] pairs = line.split(",");
            String[] pair1 = pairs[0].split("-");
            String[] pair2 = pairs[1].split("-");
            int a = Integer.parseInt(pair1[0]);
            int b = Integer.parseInt(pair1[1]);
            int c = Integer.parseInt(pair2[0]);
            int d = Integer.parseInt(pair2[1]);

            if ((a >= c && a <= d) || (b >= c && b <= d) || (c >= a && c <= b) || (d <= b && d >= a)) result++;

        }
        System.out.println(result);
    }
}
