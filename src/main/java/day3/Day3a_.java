package day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

//Find common chars in pockets
public class Day3a_ {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/java/day3/input.txt");
        List<String> lines = Files.readAllLines(path);
        long result = 0;
        for (String line : lines) {
            int length = line.length();
            String first = line.substring(0, length / 2);
            String second = line.substring(length / 2);
            Set<Character> firstSet = new HashSet<>();
            Set<Character> secondSet = new HashSet<>();

            for (char c1 : first.toCharArray()) {
                firstSet.add(c1);
            }
            for (char c1 : second.toCharArray()) {
                secondSet.add(c1);
            }
            for (char c1 : firstSet) {
                if (secondSet.contains(c1)) {
                    if (Character.isLowerCase(c1)) {
                        result += c1 - 'a' + 1;
                    } else if (Character.isUpperCase(c1)) {
                        result += (c1 - 'A' + 27);
                    }
                }
            }
        }
        System.out.println(result);
    }
}
