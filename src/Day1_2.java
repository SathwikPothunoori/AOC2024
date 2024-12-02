import java.io.*;
import java.util.*;

public class Day1_2 {
    public static void main(String[] args) {
        // File paths (adjust as needed)
        String inputFilePath = "/Users/sathwikp/IdeaProjects/AOC2024/src/input.txt";
        String outputFilePath = "/Users/sathwikp/IdeaProjects/AOC2024/src/output.txt";

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
        )
        {
            String line;
            List<Long> arr1 = new ArrayList<>();
            List<Long> arr2 = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                // Split the line into two numbers
                String[] parts = line.trim().split("\\s+");
                long num1 = Long.parseLong(parts[0]);
                long num2 = Long.parseLong(parts[1]);

                arr1.add(num1);
                arr2.add(num2);
            }
            long result = 0;
            long c =0;
            // Write the result to the output file
            for (int i = 0; i < arr1.size(); i++) {
                long tar = arr1.get(i);
                long count = arr2.stream()
                        .filter(num -> num == tar)
                        .count();

                result+= (tar*count);
            }
            writer.write(String.valueOf(result));
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error reading or writing files: " + e.getMessage());
        }
    }
}