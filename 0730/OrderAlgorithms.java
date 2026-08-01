import java.util.List;
import java.util.ArrayList;

public class OrderAlgorithms {

    public static void mergeSortByAmountDesc(List<Order> orders, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSortByAmountDesc(orders, left, mid);
        mergeSortByAmountDesc(orders, mid + 1, right);
        merge(orders, left, mid, right);
    }

    private static void merge(List<Order> orders, int left, int mid, int right) {
        List<Order> L = new ArrayList<>(orders.subList(left, mid + 1));
        List<Order> R = new ArrayList<>(orders.subList(mid + 1, right + 1));

        int i = 0, j = 0, k = left;
        while (i < L.size() && j < R.size()) {
            if (L.get(i).getAmount() >= R.get(j).getAmount()) {
                orders.set(k++, L.get(i++));
            } else {
                orders.set(k++, R.get(j++));
            }
        }
        while (i < L.size()) orders.set(k++, L.get(i++));
        while (j < R.size()) orders.set(k++, R.get(j++));
    }

    public static List<Order> searchByCustomerName(List<Order> orders, String customerName) {
        List<Order> result = new ArrayList<>();
        for (Order o : orders) {
            if (o.getCustomerName().equalsIgnoreCase(customerName)) {
                result.add(o);
            }
        }
        return result;
    }
}