import java.util.*;

public class RepairSchedulingSystem {
    private List<RepairTask> allTasks = new ArrayList<>();
    private Queue<RepairTask> waitQueue = new LinkedList<>();
    private Stack<RepairTask> completedStack = new Stack<>();

    public void addTask(RepairTask task) {
        allTasks.add(task);
        waitQueue.offer(task);
    }

    public void completeTask() {
        if (!waitQueue.isEmpty()) {
            RepairTask finished = waitQueue.poll();
            completedStack.push(finished);
        }
    }

    public void completeMultipleTasks(int count) {
        while (count > 0 && !waitQueue.isEmpty()) {
            completeTask();
            count--;
        }
    }

    public List<RepairTask> searchByDeviceName(String name) {
        List<RepairTask> res = new ArrayList<>();
        for (RepairTask t : allTasks) {
            if (t.getDeviceName().equalsIgnoreCase(name)) {
                res.add(t);
            }
        }
        return res;
    }

    public void showStatistics() {
        System.out.printf("統計報告 -> 總計: %d | 等待中: %d | 已完成: %d\n", 
                          allTasks.size(), waitQueue.size(), completedStack.size());
    }

    public static void main(String[] args) {
        RepairSchedulingSystem sys = new RepairSchedulingSystem();
        sys.addTask(new RepairTask("T01", "Laptop A", 2));
        sys.addTask(new RepairTask("T02", "Server X", 5));
        sys.addTask(new RepairTask("T03", "Laptop B", 5)); 
        sys.addTask(new RepairTask("T04", "Printer", 1));

        RepairAlgorithms.mergeSortByPriorityDesc(sys.allTasks, 0, sys.allTasks.size() - 1);

        sys.completeMultipleTasks(2);
        sys.showStatistics();

        sys.searchByDeviceName("Laptop A");
    }
}