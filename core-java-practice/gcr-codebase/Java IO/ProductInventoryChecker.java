import java.io.*;

public class ProductInventoryChecker {
    public static void main(String[] args) {
        String inputFile = "inventory.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] parts = line.split("-");
                if (parts.length != 2) {
                    continue;
                }
                String product = parts[0].trim();
                int quantity;
                try {
                    quantity = Integer.parseInt(parts[1].trim());
                } catch (NumberFormatException e) {
                    continue;
                }
                if (quantity == 0) {
                    System.out.println(product + " is out of stock");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + inputFile);
        } catch (IOException e) {
            System.out.println("Error reading inventory: " + e.getMessage());
        }
    }
}
