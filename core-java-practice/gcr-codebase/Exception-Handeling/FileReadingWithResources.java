import java.io.*;

/**
 * Problem 5: try-with-resources (Auto-closing Resources)
 * 
 * Write a Java program that reads the first line of a file named "info.txt" 
 * using BufferedReader.
 * Use try-with-resources to ensure the file is automatically closed after reading.
 */
public class FileReadingWithResources {
    
    public static void main(String[] args) {
        readFirstLine("info.txt");
    }
    
    /**
     * Reads and prints the first line of a file using try-with-resources
     * @param filename the name of the file to read
     */
    public static void readFirstLine(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String firstLine = reader.readLine();
            
            if (firstLine != null) {
                System.out.println("First line: " + firstLine);
            } else {
                System.out.println("File is empty");
            }
            
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
