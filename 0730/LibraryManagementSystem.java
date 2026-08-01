import java.util.*;

public class LibraryManagementSystem {
    private List<Book> books = new ArrayList<>();
    private Set<String> bookIds = new HashSet<>();

    public boolean addBook(Book book) {
        if (bookIds.contains(book.getId())) {
            return false;
        }
        bookIds.add(book.getId());
        books.add(book);
        return true;
    }

    public void run() {
        BookAlgorithms.binarySearchById(books, "B001");

        addBook(new Book("B003", "Java Programming", "CS", 120));
        addBook(new Book("B001", "Data Structures", "CS", 300));
        addBook(new Book("B002", "Algorithm Analysis", "CS", 250));
        addBook(new Book("B001", "Duplicate Book", "CS", 50));

        BookAlgorithms.mergeSort(books, 0, books.size() - 1, true);

        BookAlgorithms.mergeSort(books, 0, books.size() - 1, false);

        BookAlgorithms.mergeSort(books, 0, books.size() - 1, true);
        BookAlgorithms.binarySearchById(books, "B002");

        BookAlgorithms.sequentialSearchByTitle(books, "Python");
    }

    public static void main(String[] args) {
        new LibraryManagementSystem().run();
    }
}