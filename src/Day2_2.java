import java.io.*;
import java.util.*;

public class Day2_2 {
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
            int ans =0;
            while ((line = reader.readLine()) != null) {

                if (isSafe(line) ||canBeMadeSafe(line)) {
                    ans++;
                }
            }

            writer.write(String.valueOf(ans));
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error reading or writing files: " + e.getMessage());
        }
    }
    private static boolean isSafe(String report) {
        String[] levelsStr = report.trim().split("\\s+");
        int[] levels = new int[levelsStr.length];

        for (int i = 0; i < levelsStr.length; i++) {
            levels[i] = Integer.parseInt(levelsStr[i]);
        }

        return isStrictlyIncreasingOrDecreasing(levels);
    }

    private static boolean canBeMadeSafe(String report) {
        String[] levelsStr = report.trim().split("\\s+");
        int[] levels = new int[levelsStr.length];

        for (int i = 0; i < levelsStr.length; i++) {
            levels[i] = Integer.parseInt(levelsStr[i]);
        }

        // try by removing each level and check if the report becomes safe
        for (int i = 0; i < levels.length; i++) {
            int[] modifiedLevels = new int[levels.length - 1];
            int index = 0;

            for (int j = 0; j < levels.length; j++) {
                if (j != i) {
                    modifiedLevels[index++] = levels[j];
                }
            }

            if (isStrictlyIncreasingOrDecreasing(modifiedLevels)) {
                return true;
            }
        }

        return false;
    }

    private static boolean isStrictlyIncreasingOrDecreasing(int[] levels) {
        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 1; i < levels.length; i++) {
            int diff = levels[i] - levels[i - 1];

            if (Math.abs(diff) < 1 || Math.abs(diff) > 3) {
                return false;
            }

            if (diff < 0 || diff==0) {
                increasing = false;
            } else if (diff > 0 || diff==0) {
                decreasing = false;
            }
        }

        return increasing || decreasing;
    }
}
