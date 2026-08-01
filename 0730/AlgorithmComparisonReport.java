import java.util.Arrays;
import java.util.Random;

public class AlgorithmComparisonReport {

    public static long selectionSortCompareCount(int[] arr) {
        long compares = 0;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                compares++;
                if (arr[j] < arr[minIdx]) minIdx = j;
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
        return compares;
    }

    public static long insertionSortCompareCount(int[] arr) {
        long compares = 0;
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0) {
                compares++;
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                } else {
                    break;
                }
            }
            arr[j + 1] = key;
        }
        return compares;
    }

    private static long mergeCompares = 0;

    public static long mergeSortCompareCount(int[] arr) {
        mergeCompares = 0;
        mergeSortHelper(arr, 0, arr.length - 1);
        return mergeCompares;
    }

    private static void mergeSortHelper(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSortHelper(arr, left, mid);
        mergeSortHelper(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] L = Arrays.copyOfRange(arr, left, mid + 1);
        int[] R = Arrays.copyOfRange(arr, mid + 1, right + 1);
        int i = 0, j = 0, k = left;
        while (i < L.length && j < R.length) {
            mergeCompares++;
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i < L.length) arr[k++] = L[i++];
        while (j < R.length) arr[k++] = R[j++];
    }

    public static void runBenchmarkForSize(int size) {
        System.out.println("==================================================");
        System.out.println(" 資料筆數 N = " + size);
        System.out.println("==================================================");
        System.out.printf("%-12s | %-12s | %-12s | %-12s\n", "資料類型", "選擇排序", "插入排序", "歸併排序");
        System.out.println("--------------------------------------------------");

        String[] types = {"已排序", "反向排序", "固定亂序"};
        for (String type : types) {
            int[] baseData = new int[size];
            if (type.equals("已排序")) {
                for (int i = 0; i < size; i++) baseData[i] = i;
            } else if (type.equals("反向排序")) {
                for (int i = 0; i < size; i++) baseData[i] = size - i;
            } else {
                Random rand = new Random(42);
                for (int i = 0; i < size; i++) baseData[i] = rand.nextInt(10000);
            }

            long c1 = selectionSortCompareCount(baseData.clone());
            long c2 = insertionSortCompareCount(baseData.clone());
            long c3 = mergeSortCompareCount(baseData.clone());

            System.out.printf("%-12s | %-12d | %-12d | %-12d\n", type, c1, c2, c3);
        }
    }

    public static void main(String[] args) {
        int[] sizes = {16, 128, 1024};
        for (int s : sizes) {
            runBenchmarkForSize(s);
        }
    }
}