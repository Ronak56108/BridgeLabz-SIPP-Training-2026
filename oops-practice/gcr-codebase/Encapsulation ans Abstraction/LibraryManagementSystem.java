public class LibraryManagementSystem {
    public static void main(String[] args) {
        Book book = new Book("B001", "Java Fundamentals", "Alice");
        Magazine magazine = new Magazine("M001", "Tech Monthly", "Bob");
        DVD dvd = new DVD("D001", "Space Journey", "Charlie");

        book.displayItemDetails();
        System.out.println("Loan Duration: " + book.getLoanDuration() + " days\n");

        magazine.displayItemDetails();
        System.out.println("Loan Duration: " + magazine.getLoanDuration() + " days\n");

        dvd.displayItemDetails();
        System.out.println("Loan Duration: " + dvd.getLoanDuration() + " days");
    }
}

abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void displayItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }

    public abstract int getLoanDuration();
}

class Book extends LibraryItem {
    public Book(String itemId, String title, String author) {
        setItemId(itemId);
        setTitle(title);
        setAuthor(author);
    }

    @Override
    public int getLoanDuration() {
        return 14;
    }
}

class Magazine extends LibraryItem {
    public Magazine(String itemId, String title, String author) {
        setItemId(itemId);
        setTitle(title);
        setAuthor(author);
    }

    @Override
    public int getLoanDuration() {
        return 7;
    }
}

class DVD extends LibraryItem {
    public DVD(String itemId, String title, String author) {
        setItemId(itemId);
        setTitle(title);
        setAuthor(author);
    }

    @Override
    public int getLoanDuration() {
        return 3;
    }
}
