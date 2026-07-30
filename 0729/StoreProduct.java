public class StoreProduct {
    private int id;
    private String name;
    private double price;
    private int stock;

    public StoreProduct(int id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }

    @Override
    public String toString() {
        return String.format("編號: %-4d | 名稱: %-8s | 價格: %-7.1f | 庫存: %-4d", 
                             id, name, price, stock);
    }
}