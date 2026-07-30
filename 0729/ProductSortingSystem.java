import java.util.Scanner;

public class ProductSortingSystem {

    public static StoreProduct[] copyArray(StoreProduct[] source) {
        StoreProduct[] copy = new StoreProduct[source.length];
        System.arraycopy(source, 0, copy, 0, source.length);
        return copy;
    }

    public static void sortByPriceAsc(StoreProduct[] arr) {
        for (int i = 1; i < arr.length; i++) {
            StoreProduct key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].getPrice() > key.getPrice()) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void sortByPriceDesc(StoreProduct[] arr) {
        for (int i = 1; i < arr.length; i++) {
            StoreProduct key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].getPrice() < key.getPrice()) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void sortByStockDesc(StoreProduct[] arr) {
        for (int i = 1; i < arr.length; i++) {
            StoreProduct key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].getStock() < key.getStock()) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void display(StoreProduct[] arr, String sortField, String direction) {
        System.out.println("\n【排序結果】欄位: " + sortField + " | 方向: " + direction);
        for (StoreProduct p : arr) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        StoreProduct[] original = {
            new StoreProduct(1, "筆記型電腦", 35000.0, 10),
            new StoreProduct(2, "智慧型手機", 28000.0, 25),
            new StoreProduct(3, "藍牙音響", 2500.0, 50),
            new StoreProduct(4, "無線滑鼠", 650.0, 120),
            new StoreProduct(5, "機械鍵盤", 2500.0, 40),
            new StoreProduct(6, "曲面螢幕", 8900.0, 15),
            new StoreProduct(7, "行動電源", 800.0, 80),
            new StoreProduct(8, "外接硬碟", 3100.0, 30),
            new StoreProduct(9, "遊戲手把", 1500.0, 60),
            new StoreProduct(10, "網路攝影機", 1800.0, 20)
        };

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== 商品排序系統選單 ===");
            System.out.println("1. 依價格升冪排序");
            System.out.println("2. 依價格降冪排序");
            System.out.println("3. 依庫存降冪排序");
            System.out.println("4. 離開系統");
            System.out.print("請選擇操作 (1-4): ");

            int choice = scanner.nextInt();
            if (choice == 4) break;

            StoreProduct[] testData = copyArray(original);

            switch (choice) {
                case 1:
                    sortByPriceAsc(testData);
                    display(testData, "價格", "升冪");
                    break;
                case 2:
                    sortByPriceDesc(testData);
                    display(testData, "價格", "降冪");
                    break;
                case 3:
                    sortByStockDesc(testData);
                    display(testData, "庫存", "降冪");
                    break;
                default:
                    System.out.println("無效選擇，請重新輸入！");
            }
        }
        scanner.close();
    }
}