import java.util.Arrays;

public class RangeSearchSystem {

    private static int findFirst(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                result = mid;
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    private static int findLast(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                result = mid;
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    public static void searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findLast(nums, target);

        System.out.println("搜尋目標: " + target);
        if (first == -1) {
            System.out.println("結果範圍索引: " + Arrays.toString(new int[]{-1, -1}));
            System.out.println("總出現次數: 0 次");
        } else {
            int count = last - first + 1;
            System.out.println("結果範圍索引: [" + first + ", " + last + "]");
            System.out.println("總出現次數: " + count + " 次");
        }
        System.out.println("------------------------------------");
    }

    public static void main(String[] args) {
        int[] sortedScores = {50, 60, 75, 75, 75, 75, 85, 90, 95};

        System.out.println("=== 課後作業五：範圍搜尋系統 ===");
        searchRange(sortedScores, 75);
        searchRange(sortedScores, 90);
        searchRange(sortedScores, 80);
    }
}