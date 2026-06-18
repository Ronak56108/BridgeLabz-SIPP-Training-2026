import java.util.Scanner;

/**
 * Additional Problem 2: Smart Library System
 * 
 * Books are stored as strings in an array.
 * String books[] = {"Java","Python",null,"C++"};
 * 
 * A method:
 * getBookLength(int index)
 * returns the length of the book name.
 * 
 * Scenario:
 * User requests:
 * - Invalid index
 * - Book entry containing null
 * 
 * Task:
 * Handle both exceptions separately and provide custom messages.
 */
public class SmartLibrarySystem {
    
    private String[] books;
    private boolean[] isIssued;
    private String[] issuedTo;
    
    public SmartLibrarySystem(int capacity) {
        this.books = new String[capacity];
        this.isIssued = new boolean[capacity];
        this.issuedTo = new String[capacity];
    }
    
    /**
     * Add a book to the library
     */
    public void addBook(int index, String bookName) {
        try {
            if (index < 0 || index >= books.length) {
                throw new ArrayIndexOutOfBoundsException("Invalid shelf position: " + index);
            }
            
            if (bookName == null || bookName.trim().isEmpty()) {
                throw new IllegalArgumentException("Book name cannot be null or empty");
            }
            
            books[index] = bookName;
            System.out.println("✓ Book added: " + bookName + " at shelf " + index);
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    /**
     * Get book name by index
     */
    public String getBook(int index) {
        try {
            if (index < 0 || index >= books.length) {
                throw new ArrayIndexOutOfBoundsException("Invalid shelf position: " + index);
            }
            
            String book = books[index];
            
            if (book == null) {
                throw new NullPointerException("No book found at shelf " + index);
            }
            
            return book;
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
    
    /**
     * Get the length of book name
     * Handles both ArrayIndexOutOfBoundsException and NullPointerException
     */
    public int getBookLength(int index) {
        try {
            // Check if index is valid
            if (index < 0 || index >= books.length) {
                throw new ArrayIndexOutOfBoundsException("Invalid shelf position: " + index + 
                                                        ". Available shelves: 0 to " + 
                                                        (books.length - 1));
            }
            
            // Check if book exists at that position
            if (books[index] == null) {
                throw new NullPointerException("No book at shelf " + index + 
                                              ". Please add a book first.");
            }
            
            int length = books[index].length();
            return length;
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid Shelf - " + e.getMessage());
            return -1;
        } catch (NullPointerException e) {
            System.out.println("Error: Null Book - " + e.getMessage());
            return -1;
        }
    }
    
    /**
     * Issue a book to a student
     */
    public void issueBook(int index, String studentName) {
        try {
            if (index < 0 || index >= books.length) {
                throw new ArrayIndexOutOfBoundsException("Invalid shelf position");
            }
            
            if (books[index] == null) {
                throw new NullPointerException("No book at this shelf");
            }
            
            if (isIssued[index]) {
                System.out.println("Error: Book '" + books[index] + "' is already issued to " + 
                                 issuedTo[index]);
                return;
            }
            
            isIssued[index] = true;
            issuedTo[index] = studentName;
            System.out.println("✓ Book '" + books[index] + "' issued to " + studentName);
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    /**
     * Return a book to the library
     */
    public void returnBook(int index) {
        try {
            if (index < 0 || index >= books.length) {
                throw new ArrayIndexOutOfBoundsException("Invalid shelf position");
            }
            
            if (books[index] == null) {
                throw new NullPointerException("No book at this shelf");
            }
            
            if (!isIssued[index]) {
                System.out.println("Book '" + books[index] + "' is not issued");
                return;
            }
            
            String wasIssuedTo = issuedTo[index];
            isIssued[index] = false;
            issuedTo[index] = null;
            System.out.println("✓ Book '" + books[index] + "' returned by " + wasIssuedTo);
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    /**
     * Display all books in the library
     */
    public void displayAllBooks() {
        System.out.println("\n--- Library Inventory ---");
        boolean hasBooks = false;
        
        for (int i = 0; i < books.length; i++) {
            try {
                if (books[i] != null) {
                    String status = isIssued[i] ? "Issued to: " + issuedTo[i] : "Available";
                    System.out.println("Shelf " + i + ": " + books[i] + " (Length: " + 
                                     books[i].length() + ") - " + status);
                    hasBooks = true;
                } else {
                    System.out.println("Shelf " + i + ": [Empty]");
                }
            } catch (NullPointerException e) {
                System.out.println("Shelf " + i + ": [Error: Null reference]");
            }
        }
        
        if (!hasBooks) {
            System.out.println("Library is empty!");
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SmartLibrarySystem library = new SmartLibrarySystem(5);
        
        // Add some books
        library.addBook(0, "Java");
        library.addBook(1, "Python");
        // Shelf 2 is left empty (null)
        library.addBook(3, "C++");
        library.addBook(4, "JavaScript");
        
        System.out.println("\n--- Testing getBookLength() ---");
        
        // Test valid shelf with book
        System.out.println("Book length at shelf 0: " + library.getBookLength(0));
        
        // Test shelf with null book
        System.out.println("Book length at shelf 2: " + library.getBookLength(2));
        
        // Test invalid shelf
        System.out.println("Book length at shelf 8: " + library.getBookLength(8));
        
        // Display library
        library.displayAllBooks();
        
        // Interactive menu
        boolean running = true;
        while (running) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Get Book Length");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Display All Books");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                
                switch (choice) {
                    case 1:
                        System.out.print("Enter shelf position: ");
                        int index = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter book name: ");
                        String bookName = scanner.nextLine();
                        library.addBook(index, bookName);
                        break;
                        
                    case 2:
                        System.out.print("Enter shelf position: ");
                        int shelfIndex = scanner.nextInt();
                        int length = library.getBookLength(shelfIndex);
                        if (length != -1) {
                            System.out.println("Book length: " + length);
                        }
                        break;
                        
                    case 3:
                        System.out.print("Enter shelf position: ");
                        int issueIndex = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter student name: ");
                        String studentName = scanner.nextLine();
                        library.issueBook(issueIndex, studentName);
                        break;
                        
                    case 4:
                        System.out.print("Enter shelf position: ");
                        int returnIndex = scanner.nextInt();
                        library.returnBook(returnIndex);
                        break;
                        
                    case 5:
                        library.displayAllBooks();
                        break;
                        
                    case 6:
                        running = false;
                        System.out.println("Thank you for using Smart Library System!");
                        break;
                        
                    default:
                        System.out.println("Invalid option!");
                }
            } catch (Exception e) {
                System.out.println("Error: Invalid input");
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }
}
