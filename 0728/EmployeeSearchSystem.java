import java.util.Scanner;

public class EmployeeSearchSystem {

    public static Employee binarySearchById(Employee[] employees, int targetId) {
        int low = 0;
        int high = employees.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (employees[mid].getId() == targetId) {
                return employees[mid];
            } else if (employees[mid].getId() < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Employee[] employees = {
            new Employee(1001, "張三", "資訊部", "801"),
            new Employee(1005, "李四", "財務部", "805"),
            new Employee(1012, "王五", "研發部", "812"),
            new Employee(1020, "趙六", "業務部", "820"),
            new Employee(1035, "孫七", "人資部", "835")
        };

        Scanner scanner = new Scanner(System.in);
        System.out.println("=== 課後作業三：員工編號查詢系統 ===");
        System.out.print("請輸入欲查詢的員工編號: ");
        String input = scanner.nextLine().trim();

        if (input.isEmpty()) {
            System.out.println("錯誤：輸入內容不可為空白！");
            scanner.close();
            return;
        }

        try {
            int targetId = Integer.parseInt(input);
            Employee result = binarySearchById(employees, targetId);

            if (result != null) {
                System.out.println("【查詢結果】");
                System.out.println(result);
            } else {
                System.out.println("系統說明：查無員工編號為 " + targetId + " 的紀錄。");
            }
        } catch (NumberFormatException e) {
            System.out.println("錯誤：請輸入有效的純數字員工編號！");
        }

        scanner.close();
    }
}