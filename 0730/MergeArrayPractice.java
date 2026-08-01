import java.util.Arrays;

public class MergeArrayPractice {

    public static int[] mergeDistinct(int[] arr1, int[] arr2) {
        if (arr1 == null) arr1 = new int[0];
        if (arr2 == null) arr2 = new int[0];

        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] temp = new int[n1 + n2];

        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {
            int val;
            if (arr1[i] < arr2[j]) {
                val = arr1[i++];
            } else if (arr1[i] > arr2[j]) {
                val = arr2[j++];
            } else {
                val = arr1[i];
                i++;
                j++;
            }
            if (k == 0 || temp[k - 1] != val) {
                temp[k++] = val;
            }
        }

        while (i < n1) {
            int val = arr1[i++];
            if (k == 0 || temp[k - 1] != val) {
                temp[k++] = val;
            }
        }

        while (j < n2) {
            int val = arr2[j++];
            if (k == 0 || temp[k - 1] != val) {
                temp[k++] = val;
            }
        }

        int[] result = new int[k];
        System.arraycopy(temp, 0, result, 0, k);
        return result;
    }

    public static void main(String[] args) {
        int[] a1 = {-5, -2, 0, 3, 7, 7, 10};
        int[] a2 = {-3, -2, 3, 5, 8, 10, 12};
        System.out.println(Arrays.toString(mergeDistinct(a1, a2)));

        int[] a3 = {};
        int[] a4 = {-1, 4, 9};
        System.out.println(Arrays.toString(mergeDistinct(a3, a4)));
    }
}