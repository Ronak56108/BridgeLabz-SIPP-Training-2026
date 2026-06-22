import java.io.*;
import java.util.*;

public class CustomerFeedbackAnalyzer {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter 5 feedback messages:");
        int goodCount = 0;

        try {
            for (int i = 0; i < 5; i++) {
                String feedback = reader.readLine();
                if (feedback == null) {
                    break;
                }
                if (feedback.toLowerCase().contains("good")) {
                    goodCount++;
                }
            }
            System.out.println("Good Feedback Count = " + goodCount);
        } catch (IOException e) {
            System.out.println("Error reading feedback: " + e.getMessage());
        }
    }
}
