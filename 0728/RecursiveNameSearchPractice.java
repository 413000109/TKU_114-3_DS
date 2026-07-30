public class RecursiveNameSearchPractice {

    public static int search(String[] names, String target, int index) {
        if (names == null || index >= names.length) {
            return -1;
        }
        if (names[index] != null && names[index].equals(target)) {
            return index;
        }
        return search(names, target, index + 1);
    }

    public static void main(String[] args) {
        String[] names = {"Alice", "Bob", "Charlie", "David", "Eve"};

        System.out.println("=== 課堂實踐題四：遞回版文字搜索測試 ===");
        
        System.out.println("1. 第一筆 (Alice): " + search(names, "Alice", 0));
        System.out.println("2. 中間筆 (Charlie): " + search(names, "Charlie", 0));
        System.out.println("3. 最後一筆 (Eve): " + search(names, "Eve", 0));
        System.out.println("4. 不存在資料 (Frank): " + search(names, "Frank", 0));
        System.out.println("5. 空陣列測試: " + search(new String[]{}, "Alice", 0));
    }
}