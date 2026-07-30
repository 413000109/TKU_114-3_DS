import java.util.Arrays;

public class InsertionSortPractice {

    public static void insertionSort(int[] arr, String label) {
        System.out.println("=== 測試資料：" + label + " ===");
        System.out.println("初始陣列: " + Arrays.toString(arr));

        int comparisons = 0;
        int shifts = 0;

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0) {
                comparisons++;
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    shifts++;
                    j--;
                } else {
                    break;
                }
            }
            arr[j + 1] = key;

            System.out.printf("第 %d 輪 -> key: %-2d, 插入位置: %-2d, 陣列狀態: %s\n", 
                              i, key, (j + 1), Arrays.toString(arr));
        }

        System.out.println("比較次數: " + comparisons + ", 右移次數: " + shifts + "\n");
    }

    public static void main(String[] args) {
        int[] data1 = {30, 10, 20, 50, 40, 5};
        int[] data2 = {5, 10, 20, 30, 40, 50};
        int[] data3 = {50, 40, 30, 20, 10, 5};

        insertionSort(data1, "一般未排序");
        insertionSort(data2, "已排序資料");
        insertionSort(data3, "逆向排序資料");

        System.out.println("【分析結論】");
        System.out.println("逆向排序資料的右移次數最多。因為每個元素都小於前面的所有已排序元素，必須移動前面所有的元素才能放入正確位置。");
    }
}