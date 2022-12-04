package day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Day4a_ {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/java/day4/input/4a_input.txt");
        List<String> lines = Files.readAllLines(path);
        long result = 0;

        for (String line : lines) {
            String[] pairs = line.split(",");
            String[] pair1 = pairs[0].split("-");
            String[] pair2 = pairs[1].split("-");
            int p1N1 = Integer.parseInt(pair1[0]);
            int p1N2 = Integer.parseInt(pair1[1]);
            int p2N1 = Integer.parseInt(pair2[0]);
            int p2N2 = Integer.parseInt(pair2[1]);

            if ((p1N1 >= p2N1 && p1N2 <= p2N2) || (p2N1 >= p1N1 && p2N2 <= p1N2)) result++;
        }
        System.out.println(result);
    }
}
