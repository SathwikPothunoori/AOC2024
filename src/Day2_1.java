import java.io.*;
import java.util.*;

public class Day2_1 {
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
                // Split the line into two numbers
                String[] parts = line.trim().split("\\s+");
                int inc_dec = -1;

                for (int i = 0; i < parts.length-1; i++) {
                    int num1 = Integer.parseInt(parts[i]);
                    int num2 = Integer.parseInt(parts[i+1]);
                    int abs=Math.abs(num1-num2);

                    if(inc_dec!=-1){
                        if(num1 > num2 && inc_dec ==1) break;
                        if(num1 < num2 && inc_dec ==0) break;
                    }

                    if(num1 > num2) inc_dec = 0;
                    if(num1 < num2) inc_dec = 1;


                    if(!(abs>0 && abs<=3)){
                        break;
                    }

                    if(i== parts.length-2) ans++;
                }
            }

            writer.write(String.valueOf(ans));
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error reading or writing files: " + e.getMessage());
        }
    }
}
