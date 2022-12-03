package day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day3b_ {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/java/day3/input/input.txt");
        List<String> lines = Files.readAllLines(path);
        long result = 0;
        int i = 0;
        while (i < lines.size()) {
            String first = lines.get(i + 0);
            String second = lines.get(i + 1);
            String third = lines.get(i + 2);
            Set<Character> firstSet = new HashSet<>();
            Set<Character> secondSet = new HashSet<>();
            Set<Character> thirdSet = new HashSet<>();

            for (char c : first.toCharArray()) {
                firstSet.add(c);
            }
            for (char c : second.toCharArray()) {
                secondSet.add(c);
            }
            for (char c : third.toCharArray()) {
                thirdSet.add(c);
            }

            char[] arr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

            for (char c : arr) {
                if (firstSet.contains(c) && secondSet.contains(c) && thirdSet.contains(c)) {
                    if (Character.isLowerCase(c)) {
                        result += c - 'a' + 1;
                    } else if (Character.isUpperCase(c)) {
                        result += (c - 'A' + 27);
                    }
                }
            }
            i += 3;
        }
        System.out.println(result);
    }
}
