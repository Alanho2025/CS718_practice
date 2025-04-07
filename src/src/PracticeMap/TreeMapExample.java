package PracticeMap;
import java.util.TreeMap;

public class TreeMapExample {
        private TreeMap<String, String> books = new TreeMap<>();

        public void addOrUpdateBook(String isbn, String title) {
            books.put(isbn, title);
            System.out.println("Book with ISBN " + isbn + " has been added/updated.");
        }

        public void removeBook(String isbn) {
            if (books.containsKey(isbn)) {
                books.remove(isbn);
                System.out.println("Book with ISBN " + isbn + " has been removed.");
            } else {
                System.out.println("Book with ISBN " + isbn + " is not in the inventory.");
            }
        }

        public void getBookTitle(String isbn) {
            String title = books.get(isbn);
            if (title != null) {
                System.out.println("ISBN " + isbn + ": " + title);
            } else {
                System.out.println("Book with ISBN " + isbn + " is not in the inventory.");
            }
        }

        public void displayAllBooks() {
            System.out.println("Book Inventory: " + books);
        }

        public static void main(String[] args) {
            TreeMapExample inventory = new TreeMapExample();

            // Add or update books
            inventory.addOrUpdateBook("978-0134685991", "Effective Java");
            inventory.addOrUpdateBook("978-1491950357", "Clean Architecture");
            inventory.addOrUpdateBook("978-0132350884", "Clean Code");

            // Display all books
            inventory.displayAllBooks();

            // Retrieve the title of a specific book by ISBN
            inventory.getBookTitle("978-0134685991");

            // Remove a book
            inventory.removeBook("978-1491950357");

            // Display all books after removal
            inventory.displayAllBooks();
        }
    }
