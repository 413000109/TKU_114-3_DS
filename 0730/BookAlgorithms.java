import java.util.List;
import java.util.ArrayList;

public class BookAlgorithms {

    public static void mergeSort(List<Book> books, int left, int right, boolean sortByIdAsc) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(books, left, mid, sortByIdAsc);
        mergeSort(books, mid + 1, right, sortByIdAsc);
        merge(books, left, mid, right, sortByIdAsc);
    }

    private static void merge(List<Book> books, int left, int mid, int right, boolean sortByIdAsc) {
        List<Book> L = new ArrayList<>(books.subList(left, mid + 1));
        List<Book> R = new ArrayList<>(books.subList(mid + 1, right + 1));

        int i = 0, j = 0, k = left;
        while (i < L.size() && j < R.size()) {
            boolean condition = sortByIdAsc ? 
                L.get(i).getId().compareTo(R.get(j).getId()) <= 0 : 
                L.get(i).getBorrowCount() >= R.get(j).getBorrowCount();

            if (condition) {
                books.set(k++, L.get(i++));
            } else {
                books.set(k++, R.get(j++));
            }
        }
        while (i < L.size()) books.set(k++, L.get(i++));
        while (j < R.size()) books.set(k++, R.get(j++));
    }

    public static int binarySearchById(List<Book> books, String targetId) {
        int low = 0, high = books.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = books.get(mid).getId().compareTo(targetId);
            if (cmp == 0) return mid;
            if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static List<Book> sequentialSearchByTitle(List<Book> books, String keyword) {
        List<Book> results = new ArrayList<>();
        for (Book b : books) {
            if (b.getTitle().contains(keyword)) {
                results.add(b);
            }
        }
        return results;
    }
}