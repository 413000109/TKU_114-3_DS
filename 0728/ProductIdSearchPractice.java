import java.util.Scanner;

public class ProductIdSearchPractice {

    public static void main(String[] args) {
        int[] productIds = {105, 302, 101, 888, 405, 209, 777, 512};

        Scanner scanner = new Scanner(System.in);
        System.out.println("=== 課堂實踐題二：商品編號循序搜索 ===");
        System.out.print("請輸入要搜尋的商品編號: ");
        int target = scanner.nextInt();

        int foundIndex = -1;
        int compareCount = 0;

        for (int i = 0; i < productIds.length; i++) {
            compareCount++;
            if (productIds[i] == target) {
                foundIndex = i;
                break;
            }
        }

        System.out.println("實際比較次數: " + compareCount);
        if (foundIndex != -1) {
            System.out.println("成功找到商品！索引位置為: " + foundIndex);
        } else {
            System.out.println("找不到商品編號 " + target + "！");
        }

        scanner.close();
    }
}