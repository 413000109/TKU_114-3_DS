public class ProductSortPractice {

    public static void insertionSortByPrice(Product[] products) {
        for (int i = 1; i < products.length; i++) {
            Product key = products[i];
            int j = i - 1;

            while (j >= 0 && products[j].getPrice() > key.getPrice()) {
                products[j + 1] = products[j];
                j--;
            }
            products[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "滑鼠", 590.0, 50),
            new Product(102, "鍵盤", 1200.0, 30),
            new Product(103, "耳機", 590.0, 20),
            new Product(104, "螢幕", 4500.0, 15),
            new Product(105, "喇叭", 1200.0, 25),
            new Product(106, "墊子", 290.0, 100),
            new Product(107, "線材", 290.0, 200),
            new Product(108, "支架", 890.0, 40)
        };

        System.out.println("=== 排序前商品清單 ===");
        for (Product p : products) {
            System.out.println(p);
        }

        insertionSortByPrice(products);

        System.out.println("\n=== 依價格升冪排序後商品清單（價格相同保持原始順序）===");
        for (Product p : products) {
            System.out.println(p);
        }
    }
}