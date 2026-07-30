import java.util.ArrayList;
import java.util.List;

public class AllOccurrenceSearch {

    public static void searchAllIndices(int[] scores, int target) {
        List<Integer> foundIndices = new ArrayList<>();
        int compareCount = 0;

        for (int i = 0; i < scores.length; i++) {
            compareCount++;
            if (scores[i] == target) {
                foundIndices.add(i);
            }
        }

        System.out.println("搜尋目標分數: " + target);
        System.out.println("總比較次數: " + compareCount);

        if (foundIndices.isEmpty()) {
            System.out.println("未找到任何符合分數 " + target + " 的記錄！");
        } else {
            System.out.println("出現總次數: " + foundIndices.size());
            System.out.println("所有符合的索引位置: " + foundIndices);
        }
        System.out.println("------------------------------------");
    }

    public static void main(String[] args) {
        int[] scores = {85, 92, 78, 85, 60, 85, 100, 78, 90};

        System.out.println("=== 課後作業二：搜尋全部符合資料 ===");
        searchAllIndices(scores, 85);
        searchAllIndices(scores, 100);
        searchAllIndices(scores, 59);
    }
}