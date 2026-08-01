import java.util.List;
import java.util.ArrayList;

public class RegistrationAlgorithms {

    public static void mergeSortById(List<Registration> list, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSortById(list, left, mid);
        mergeSortById(list, mid + 1, right);
        merge(list, left, mid, right);
    }

    private static void merge(List<Registration> list, int left, int mid, int right) {
        List<Registration> L = new ArrayList<>(list.subList(left, mid + 1));
        List<Registration> R = new ArrayList<>(list.subList(mid + 1, right + 1));
        int i = 0, j = 0, k = left;
        while (i < L.size() && j < R.size()) {
            if (L.get(i).getId().compareTo(R.get(j).getId()) <= 0) {
                list.set(k++, L.get(i++));
            } else {
                list.set(k++, R.get(j++));
            }
        }
        while (i < L.size()) list.set(k++, L.get(i++));
        while (j < R.size()) list.set(k++, R.get(j++));
    }

    public static int binarySearchById(List<Registration> list, String id) {
        int low = 0, high = list.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = list.get(mid).getId().compareTo(id);
            if (cmp == 0) return mid;
            if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static Registration sequentialSearchByName(List<Registration> list, String name) {
        for (Registration r : list) {
            if (r.getName().equalsIgnoreCase(name)) return r;
        }
        return null;
    }
}