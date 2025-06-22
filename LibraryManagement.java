import java.io.*;
import java.util.*;

class Book {
    String title, author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return title + " by " + author;
    }
}

public class LibraryManagement {
    static ArrayList<Book> books = new ArrayList<>();
    static String filename = "books.txt";

    public static void main(String[] args) {
        loadBooks();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add Book\n2. View Books\n3. Delete Book\n4. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline
            switch (choice) {
                case 1 -> addBook(sc);
                case 2 -> viewBooks();
                case 3 -> deleteBook(sc);
                case 4 -> {
                    saveBooks();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    static void addBook(Scanner sc) {
        System.out.print("Title: ");
        String title = sc.nextLine();
        System.out.print("Author: ");
        String author = sc.nextLine();
        books.add(new Book(title, author));
        System.out.println("Book added.");
    }

    static void viewBooks() {
        if (books.isEmpty()) System.out.println("No books available.");
        else {
            System.out.println("\nBooks in Library:");
            for (int i = 0; i < books.size(); i++)
                System.out.println((i + 1) + ". " + books.get(i));
        }
    }

    static void deleteBook(Scanner sc) {
        viewBooks();
        System.out.print("Enter book number to delete: ");
        int index = sc.nextInt();
        if (index > 0 && index <= books.size()) {
            books.remove(index - 1);
            System.out.println("Book removed.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    static void saveBooks() {
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (Book b : books)
                writer.println(b.title + ";" + b.author);
        } catch (Exception e) {
            System.out.println("Error saving books.");
        }
    }

    static void loadBooks() {
        try (Scanner file = new Scanner(new File(filename))) {
            while (file.hasNextLine()) {
                String[] data = file.nextLine().split(";");
                books.add(new Book(data[0], data[1]));
            }
        } catch (Exception e) {
            // File not found, ignore
        }
    }
}
