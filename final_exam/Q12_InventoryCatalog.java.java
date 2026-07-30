import java.util.ArrayList;

class Q12_Product {
    private String id;
    private String name;
    private int price;
    private int stock;

    public Q12_Product(
        String id,
        String name,
        int price,
        int stock
    ) {
        if (id == null) {
            this.id = "";
        } else {
            this.id = id.trim();
        }

        if (name == null) {
            this.name = "";
        } else {
            this.name = name.trim();
        }

        this.price = price < 0 ? 0 : price;
        this.stock = stock < 0 ? 0 : stock;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return id + " " + name
            + " price=" + price
            + " stock=" + stock;
    }
}

public class Q12_InventoryCatalog {

    private ArrayList<Q12_Product> products =
        new ArrayList<>();

    public boolean addProduct(Q12_Product product) {

        if (product == null) {
            return false;
        }

        String newId = product.getId();

        if (newId == null || newId.trim().isEmpty()) {
            return false;
        }

        for (int i = 0; i < products.size(); i++) {
            Q12_Product current = products.get(i);

            if (current.getId().equalsIgnoreCase(newId)) {
                return false;
            }
        }

        products.add(product);
        return true;
    }

    public Q12_Product[] createSortedCopyById() {

        Q12_Product[] result =
            products.toArray(new Q12_Product[products.size()]);

        if (result.length < 2) {
            return result;
        }

        Q12_Product[] buffer =
            new Q12_Product[result.length];

        mergeSort(result, buffer, 0, result.length - 1);

        return result;
    }

    private void mergeSort(
        Q12_Product[] data,
        Q12_Product[] buffer,
        int left,
        int right
    ) {
        if (left >= right) {
            return;
        }

        int middle = left + (right - left) / 2;

        mergeSort(data, buffer, left, middle);
        mergeSort(data, buffer, middle + 1, right);

        merge(data, buffer, left, middle, right);
    }

    private void merge(
        Q12_Product[] data,
        Q12_Product[] buffer,
        int left,
        int middle,
        int right
    ) {
        for (int i = left; i <= right; i++) {
            buffer[i] = data[i];
        }

        int leftIndex = left;
        int rightIndex = middle + 1;
        int position = left;

        while (leftIndex <= middle &&
               rightIndex <= right) {

            String leftId = buffer[leftIndex].getId();
            String rightId = buffer[rightIndex].getId();

            if (leftId.compareToIgnoreCase(rightId) <= 0) {
                data[position] = buffer[leftIndex];
                leftIndex++;
            } else {
                data[position] = buffer[rightIndex];
                rightIndex++;
            }

            position++;
        }

        while (leftIndex <= middle) {
            data[position] = buffer[leftIndex];
            leftIndex++;
            position++;
        }

        while (rightIndex <= right) {
            data[position] = buffer[rightIndex];
            rightIndex++;
            position++;
        }
    }

    public Q12_Product binarySearchById(
        Q12_Product[] sortedProducts,
        String id
    ) {
        if (sortedProducts == null ||
            id == null ||
            id.trim().isEmpty()) {
            return null;
        }

        String target = id.trim();

        int low = 0;
        int high = sortedProducts.length - 1;

        while (low <= high) {

            int middle = low + (high - low) / 2;

            Q12_Product current = sortedProducts[middle];

            if (current == null) {
                return null;
            }

            int comparison =
                current.getId().compareToIgnoreCase(target);

            if (comparison == 0) {
                return current;
            }

            if (comparison < 0) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        return null;
    }

    public ArrayList<Q12_Product> findByNameKeyword(
        String keyword
    ) {
        ArrayList<Q12_Product> result =
            new ArrayList<>();

        if (keyword == null ||
            keyword.trim().isEmpty()) {
            return result;
        }

        String target = keyword.trim().toLowerCase();

        for (int i = 0; i < products.size(); i++) {

            Q12_Product product = products.get(i);

            String name = product.getName();

            if (name.toLowerCase().contains(target)) {
                result.add(product);
            }
        }

        return result;
    }

    public ArrayList<Q12_Product> findLowStock(
        int maximumStock
    ) {
        ArrayList<Q12_Product> result =
            new ArrayList<>();

        for (int i = 0; i < products.size(); i++) {

            Q12_Product product = products.get(i);

            if (product.getStock() <= maximumStock) {
                result.add(product);
            }
        }

        return result;
    }

    public int totalInventoryValue() {

        int total = 0;

        for (int i = 0; i < products.size(); i++) {

            Q12_Product product = products.get(i);

            total += product.getPrice() * product.getStock();
        }

        return total;
    }
}

class Q12_InventoryDemo {

    public static void main(String[] args) {

        Q12_InventoryCatalog catalog =
            new Q12_InventoryCatalog();

        catalog.addProduct(
            new Q12_Product(
                "P205",
                "Wireless Mouse",
                650,
                4
            )
        );

        catalog.addProduct(
            new Q12_Product(
                "P101",
                "Keyboard",
                1200,
                8
            )
        );

        catalog.addProduct(
            new Q12_Product(
                "P330",
                "Gaming Mouse",
                1800,
                2
            )
        );

        catalog.addProduct(
            new Q12_Product(
                "P150",
                "Monitor",
                5200,
                5
            )
        );

        Q12_Product[] sorted =
            catalog.createSortedCopyById();

        System.out.println("依編號排序：");

        for (Q12_Product product : sorted) {
            System.out.println(product);
        }

        System.out.println(
            "查詢 P150：" +
            catalog.binarySearchById(sorted, "p150")
        );

        System.out.println(
            "名稱包含 mouse：" +
            catalog.findByNameKeyword("mouse")
        );

        System.out.println(
            "低庫存：" +
            catalog.findLowStock(4)
        );

        System.out.println(
            "庫存總值：" +
            catalog.totalInventoryValue()
        );
    }
}