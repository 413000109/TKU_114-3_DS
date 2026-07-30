import java.util.Arrays;

public class SortingExperiment {

    public static void selectionSort(int[] input) {
        int[] arr = Arrays.copyOf(input, input.length);
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
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
                swaps++;
            }
        }
        System.out.printf("%-12s | 比較: %-4d | 交換: %-4d | 移動: %-4d\n", 
                          "選擇排序", comparisons, swaps, 0);
    }

    public static void insertionSort(int[] input) {
        int[] arr = Arrays.copyOf(input, input.length);
        int comparisons = 0;
        int moves = 0;

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0) {
                comparisons++;
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    moves++;
                    j--;
                } else {
                    break;
                }
            }
            arr[j + 1] = key;
        }
        System.out.printf("%-12s | 比較: %-4d | 交換: %-4d | 移動: %-4d\n", 
                          "插入排序", comparisons, 0, moves);
    }

    public static void runExperiment(String label, int[] data) {
        System.out.println("==============================================");
        System.out.println("資料類型: " + label);
        System.out.println("==============================================");
        selectionSort(data);
        insertionSort(data);
        System.out.println();
    }

    public static void main(String[] args) {
        int[] sorted = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] reversed = {8, 7, 6, 5, 4, 3, 2, 1};
        int[] random = {5, 2, 8, 1, 7, 3, 6, 4};

        System.out.println("=== 課後作業三：排序演算法實驗報告 ===");
        runExperiment("已排序資料", sorted);
        runExperiment("逆向排序資料", reversed);
        runExperiment("隨機排列資料", random);

        System.out.println("【觀察結論與分析】");
        System.out.println("1. 選擇排序（Selection Sort）：");
        System.out.println("   - 無論資料分佈如何，比較次數均為固定的 N*(N-1)/2 次。");
        System.out.println("   - 交換次數極少，最多不超過 N-1 次。");
        System.out.println("2. 插入排序（Insertion Sort）：");
        System.out.println("   - 受初始狀態影響巨大。已排序時為最佳狀況，比較僅 N-1 次且 0 次移動。");
        System.out.println("   - 逆向排序時為最壞狀況，比較與移動次數皆達到最高。");
        System.out.println("3. 綜合比較：對於接近排序完成的資料，插入排序效率遠高於選擇排序。");
    }
}