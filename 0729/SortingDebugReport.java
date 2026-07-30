import java.util.Arrays;

public class SortingDebugReport {

    public static void buggySelectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void buggyInsertionSortNoKey(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            while (j >= 0 && arr[j] > arr[i]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = arr[i];
        }
    }

    public static void buggyInsertionSortWrongDirection(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void fixedSelectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    public static void fixedInsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== 課後作業五：排序除錯與修正報告 ===");

        int[] test1 = {5, 2, 8, 1, 3};
        System.out.println("\n【錯誤 1：內層範圍錯誤】");
        System.out.println("原因：內層迴圈 j 從 i 開始而非 i+1，多比較了自己一次（影響效率但邏輯勉強運作）。");
        System.out.println("原始測試資料: " + Arrays.toString(test1));
        fixedSelectionSort(test1);
        System.out.println("修正後結果: " + Arrays.toString(test1));

        int[] test2 = {5, 2, 8, 1, 3};
        System.out.println("\n【錯誤 2：key 未儲存】");
        System.out.println("原因：在元素右移過程中，arr[i] 的值會被覆蓋，直接拿覆蓋後的 arr[i] 賦值會導致資料遺失錯誤。");
        System.out.println("原始測試資料: " + Arrays.toString(test2));
        fixedInsertionSort(test2);
        System.out.println("修正後結果: " + Arrays.toString(test2));

        int[] test3 = {5, 2, 8, 1, 3};
        System.out.println("\n【錯誤 3：比較方向錯誤】");
        System.out.println("原因：應為升冪排序時使用了 < 符號，導致原本要求升冪卻排成了降冪結果。");
        System.out.println("原始測試資料: " + Arrays.toString(test3));
        fixedInsertionSort(test3);
        System.out.println("修正後結果: " + Arrays.toString(test3));
    }
}