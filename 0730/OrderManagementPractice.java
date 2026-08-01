import java.util.*;

public class OrderManagementPractice {
    private List<Order> mainOrders = new ArrayList<>();
    private Queue<Order> pendingQueue = new LinkedList<>();
    private Stack<Order> completedStack = new Stack<>();
    private Set<String> orderIdSet = new HashSet<>();

    public boolean addOrder(Order order) {
        if (orderIdSet.contains(order.getId())) {
            return false;
        }
        orderIdSet.add(order.getId());
        mainOrders.add(order);
        pendingQueue.offer(order);
        return true;
    }

    public void processNextOrder() {
        if (pendingQueue.isEmpty()) {
            return;
        }
        Order processed = pendingQueue.poll();
        completedStack.push(processed);
    }

    public Order peekNextOrder() {
        return pendingQueue.peek();
    }

    public static void main(String[] args) {
        OrderManagementPractice sys = new OrderManagementPractice();

        sys.peekNextOrder();
        sys.processNextOrder();

        sys.addOrder(new Order("O101", "Alice", 1500));
        sys.addOrder(new Order("O102", "Bob", 3200));
        sys.addOrder(new Order("O101", "Charlie", 800));

        OrderAlgorithms.mergeSortByAmountDesc(sys.mainOrders, 0, sys.mainOrders.size() - 1);

        OrderAlgorithms.searchByCustomerName(sys.mainOrders, "Bob");
        OrderAlgorithms.searchByCustomerName(sys.mainOrders, "David");
    }
}