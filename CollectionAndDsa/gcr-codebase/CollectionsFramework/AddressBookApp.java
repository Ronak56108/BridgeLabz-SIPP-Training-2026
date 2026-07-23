import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class AddressBookApp {
    static class Contact implements Comparable<Contact> {
        String name;
        String phone;
        String email;

        Contact(String name, String phone, String email) {
            this.name = name;
            this.phone = phone;
            this.email = email;
        }

        @Override
        public int compareTo(Contact other) {
            return this.name.compareToIgnoreCase(other.name);
        }

        @Override
        public String toString() {
            return String.format("Name: %s, Phone: %s, Email: %s", name, phone, email);
        }
    }

    private final List<Contact> contacts = new ArrayList<>();
    private final HashMap<String, Contact> nameIndex = new HashMap<>();
    private final HashSet<String> phoneNumbers = new HashSet<>();

    public boolean addContact(String name, String phone, String email) {
        if (nameIndex.containsKey(name)) {
            System.out.println("A contact with that name already exists: " + name);
            return false;
        }
        if (phoneNumbers.contains(phone)) {
            System.out.println("Duplicate phone number not allowed: " + phone);
            return false;
        }

        Contact contact = new Contact(name, phone, email);
        contacts.add(contact);
        nameIndex.put(name, contact);
        phoneNumbers.add(phone);
        return true;
    }

    public Contact search(String name) {
        return nameIndex.get(name);
    }

    public boolean delete(String name) {
        Contact contact = nameIndex.remove(name);
        if (contact == null) {
            return false;
        }
        contacts.remove(contact);
        phoneNumbers.remove(contact.phone);
        return true;
    }

    public void displaySortedByName() {
        List<Contact> sortedContacts = new ArrayList<>(contacts);
        Collections.sort(sortedContacts);
        System.out.println("\nAddress Book (sorted by name):");
        for (Contact contact : sortedContacts) {
            System.out.println(contact);
        }
    }

    public static void main(String[] args) {
        AddressBookApp addressBook = new AddressBookApp();

        addressBook.addContact("Alice Parker", "9876543210", "alice@example.com");
        addressBook.addContact("Bob Carter", "9123456780", "bob@example.com");
        addressBook.addContact("Claire Mason", "9988776655", "claire@example.com");
        addressBook.addContact("David Lee", "9234567890", "david@example.com");

        addressBook.displaySortedByName();

        System.out.println("\nSearching for Bob Carter:");
        Contact found = addressBook.search("Bob Carter");
        System.out.println(found != null ? found : "Contact not found.");

        System.out.println("\nDeleting Claire Mason...");
        addressBook.delete("Claire Mason");
        addressBook.displaySortedByName();
    }
}
