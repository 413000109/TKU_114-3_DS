import java.util.Scanner;

public class SeatNumberSearchPractice {

    public static void main(String[] args) {
        int[] seats = {101, 102, 105, 108, 110, 115, 120, 125, 130, 135, 140, 150};

        Scanner scanner = new Scanner(System.in);
        System.out.println("=== 課堂實踐題三：座位編號二分搜索 ===");
        System.out.print("請輸入要搜尋的座位編號: ");
        int target = scanner.nextInt();

        int low = 0;
        int high = seats.length - 1;
        int foundIndex = -1;
        int round = 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            System.out.printf("第 %d 輪 -> low: %d, mid: %d (值:%d), high: %d\n", 
                              round++, low, mid, seats[mid], high);

            if (seats[mid] == target) {
                foundIndex = mid;
                break;
            } else if (seats[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (foundIndex != -1) {
            System.out.println("搜尋成功！座位編號 " + target + " 位於索引: " + foundIndex);
        } else {
            System.out.println("搜尋失敗！座位編號 " + target + " 不存在。");
        }

        scanner.close();
    }
}