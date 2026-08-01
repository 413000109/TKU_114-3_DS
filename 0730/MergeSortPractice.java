import java.util.Arrays;

public class MergeSortPractice {

    public static void mergeSort(int[] arr, int left, int right) {
        if (arr == null || left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        System.out.printf("分割範圍 -> [%d, %d] 拆分為 [%d, %d] 與 [%d, %d]\n", 
                          left, right, left, mid, mid + 1, right);

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);

        System.out.printf("治癒(合併)後區間 [%d, %d] 內容: %s\n", 
                          left, right, getSubArrayString(arr, left, right));
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    private static String getSubArrayString(int[] arr, int start, int end) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = start; i <= end; i++) {
            sb.append(arr[i]).append(i == end ? "" : ", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] data = {41, 12, 35, 8, 27, 19, 50, 3};
        mergeSort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));

        int[] empty = {};
        mergeSort(empty, 0, empty.length - 1);

        int[] single = {99};
        mergeSort(single, 0, single.length - 1);
        System.out.println(Arrays.toString(single));
    }
}