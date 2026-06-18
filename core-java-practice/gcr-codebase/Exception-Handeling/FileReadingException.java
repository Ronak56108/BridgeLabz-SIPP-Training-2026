import java.io.*;

/**
 * Problem 1: Checked Exception (Compile-time Exception)
 * 
 * Create a Java program that reads a file named "data.txt". 
 * If the file does not exist, handle the IOException properly 
 * and display a user-friendly message.
 */
public class FileReadingException {
    
    public static void main(String[] args) {
        readFileContents("data.txt");
    }
    
    /**
     * Reads and prints the contents of a file
     * @param filename the name of the file to read
     */
    public static void readFileContents(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            
            System.out.println("File contents:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
            
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}
