public class SearchEfficiencyReport {

    public static int linearSearch(int[] arr, int target) {
        int comparisons = 0;
        for (int num : arr) {
            comparisons++;
            if (num == target) {
                break;
            }
        }
        return comparisons;
    }

    public static int binarySearch(int[] arr, int target) {
        int comparisons = 0;
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            comparisons++;
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                break;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return comparisons;
    }

    public static void runTest(int size) {
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = (i + 1) * 2;
        }

        int first = data[0];
        int last = data[size - 1];
        int notExist = -1;

        System.out.println("==========================================");
        System.out.println("資料筆數 Size: " + size);
        System.out.println("==========================================");
        System.out.printf("%-12s | %-12s | %-12s\n", "搜尋標的", "循序搜尋比較次數", "二分搜尋比較次數");
        System.out.println("------------------------------------------");
        System.out.printf("%-12s | %-16d | %-12d\n", "第一筆 (" + first + ")", linearSearch(data, first), binarySearch(data, first));
        System.out.printf("%-12s | %-16d | %-12d\n", "最後一筆 (" + last + ")", linearSearch(data, last), binarySearch(data, last));
        System.out.printf("%-12s | %-16d | %-12d\n", "不存在 (" + notExist + ")", linearSearch(data, notExist), binarySearch(data, notExist));
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("=== 課後作業四：搜尋效率分析報告 ===");
        runTest(16);
        runTest(128);
        runTest(1024);

        System.out.println("【觀察結果與分析結論】");
        System.out.println("1. 循序搜尋（Linear Search）：");
        System.out.println("   - 時間複雜度為 O(N)。最佳情況只需 1 次比較；最壞情況需要比較 N 次。");
        System.out.println("   - 比較次數隨資料量呈線性成長。");
        System.out.println("2. 二分搜尋（Binary Search）：");
        System.out.println("   - 時間複雜度為 O(log N)。最壞情況下的比較次數約為 ceil(log2(N))。");
        System.out.println("   - 當資料量由 16 增加至 1024 筆時，最壞比較次數僅從 5 次增加到 11 次，呈對數成長。");
        System.out.println("3. 綜合評估：");
        System.out.println("   - 針對已排序資料，二分搜尋在搜尋效率上具備顯著優勢。");
    }
}