package day5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Day5a {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/java/day5/input/input.txt");
        List<String> lines = Files.readAllLines(path);
        Stack<String> stack1 = new Stack<>();
        stack1.addAll(Arrays.asList("B", "Q", "C"));

        Stack<String> stack2 = new Stack<>();
        stack2.addAll(Arrays.asList("R", "Q", "W", "Z"));

        Stack<String> stack3 = new Stack<>();
        stack3.addAll(Arrays.asList("B", "M", "R", "L", "V"));

        Stack<String> stack4 = new Stack<>();
        stack4.addAll(Arrays.asList("C", "Z", "H", "V", "T", "W"));

        Stack<String> stack5 = new Stack<>();
        stack5.addAll(Arrays.asList("D", "Z", "H", "B", "N", "V", "G"));

        Stack<String> stack6 = new Stack<>();
        stack6.addAll(Arrays.asList("H", "N", "P", "C", "J", "F", "V", "Q"));

        Stack<String> stack7 = new Stack<>();
        stack7.addAll(Arrays.asList("D", "G", "T", "R", "W", "Z", "S"));

        Stack<String> stack8 = new Stack<>();
        stack8.addAll(Arrays.asList("C", "G", "M", "N", "B", "W", "Z", "P"));

        Stack<String> stack9 = new Stack<>();
        stack9.addAll(Arrays.asList("N", "J", "B", "M", "W", "Q", "F", "P"));

        Map<Integer, Stack<String>> stackMap = new HashMap<>();
        stackMap.put(1, stack1);
        stackMap.put(2, stack2);
        stackMap.put(3, stack3);
        stackMap.put(4, stack4);
        stackMap.put(5, stack5);
        stackMap.put(6, stack6);
        stackMap.put(7, stack7);
        stackMap.put(8, stack8);
        stackMap.put(9, stack9);

        for (int i = 10; i < lines.size(); i++) {
            String line = lines.get(i).replace("move", "-").replace("from", "-").replace("to", "-").trim();
            String[] splits = line.split("-");
            int noOfBlocks = Integer.parseInt(splits[1].trim());
            int moveFrom = Integer.parseInt(splits[2].trim());
            int moveTo = Integer.parseInt(splits[3].trim());

            for (int m = 0; m < noOfBlocks; m++) {
                String popped = stackMap.get(moveFrom).pop();
                stackMap.get(moveTo).push(popped);
            }
        }

        System.out.println(stack1.peek() + stack2.peek() + stack3.peek() + stack4.peek() + stack5.peek() + stack6.peek() + stack7.peek() + stack8.peek() + stack9.peek());
    }
}
