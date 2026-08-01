import java.util.List;
import java.util.ArrayList;

public class RepairAlgorithms {

    public static void mergeSortByPriorityDesc(List<RepairTask> tasks, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSortByPriorityDesc(tasks, left, mid);
        mergeSortByPriorityDesc(tasks, mid + 1, right);
        merge(tasks, left, mid, right);
    }

    private static void merge(List<RepairTask> tasks, int left, int mid, int right) {
        List<RepairTask> L = new ArrayList<>(tasks.subList(left, mid + 1));
        List<RepairTask> R = new ArrayList<>(tasks.subList(mid + 1, right + 1));

        int i = 0, j = 0, k = left;
        while (i < L.size() && j < R.size()) {
            if (L.get(i).getPriority() >= R.get(j).getPriority()) {
                tasks.set(k++, L.get(i++));
            } else {
                tasks.set(k++, R.get(j++));
            }
        }
        while (i < L.size()) tasks.set(k++, L.get(i++));
        while (j < R.size()) tasks.set(k++, R.get(j++));
    }
}