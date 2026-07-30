public class SelectionSortPractice {

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            System.out.println("陣列為空或僅有一個元素，不需排序。");
            return;
        }

        int comparisons = 0;
        int swaps = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                comparisons++;
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            System.out.printf("第 %d 輪 -> start: %d, 選取索引: %d, 選取內容: %d\n", 
                              i + 1, i, minIndex, arr[minIndex]);

            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
                swaps++;
            }
        }

        System.out.println("總比較次數: " + comparisons);
        System.out.println("實際交換次數: " + swaps);
    }

    public static void main(String[] args) {
        System.out.println("=== 測試 1：標準陣列 ===");
        int[] data1 = {42, 18, 35, 7, 29, 14};
        selectionSort(data1);

        System.out.println("\n=== 測試 2：空陣列 ===");
        int[] data2 = {};
        selectionSort(data2);

        System.out.println("\n=== 測試 3：單一元素陣列 ===");
        int[] data3 = {99};
        selectionSort(data3);
    }
}