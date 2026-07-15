import java.util.Scanner;

public class ProductManagementSystem {
    public static void showAllProducts(Product[] products, int count) {
        System.out.println("\n--- 現貨庫存清單 (" + count + "/10) ---");
        if (count == 0) {
            System.out.println("目前無商品登錄。");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + products[i]);
        }
    }

    public static int findProductIndex(Product[] products, int count, String name) {
        if (name == null) {
            return -1;
        }
        String cleanName = name.trim().toLowerCase();
        for (int i = 0; i < count; i++) {
            if (products[i].getName().toLowerCase().equals(cleanName)) {
                return i;
            }
        }
        return -1;
    }

    public static void searchProduct(Scanner sc, Product[] products, int count) {
        System.out.print("請輸入商品名稱關鍵字：");
        String name = sc.nextLine();
        int idx = findProductIndex(products, count, name);
        if (idx != -1) {
            System.out.println("查詢成功：" + products[idx]);
        } else {
            System.out.println("無相符商品。");
        }
    }

    public static int addNewProduct(Scanner sc, Product[] products, int count) {
        if (count >= products.length) {
            System.out.println("錯誤：儲存格已滿 (10/10)！");
            return count;
        }

        System.out.print("請輸入新商品名稱：");
        String name = sc.nextLine();
        if (name.trim().isEmpty()) {
            System.out.println("錯誤：名稱不可為空！");
            return count;
        }

        if (findProductIndex(products, count, name) != -1) {
            System.out.println("錯誤：此品名已存在！");
            return count;
        }

        System.out.print("請輸入定價：");
        int price = sc.nextInt();
        System.out.print("請輸入初期入庫數量：");
        int stock = sc.nextInt();
        sc.nextLine();

        if (price <= 0 || stock < 0) {
            System.out.println("錯誤：價格或庫存初始設定不合規範！");
            return count;
        }

        products[count] = new Product(name, price, stock);
        System.out.println("商品「" + name.trim() + "」已建檔！");
        return count + 1;
    }

    public static void sellProduct(Scanner sc, Product[] products, int count, int[] summary) {
        System.out.print("請輸入出售商品名稱：");
        String name = sc.nextLine();
        int idx = findProductIndex(products, count, name);
        if (idx == -1) {
            System.out.println("錯誤：查無此商品！");
            return;
        }

        System.out.print("請輸入出售數量：");
        int qty = sc.nextInt();
        sc.nextLine();

        if (products[idx].sell(qty)) {
            summary[idx] += qty;
            System.out.println("出貨成功！");
        } else {
            System.out.println("出貨失敗：庫存不足或輸入數量有誤。");
        }
    }

    public static void restockProduct(Scanner sc, Product[] products, int count) {
        System.out.print("請輸入補貨商品名稱：");
        String name = sc.nextLine();
        int idx = findProductIndex(products, count, name);
        if (idx == -1) {
            System.out.println("錯誤：查無此商品！");
            return;
        }

        System.out.print("請輸入補貨數量：");
        int qty = sc.nextInt();
        sc.nextLine();

        if (products[idx].restock(qty)) {
            System.out.println("補貨完畢！當前庫存為：" + products[idx].getStock());
        } else {
            System.out.println("補貨失敗：輸入數量錯誤。");
        }
    }

    public static void applyGlobalDiscount(Scanner sc, Product[] products, int count) {
        System.out.print("請輸入折扣比例 (例如: 輸入 90 代表 9 折，輸入 85 代表 85 折)：");
        int percent = sc.nextInt();
        sc.nextLine();

        if (percent <= 0 || percent >= 100) {
            System.out.println("無效的折扣比例！");
            return;
        }

        double factor = percent / 100.0;
        for (int i = 0; i < count; i++) {
            int newPrice = (int) Math.round(products[i].getPrice() * factor);
            products[i].setPrice(newPrice);
        }
        System.out.println("全館商品已成功套用 " + percent + "% 折扣！");
    }

    public static long calculateTotalInventoryValue(Product[] products, int count) {
        long total = 0;
        for (int i = 0; i < count; i++) {
            total += products[i].getInventoryValue();
        }
        return total;
    }

    public static void printSummaryReport(Product[] products, int count, int[] summary) {
        System.out.println("\n================ 當日銷貨結算 ================");
        int totalRevenue = 0;
        for (int i = 0; i < count; i++) {
            if (summary[i] > 0) {
                int salesAmt = summary[i] * products[i].getPrice();
                System.out.println(products[i].getName() + " 累計銷售：" + summary[i] + " 件 | 總額：" + salesAmt);
                totalRevenue += salesAmt;
            }
        }
        System.out.println("本日累積營業總額：" + totalRevenue + " 元");
        System.out.println("=========================================");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product[] products = new Product[10];

        products[0] = new Product("Espresso Beans", 450, 30);
        products[1] = new Product("Drip Filter Paper", 120, 100);
        products[2] = new Product("Coffee Grinder", 2800, 5);
        products[3] = new Product("Moka Pot", 1650, 12);
        products[4] = new Product("Ceramic Mug", 350, 40);
        int count = 5;

        int[] summary = new int[products.length];

        int choice;
        do {
            System.out.println("\n===== 營運型咖啡周邊管理系統 =====");
            System.out.println("1. 顯示全部現貨商品");
            System.out.println("2. 查詢特定商品");
            System.out.println("3. 新商品建檔");
            System.out.println("4. 銷貨出庫");
            System.out.println("5. 進貨入庫");
            System.out.println("6. 全館商品統一折扣");
            System.out.println("7. 計算庫存總資產");
            System.out.println("8. 關機並結帳");
            System.out.print("請輸入操作代碼 (1~8)：");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    showAllProducts(products, count);
                    break;
                case 2:
                    searchProduct(sc, products, count);
                    break;
                case 3:
                    count = addNewProduct(sc, products, count);
                    break;
                case 4:
                    sellProduct(sc, products, count, summary);
                    break;
                case 5:
                    restockProduct(sc, products, count);
                    break;
                case 6:
                    applyGlobalDiscount(sc, products, count);
                    break;
                case 7:
                    System.out.println("\n現有商品庫存總資產：" + calculateTotalInventoryValue(products, count) + " 元");
                    break;
                case 8:
                    printSummaryReport(products, count, summary);
                    System.out.println("系統正常關機。");
                    break;
                default:
                    System.out.println("輸入代碼無效！");
            }
        } while (choice != 8);

        sc.close();
    }
}

/*
========================= 測試案例清單 =========================
1. 正常商品名稱查詢：搜尋 "Moka Pot"，預期成功找到。
2. 模糊空格名稱查詢：搜尋 "  espresso beans  "，預期自動忽略首尾空格成功找到。
3. 全館打九折：輸入折扣 90，預期所有商品價格按比例更新（Mug $350 變 $315）。
4. 無效折扣輸入：輸入折扣 0 或負數，預期顯示無效折扣。
5. 正常新增商品：新增 "Pour Over Kettle", 1200, 10，預期新增成功。
6. 重複品名防錯：新增 "Ceramic Mug"（重複），預期顯示此品名已存在。
7. 正常銷貨扣除：出售 "Espresso Beans" 10 包，庫存由 30 降至 20。
8. 庫存不足防呆：出售 "Coffee Grinder" 6 台（現存 5 台），預期交易失敗。
9. 正常進貨補庫：為 "Moka Pot" 進貨 8 台，庫存由 12 升至 20。
10. 空值建檔防呆：新增商品時品名輸入空白，預期提示錯誤並取消。
==============================================================
*/