import java.io.*;
import java.util.ArrayList;
 
public class GradeAnalyzer {
 
    public static void main(String[] args) {
        ArrayList<Integer> scores = (readScores("scores.txt"));
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;
        double average = calculateAverage(scores);
        for(int i = 0; i < scores.size(); i++) {
            int curr = scores.get(i);
            if (curr > highest) {
                highest = curr;
            }
            if (curr < lowest) {
                lowest = curr;
            }
        }

        writeReport(scores, average, highest, lowest, "report.txt");

    } 
 
    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {

        ArrayList<Integer> scores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String trimmed = line.trim();
                
                if (!trimmed.isEmpty()) {
                    try {
                        int score = Integer.parseInt(trimmed);
                        scores.add(score);
                    } catch (NumberFormatException e) {
                    System.out.println("Warning: skipping invalid line -> \"" + trimmed + "\"");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }
        return scores;
    }
 
    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        double average = 0.0;
        if (scores.isEmpty()) {
            return average;
        } else {
            for (int i = 0; i < scores.size(); i++) {
                average += scores.get(i);
            }
        }

        average = average / scores.size();
        return average;
    } 
 
    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,
                                   String outputFile) {
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countF = 0;

        for (int i = 0; i < scores.size(); i++) {
               int curr = scores.get(i);
               if (curr >= 90) {
                    countA++;
               } else if (curr >= 80) {
                    countB++;
               } else if (curr >= 70) {
                    countC++;
               } else if (curr >= 60) {
                    countD++;
               } else  {
                    countF++;
               } 
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                String[] lines = {
                    "=== Grade Analysis Report ===",
                    String.format("Total scores processed: %3d", scores.size()),
                    "",
                    String.format("Average score: %7.2f", avg),
                    String.format("Highest score: %7d", high),
                    String.format("Lowest score:  %7d", low),
                    "",
                    "Grade distribution:",
                    String.format("  A (90-100):   %d", countA),
                    String.format("  B (80-89):    %d", countB),
                    String.format("  C (70-79):    %d", countC),
                    String.format("  D (60-69):    %d", countD),
                    String.format("  F (below 60): %d", countF)
                };

                for (String line : lines) {
                    writer.write(line);
                    writer.newLine();
                    System.out.println(line);
                }

        } catch (IOException e) {
            System.out.println("Error writing report: " + e.getMessage());
        }
        
        }
        
}


 