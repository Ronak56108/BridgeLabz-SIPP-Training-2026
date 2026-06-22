import java.io.*;
import java.util.*;

public class EmailDomainCounter {
    public static void main(String[] args) {
        String inputFile = "employee_emails.txt";
        Map<String, Integer> domainCount = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                String domain = extractDomain(line);
                if (!domain.isEmpty()) {
                    domainCount.put(domain, domainCount.getOrDefault(domain, 0) + 1);
                }
            }
            for (Map.Entry<String, Integer> entry : domainCount.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + inputFile);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private static String extractDomain(String email) {
        int atIndex = email.indexOf('@');
        if (atIndex == -1 || atIndex == email.length() - 1) {
            return "";
        }
        return email.substring(atIndex + 1);
    }
}
